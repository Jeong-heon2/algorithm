package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1309 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][3];
		dp[0][0] = 1;//사자 x
		dp[0][1] = 1;//사자 왼
		dp[0][2] = 1;//사자 오른쪽 
		for (int i = 1; i < N; i++) { 
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901; //사자가 없는 경우 
			dp[i][1] = dp[i - 1][0] + dp[i - 1][2] % 9901; //사자가 왼쪽만 
			dp[i][2] = dp[i - 1][0] + dp[i - 1][1] % 9901; //사자가 오른쪽만 
		}
		System.out.println((dp[N-1][0] + dp[N-1][1] + dp[N-1][2]) % 9901);

	}

}
