package com.serialize.test.until;

import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * java序列化
 * @author wyj
 */
public class JavaSerialize {

    /**
     * 序列化
     * @param serializePack
     * @throws IOException
     */
    public static byte[] serialize(SerializePack serializePack) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("data/javaTest.txt")));
        oos.writeObject(serializePack);
        oos.close();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("data/javaTest.txt")));
        byte[] bytes = new byte[bis.available()];
        bis.read();
        bis.close();
        return bytes;
    }
    /**
     * 反序列化
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deSerialize() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream( new File("data/javaTest.txt")));
        return ois.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DxPackRecv dxPackRecv = new DxPackRecv("1","2","3","4","5","6");
        List<DxPackRecv> list = new ArrayList<>();
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        list.add(dxPackRecv);
        SerializePack serializePack = new SerializePack();
        serializePack.data.put("1001",list);
        System.out.println(serialize(serializePack).length);
        System.out.println(deSerialize());
    }
}
