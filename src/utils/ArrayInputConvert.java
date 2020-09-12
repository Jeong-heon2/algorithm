package utils;

import java.util.HashMap;
import java.util.Map.Entry;

public class ArrayInputConvert {
	public static String convertInput(String str) {
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		
		return str;
	}
}
