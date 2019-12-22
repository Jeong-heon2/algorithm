package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N+1];
			int[][] dp = new int[2][N+1];
			for(int j = 0 ; j < 2 ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i = 1 ; i <= N ; i++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for(int i = 2 ; i <= N ; i++) {
				dp[0][i] = arr[0][i] + Math.max(dp[1][i-1],dp[1][i-2]);
				dp[1][i] = arr[1][i] + Math.max(dp[0][i-1],dp[0][i-2]);
			}
			System.out.println(Math.max(dp[0][N],dp[1][N]));
		}
	}
}
