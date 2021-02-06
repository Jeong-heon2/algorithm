package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1111 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if( N < 2) {
			System.out.println("A");
		}else if(N == 2){
			if(arr[0] == arr[1]) {
				System.out.println(arr[0]);
			}else {
				System.out.println("A");
			}
		}else {
			int a = 0;
			int b = 0;
			if(arr[1] - arr[0] == 0) {
				a = 0;
				b = arr[1];
			}else {
				a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
				b = arr[1] - a * arr[0];
			}
			boolean flag = true;
			for(int i = 0 ; i < N-1; i++) {
				int tmp = arr[i]*a + b;
				int next = arr[i+1];
				if(tmp != next) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println(arr[N-1]*a + b);
			}else {
				System.out.println("B");
			}
			
		}
	}
}
