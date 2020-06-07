package algorithm;
/*
투 포인터 basic
문제에서 연속된 데이터 구간을 처리해야할 경우 사용.
문제 예시
[1,2,3,2,5] 에서 합이 5인 부분 연속 수열의 개수?
arr의 요소를 가리키는 start 와 end 두개의 투 포인터를 이용. 
start와 end사이의 요소들의 총합인 sum 
 */
public class TwoPointer {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 5};
		int target = 5;
		int N = arr.length; //배열의 크기 
		
		
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
