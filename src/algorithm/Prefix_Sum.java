package algorithm;
/*
������ �� �˰���
N���� �����ε� �������� Ư�� ������ ���� M�� ��� ��, 
O(N+M)�ð��� �˰��� 
[10, 20, 30, 40, 50] �� ��������
1, 4 ������ ����?
2, 5 ������ ����?

 */
public class Prefix_Sum {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int L = 1; 
		int R = 4;
		//�������� �����ش�.  prefix_sum[i] : arr�� ó������ i�ε��� ��ұ����� ���� 
		//prefix_sum[R] - prefix_sum[L-1]�� ������ �ȴ�. 
		//�� {0, 10, 30, 60, 100, 150} �� ���Ѵ�. 
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
