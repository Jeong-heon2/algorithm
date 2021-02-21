package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18429 {
	static int ans = 0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(arr, 0, N, K);
		System.out.println(ans);
	}
	//depth는 교환 트리구조에서 깊이 를 의미. n은 배열의 크기
	public static void perm(int[] arr, int depth, int n, int k) {
		if(depth == n) {
			boolean flag = true;
			int w = 500;
			for(int i = 0 ; i < n ; i ++) {
				w = w - k + arr[i];
				if (w < 500) {
					flag = false;
					break;
				}
			}
			if(flag) ans++;
			return;
		}
		for(int i = depth ; i < n ; i ++) {
			swap(arr, i , depth);
			perm(arr, depth+1, n, k);
			swap(arr, i , depth);
		}
	}
	//교환하는 함수
	public static void swap(int[]arr , int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
