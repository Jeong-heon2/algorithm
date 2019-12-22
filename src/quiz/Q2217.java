package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2217 {

	public static void main(String[] args) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max_weight = 0;
		for(int i = 0 ; i < N ; i++) {
			arraylist.add(sc.nextInt());
		}
		// �������� ���� �ϰ� �� ���� ���Һ���  ����x(arraylist.size - (index)) ���� ���Ҵ� �ǳ� �پ����
	    Collections.sort(arraylist);
		for(int i = 0 ; i<N ; i++) {
			if(i>0) {
				if(arraylist.get(i)==arraylist.get(i-1));
				else {
					if(max_weight < arraylist.get(i)*(arraylist.size()-i))
						max_weight = arraylist.get(i)*(arraylist.size()-i);
				}
			}
			else {
				max_weight = arraylist.get(i)*(arraylist.size()-i);
			}
		}
		System.out.println(max_weight);
	}
}

/*
N(1��N��100,000)���� ������ �ִ�. �� ������ �̿��Ͽ� �̷� ���� ��ü�� ���ø� �� �ִ�. 
������ ������ �� ���⳪ ���̰� �ٸ��� ������ �� �� �ִ� ��ü�� �߷��� ���� �ٸ� ���� �ִ�.
������ ���� ���� ������ ���ķ� �����ϸ� ������ ������ �ɸ��� �߷��� ���� �� �ִ�.
 k���� ������ ����Ͽ� �߷��� w�� ��ü�� ���ø� ��, ������ �������� ��� ���� w/k ��ŭ�� �߷��� �ɸ��� �ȴ�.
�� �����鿡 ���� ������ �־����� ��, �� �������� �̿��Ͽ� ���ø� �� �ִ� ��ü�� �ִ� �߷��� ���س��� ���α׷��� �ۼ��Ͻÿ�. 
��� ������ ����ؾ� �� �ʿ�� ������, ���Ƿ� �� ���� ������ ��� ����ص� �ȴ�.
 ��, ������ ������ �� ������ �����Ѵ�.

ù° �ٿ� ���� N�� �־�����. ���� N���� �ٿ��� �� ������ ��ƿ �� �ִ� �ִ� �߷��� �־�����. 
�� ���� 10,000�� ���� �ʴ� �����̴�.
*/