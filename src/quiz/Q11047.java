package quiz;

import java.util.Scanner;

public class Q11047 {

	public static void main(String[] args) {
		int used_coin=0;
		int N;
		int K;
		int[] A = new int[10];
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		for(int i = 0 ; i <N ; i++) {
			A[i] = sc.nextInt();
		}
		
		int target = K;
		for(int i = N-1 ; i >= 0; i--) {
			if(K-A[i] >= 0) {
				while(target>0) {
					if(target-A[i] < 0) {
						K = target;
						break;
					}
					target = target - A[i];
					used_coin++;
				}
			}
			if(K == 0) break;
		}
		System.out.println(used_coin);
	}
}
