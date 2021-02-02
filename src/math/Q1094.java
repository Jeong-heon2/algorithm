package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1094 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//64 : 100 0000
		// �������� �ڸ���  10 0000,  1 0000 , 1000, 100 ... 1  �̰� �� ����� 
		// ��� ���븦 ���̴°�?  ==  1�� ������ ��ΰ� 
		int ans = 0;
		while(N > 0) {
			if( (N & 1) == 1) ans ++;
			
			N >>= 1;
		}
		System.out.println(ans);
	}

}
