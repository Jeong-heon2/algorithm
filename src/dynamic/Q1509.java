package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1509 {//�Ӹ���� ���� , dp,���ڿ� ó��

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		//Q10942 �������� ����
		//12321 �� �־�������
		//12321�� �� �˻��� �ʿ����
		//�������� ������ ����    �������� ������ ������ 232 �� �Ӹ�����̸� 
		//12321�� �Ӹ�����̴�.
		//dp[s][e] = s���� e���� �Ӹ�������� �ƴ��� 
		//dp[s][e] = array[s] == array[e] && dp[s + 1][e - 1]
	}
}
