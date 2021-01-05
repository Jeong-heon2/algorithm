package math;

public class SieveOfEratosthenes {
	static int num = 9999;
	static int[] arr = new int[10000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//에라토스테네스의 체 
		// 1. 배열을 생성하여 초기화한다.
	    for(int i=2; i<=num; i++) {
	        arr[i] = i;
	    }
	    // 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
	    // (지울 때 자기자신은 지우지 않고, 이미 지워진 수는 건너뛴다.)
	    for(int i=2;i <= num; i++) {
	        if(arr[i]==0) continue; // 이미 지워진 수라면 건너뛰기

	        // 이미 지워진 숫자가 아니라면, 그 배수부터 출발하여, 가능한 모든 숫자 지우기
	        for(int j=2*i; j <= num; j+=i) {
	            arr[j] = 0;
	        }
	    }
	}

}
