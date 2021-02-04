package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9935 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		String regex = "^.*"+bomb+".*";
		while(str.matches(regex)) {
			str = str.replace(bomb, "");
		}
		if(str.length() == 0) {
			System.out.println("FRULA");
		}else {
			System.out.println(str);
		}
		
	}

}
