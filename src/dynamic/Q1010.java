package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010 {
	static int k = 0;
	static int T;
	static int[] N ;
	static int[] M ;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = new int[T];
		M = new int[T];
		for(  ; k< T ; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N[k] = Integer.parseInt(st.nextToken());
			M[k] = Integer.parseInt(st.nextToken());
			if(N[k]==M[k]) System.out.println(1);
			else if (N[k]==1) System.out.println(M[k]);
			else {
				int answer = 0;
				for(int i=1; i<=M[k]-N[k]+1; i++) {
					answer += dp(1,i);
				}
				System.out.println(answer);
			}
		}
		
	}
	
	public static int dp(int a, int b) {
		int sum=0;
		if(a==1 && b == M[k]-N[k]+1) return 1;
		if(a==N[k]) return 1;
		for(int j = b+1 ; j <= M[k]-N[k]+a+1 ; j++) {
			sum += dp(a+1,j);
		}
		return sum;
	}
}
