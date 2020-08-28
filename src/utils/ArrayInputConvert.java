package utils;

public class ArrayInputConvert {
	public static String convertInput(String str) {
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		return str;
	}
}
