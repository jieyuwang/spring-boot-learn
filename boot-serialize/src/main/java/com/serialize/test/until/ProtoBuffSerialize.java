package com.serialize.test.until;

import com.serialize.test.pojo.DxPackRecvProtoTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

//import com.baidu.bjf.remoting.protobuf.Codec;
//import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

public class ProtoBuffSerialize {
    public static void start(List<DxPackRecvProtoTest.DxPackRecvProtoTest1.Builder> dxPackSendList) throws IOException {
        //--------------------序列化---------------
        FileOutputStream filestream = new FileOutputStream("data/ProtoBuff.txt");
        ObjectOutputStream os = new ObjectOutputStream(filestream);
        for(DxPackRecvProtoTest.DxPackRecvProtoTest1.Builder builder : dxPackSendList){
            DxPackRecvProtoTest.DxPackRecvProtoTest1 p22 = builder.build();
            byte[] bytes = p22.toByteArray();
            os.write(bytes);
        }
        os.close();
//        bytesList = null;
        //---------------------反序列化---------------
//        List<DxPackRecvProtoTest.DxPackRecvProtoTest1> list = new ArrayList<DxPackRecvProtoTest.DxPackRecvProtoTest1>();
//        for(byte[] b : bytesList) {
//            try {
//                list.add(DxPackRecvProtoTest.DxPackRecvProtoTest1.parseFrom(b));
//            } catch (InvalidProtocolBufferException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
