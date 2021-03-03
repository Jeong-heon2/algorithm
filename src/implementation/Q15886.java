package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q15886 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[N];
		int[] set = new int[N];
		for(int i = 0 ; i < N ;i++) {
			//ó������ �� �ٸ� ���� 
			set[i] = i;
		}
		arr = br.readLine().toCharArray();
		for(int i = 0 ; i< N ;i++) {
			if (arr[i] == 'E') {
				//E�� ���� ���Ҹ� �� �������� ���� 
				set[i+1] = set[i];
			}else {
				//W�� ����  �� ���� ������ �������� �� 
				set[i] = set[i-1];
			}
		}
		int cur = set[0];
		int ans = 1;
		//������ ������ ���� 
		for(int i = 1 ; i < N ;i++) {
			if(cur != set[i]) {
				ans++;
				cur = set[i];
			}
		}
		System.out.println(ans);
	}

}
