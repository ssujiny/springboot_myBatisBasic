package com.study.springboot.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.study.springboot.jdbc.ChartDTO;
import com.study.springboot.jdbc.IChartDao;

@Service
public class ChartService implements IChartService{
	
	@Autowired
	IChartDao dao;
	
	@Override
	public List<ChartDTO> chartList() {
		return dao.chartList();
	}
	
	@Override
	public List<Map<String, Object>> convertData() {
		List<ChartDTO> prevList = this.chartList();
		
		Map<String, Map<String, Double>> grouped = new LinkedHashMap<>();
		List<Map<String, Object>> result = new ArrayList<>();

        for (ChartDTO data : prevList) {
            String date = data.getUseDate().toString();
            String key = data.getType() + "-" + data.getColor(); // key명 조합
            Double value = data.getRatio();

            grouped
                .computeIfAbsent(date, k -> new LinkedHashMap<>())
                .put(key, value);
        }

        // 원하는 형태로 리스트 구성
        for (Map.Entry<String, Map<String, Double>> entry : grouped.entrySet()) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("useDate", entry.getKey());
            row.putAll(entry.getValue()); // type-color : ratio

            result.add(row);
        }
        
        // console 출력
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // 보기 좋게 출력

        String json = null;
		try {
			json = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		
        System.out.println(json);
		
		
		return result;
	}
	
	
}
