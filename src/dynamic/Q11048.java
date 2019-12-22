package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11048 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().toString());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		//2���� �迭�� ���� �Է¹ް�
		for(int i = 1; i<=N ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine().toString());
			for(int j = 1; j<=M ; j++) {
				arr[i][j]=Integer.parseInt(st2.nextToken());
			}
		}
		//dp[x][y] �� (x,y)���� ���µ� �ִ� ��������
		//dp[0][0] , dp[1][0], dp[0][1] = 0
		//dp[x][y] �� x-1,y-1 x,y-1  x-1,y �� ������ ��ο��� �� �� �ִ� 
		//�� ����� �ִ밪�� arr[x][y] ���� ���Ѱ��� dp[x][y]
		for(int i = 1; i<=N ; i++) {
			for(int j = 1; j<=M; j++) {
				dp[i][j] = Math.max(Math.max(dp[i-1][j-1]+arr[i][j], dp[i][j-1]+arr[i][j]),dp[i-1][j]+arr[i][j]);
			}
		}
		System.out.println(dp[N][M]);
	}
}
