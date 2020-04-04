package programmers;

import java.util.ArrayList;

public class BruteForceQ2 {
	static ArrayList<Integer> ts = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		func(str,"1234");
	}
	private static void func(String s, String number) {
		if(number.length()==0) {
			if(!s.equals("")) {
				System.out.println("ts add : " + s);
				ts.add(Integer.parseInt(s));
			}
		}else {
			for(int i = 0 ; i < number.length() ; i++) {
				System.out.println("func  s: " + s + number.charAt(i) + " number : " + number.substring(0,i) + number.substring(i+1,number.length()));
				func(s+number.charAt(i), number.substring(0,i) + number.substring(i+1,number.length()));
			}
			for(int i = 0 ; i < number.length(); i++) {
				System.out.println("func2 s : " + s + " number : " + number.substring(0,i) + number.substring(i+1 , number.length()));
				func(s, number.substring(0,i) + number.substring(i+1 , number.length()));
			}
		}
	}

}
