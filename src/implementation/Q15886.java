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
			//처음에는 다 다른 집합 
			set[i] = i;
		}
		arr = br.readLine().toCharArray();
		for(int i = 0 ; i< N ;i++) {
			if (arr[i] == 'E') {
				//E면 다음 원소를 내 집합으로 만듬 
				set[i+1] = set[i];
			}else {
				//W면 내가  내 이전 원소의 집합으로 들어감 
				set[i] = set[i-1];
			}
		}
		int cur = set[0];
		int ans = 1;
		//집합의 개수를 센다 
		for(int i = 1 ; i < N ;i++) {
			if(cur != set[i]) {
				ans++;
				cur = set[i];
			}
		}
		System.out.println(ans);
	}

}
