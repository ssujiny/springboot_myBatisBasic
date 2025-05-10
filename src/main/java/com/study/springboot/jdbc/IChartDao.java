package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/*	@Mapper 어노테이션
 * 	"해당 인터페이스의 구현을 자바 코드로 하지 않고 XML파일로 SQL을 만들어서 한다.(resource/mybatis/mapper/**.xml)"
 */

@Mapper
public interface IChartDao {
	public List<ChartDTO> chartList();
	
}
