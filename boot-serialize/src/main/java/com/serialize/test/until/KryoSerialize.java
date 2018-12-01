package com.serialize.test.until;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * kroy序列化
 * @author  wyj
 */
public class KryoSerialize  {
    /**
     *  序列化
     * @param serializePack
     * @return
     * @throws FileNotFoundException
     */
    public static byte[] serialize(SerializePack serializePack) throws FileNotFoundException {

        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("data/KryoTest.bin"));
        kryo.writeObject(output,serializePack);
        output.close();
        return kryo.toString().getBytes();
    }

    /**
     * 反序列化
     * @return
     * @throws FileNotFoundException
     */
    public static SerializePack deSerialize() throws FileNotFoundException {

        Kryo kryo = new Kryo();
        kryo.register(SerializePack.class);
        Input input = new Input(new FileInputStream("data/KryoTest.bin"));
        SerializePack serializePack = kryo.readObject(input,SerializePack.class);
        input.close();
        return serializePack;
    }

    public static void main(String[] args) throws FileNotFoundException {
        DxPackRecv dxPackRecv = new DxPackRecv("1","2","3","4","5","6");
        List<DxPackRecv> list = new ArrayList<>();
        list.add(dxPackRecv);
        SerializePack serializePack = new SerializePack();
        serializePack.data.put("1001",list);
        System.out.println(serialize(serializePack).length);
        System.out.println(deSerialize());
    }
}
