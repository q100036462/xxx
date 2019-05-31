package com.xxx.xxx.controller.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xxx.xxx.entity.Cgoods;
import com.xxx.xxx.service.CgoodsService;
import com.xxx.xxx.utils.RedisUtil;

@Controller
public class CgoodsController {
	
	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	private RedisUtil redisUtil;
	
	/**
     * 页面跳转
     * @return
     */
    @RequestMapping("/tocgoodsList")
    public String toUserlistPage(){

        return "page/cgoods/cgoods_list.html";
    }
    @ResponseBody
    @RequestMapping("/getAllCgoods")
    public String getAllCgoods(){
    	/*Cgoods select = new Cgoods();
    	select.setState("1");
    	select.setPcode("0");
    	//得到根目录（一级目录）
    	List<Cgoods> selectList = cgoodsService.selectList(select);
    	for (Cgoods cgoods : selectList) {
    		Cgoods select2 = new Cgoods();
    		select2.setState("1");
    		select2.setPcode(cgoods.getCode());
    		//得到2级目录
			List<Cgoods> selectList2 = cgoodsService.selectList(select2);
			for (Cgoods cgoods2 : selectList2) {
				Cgoods select3 = new Cgoods();
				select3.setState("1");
				select3.setPcode(cgoods2.getCode());
				//得到3级目录
				List<Cgoods> selectList3 = cgoodsService.selectList(select3);
				for (Cgoods cgoods3 : selectList3) {
					Cgoods select4 = new Cgoods();
					select4.setState("1");
					select4.setPcode(cgoods3.getCode());
					List<Cgoods> selectList4 = cgoodsService.selectList(select4);
					cgoods3.setChildren(selectList4);
				}
				cgoods2.setChildren(selectList3);
			}
			cgoods.setChildren(selectList2);
		}*/
    	String json = (String)redisTemplate.opsForValue().get("cgoodsList");
        return json;
    }

}
