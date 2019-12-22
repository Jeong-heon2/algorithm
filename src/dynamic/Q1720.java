package dynamic;

import java.util.Scanner;

public class Q1720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[1] = 1;
		dp[0] = 1;
		for(int i = 2; i <= N ; i++) {
			dp[i] = dp[i-1] + dp[i-2]*2;
		}
		if(N==1) System.out.println(1);
		else if(N==2) System.out.println(3);
		else System.out.println(dp[N]/2 + dp[N/2]);
	}
}
