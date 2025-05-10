package com.study.springboot.jdbc;

import java.sql.Date;

import lombok.Data;

@Data
public class ConvertDTO {
	private Date useDate;
	private String name;
	private double ratio;
}
