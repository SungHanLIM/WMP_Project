package com.wmp.project.common;

public class CommonConstants {
	public static final String patternEng = "English";
	public static final String patternNum = "Number";
	
	public static String getPagePath(int code) throws Exception {
		switch (code) {
		case 404:
			return "/error/404";

		case 500:
			return "/error/500";

		case 520:
			return "/error/520";

		default:
			return "/error/error";
		}
	}
	
	public static String getPattern(String item) throws Exception {
		switch (item) {
		case patternEng:
			return "[^[a-zA-Z]*$]";

		case patternNum:
			return "[^[0-9]*$]";

		default:
			return null;
		}
	}
}
