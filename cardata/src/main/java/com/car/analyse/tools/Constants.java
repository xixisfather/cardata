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
}
