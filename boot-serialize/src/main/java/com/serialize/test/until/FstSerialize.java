package com.serialize.test.until;

import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;
import org.nustaq.serialization.FSTConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * fst序列化
 * @author wyj
 */
public class FstSerialize {
    public static FSTConfiguration configuration = FSTConfiguration.createDefaultConfiguration();
    /**
     * 序列化
     * @param serializePack
     * @throws IOException
     */
    public static byte[] serialize(SerializePack serializePack) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("data/FstTest.txt"));
        byte[] fstByte = configuration.asByteArray(serializePack);
        bos.write(fstByte);
        bos.close();
        return fstByte;
    }
    /**
     *  反序列化
     */
    public static Object deSerialize() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data/FstTest.txt"));
        byte[] bytes = new byte[bis.available()];
        bis.read(bytes);
        bis.close();
        return configuration.asObject(bytes);
    }
    public static void main(String[ ] args) throws IOException, ClassNotFoundException {
        DxPackRecv dxPackRecv = new DxPackRecv("1","2","3","4","5","6");
        List<DxPackRecv> list = new ArrayList<>();
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        SerializePack serializePack = new SerializePack();
        serializePack.data.put("1001",list);

        System.out.println(serialize(serializePack).length);
        System.out.println(((SerializePack) deSerialize()).toString());
    }
}
