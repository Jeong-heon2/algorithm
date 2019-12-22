package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문자열 3개 LCS 길이 구하기
//문자열 2개 LCS 길이 구하기에서 확장
public class Q1958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		int N = str1.length();
		int M = str2.length();
		int K = str3.length();
		int[][][] Dp = new int[N+1][M+1][K+1];
		
		for(int i = 1; i<=N; i++) {//str1
			for(int j = 1; j<=M ; j++) {//str2
				for(int k = 1; k<=K ; k++) {//str3
					if((str3.charAt(k-1)==str2.charAt(j-1))&&
							(str1.charAt(i-1)==str3.charAt(k-1))&&
								(str2.charAt(j-1)==str1.charAt(i-1))) {
						Dp[i][j][k] = Dp[i-1][j-1][k-1] + 1;
					}
					else {
						Dp[i][j][k] = Math.max(Dp[i-1][j][k],
										Math.max(Dp[i][j-1][k], 
												Dp[i][j][k-1])); 
					}
				}
			}
		}
		System.out.println(Dp[N][M][K]);
	}
}
