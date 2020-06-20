package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
베르트랑 공준
입력]
입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 케이스는 n을 포함하며, 한 줄로 이루어져 있다. (n ≤ 123456)
입력의 마지막에는 0이 주어진다.
출력]
각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
 */
public class Q4948 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 123456*2;
		int[] arr = new int[max+1];
		for(int i = 2 ; i <= max ; i++) {
			arr[i] = i;
		}
		/*
		소수는 n의 배수가 아니어야 한다.
		입력받은 수를 입력받은 수보다 작은 수 들로 나누어서 떨어지면 소수가 아니다.
		그러나 모두 나누어볼 필요없이, 루트 n 까지만 나누어서 떨어지면 소수가 아니다.
		 */
		for (int i = 2; i <= Math.sqrt(max); i++) { 
			if (arr[i] == 0) // 이미 체크된 수의 배수는 확인하지 않는다
				continue;
	        for (int j = i + i; j <= max; j += i) { // i를 제외한 i의 배수들은 0으로 체크
	        	arr[j] = 0;
	        }
		}
		do {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			int ans = 0;
			for(int i = n+1 ; i <= 2*n ; i++) {
				if(arr[i] != 0) ans++;
			}
			System.out.println(ans);
		}while(true);
		
	}
}
