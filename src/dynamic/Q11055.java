package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11055 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1 ; i <= N ; i++) {
			dp[i] = arr[i];
			for(int j = 1 ; j < i ; j ++) {
				if(arr[j]<arr[i] && dp[i] < dp[j]+arr[i]) dp[i] = dp[j]+arr[i];
			}
			if(max<dp[i]) max = dp[i];
		}
		System.out.println(max);
	}
}
