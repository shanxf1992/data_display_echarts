package com.spring.mapper;


import com.spring.pojo.TAvgpvNum;
import com.spring.pojo.TAvgpvNumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAvgpvNumMapper {
    int countByExample(TAvgpvNumExample example);

    int deleteByExample(TAvgpvNumExample example);

    int insert(TAvgpvNum record);

    int insertSelective(TAvgpvNum record);

    List<TAvgpvNum> selectByExample(TAvgpvNumExample example);

    int updateByExampleSelective(@Param("record") TAvgpvNum record, @Param("example") TAvgpvNumExample example);

    int updateByExample(@Param("record") TAvgpvNum record, @Param("example") TAvgpvNumExample example);
}