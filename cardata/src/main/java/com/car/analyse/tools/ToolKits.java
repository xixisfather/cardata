package com.car.analyse.tools;

import java.math.BigDecimal;

public class ToolKits {

	public static double add(double d1,double d2) {
		return new BigDecimal(d1).add(new BigDecimal(d2)).divide(new BigDecimal("1.00"), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static Double divid(double d1,double d2) {
		if(d2 == 0d) {
			return null;
		}
		return new BigDecimal(d1).divide(new BigDecimal(d2), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
}
