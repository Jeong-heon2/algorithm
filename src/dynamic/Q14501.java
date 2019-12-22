package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501 {//���
	
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
		//dp[x] x�� ������  ����� �ִ�����
	
		int[] dp = new int[N+2];
		int ans = 0;
		//���� �״����� �޴´ٰ� ����
		for(int i = 1 ; i<=N ; i++) {
			if(i+T[i]<=N+1) {//i��° ���� ���� ���� ���
				dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);//3�Ͽ� 2��¥�� ���� �ߴ� > 5�Ͽ� ������ �����.
				//i+T[i]�� ���� ����� �ִ�����
				//�ִ밪 ����
				ans = Math.max(ans, dp[i+T[i]]);
			}
			//i��° ���� ���� ������ ���
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			//�ִ밪 ����
			ans = Math.max(ans, dp[i+1]);
		}
		System.out.println(ans);
	}
}
