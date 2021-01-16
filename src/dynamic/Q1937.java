package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1937 {
	static int[][] arr;
	static int[][] dp;
	static int[] goX = {1,-1, 0, 0};
	static int[] goY = {0,0,1,-1};
	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//dp[i][j] :  i, j 에서 출발했을 때 최대한 살 수 있는 일수 
		arr = new int[N][N];
		dp = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j <N; j++) {
				ans = Math.max(ans, dps(j, i));
			}
		}
		System.out.println(ans);
	}
	public static int dps(int x, int y) {
		if(dp[y][x] != 0) {
			return dp[y][x];
		}
		dp[y][x] = 1;
		
		int nx;
		int ny;
		for(int i = 0 ; i < 4 ; i++) {
			nx = x + goX[i];
			ny = y + goY[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(arr[ny][nx] > arr[y][x]) {
				dp[y][x] = Math.max(dp[y][x], dps(nx, ny) + 1);
			
			}
		}
		return dp[y][x];
		
	}

}
