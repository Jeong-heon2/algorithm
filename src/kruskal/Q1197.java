package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
입력
첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다. 
다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 
이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. 
C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.

그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 
최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 
2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.

출력]
첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.
 */
public class Q1197 {
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//num of node
		int V = Integer.parseInt(st.nextToken());
		//num of edge
		int E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		for(int i = 1 ; i <= V ; i ++) {
			parents[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		int ans = 0;
		while(pq.size() > 0) {
			Edge edge = pq.poll();
			if(find(edge.s) == find(edge.e)) continue;
			union(edge.s, edge.e);
			ans += edge.w;
		}
		System.out.println(ans);
		
	}
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		Edge(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	private static int find(int x) {
		if(parents[x] == x) return x;
		else return parents[x] = find(parents[x]);
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(y > x) parents[y] = x;
			else parents[x] = y;
		}
	}

}
