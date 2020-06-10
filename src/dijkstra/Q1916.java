package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*최소비용 구하기
[입력]
첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다.
 그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.
그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다.
 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

[출력]
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
 */
public class Q1916 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//도시의 개수
		int N = Integer.parseInt(br.readLine());
		//버스의 개수
		int M = Integer.parseInt(br.readLine());
		
		int[] dist = new int[N+1];
		ArrayList<Edge>[] arr = (ArrayList<Edge>[])new ArrayList[N+1];
		//초기화
		for(int i = 0 ; i < N+1; i++) {
			arr[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		//입력
		for(int i = 1 ; i <= M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[s].add(new Edge(e, v));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
		br.close();
		
		//dijkstra
		//시작노드에서 시작노드로가는 비용은 0이므로 
		dist[start] = 0; 
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.offer(new Edge(start, 0));
		
		while(pq.size() > 0) {
			Edge edge = pq.poll();
			if(visited[edge.dest]) continue;
			visited[edge.dest] = true;
			for(Edge e : arr[edge.dest]) {
				if(!visited[e.dest]) {
					dist[e.dest] = Math.min(dist[e.dest], dist[edge.dest] + e.val);
					//새로조정된 dist값으로 edge를 다시 만들어서 큐에 넣어준다. 
					pq.offer(new Edge(e.dest, dist[e.dest]));
				}
			}
		}
		System.out.println(dist[destination]);
		
		

	}
	static class Edge implements Comparable<Edge>{
		int dest;
		int val;
		Edge(int d, int v){
			this.dest = d;
			this.val = v;
		}
		@Override
		public int compareTo(Edge o) {
			return this.val > o.val ? 1 : -1;
		}
	}

}
