package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q13022 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int size = word.length();
		char[] tmp = {'w','o','l','f'};
		int idx = 0;
		boolean flag = true;
		while(idx < size) {
			int n = 0;//ó���� w�� ��� ���Դ��� ��� n�� ���Ѵ� 
			for(; idx < size; idx++) {
				if(word.charAt(idx) == 'w') {
					n++;
				}else {
					break;
				}
			}
			//o, l , f�� ������� ��� �������� ����,  n�� �ٸ��� 0�� ����Ѵ� 
			for(int i = 1 ; i < 4; i++) {
				int cnt = 0;
				for(; idx < size; idx++) {
					if(word.charAt(idx) == tmp[i]) {
						cnt++;
					}else {
						break;
					}
				}
				if(n != cnt) {
					flag = false;
					break;
				}
			}
			if(!flag) {
				break;
			}
		}
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
