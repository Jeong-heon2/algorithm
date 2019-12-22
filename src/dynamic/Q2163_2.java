package dynamic;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2163_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;
		ArrayList<Integer> arraylistM = new ArrayList<>();
		ArrayList<Integer> arraylistN = new ArrayList<>();
		arraylistM.add(M);
		arraylistN.add(N);
		for(int i = 0; i < arraylistM.size() ; i++) {
			if(arraylistM.get(i)<=1) {
				for(int k = 0; k < arraylistN.size();k++) {
					if(arraylistN.get(k)>1) {
						int N1 = N/2;
						N = N- N1;
						count++;
						arraylistN.add(N1);
						arraylistN.add(N);
					}
					if((k==arraylistN.size()-1) && arraylistN.get(arraylistN.size()-1)<=1) {
						break;
					}
				}
			}
			else {
				int M1 = M/2;
				M = M - M1;
				count++;
				arraylistM.add(M1);
				arraylistM.add(M);
			}
			if((i==arraylistM.size()-1) && arraylistM.get(arraylistM.size()-1)<=1) {
				break;
			}
		}
		System.out.println( count);
	}
	
}
