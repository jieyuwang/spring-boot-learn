package com.serialize.test.controller;

import com.serialize.test.dao.DxPackRecvMapper;
import com.serialize.test.pojo.DxPackRecv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/data")
public class DxPackSendController {
    public final static Logger LOGGER = LoggerFactory.getLogger(DxPackSendController.class);
    @Autowired
    private DxPackRecvMapper dxPackRecvMapper;

    @RequestMapping(value="/recv", method= RequestMethod.GET)
    @ResponseBody
    public int getDxPackList() {
        List<DxPackRecv> dxPackRecvList = dxPackRecvMapper.selectByExample(null);
        LOGGER.info("数据的大小"+dxPackRecvList.size());
        return dxPackRecvList.size();
    }


}
