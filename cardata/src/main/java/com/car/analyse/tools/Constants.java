package com.car.analyse.tools;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static Map<Integer, String> buildSeasonMap() {
		Map<Integer, String> seasonMap = new HashMap<Integer, String>();
		seasonMap.put(1, "-01-01,-03-31");
		seasonMap.put(2, "-04-01,-06-30");
		seasonMap.put(3, "-07-01,-09-30");
		seasonMap.put(4, "-10-01,-12-31");
		return seasonMap;
	}
	
	public static Map<Integer, String> buildMonthMap() {
		Map<Integer, String> monthMap = new HashMap<Integer, String>();
		monthMap.put(1, "-01-01,-01-31");
		monthMap.put(2, "-02-01,-02-29");
		monthMap.put(3, "-03-01,-03-31");
		monthMap.put(4, "-04-01,-04-30");
		monthMap.put(5, "-05-01,-05-31");
		monthMap.put(6, "-06-01,-06-30");
		monthMap.put(7, "-07-01,-07-31");
		monthMap.put(8, "-08-01,-08-31");
		monthMap.put(9, "-09-01,-09-30");
		monthMap.put(10, "-10-01,-10-31");
		monthMap.put(11, "-11-01,-11-30");
		monthMap.put(12, "-12-01,-12-31");
		return monthMap;
	}
}
