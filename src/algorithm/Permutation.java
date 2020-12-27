package algorithm;
//순열 알고리즘 (재귀)
//https://minusi.tistory.com/entry/%EC%88%9C%EC%97%B4-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Permutation-Algorithm
public class Permutation {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		perm(arr,0,3);
		
	}
	//depth는 교환 트리구조에서 깊이 를 의미. n은 배열의 크기
	public static void perm(int[] arr, int depth, int n) {
		if(depth == n) {
			for(int i = 0 ; i < n ; i ++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = depth ; i < n ; i ++) {
			swap(arr, i , depth);
			perm(arr, depth+1, n);
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
