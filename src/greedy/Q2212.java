package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2212 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] interval = new int[N-1];
		for(int i = 0; i < N-1 ; i++) {
			interval[i] = arr[i+1] - arr[i];
		}
		Arrays.sort(interval);
		int ans = 0;//N-1  - (K-1)
		for(int i = 0 ; i< N-K; i++) {
			ans += interval[i];
		}
		System.out.println(ans);
	}

}
