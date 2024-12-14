package com.study.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.SimpleBbsDto;

/*	@Mapper 어노테이션
 * 	"해당 인터페이스의 구현을 자바 코드로 하지 않고 XML파일로 SQL을 만들어서 한다.(resource/mybatis/mapper/**.xml)"
 */

@Mapper
public interface ISimpleBbsDao {
	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDao(Map<String, String> map);
	public int deleteDao(@Param("_id") String id);
	public int articleCount();
}
