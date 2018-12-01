package com.serialize.test.until;

import com.google.gson.Gson;
import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GsonSerialize {
    /**
     * 序列化
     * @param serializePack
     * @throws IOException
     */
    public static byte[] serialize(SerializePack serializePack) throws IOException {
        BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream("data/GsonTest.txt"));
        Gson gson = new Gson();
        String gsonString = gson.toJson(serializePack);
        bis.write(gsonString.getBytes());
        bis.close();
        return gsonString.getBytes();
    }

    /**
     * 反序列化
     * @throws IOException
     */
    public static SerializePack deSerialize() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data/GsonTest.txt"));
        int len=0;
        StringBuilder stringBuffer = new StringBuilder();
        byte[] temp = new byte[1024];
        while ((len = bis.read(temp)) != -1) {
            stringBuffer.append(new String(temp, 0, len));
        }
        Gson gson = new Gson();
        return gson.fromJson(stringBuffer.toString(), SerializePack.class);
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
