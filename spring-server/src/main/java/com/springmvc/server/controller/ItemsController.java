package com.springmvc.server.controller;

import com.springmvc.api.exception.BusinessException;
import com.springmvc.api.model.Response;
import com.springmvc.api.model.ResponseStatus;
import com.springmvc.api.model.UserVo;
import com.springmvc.api.model.v1.CreateItemsRequest;
import com.springmvc.api.model.v1.DeleteItemsRequest;
import com.springmvc.api.model.v1.ErrorResponse;
import com.springmvc.service.ItemsService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.math.BigDecimal;
import java.util.UUID;
import com.springmvc.api.model.ItemsVo;

/**
 * Created by xiongbanglong on 17/4/25.
 */

@Controller
@RequestMapping(value = "/item")
public class ItemsController {
    private static final Logger logger = LogManager.getLogger(ItemsController.class);

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/addItems",method = RequestMethod.POST)
    @ResponseBody
    public Response batchAddItems(@RequestBody CreateItemsRequest request){
        if (request.getRequestId() == null) {
            request.setRequestId(UUID.randomUUID().toString());
        }

        if(request.getItemsList() == null || request.getItemsList().size() <=0){
            return new ErrorResponse(ResponseStatus.Invalid.getCode(), "itemsList is null");
        }

        for(ItemsVo itemsVo : request.getItemsList()){
            validateItemVo(itemsVo);
        }

        Response response = null;
        try{
            response = itemsService.batchAddItems(request.getItemsList());
            response.setRequestId(request.getRequestId());
        } catch (Exception e){
            logger.error(e.getMessage());
        }

        logger.info(response.toString());
        return response;
    }

    @RequestMapping(value = "/deleteItems",method = RequestMethod.POST)
    @ResponseBody
    public Response deleteItems(@RequestBody DeleteItemsRequest request) {
        if (request.getRequestId() == null) {
            request.setRequestId(UUID.randomUUID().toString());
        }

        if(request.getItemIds() == null || request.getItemIds().size() <=0){
            return new ErrorResponse(ResponseStatus.Invalid.getCode(), "itemIds is null");
        }

        Response response = null;
        try{
            response = itemsService.batchDeleteItems(request.getItemIds());
            response.setRequestId(request.getRequestId());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.info(response.toString());
        return response;

    }


    private void validateItemVo(ItemsVo itemsVo) {
        String error = null;
        if(itemsVo == null){
            error = "Invalid itemsVo";
        }else if (itemsVo.getName() == null || itemsVo.getName().equals("")) {
            error = "Invalid name";
        }else if(itemsVo.getPrice() == null || itemsVo.getPrice().equals(BigDecimal.ZERO)){
            error = "Invalid price";
        }

        if (error != null) {
            throw new BusinessException(ResponseStatus.Invalid.getCode(), error);
        }
    }
}
