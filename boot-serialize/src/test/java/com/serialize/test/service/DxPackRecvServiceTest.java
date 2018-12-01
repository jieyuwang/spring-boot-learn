package com.serialize.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;
import com.serialize.test.pojo.DxPackRecvAvroTest;
import com.serialize.test.pojo.DxPackRecvProtoTest;
import com.serialize.test.until.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class DxPackRecvServiceTest {
    public final static Logger LOGGER = LoggerFactory.getLogger(DxPackRecvServiceTest.class);
    @Autowired
    private DxPackRecvService dxPackRecvService;

    //数据库记录
    public   List<DxPackRecv> list;
    //封装数据库记录
    SerializePack serializePack = new SerializePack();
    //序列化次数
    int count = 100;
    //是否开启反序列化
    boolean flag = true;
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
    public void getList() throws IOException, ClassNotFoundException {
        //直接序列化列表
        javaSerialize();
        fastJsonSerialize();
        jsonSerialize();
        gsonSerialize();
        kryoSerialize();
        protoStuffSerialize();
        fstSerialize();

        //遍历对象挨个写入
//        avroSerialize();
//        protoBuffSerialize();
    }
    @Test
    public void fastJsonSerialize() throws IOException {
        //--------------------FastJsonSerialize 测试------------------
        Long t1 = System.currentTimeMillis();
        int len = 0;
        for (int i=0;i<count;i++){
            if (flag){
                byte[] bytes = FastJsonSerialize.serialize(serializePack);
                len += bytes.length;
                SerializePack serializePack = (SerializePack) FastJsonSerialize.deSerialize().get(SerializePack.class);
            }else {
                byte[] bytes = FastJsonSerialize.serialize(serializePack);
                len += bytes.length;
            }
        }
        Long t2 = System.currentTimeMillis();
        LOGGER.info("fastJson serialize time: " +(t2 - t1));
        LOGGER.info("fastJson serialize byteSize: " +len);
    }
    @Test
    public void javaSerialize( ) throws IOException, ClassNotFoundException {
        //--------------------JavaSerialize 测试------------------
        Long t3 = System.currentTimeMillis();
        int len =0;
        for (int i=0;i<count;i++){
            if (flag){
                byte[] bytes = JavaSerialize.serialize(serializePack);
                len +=bytes.length;
                JavaSerialize.deSerialize();
            }else {
                byte[] bytes = JavaSerialize.serialize(serializePack);
                len +=bytes.length;
            }
        }
        Long t4 = System.currentTimeMillis();
        LOGGER.info("JavaSerialize serialize: " +(t4 - t3));
        LOGGER.info("JavaSerialize serialize bytesSize: " +len);
    }
    @Test
    public void jsonSerialize( ) throws IOException {
        //--------------------JsonSerialize 测试------------------
        Long t5 = System.currentTimeMillis();
        int len =0;
        for (int i=0;i<count;i++){
            if (flag) {
                byte[] bytes = JsonSerialize.serialize(serializePack);
                len += bytes.length;
                SerializePack newserializePack = JsonSerialize.deSerialize();
            }else {
                byte[] bytes = JsonSerialize.serialize(serializePack);
                len += bytes.length;
            }
        }
        Long t6 = System.currentTimeMillis();
        LOGGER.info("JsonSerialize serialize: " +(t6 - t5));
        LOGGER.info("JsonSerialize serialize byteSize: " +len);
    }
    @Test
    public void gsonSerialize( ) throws IOException {
        //--------------------gsonSerialize 测试------------------
        Long t5 = System.currentTimeMillis();
        int len = 0;
        for (int i=0;i<count;i++){
            if (flag) {
                byte[] bytes = GsonSerialize.serialize(serializePack);
                len += bytes.length;
                GsonSerialize.deSerialize();
            }else {
                byte[] bytes = GsonSerialize.serialize(serializePack);
                len += bytes.length;
            }
        }
        Long t6 = System.currentTimeMillis();
        LOGGER.info("gsonSerialize serialize: " +(t6 - t5));
        LOGGER.info("gsonSerialize serialize byteSize: " +len);
    }
    @Test
    public void fstSerialize( ) throws IOException {
        //--------------------fstSerialize 测试------------------
        Long t5 = System.currentTimeMillis();
        int len = 0;
        for (int i=0;i<count;i++){
            if (flag) {
                byte[] bytes = FstSerialize.serialize(serializePack);
                len += bytes.length;
                FstSerialize.deSerialize();
//                System.out.println(((SerializePack)FstSerialize.deSerialize()).toString());
            }else {
                byte[] bytes = FstSerialize.serialize(serializePack);
                len += bytes.length;
            }
        }
        Long t6 = System.currentTimeMillis();
        LOGGER.info("fstSerialize serialize: " +(t6 - t5));
        LOGGER.info("fstSerialize serialize byteSize: " +len);
    }
    @Test
    public void avroSerialize() throws IOException {
        //--------------------AvroSerialize 测试------------------处理一下数据：由于序列话的数据是avro自己生成的java bean，则需要赋值为生成java bean的列表
        List<DxPackRecvAvroTest> dxPackRecvAvroTests = new ArrayList<>();
        for (DxPackRecv dxPackRecv : list){
            //处理成序列化的java bean
            DxPackRecvAvroTest dxPackRecvAvroTest = new DxPackRecvAvroTest();
            BeanUtils.copyProperties(dxPackRecv,dxPackRecvAvroTest);
            dxPackRecvAvroTests.add(dxPackRecvAvroTest);
        }
        Long t7 = System.currentTimeMillis();
        for (int i=0;i<count;i++){
            AvroSerialize.serialize(dxPackRecvAvroTests);
        }
        Long t8 = System.currentTimeMillis();
        LOGGER.info("AvroSerialize serialize: " +(t8 - t7));
    }
    @Test
    public void protoBuffSerialize() throws IOException {
        //--------------------ProtoBuffSerialize 测试------------------
        List< DxPackRecvProtoTest.DxPackRecvProtoTest1.Builder> builderList = new ArrayList<>();
        for (DxPackRecv dxPackRecv : list){
            DxPackRecvProtoTest.DxPackRecvProtoTest1.Builder builder = DxPackRecvProtoTest.DxPackRecvProtoTest1.newBuilder();
            BeanUtils.copyProperties(dxPackRecv,builder);
            builderList.add(builder);
        }
        Long t9 = System.currentTimeMillis();
        for (int i=0;i<count;i++){
            ProtoBuffSerialize.start(builderList);
        }
        Long t10 = System.currentTimeMillis();
        LOGGER.info("ProtoBuffSerialize serialize: " +(t10 - t9));
    }
    @Test
    public void kryoSerialize( ) throws IOException {
        //--------------------KryoSerialize 测试------------------
        Long t11 = System.currentTimeMillis();
//        int len=0;
        for (int i=0;i<count;i++){
            if (flag){
                byte[] bytes = KryoSerialize.serialize(serializePack);
                SerializePack newserializePack = KryoSerialize.deSerialize();
            }else {
                byte[] bytes = KryoSerialize.serialize(serializePack);
            }
//            len += bytes.length;
//            System.out.println(newserializePack.data.get("1001").size());
        }
        Long t12 = System.currentTimeMillis();
        LOGGER.info("KryoSerialize serialize: " +(t12 - t11));
//        LOGGER.info("KryoSerialize serialize byteSize: " +len);
    }
    @Test
    public void protoStuffSerialize( ) throws IOException {
        //--------------------ProtoStuffSerialize 测试------------------
        Long t13 = System.currentTimeMillis();
        int len=0;
        for (int i=0;i<count;i++){
            if (flag) {
                //序列化
                byte[] strBytsmall = ProtostuffSerialize.serialize(serializePack);
                len += strBytsmall.length;
                //反序列化
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data/ProtoStuff.txt"));
                byte[] buffer = new byte[bis.available()];
                bis.read(buffer);
                bis.close();
                SerializePack serializePack = ProtostuffSerialize.deserialize(buffer, SerializePack.class);
            }else {
                //序列化
                byte[] strBytsmall = ProtostuffSerialize.serialize(serializePack);
                len += strBytsmall.length;
            }
        }
        Long t14 = System.currentTimeMillis();
        LOGGER.info("ProtoStuffSerialize serialize: " +(t14 - t13));
        LOGGER.info("ProtoStuffSerialize serialize byteSize: " +len);
    }
}