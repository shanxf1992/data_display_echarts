package com.spring.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.mapper.TAvgpvNumMapper;
import com.spring.pojo.AvgToPageBean;
import com.spring.pojo.TAvgpvNum;
import com.spring.pojo.TAvgpvNumExample;
import com.spring.service.AvgPvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvgPvServiceImpl implements AvgPvService {
    
    @Autowired
    private TAvgpvNumMapper mapper;

    @Override
    public String getAvgPvNumByDates(String startDate, String endDate){
        TAvgpvNumExample example = new TAvgpvNumExample();
        
        TAvgpvNumExample.Criteria criteria = example.createCriteria();
        
        criteria.andDatestrBetween(startDate, endDate);
        
        example.setOrderByClause("`dateStr` ASC");
        List<TAvgpvNum> lists = mapper.selectByExample(example);
        // 数组大小
        int size = 7;
        
        String[] dates = new String[size];
        double[] datas = new double[size];
        
        int i = 0;
        for (TAvgpvNum tAvgpvNum : lists) {
                dates[i]=tAvgpvNum.getDatestr();
                datas[i]=tAvgpvNum.getAvgpvnum().doubleValue();
                i++;
        }
        
        AvgToPageBean bean = new AvgToPageBean();
        bean.setDates(dates);
        bean.setData(datas);
        ObjectMapper om = new ObjectMapper();
        String beanJson= null;
        try {
            beanJson = om.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return beanJson;
    }


}
