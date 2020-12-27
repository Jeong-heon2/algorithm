package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
입력]
첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스의 개수는 최대 100개이다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

첫째 줄에 컴퓨터 개수 n, 의존성 개수 d, 해킹당한 컴퓨터의 번호 c가 주어진다(1 ≤ n ≤ 10,000, 1 ≤ d ≤ 100,000, 1 ≤ c ≤ n).
이어서 d개의 줄에 각 의존성을 나타내는 정수 a, b, s가 주어진다(1 ≤ a, b ≤ n, a ≠ b, 0 ≤ s ≤ 1,000). 이는 컴퓨터 a가 컴퓨터 b를 의존하며, 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨을 뜻한다.
각 테스트 케이스에서 같은 의존성 (a, b)가 두 번 이상 존재하지 않는다.

출력]
각 테스트 케이스마다 한 줄에 걸쳐 총 감염되는 컴퓨터 수, 마지막 컴퓨터가 감염되기까지 걸리는 시간을 공백으로 구분지어 출력한다.
 */
//에지를 저장하는 자료구조, stringbuilder사용 하면 시간을 좀 줄일 수 있지 않을까? 
public class Q10282 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//test case
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int[] dist ;
			StringTokenizer st = new StringTokenizer(br.readLine());
			//count of computers
			int n = Integer.parseInt(st.nextToken());
			//count of dependencies
			int d = Integer.parseInt(st.nextToken());
			//num of hacked com
			int c = Integer.parseInt(st.nextToken());
			
			dist = new int[n+1];
			@SuppressWarnings("unchecked")
			ArrayList<Edge>[] arr = (ArrayList<Edge>[])new ArrayList[n+1];
			for(int i = 1 ; i <= n ; i ++) {
				arr[i] = new ArrayList<>();
				dist[i] = Integer.MAX_VALUE;
			}
			for(int i = 0 ; i < d ; i ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				arr[b].add(new Edge(a, s));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			dist[c] = 0;
			pq.add(new Edge(c, 0));
			
			while(pq.size() > 0) {
				Edge curr = pq.poll();
				for(Edge e : arr[curr.e]) {
					if(dist[e.e] > dist[curr.e] + e.w) {
						dist[e.e] = dist[curr.e] + e.w;
						pq.add(new Edge(e.e, dist[e.e]));
					}
				}
			}
			int max = 0;
			int cnt = 0;
			for(int i = 1 ; i <= n ; i++) {
				if(dist[i] != Integer.MAX_VALUE) {
					cnt ++;
					if(max < dist[i]) max = dist[i];
				}
			}
			System.out.println(cnt + " " + max);
		}

	}
	static class Edge implements Comparable<Edge>{
		int e;
		int w;
		Edge(int e, int w){
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w ;
		}
	}
}
