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
			//dp[i] �� i�� ī�� �����Ҷ� �ִ��� dp[0] = 0
			// �Ǹ����� ī�带 1��¥�� �����ϴ� ���     dp[N-1] + arr[1]  , dp[N]  �����ִ밪
			// �Ǹ����� ī�屸���� 2��¥�� �����ϴ� ���  dp[N-2] + arr[2] , dp[N]  ���� �ִ밪
			// �Ǹ����� ī�屸���� 3��¥�� �����ϴ� ��� dp[N-3] + arr[3] , dp[N]  �����ִ밪
			// .. �Ǹ����� ī�带 N��¥�� ����ϴ°�� dp[N]  
			// ����ü�� �ִ밪�� ����
			//dp[i] �� ���Ϸ��� 
			//�Ǹ����� 1���ڸ� �����ϴ� ��� ~ �Ǹ����� i��¥�� �����ϴ� ���  �� �ִ밪�� dp [i]
		}
		System.out.println(dp[N]);
	}
}
