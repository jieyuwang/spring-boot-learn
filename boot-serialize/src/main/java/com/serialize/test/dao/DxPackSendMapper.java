package com.serialize.test.dao;

import com.serialize.test.pojo.DxPackSend;
import com.serialize.test.pojo.DxPackSendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DxPackSendMapper {
    long countByExample(DxPackSendExample example);

    int deleteByExample(DxPackSendExample example);

    int deleteByPrimaryKey(String packId);

    int insert(DxPackSend record);

    int insertSelective(DxPackSend record);

    List<DxPackSend> selectByExample(DxPackSendExample example);

    DxPackSend selectByPrimaryKey(String packId);

    int updateByExampleSelective(@Param("record") DxPackSend record, @Param("example") DxPackSendExample example);

    int updateByExample(@Param("record") DxPackSend record, @Param("example") DxPackSendExample example);

    int updateByPrimaryKeySelective(DxPackSend record);

    int updateByPrimaryKey(DxPackSend record);
}