package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*도로 검문
1.최소경로, 최소경로의 비용 을 모두 구한다음
2.최소경로에 포함된 에지들만 하나씩 제외하고 다시 다익스트라를 돌려서 최소비용을 구한다.
2에서 나온 비용의 최대값을 구한 후, 최소 경로와 빼주면 정답.
 */
public class Q2307_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dist = new int[N+1];
		int[] path = new int[N+1];
		ArrayList<Edge>[] arr = (ArrayList<Edge>[])new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i ++) {
			arr[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Edge(v,w));
			arr[v].add(new Edge(u,w));
		}
		int min;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[1] = 0;
		pq.offer(new Edge(1,0));
		while(pq.size() > 0) {
			Edge edge = pq.poll();
			for(Edge e : arr[edge.to]) {
				if(dist[e.to] > dist[edge.to] + e.w) {
					dist[e.to] = dist[edge.to] + e.w;
					//경로도 업데이트
					path[e.to] = edge.to;
					pq.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
		min = dist[N];
		//최소 경로 : path , 최소경로 가중치 : min
		//path[i] = j 일때 , 최소 경로를 통해 i노드를 방문하기 위해서는 j노드 > i노드로 방문해야한다.
		
		
		int to = N;
		int max = 0;
		do {
			//from 노드와 to 노드를 잇는 간선을 이번 라운드에서 제외시킨다. 
			int from = path[to];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = 0;
			pq.offer(new Edge(1, 0));
			while(pq.size() > 0) {
				Edge edge = pq.poll();
				for(Edge e : arr[edge.to]) {
					if(from != edge.to || to != e.to) {
						if(dist[e.to] > dist[edge.to] + e.w) {
							dist[e.to] = dist[edge.to] + e.w;
							pq.offer(new Edge(e.to, dist[e.to]));
						}
					}
				}
			}
			if(dist[N] > max) max = dist[N];
			to = from;
		}while(to != 1);
		if(max == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(max - min);
	}
	static class Edge implements Comparable<Edge>{
		int to;
		int w;
		Edge(int to, int w){
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w ;
		}
	}

}
