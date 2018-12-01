package com.serialize.test.until;

import com.serialize.test.dto.SerializePack;
import com.serialize.test.pojo.DxPackRecv;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ProtostuffSerialize {
    /**
     * 避免每次序列化都重新申请Buffer空间
     */
    private static LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    /**
     * 缓存Schema
     */
    private static Map<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap<>();
    /**
     * 反序列化使用缓存
     */
    private static Objenesis objenesis = new ObjenesisStd(true);
    /**
     * 序列化方法，把指定对象序列化成字节数组
     *
     * @param obj
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T obj) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("data/ProtoStuff.txt"));
        Class<T> clazz = (Class<T>) obj.getClass();
        Schema<T> schema = getSchema(clazz);
        byte[] data;
        try {
            data = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
                buffer.clear();
        }
        bos.write(data);
        bos.close();
        return data;
    }
    /**
     * 反序列化方法，将字节数组反序列化成指定Class类型
     *
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] data, Class<T> clazz) throws IOException {
        try {
            T message = objenesis.newInstance(clazz);
            Schema<T> schema = getSchema(clazz);
            ProtostuffIOUtil.mergeFrom(data, message, schema);
//            ProtostuffIOUtil.mergeFrom(new FileInputStream("ProtoStuff.txt"),message,schema);
            return message;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        Schema<T> schema = (Schema<T>) schemaCache.get(clazz);
        if (Objects.isNull(schema)) {
            //这个schema通过RuntimeSchema进行懒创建并缓存
            //所以可以一直调用RuntimeSchema.getSchema(),这个方法是线程安全的
            schema = RuntimeSchema.createFrom(clazz);
            if (Objects.nonNull(schema)) {
                schemaCache.put(clazz, schema);
            }
        }

        return schema;
    }
    public static void main(String[] args) throws IOException {
        DxPackRecv dxPackRecv = new DxPackRecv("1","2","3","4","5","6");
        List<DxPackRecv> list = new ArrayList<>();
        list.add(dxPackRecv);
        SerializePack serializePack = new SerializePack();
        serializePack.data.put("1001",list);
        System.out.println(serialize(serializePack).length);
        System.out.println(Arrays.toString(serialize(serializePack)));



        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data/ProtoStuff.txt"));
        byte[] buffer = new byte[bis.available()];
        bis.read(buffer);
        bis.close();



        System.out.println(buffer.length);
        System.out.println(Arrays.toString(buffer));
        System.out.println(deserialize(buffer,SerializePack.class));

    }

}
