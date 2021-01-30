package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1912 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i  = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		int ans = dp[0];
		
		for(int i = 1 ; i < N ; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);// arr[i]가 더 크면 구간을 다시 시작 
			ans = Math.max(dp[i], ans);
		}
		System.out.println(ans);
	}

}
