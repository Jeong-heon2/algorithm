package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1013 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			if(br.readLine().matches("^(100+1+|01)+")) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
