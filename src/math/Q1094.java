package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1094 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//64 : 100 0000
		// 절반으로 자르면  10 0000,  1 0000 , 1000, 100 ... 1  이게 곧 막대기 
		// 몇개의 막대를 붙이는가?  ==  1의 개수가 몇개인가 
		int ans = 0;
		while(N > 0) {
			if( (N & 1) == 1) ans ++;
			
			N >>= 1;
		}
		System.out.println(ans);
	}

}
