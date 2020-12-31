package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2947 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		for(int i = 0 ; i < 5 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1 ; i < 5 ; i++) {
			if(arr[i-1] > arr[i]) {
				int tmp = arr[i-1];
				arr[i-1] = arr[i];
				arr[i] = tmp;
				for(int j = 0 ; j < 5 ; j++) {
					System.out.print(arr[j]+" ");
				}
				System.out.println();
			}
			if(i == 4) {
				for(int t = 0 ; t < 5 ; t++) {
					if(arr[t] != t+1) {
						i = 0;
						break;
					}
				}
			}
		}
	}
}
