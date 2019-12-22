package dynamic;

import java.util.Scanner;

public class Q2163 {
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		if ( N == 1 && M==1) {
			System.out.println(count);
		}
		if (M == 1) {
			sliceN(N,M);
		}
		if (N == 1) {
			sliceM(N,M);
		}
		sliceM(N,M);
		System.out.println(count);
	}
	public static void sliceM(int N,int M) {
		
		int M1 = M/2;
		int M2 = M-M1;
		count++;
		if(M1 == 1) {
			if(N == 1) {
				return ;
			}
			else {
				sliceN(N,M1);
			}
		}
		else sliceM(N,M1);
		if(M2 == 1) {
			if(N == 1) {
				return ;
			}
			else {
				sliceN(N,M2);
			}
		}
		else sliceM(N,M2);
	}
	public static void sliceN(int N,int M) {
		int N1 = N/2;
		int N2 = N-N1;
		count++;
		if(N1 == 1) {
			if(M == 1) {
				return ;
			}
			else {
				sliceM(N1,M);
			}
		}
		if(N2 == 1) {
			if(M == 1) {
				return ;
			}
			else {
				sliceN(N2,M);
			}
		}
		sliceM(N1,M);
		sliceM(N2,M);
	}
}
// ���ݸ� �ڸ���
// N * M ĭ�� ���ݸ���  1*1 ũ���� �������� �ڸ������ҋ�
// �ּ������� �ڸ��� ���
// �Է� N,M ���  �ڸ��� Ƚ��