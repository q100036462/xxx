package com.xxx.xxx.listener;


import java.util.List;
import java.util.Map;

import com.xxx.xxx.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.xxx.xxx.entity.ItemCat;
import com.xxx.xxx.service.ItemCatService;

@Component
@Order(value = 1)
public class StartUp  implements CommandLineRunner {
	
	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	ItemCatService itemCatService;
	@Autowired
	ItemService itemService;

	
	private static final Logger logger = LoggerFactory.getLogger(StartUp.class);
	
	@Override
	public void run(String... args) throws Exception {
		ItemCat itemCat = new ItemCat();
		List<ItemCat> selectList = itemCatService.selectList(itemCat);
    	String json = JSONObject.toJSONString(selectList);
    	redisTemplate.opsForValue().set("cgoodsList", json);
		itemService.importItems();
	}

}
