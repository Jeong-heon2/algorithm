package quiz;

import java.util.Scanner;

public class Q11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum=0;
		int[] P = new int[1000];
		for(int i = 0 ; i < N ; i++) {
			P[i] = sc.nextInt();
		}
		//선택정렬
		for(int i = 0 ; i < N ; i++) {
			for(int k = i; k+1 < N; k++) {
				if(P[i] > P[k+1]) {
					int temp = P[i];
					P[i] = P[k+1];
					P[k+1] = temp;
				}
			}
		}
		//합 구하기
		for(int i = 0 ; i < N ; i++) {
			for(int k = 0 ; k <= i ; k++) {
				sum += P[k];
			}
		}
		System.out.println(sum);
	}
}
