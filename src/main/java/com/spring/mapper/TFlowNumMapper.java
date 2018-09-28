package com.spring.mapper;


import com.spring.pojo.TFlowNum;
import com.spring.pojo.TFlowNumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TFlowNumMapper {
    int countByExample(TFlowNumExample example);

    int deleteByExample(TFlowNumExample example);

    int insert(TFlowNum record);

    int insertSelective(TFlowNum record);

    List<TFlowNum> selectByExample(TFlowNumExample example);

    int updateByExampleSelective(@Param("record") TFlowNum record, @Param("example") TFlowNumExample example);

    int updateByExample(@Param("record") TFlowNum record, @Param("example") TFlowNumExample example);
}