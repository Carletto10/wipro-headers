package com.wipro.utils;

public class StringSplitUtils {

	
	private static final String pattern = ",(?![^()]*\\))";
	
	public static String[]  split(String  cadena) {

		String[] strParts = cadena.split(pattern, -1);
		
		for(String part : strParts)
		    System.out.println(part);
		
		return strParts;
	}

}
