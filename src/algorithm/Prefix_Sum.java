package algorithm;
/*
구간의 합 알고리즘
N개의 정수로된 수열에서 특정 구간의 합을 M번 물어볼 때, 
O(N+M)시간의 알고리즘 
[10, 20, 30, 40, 50] 의 수열에서
1, 4 구간의 합은?
2, 5 구간의 합은?

 */
public class Prefix_Sum {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int L = 1; 
		int R = 4;
		//누적합을 구해준다.  prefix_sum[i] : arr의 처음부터 i인덱스 요소까지의 총합 
		//prefix_sum[R] - prefix_sum[L-1]이 정답이 된다. 
		//즉 {0, 10, 30, 60, 100, 150} 을 구한다. 
		int[] prefix_sum = new int[arr.length+1];
		prefix_sum[0] = 0;
		int sum = 0;
		for(int i = 1; i <= arr.length ; i++) {
			sum += arr[i-1];
			prefix_sum[i] = sum;
		}
		
		System.out.println(prefix_sum[R] - prefix_sum[L-1]);
	}

}
