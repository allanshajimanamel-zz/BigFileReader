package com.marqeta.util;

public class Parser {
	private static int count = 1720;
	
	public static String[] parse(String line) {
		String[] parsed = new String[6];
		
		parsed[0] = "06";
		parsed[1] = Integer.valueOf(count++).toString();
		parsed[2] = "6121111111111111   ";
		parsed[3] = "3000";
		parsed[4] = "000000000468";
		parsed[5] = "20170104";
		
		
		return parsed;
	}
}
