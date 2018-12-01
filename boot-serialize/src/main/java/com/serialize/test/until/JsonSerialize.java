package com.serialize.test.until;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * json序列化
 * @author wyj
 */
public class JsonSerialize {
    /**
     * 序列化
     * @param serializePack
     */
    public static byte[] serialize(SerializePack serializePack) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("data/JsonTest.txt"));
        ObjectMapper mapper = new ObjectMapper();
        byte[] writeValueAs = mapper.writeValueAsBytes(serializePack);
        bos.write(writeValueAs);
        bos.close();
        return writeValueAs;
    }

    /**
     * 反序列化
     * @throws FileNotFoundException
     */
    public static SerializePack deSerialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SerializePack serializePack = mapper.readValue(new File("data/JsonTest.txt"), SerializePack.class);
        return serializePack;
    }
    public static void main(String[] args) throws IOException {
        DxPackRecv dxPackRecv = new DxPackRecv("1","2","3","4","5","6");
        List<DxPackRecv> list = new ArrayList<>();
        list.add(dxPackRecv);
        SerializePack serializePack = new SerializePack();
        serializePack.data.put("1001",list);
        serialize(serializePack);
        System.out.println(deSerialize());
    }
}
