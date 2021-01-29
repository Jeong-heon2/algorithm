package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2671 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.matches("^(100+1+|01)+")) {
			System.out.println("SUBMARINE");
		}else {
			System.out.println("NOISE");
		}
		
	}

}
