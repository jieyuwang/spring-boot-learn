package com.serialize.test.service;

import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;
import com.serialize.test.until.JRedisSerializationUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * java fst kroy比较
 */
public class test2 {
    @Test
    public void test(){
        DxPackRecv dxPackRecv = new DxPackRecv("1","2","3","4","5","6");
        List<DxPackRecv> list = new ArrayList<>();
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        SerializePack bean = new SerializePack();
        bean.data.put("1001",list);
        System.out.println("序列化 ， 反序列化 对比测试：");
        long size = 0;
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            byte[] jdkserialize = JRedisSerializationUtils.jdkserialize(bean);
            size += jdkserialize.length;
            JRedisSerializationUtils.jdkdeserialize(jdkserialize);
        }
        System.out.println("原生序列化方案[序列化10000次]耗时："
                + (System.currentTimeMillis() - time1) + "ms size:=" + size);

        size = 0;
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            byte[] serialize = JRedisSerializationUtils.serialize(bean);
            size += serialize.length;
            SerializePack u = (SerializePack) JRedisSerializationUtils.unserialize(serialize);
        }
        System.out.println("fst序列化方案[序列化10000次]耗时："
                + (System.currentTimeMillis() - time2) + "ms size:=" + size);
        size = 0;
        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            byte[] serialize = JRedisSerializationUtils.kryoSerizlize(bean);
            size += serialize.length;
            SerializePack u = (SerializePack) JRedisSerializationUtils.kryoUnSerizlize(serialize);
        }
        System.out.println("kryo序列化方案[序列化10000次]耗时："
                + (System.currentTimeMillis() - time3) + "ms size:=" + size);
    }
}
