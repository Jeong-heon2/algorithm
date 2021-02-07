package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q12904_2 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		StringBuilder sb = new StringBuilder(t);
		boolean res = false;
		while(true) {
			int size = sb.length();
			if(size == s.length()) {
				if(sb.toString().equals(s)) res = true;
				break;
			}
			if(sb.charAt(size-1) == 'A') {
				sb.deleteCharAt(size-1);
			}else {
				sb.deleteCharAt(size-1);
				sb.reverse();
			}
		}
		if(res) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

}
