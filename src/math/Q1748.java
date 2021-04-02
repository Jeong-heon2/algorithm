package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1748 {

	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//120
		int i = 0;
		int v = 9;
		//120/9
		//120-9 = 111
		//111/90
		//111-90 = 21 
		//1자리수 9개 , 2자리수 90개 , 3자리수 21개 
		int ans = 0;
		while(n/v > 0) {
			ans += v*(i+1);
			i++;
			n -= v;
			v = 9*(int)Math.pow(10, i);
		}
		//나머지와  자리수 
		//21*3 
		ans += (n % v) * (i+1);
		System.out.println(ans);
	}

}
