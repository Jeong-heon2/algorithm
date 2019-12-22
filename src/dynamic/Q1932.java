package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//   트리 모양이지만 > 1차원 배열로 생각
		//           1     >> arr[1]
		//          2 3    >> arr[2] arr[3]
		//         4 5 6
		//        7 8 9 10
		int[] arr = new int[N*(N+1)/2+1]; //값을 담을 배열 
		int[] dp = new int[N*(N+1)/2+1]; //dp[n]은 arr[n] 위치에서 여기까지 오는데 최대 경로 수값 
		for(int i =1; i<=N; i++) {//값을 받고
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1+i*(i-1)/2; j<=i*(i+1)/2 ; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
		}
		//맨윗층을 1층으로생각하고 1층 부터  내려가면서  dp를 구할것임
		for(int i = 1 ; i <= N; i++) {// i는 현재 층수
			int x = 1 + i*(i-1)/2;//x는 i층의 첫번째 원소의 arr배열에서 idx값
			for(int j = 0; j<i; j++) {//i층에는 i개의 원소가 있으므로  원소의 갯수만큼 반복
				if(j != 0 && j != i-1) {//각층의 첫번째 원소와 마지막원소는 스페셜 케이스
					dp[x+j] = Math.max(dp[x+j-i], dp[x+j-i+1]) + arr[x+j]; // 예를들어 3층의 두번쨰원소인(idx5번)
				}// 이놈에서 갈 수 있는경로는 idx 2와 3   나의 idx(5)-나의 층수(3) or 나의 idx - 나의 층수 +1
				else if (j == 0) {//각층의 첫번째 원소는   나의 idx - 나의 층수 + 1 로만 갈수있음
					dp[x+j] = dp[x+j-i+1] + arr[x+j];
				}
				else dp[x+j] = dp[x+j-i] + arr[x+j];// 얘는 나의 idx - 나의층수 로만 갈 수 있음 
			}
		}
		int max = 0;
		for(int i = 1+N*(N-1)/2; i<= N*(N+1)/2 ; i++) { // 맨 아래층 의 dp의 최대값이 정답임
			if (max < dp[i]) max = dp[i];
		}
		System.out.println(max);
	}

}
