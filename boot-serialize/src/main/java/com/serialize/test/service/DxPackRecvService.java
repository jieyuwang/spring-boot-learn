package com.serialize.test.service;

import com.serialize.test.dao.DxPackRecvMapper;
import com.serialize.test.pojo.DxPackRecv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DxPackRecvService {
    @Autowired
    private DxPackRecvMapper dxPackRecvMapper;

    @Autowired
    public List<DxPackRecv> getList(){
        List<DxPackRecv> list = dxPackRecvMapper.selectByExample(null);
        return list;
    }
}
