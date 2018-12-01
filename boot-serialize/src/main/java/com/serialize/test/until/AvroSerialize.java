package com.serialize.test.until;

import com.serialize.test.pojo.DxPackRecvAvroTest;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * avro序列化
 * @author wyj
 */
public class AvroSerialize {

    public static void serialize(List<DxPackRecvAvroTest> recvList) throws IOException {
        //---------------------序列化----------------------
        // 创建数据输出流
        DatumWriter<DxPackRecvAvroTest> dxPackRecvSpecificDatumWriter = new SpecificDatumWriter<DxPackRecvAvroTest>(DxPackRecvAvroTest.class);
        // 创建数据文件输出流
        DataFileWriter<DxPackRecvAvroTest> dfw = new DataFileWriter<DxPackRecvAvroTest>(dxPackRecvSpecificDatumWriter);

        // 给数据文件输出流指定模式和文件
        DxPackRecvAvroTest dxPackRecvAvroTest = new DxPackRecvAvroTest();
//        dxPackRecvAvroTest = convertObject(recvList.get(0));//转换对象数据
        dfw.create(((recvList.get(0))).getSchema(), new File("data/avroTest.txt"));
        for (int i=1;i<recvList.size();i++){
            dfw.append(recvList.get(i));
        }
        // 关闭数据文件输出流
        dfw.close();

    }
    public static void deSerialize(List<DxPackRecvAvroTest> recvList) throws IOException {
        //---------------------反序列化----------------------
        // 创建数据输入流
        DatumReader<DxPackRecvAvroTest> dr = new SpecificDatumReader<DxPackRecvAvroTest>(DxPackRecvAvroTest.class);
        // 创建数据文件输入流
        DataFileReader<DxPackRecvAvroTest> dfr = new DataFileReader<DxPackRecvAvroTest>(new File("data/avroTest.txt"), dr);
        // 读取数据文件，反序列化为对象
        while (dfr.hasNext()) {
//            System.out.println(dfr.next());
            dfr.next();
        }
        // 关闭数据文件输入流
        dfr.close();
    }

}
