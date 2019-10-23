package com.springmvc.service;

import com.springmvc.api.model.ItemsVo;
import  com.springmvc.api.model.v1.AddItemsResponse;
import com.springmvc.api.model.v1.DeleteItemsResponse;

import java.util.List;

/**
 * Created by xiongbanglong on 17/4/25.
 */
public interface ItemsService {

    public ItemsVo findItemsById(Integer id) throws Exception;
    public void updateItems(Integer id, ItemsVo itemsVo) throws Exception;
    public AddItemsResponse batchAddItems(List<ItemsVo> itemsVoList);
    public DeleteItemsResponse batchDeleteItems(List<Integer> itemIds);
}
