package algorithm;
//순열 알고리즘 (재귀)
public class Permutation {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		perm(arr,0,3,1);
		
	}
	//depth는 교환 트리구조에서 깊이를 의미,  n은 배열의 크기, k는 몇개를 뽑아서 순열을 만들것인가?
	//depth가 k와 같아지면 더이상 순열을 만들어내지않는다.
	public static void perm(int[] arr, int depth, int n,int k) {
		if(depth == k) {
			for(int i = 0 ; i < n ; i ++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = depth ; i < n ; i ++) {
			swap(arr, i , depth);
			perm(arr, depth+1, n,k);
			swap(arr, i , depth);
		}
	}
	public static void swap(int[]arr , int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
