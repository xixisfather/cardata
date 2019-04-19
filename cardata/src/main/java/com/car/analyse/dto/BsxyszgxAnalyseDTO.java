package com.car.analyse.dto;

/**
 * 保司效益险种贡献
 * @author chenchunrong
 *
 */
public class BsxyszgxAnalyseDTO {
	
	private String bxgs;
	
	private int year;
	
	private int month;
	
	private int cls;
	
	private Double syxzbf;
	
	private Double syxdjbf;

	public String getBxgs() {
		return bxgs;
	}

	public void setBxgs(String bxgs) {
		this.bxgs = bxgs;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getCls() {
		return cls;
	}

	public void setCls(int cls) {
		this.cls = cls;
	}

	public Double getSyxzbf() {
		return syxzbf;
	}

	public void setSyxzbf(Double syxzbf) {
		this.syxzbf = syxzbf;
	}

	public Double getSyxdjbf() {
		return syxdjbf;
	}

	public void setSyxdjbf(Double syxdjbf) {
		this.syxdjbf = syxdjbf;
	}
}
