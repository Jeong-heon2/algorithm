package utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayInputConvert {
	public static String convertInput(String str) {
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		List<Integer> list = new ArrayList<>();
		
		return str;
	}

	public static double sumOfList(List<Number> list) {
	    double s = 0.0;
	    for (Number n : list)
	        s += n.doubleValue();
	    return s;
	}
}
