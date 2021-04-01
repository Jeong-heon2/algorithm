package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11066 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N  = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] sum = new int[N+1];
			for(int i = 1 ; i<= N ;i++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i] = a;
				sum[i] = sum[i-1] + arr[i];
			}
			int[][] dp = new int[N+1][N+1];//dp[i][j] : i부터 j까지  최소 
			for (int d = 1; d <N; ++d) {
	            for (int tx = 1; tx + d <= N; ++tx) {
	                int ty = tx + d;
	                dp[tx][ty] = Integer.MAX_VALUE;
	 
	                for (int mid = tx; mid < ty; ++mid)
	                    dp[tx][ty] =
	                        Math.min(dp[tx][ty], 
	                            dp[tx][mid] + dp[mid + 1][ty] + sum[ty] - sum[tx - 1]);
	            }
	        }
			/*
			int[] dp = new int[N+1];
			dp[1] = arr[1];
			dp[2] = arr[1]+arr[2];
			
			for(int i = 3 ; i <= N ; i++) {
				dp[i] = Math.min(dp[i-1] + sum[i-1]+ arr[i], dp[i-2] + sum[i-2] + 2*(arr[i-1]+arr[i]));
			}*/
			System.out.println(dp[1][N]);
		}
	}

}
