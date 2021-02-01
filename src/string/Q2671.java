package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2671 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//^(100+1+|01)+  :    ^: ����   ( ) : �׷� ,   + : �ѹ� �̻� �ݺ�  0+   ->  10����, 0�� �ѹ��̻� �ݺ��ȴ�: ^100+ 
		// 1+ : 1���ѹ��̻� �ݺ��ȴ�   ,  | : �Ǵ�    ^100+1+ �Ǵ�  01 �� ����   -> ^(100+1+|01)  
		//( )�ѹ��̻� �ݺ��ȴ� 
		if(str.matches("^(100+1+|01)+")) {
			System.out.println("SUBMARINE");
		}else {
			System.out.println("NOISE");
		}
		
	}

}
