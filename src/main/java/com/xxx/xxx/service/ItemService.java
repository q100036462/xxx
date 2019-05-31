package com.xxx.xxx.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.Item;
import com.xxx.xxx.entity.ItemDesc;
import com.xxx.xxx.mapper.ItemCatMapper;
import com.xxx.xxx.mapper.ItemDescMapper;
import com.xxx.xxx.mapper.ItemMapper;
import com.xxx.xxx.utils.AbstractService;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService extends AbstractService<Item> {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemCatMapper itemCatMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;
    @Autowired
    private SolrClient solrClient;

    @Override
    public Mapper<Item> getMapper() {
        return itemMapper;
    }
    
    public List<Item> selectList(Item itemCat) {
    	List<Item> itemCatlist = itemMapper.selectList(itemCat);
		return itemCatlist;
	}
    
    /**
     * 查询所有的商品（分页）
     * @param item 查询条件
     * @param page 页数
     * @param size 每页大小
     * @return
     */
    public PageInfo<Item> findAllEgoItem(Item item, int page, int size){
        PageHelper.startPage(page,size);
        List<Item> items = itemMapper.selectList(item);
        PageInfo<Item> pageInfo = new PageInfo<Item>(items);
        return pageInfo;
    }

    public Object importItems() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<SolrInputDocument> documents = new ArrayList<>();
        // 1.从mysql中查询出所有的商品信息
        List<Item> itemList = itemMapper.selectAll();
        // 2.判断返回值长度是否大于0
        if (itemList.size() > 0) {
            int i= 0;
            // 3.大于0-->判断该商品状态是否属于正常(1)
            for (Item item : itemList) {
                if (item.getStatus() == 1) {
                    // 说明商品的状态正常，创建出solr的导入文档
                    SolrInputDocument solrDocument = new SolrInputDocument();
                    // 根据schema.xml配置文件中的配置字段进行逐个添加
                    solrDocument.addField("id", item.getId());
                    solrDocument.addField("item_title", item.getTitle());
                    solrDocument.addField("item_sell_point", item.getSellPoint());
                    solrDocument.addField("item_price", item.getPrice());
                    solrDocument.addField("item_image", item.getImage());
                    // 在Item实体类中有Cid外键和ItemCat的Id字段对应
                    // select * from ego_item_cat where id = cid
                    if (item.getCid() != 0L && item.getCid() != null) {
                        // 调用itemCat的mapper
                        solrDocument.addField("item_category_name",
                                itemCatMapper.selectByPrimaryKey(item.getCid()).getName());
                    }
                    // item_desc字段添加进solr的搜索库
                    // 因为item_desc在ego_item_desc中，并且在该表中有item_id外键，这个外键对应ego_item表中的id
                    // 需要非空判断么？因为使用的是主键查询，所以不需要判断id是否为null
                    ItemDesc itemDesc = new ItemDesc();
                    itemDesc.setItemId(item.getId());
                    String desc = itemDescMapper.selectOne(itemDesc).getItemDesc();
                    if (!"".equals(desc) && null != desc) {
                        solrDocument.addField("item_desc", desc);
                    } else {
                        solrDocument.addField("item_desc", "该商品暂无描述介绍");
                    }
                    documents.add(solrDocument);

                }
            }
            try {
                solrClient.add(documents);
                solrClient.commit();
                // solr存入搜索库成功
                resultMap.put("requestCode", 200);
            } catch (SolrServerException e) {
                e.printStackTrace();
                resultMap.put("requestCode", 501);
            } catch (IOException e) {
                e.printStackTrace();
                resultMap.put("requestCode", 502);
            }
        }
        return resultMap;
    }
}
