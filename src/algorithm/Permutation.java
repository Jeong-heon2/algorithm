package algorithm;
//���� �˰��� (���)
public class Permutation {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		perm(arr,0,3,1);
		
	}
	//depth�� ��ȯ Ʈ���������� ���̸� �ǹ�,  n�� �迭�� ũ��, k�� ��� �̾Ƽ� ������ ������ΰ�?
	//depth�� k�� �������� ���̻� ������ �������ʴ´�.
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
