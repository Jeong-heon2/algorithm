package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501 {//퇴사
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+2];
		int[] P = new int[N+2];
		for(int i = 1 ; i<= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		//dp[x] x일 까지의  상담의 최대이익
	
		int[] dp = new int[N+2];
		int ans = 0;
		//돈은 그다음날 받는다고 생각
		for(int i = 1 ; i<=N ; i++) {
			if(i+T[i]<=N+1) {//i번째 날에 일을 했을 경우
				dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);//3일에 2일짜리 일을 했다 > 5일에 수익이 생긴다.
				//i+T[i]일 까지 상담의 최대이익
				//최대값 갱신
				ans = Math.max(ans, dp[i+T[i]]);
			}
			//i번째 날에 일을 안했을 경우
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			//최대값 갱신
			ans = Math.max(ans, dp[i+1]);
		}
		System.out.println(ans);
	}
}
