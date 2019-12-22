package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11052 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().toString());
		int[] arr = new int[N+1];
		int[] dp = new int[10000+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1 ; i<N+1 ;i++) {
			for (int j = 1; j<=i ; j++) {
				dp[i] = Math.max(dp[i],dp[i-j]+arr[j]);
			}
			//dp[i] 는 i개 카드 구매할때 최대비용 dp[0] = 0
			// 맨마지막 카드를 1개짜리 구매하는 경우     dp[N-1] + arr[1]  , dp[N]  둘중최대값
			// 맨마지막 카드구입을 2개짜리 구매하는 경우  dp[N-2] + arr[2] , dp[N]  둘중 최대값
			// 맨마지막 카드구입을 3개짜리 구매하는 경우 dp[N-3] + arr[3] , dp[N]  둘중최대값
			// .. 맨마지막 카드를 N개짜리 쿠매하는경우 dp[N]  
			// 이전체의 최대값이 정답
			//dp[i] 를 구하려면 
			//맨마지막 1개자리 구매하는 경우 ~ 맨마지막 i개짜리 구매하는 경우  중 최대값이 dp [i]
		}
		System.out.println(dp[N]);
	}
}
