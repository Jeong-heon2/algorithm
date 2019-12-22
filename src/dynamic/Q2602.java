package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2602 {
	//돌다리 건너기 
	// 도착까지가려면 직전에 내가 밟은 돌다리는 S여야 한다.
	// 가장 처음 내가 밟은 돌다리는 R이다.
	//예제에서 , 모든 경우의 수는  모든 조건을 만족해서 S 돌다리 오는 모든 경우의수 
	public static char[][] arr;
	public static String magic;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		magic = br.readLine();
		String devil = br.readLine();
		String engel = br.readLine();
		int N = devil.length();
		int S = engel.length();
		int M = magic.length();
		arr = new char[3][N+1];
		for(int i = 1 ; i <= N ; i ++) {
			arr[1][i] = devil.charAt(i-1);
		}
		for(int i = 1 ; i <= S ; i ++) {
			arr[2][i] = engel.charAt(i-1);
		}
		//dp[i][j] : 모든 조건을 만족해서 i,j 돌다리까지 오는 모든 경우의 수
		int answer = 0;
		for(int i = 1 ; i < 3 ; i ++) {
			if(i==1) {
				for(int j = N ; j >= M ; j--) {
					if(arr[i][j] == magic.charAt(M-1)) {
						int[][] dp = new int[3][N+1];
						answer += f(dp,M-1,i,j);
					}
				}
			}
			else {
				for(int j = S ; j >= M ; j--) {
					if(arr[i][j] == magic.charAt(M-1)) {
						int[][] dp = new int[3][N+1];
						answer += f(dp,M-1,i,j);
					}
				}
				
			}
		}
		System.out.println(answer);
	}
	public static int f(int[][] dp,int target,int i,int j) {
		if((arr[i][j] == magic.charAt(0))&&(target == 0)){
			if(j==1) {//j도 1이면
				return 1;
			}
			else {
				
				return f(dp,target,i,j-1);
			}
		}
		else if(j==0) return 0;
		else if(arr[i][j] == magic.charAt(target)) {
			if(i == 1) {
				for(int k = j-1 ; k>=1 ; k--) {
					if((arr[2][k] == magic.charAt(target-1))&&(target-1 == 0)){
						dp[i][j] += 1;
						continue;
					}
					else if(arr[2][k] == magic.charAt(target-1)) {
						if(target-2 >= 0) {
							dp[i][j] += f(dp,target-2,i,k-1);
						}
					}
				}
				return dp[i][j];
			}
			else {
				for(int k = j-1 ; k>=1 ; k--) {
					if((arr[1][k] == magic.charAt(target-1))&&(target-1 == 0)){
						dp[i][j] += 1;
						continue;
					}
					else if(arr[1][k] == magic.charAt(target-1)) {
						if(target-2 >= 0) {
							dp[i][j] += f(dp,target-2,i,k-1);
						}
					}
				}
				return dp[i][j];
			}
		}
		else {
			return f(dp,target,i,j-1);
		}
	}
}
