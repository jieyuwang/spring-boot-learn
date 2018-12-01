package com.serialize.test.dao;

import com.serialize.test.pojo.DxPackRecv;
import com.serialize.test.pojo.DxPackRecvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DxPackRecvMapper {
    long countByExample(DxPackRecvExample example);

    int deleteByExample(DxPackRecvExample example);

    int deleteByPrimaryKey(String packId);

    int insert(DxPackRecv record);

    int insertSelective(DxPackRecv record);

    List<DxPackRecv> selectByExample(DxPackRecvExample example);

    DxPackRecv selectByPrimaryKey(String packId);

    int updateByExampleSelective(@Param("record") DxPackRecv record, @Param("example") DxPackRecvExample example);

    int updateByExample(@Param("record") DxPackRecv record, @Param("example") DxPackRecvExample example);

    int updateByPrimaryKeySelective(DxPackRecv record);

    int updateByPrimaryKey(DxPackRecv record);
}