package com.study.springboot.jdbc;

import java.sql.Date;

import lombok.Data;

@Data
public class ChartDTO {
	private Date useDate;
	private String type;
	private int num;
	private String color;
	private double ratio;
}
