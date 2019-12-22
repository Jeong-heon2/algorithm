package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1965 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];//dp[i] 는 i번째 상자 까지 중  겹쳐진 상자의 최대개수
		for(int i = 0 ; i <N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;//상자 혼자 일경우는 1 
		}
		
		for(int i = 1 ; i < N ; i++) {
			for(int j = i-1 ; j >=0 ; j--) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int ans = 0;
		for(int i = 0 ; i < N ; i ++) {
			if (ans < dp[i]) ans = dp[i];
		}
		System.out.println(ans);
	}
}
