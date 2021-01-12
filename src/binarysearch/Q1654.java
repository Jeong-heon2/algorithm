package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//이분탐색 문제인지 모르고 풀면 어려운 문제 
public class Q1654 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int K = Integer.parseInt(tmp[0]);
		int N = Integer.parseInt(tmp[1]);
		int[] arr = new int[K];
		int init = Integer.MAX_VALUE;
		while(K-- > 0) {
			int a = Integer.parseInt(br.readLine());
			arr[K] = a;
			init = Math.max(a, init);
		}
		// 1 ~ min 까지 이분탐색
		long left = 1;
		long right = init;
		long mid = init;
		long max = 0;//최대 길이를 출력해야 한다. 
		while(left <= right) {
			//mid 길이로 쪼갰을 때 나오는  조각 수 
			if(slice(mid, arr) >= N) {
				max =  Math.max(mid, max);
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			mid = (right + left)/2 ;
		}
		System.out.println(max);
	}
	public static int slice(long n, int[] arr) {
		int res = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			res += arr[i]/n;
		}
		return res;
	}
}
