package com.serialize.test.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试fastjson gson jackson性能
 */
public class test1 {    @Autowired
private DxPackRecvService dxPackRecvService;
    public final static Logger LOGGER = LoggerFactory.getLogger(DxPackRecvServiceTest.class);
    //数据库记录
    public   List<DxPackRecv> list;
    //封装数据库记录
    SerializePack serializePack = new SerializePack();

    @Before
    public void start(){
        //从数据库取到
//         list = dxPackRecvService.getList();
//         serializePack.data.put("1001",list);
//        LOGGER.info("数据的条数："+list.size());
        //从文件中恢复
        ObjectMapper mapper = new ObjectMapper();
        try {
            serializePack = mapper.readValue(new File("data/testData.txt"), SerializePack.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list = serializePack.data.get("1001");
        LOGGER.info("数据的条数："+serializePack.data.get("1001").size());
    }
    @Test
    public  void test() throws JsonProcessingException {
        //测试gson用时
        Gson gson = new Gson();
        long start = new Date().getTime();
        gson.toJson(serializePack);
        long end = new Date().getTime();
        System.out.println("gson转换共用时："+(end-start)+"ms");
        //测试fastjson用时
        long start1 = new Date().getTime();
        JSON.toJSONString(serializePack);
        long end1 = new Date().getTime();
        System.out.println("fastjson转换共用时："+(end1-start1)+"ms");
        //测试jackson用时
        long start2 = new Date().getTime();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(serializePack);
        long end2 = new Date().getTime();
        System.out.println("jackson转换共用时："+(end2-start2)+"ms");
    }
}
