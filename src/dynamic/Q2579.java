package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2579 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];//dp[i]는 i번 계단의 최대 점수
		int[] arr = new int[N+1];
		//dp[i] = max(arr[i] + dp[i-3] + arr[i-1], arr[i] + dp[i-2] ) 
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
	    dp[1] = arr[1];
	    if(N == 1) {
	    	System.out.println(dp[1]);
	    }else {
	    	dp[2] = arr[1]+arr[2];
		    for (int i = 3; i <= N; i++) {
		    	dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
		    }
			System.out.println(dp[N]);
	    }
	    
	}

}
