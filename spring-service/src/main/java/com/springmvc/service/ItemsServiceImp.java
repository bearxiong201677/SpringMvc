package com.springmvc.service;

import com.springmvc.api.exception.BusinessException;
import com.springmvc.api.model.*;
import com.springmvc.api.model.v1.AddItemsResponse;
import com.springmvc.api.model.v1.CreateUsersResponse;
import com.springmvc.api.model.v1.DeleteItemsResponse;
import com.springmvc.dao.repository.ItemsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiongbanglong on 17/4/25.
 */

@Service("ItemsService")
public class ItemsServiceImp implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    @Transactional
    public ItemsVo findItemsById(Integer id) throws Exception {
        Items items = itemsRepository.selectByPrimaryKey(id);
        ItemsVo itemsVo = new ItemsVo();
        BeanUtils.copyProperties(items, itemsVo);
        return itemsVo;
    }

    @Transactional
    public void updateItems(Integer id, ItemsVo itemsVo) throws Exception {
        itemsVo.setId(id);
        itemsRepository.updateByPrimaryKeyWithBLOBs(itemsVo);
    }

    @Transactional
    public AddItemsResponse batchAddItems(List<ItemsVo> itemsVoList){
        List<Items> itemsList = new ArrayList<Items>();
        for(ItemsVo itemsVo:itemsVoList){
            Items items = new Items();
            BeanUtils.copyProperties(itemsVo,items);
            itemsList.add(items);
        }

        int row = itemsRepository.batchInsert(itemsList);
        AddItemsResponse addItemsResponse = new AddItemsResponse();
        if(row > 0 && row == itemsVoList.size()){
            addItemsResponse.setRow(row);
            addItemsResponse.setStatus(true);
        }else{
            addItemsResponse.setRow(row);
            addItemsResponse.setStatus(false);
        }

        return addItemsResponse;
    }

    @Transactional
    public DeleteItemsResponse batchDeleteItems(List<Integer> itemIds){
        //检查待删除的产品是否存在，如果不存在则抛出异常
        List<Integer> itemsNotExist = new ArrayList<Integer>();
        for(Integer id : itemIds){
            ItemsExample example = new ItemsExample();
            example.createCriteria().andIdEqualTo(id);
            List<Items> itemsExist = itemsRepository.selectByExample(example);
            if(itemsExist == null || itemsExist.size() <= 0) {
                itemsNotExist.add(id);
            }
        }

        if(itemsNotExist.size() >= 1){
            throw new BusinessException(ResponseStatus.Invalid.getCode(), "itemIds:" + itemsNotExist.toString() + " doesn't exist");
        }

        ItemsExample example = new ItemsExample();
        example.createCriteria().andIdIn(itemIds);
        int row = itemsRepository.deleteByExample(example);
        DeleteItemsResponse deleteUsersResponse = new DeleteItemsResponse();
        if(row > 0 && row == itemIds.size()){
            deleteUsersResponse.setRow(row);
            deleteUsersResponse.setStatus(true);
        }else{
            deleteUsersResponse.setRow(row);
            deleteUsersResponse.setStatus(false);
        }
        return deleteUsersResponse;
    }
}
