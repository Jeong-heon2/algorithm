package programmers;

import java.util.Arrays;
/*
��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
������ : 119
���ؿ� : 97 674 223
������ : 11 9552 4421
��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

[���� ����]
phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
�� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
 */
//���ٹ� 1 : �ؽ��� �̿��Ͽ� Ǯ ����� �������� �ʾҴ�. �׷��� sort�� ���Խ��� �̿��ߴ�.
//119, 97674223, 1195524421  �Է��� �̷��� ������ 
//sort �ϸ� 119, 1195524421, 97674223  �̷��� �ȴ�.
//�տ�������  ���ӵ� �ΰ����� �����ϸ� �ȴ�.  119, 1195524421 �����ϰ� �״����� 1195524421, 97674223
// 119�� 97674223�� �������ʿ䰡 ����.
//�ֳ��ϸ�  ������ �߱⶧���� 119��  1195524421��  ���ξ �ƴ϶��  �� �ڿ��ִ� �͵��� ���ξ �ƴϱ⶧���̴�.
public class HashQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        String a;
        String b = phone_book[0];
        for(int i = 1 ; i < phone_book.length ; i++){
            a = b;
            b = phone_book[i];
            if(isRight(a,b)) return false;
        }
        return true;
    }
    private static boolean isRight(String a , String b){
        if(b.matches("^"+a+".*")) return true;
        return false;
    }

}
