package com.xxx.xxx.controller.manage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.Item;
import com.xxx.xxx.entity.User;
import com.xxx.xxx.service.ItemService;
import com.xxx.xxx.utils.UserUtils;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
     * 页面跳转
     * @return
     */
    @RequestMapping("/toEgoItemPage")
    public String toEgoItemPage(){

        return "page/egoItem/egoItem_list";
    }
    
    /**
     * 查找所有用户
     * @param page 页码
     * @param limit 每页条数
     * @return
     */
    @RequestMapping("/egoItemList")
    @ResponseBody
    public Map<String, Object> findAll(Item item, Integer page, Integer limit){
        //获取当前登录用户的信息
        User admin = UserUtils.getUser();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo<Item> pager = new PageInfo<>();
        pager = itemService.findAllEgoItem(item, page, limit);
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        //总条数
        resultMap.put("count", pager.getTotal());
        //获取每页数据
        resultMap.put("data", pager.getList());
        return resultMap;
    }

}
