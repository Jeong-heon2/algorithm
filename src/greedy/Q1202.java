package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1202 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int K= Integer.parseInt(st.nextToken());
		Jewelry[] jewelrys = new Jewelry[N];
		int[] bags = new int[K];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewelrys[i] = new Jewelry(m,v);
		}
		for(int i = 0 ; i < K ; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		//무게 오름차순 
		Arrays.sort(jewelrys, new Comparator<Jewelry>(){
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				return o1.m - o2.m;
			}
			
		});
		//무게 오름차순 
		Arrays.sort(bags);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		long ans = 0;
		int j = 0;
		//O(K+N)
		for(int i = 0 ; i < K ; i++) {
			while(j<N && jewelrys[j].m <= bags[i]) {
				pq.offer(jewelrys[j++].v);
			}
			//가장 비싼 보석 선택
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		System.out.println(ans);
	}
	static class Jewelry{
		int m; 
		int v;
		public Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
}
