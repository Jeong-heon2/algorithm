package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5582 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] dp = new int[4001][4001];
		int ans = 0;
		for(int i = 0 ; i < str1.length(); i++) {
			for(int j = 0 ; j < str2.length(); j++) {
				if(str1.charAt(i)==str2.charAt(j)) {
					dp[i+1][j+1] = dp[i][j] + 1;
					ans = Math.max(ans, dp[i+1][j+1]);
				}
			}
		}
		System.out.println(ans);
	}
}
