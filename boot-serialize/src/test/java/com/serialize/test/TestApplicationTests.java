package com.serialize.test;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void contextLoads() {
        System.out.println("nihao");
        //加密数据库产生的密钥 参数是密码
        String result = stringEncryptor.encrypt("password");
        System.out.println(result);
    }


}
