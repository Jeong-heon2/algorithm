package algorithm;
/*
�� ������ basic
�������� ���ӵ� ������ ������ ó���ؾ��� ��� ���.
���� ����
[1,2,3,2,5] ���� ���� 5�� �κ� ���� ������ ����?
arr�� ��Ҹ� ����Ű�� start �� end �ΰ��� �� �����͸� �̿�. 
start�� end������ ��ҵ��� ������ sum 
 */
public class TwoPointer {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 5};
		int target = 5;
		int N = arr.length; //�迭�� ũ�� 
		
		
		int result = 0;
		int end = 0;
		int sum = 0;
		for(int start = 0 ; start < N ; start ++) {
			while(sum < target && end < N) {
				sum += arr[end];
				end++;
			}
			if(sum == target) {
				result++;
			}
			sum -= arr[start];
		}
		System.out.println(result);
	}

}
