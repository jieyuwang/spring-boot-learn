package com.serialize.test.until;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FastJson序列化
 * @author wyj
 */
public class FastJsonSerialize {
    /**
     *序列化
     * @param serializePack
     * @throws IOException
     */
    public static byte[] serialize(SerializePack serializePack) throws IOException {
        BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream("data/FastJsonTest.txt"));
        String text = JSON.toJSONString(serializePack);
        bis.write(text.getBytes());
        bis.close();
        return text.getBytes();
    }
    public static JSONObject deSerialize() throws IOException {
        //----------------反序列化------------------
        //stringBuilder是线程不安全
        StringBuffer stringBuffer = new StringBuffer();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data/FastJsonTest.txt"));
        int len = 0;
        byte[] temp = new byte[1024];
        while ((len = bis.read(temp)) != -1) {
            stringBuffer.append(new String(temp, 0, len));
        }
        bis.close();
        return JSON.parseObject(stringBuffer.toString());
    }

    public static void main(String[] args) throws IOException {
        DxPackRecv dxPackRecv = new DxPackRecv("1","2","3","4","5","6");
        List<DxPackRecv> list = new ArrayList<>();
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        SerializePack serializePack = new SerializePack();
        serializePack.data.put("1001",list);
        serialize(serializePack);
        System.out.println(deSerialize());
    }
}
