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
			int n = 0;//처음에 w가 몇번 나왔는지 세어서 n을 구한다 
			for(; idx < size; idx++) {
				if(word.charAt(idx) == 'w') {
					n++;
				}else {
					break;
				}
			}
			//o, l , f가 순서대로 몇번 나오는지 세고,  n과 다르면 0을 출력한다 
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
