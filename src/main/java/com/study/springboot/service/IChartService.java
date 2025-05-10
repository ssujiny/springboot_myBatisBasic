package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.SimpleBbsDto;
import com.study.springboot.jdbc.ChartDTO;
import com.study.springboot.jdbc.ConvertDTO;

public interface IChartService {

	public List<ChartDTO> chartList();

	public List<Map<String, Object>> convertData();
}
