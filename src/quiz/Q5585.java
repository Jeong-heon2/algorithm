package quiz;

import java.util.Scanner;

public class Q5585 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int price = sc.nextInt();
		int change = 1000 - price;
		int count=0;
		int[] Yen = {500,100,50,10,5,1};
		for(int i = 0 ; i < Yen.length ; i++) {
			while(change>0) {
				if(change - Yen[i] >= 0) {
					change = change - Yen[i];
					count ++;
				}
				else break;
			}
			if(change == 0) break;
		}
		System.out.println(count);
	}
}
/*Ÿ�δ� ���� JOI��ȭ������ ������ ���. 
 * JOI��ȭ������ �ܵ����� 500��, 100��, 50��, 10��, 5��, 1���� ����� �ְ�, ������ �Ž����� ������ ���� ���� �ܵ��� �ش�. 
 * Ÿ�ΰ� JOI��ȭ������ ������ ��� ī���Ϳ��� 1000�� ���� ���� ���� ��, ���� �ܵ��� ���Ե� �ܵ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/