package com.springmvc.api.model.v1;

import com.alibaba.fastjson.JSON;
import com.springmvc.api.model.ItemsVo;
import com.springmvc.api.model.Request;
import java.util.List;

/**
 * Created by xiongbanglong on 2017/5/11.
 */
public class CreateItemsRequest extends Request{
    private List<ItemsVo> itemsList;

    public List<ItemsVo> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsVo> itemsList) {
        this.itemsList = itemsList;
    }

    public String toString(){
        return "CreateItemsRequest:" + JSON.toJSONString(this);
    }

}
