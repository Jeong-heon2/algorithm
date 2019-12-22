package dynamic;

import java.util.ArrayList;
import java.util.Scanner;

public class Q9507 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> answerlist = new ArrayList<>();
		ArrayList<Long> arraylist = new ArrayList<>();
		for(int i = 0; i<69 ; i++) {
			if(i==0) {
				arraylist.add((long) 1);
			}
			if(i==1) {
				arraylist.add((long)1);
			}
			if(i==2) {
				arraylist.add((long)2);
			}
			if(i==3) {
				arraylist.add((long)4);
			}
			if(i>3) {
				arraylist.add(arraylist.get(i-1)+
						arraylist.get(i-2)+
						arraylist.get(i-3)+
						arraylist.get(i-4));
			}
		}
		for(int i= 0; i < N; i++) {
			answerlist.add(sc.nextInt());
		}
		for(int i=0;i<N;i++) {
			System.out.println(arraylist.get(answerlist.get(i)));
		}
	}
}
