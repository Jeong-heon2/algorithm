package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9095 {

	public static void main(String[] args) throws Exception {
		int[] arr = new int[11];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr[1] = 1; arr[2]=2; arr[3]=4;
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 4; i<11 ; i++) {
			arr[i] = arr[i-3]+arr[i-2]+arr[i-1];
		}
		for(int i = 0; i<T ; i++) {
			System.out.println(arr[Integer.parseInt(br.readLine())]);
		}
	}
}
