package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//boj 11003
/*
N개의 수 A1, A2, ..., AN과 L이 주어진다.
D[i] = A[i-L+1] ~ A[i] 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 
이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.

첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)

첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
*/
public class SlidingWindow {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] ans = new int[N];
		st = new StringTokenizer(br.readLine());
		br.close();
		Deque<int[]> d = new ArrayDeque<>();
		for(int i = 0 ; i < N ; i++) {
			int cur = Integer.parseInt(st.nextToken());
			//덱의 맨 앞 인덱스와 현재 인덱스 검사 
			if(!d.isEmpty() && d.peekFirst()[0] <= i-L) {
				d.poll();
			}
			//덱의 맨 뒤 
			while(!d.isEmpty() && d.peekLast()[1] > cur) {
				d.pollLast();
			}
			d.offer(new int[] {i,cur});
			ans[i] = d.peekFirst()[1];
		}
		for(int i = 0 ; i < N ; i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	

}
