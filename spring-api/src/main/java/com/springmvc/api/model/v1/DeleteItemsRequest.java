package com.springmvc.api.model.v1;

import com.springmvc.api.model.Request;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiongbanglong on 2017/5/15.
 */
public class DeleteItemsRequest extends Request {
    private List<Integer> itemIds = new ArrayList<Integer>();

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
