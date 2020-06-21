package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
입력]
첫째 줄에 N과 M이 주어진다. N은 100보다 작거나 같은 자연수이고, 
M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다. 
가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

출력]
첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.
 */
public class Q1049 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//broken lines
		int N = Integer.parseInt(st.nextToken());
		//num of brands
		int M = Integer.parseInt(st.nextToken());
		int[] packages = new int[M];
		int[] singles = new int[M];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			packages[i] = Integer.parseInt(st.nextToken());
			singles[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(packages);
		Arrays.sort(singles);
		
		int quotient = N/6;
		int remainder = N%6;
		int ans = 0;
		if(packages[0] < singles[0] * 6) {
			ans += quotient * packages[0];
			if(packages[0] < remainder * singles[0]) {
				ans += packages[0];
			}else {
				ans += remainder * singles[0];
			}
			System.out.println(ans);
		}else {
			System.out.println(N * singles[0]);
		}
	}

}
