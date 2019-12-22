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
		//2차원 배열에 값을 입력받고
		for(int i = 1; i<=N ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine().toString());
			for(int j = 1; j<=M ; j++) {
				arr[i][j]=Integer.parseInt(st2.nextToken());
			}
		}
		//dp[x][y] 는 (x,y)까지 오는데 최대 사탕개수
		//dp[0][0] , dp[1][0], dp[0][1] = 0
		//dp[x][y] 는 x-1,y-1 x,y-1  x-1,y 이 세가지 경로에서 올 수 있다 
		//각 경우중 최대값에 arr[x][y] 값을 더한것이 dp[x][y]
		for(int i = 1; i<=N ; i++) {
			for(int j = 1; j<=M; j++) {
				dp[i][j] = Math.max(Math.max(dp[i-1][j-1]+arr[i][j], dp[i][j-1]+arr[i][j]),dp[i-1][j]+arr[i][j]);
			}
		}
		System.out.println(dp[N][M]);
	}
}
