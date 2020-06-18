package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
입력]
첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다.
각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 
두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.

출력]
각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
 */
public class Q1946 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//test case
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			//number of applicants
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int i = 0 ; i < N ; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//	서류 
				int a = Integer.parseInt(st.nextToken());
				//  면접 
				int b = Integer.parseInt(st.nextToken());
				arr[a-1] = b-1;
			}
			int ans = 1;
			int val = arr[0];//서류1등의 면접 등수 
			for(int i = 1 ; i < N ; i++) {
				int a = arr[i];
				if(a < val) {
					ans++;
					val = a;
				}
			}
			System.out.println(ans);
		}

	}

}
