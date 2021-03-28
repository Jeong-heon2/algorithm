package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayInputConvert {
	public static String convertInput(String str) {
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		
		
		return str;
	}

	public static double sumOfList(List<Number> list) {
	    double s = 0.0;
	    for (Number n : list)
	        s += n.doubleValue();
	    return s;
	}
}
