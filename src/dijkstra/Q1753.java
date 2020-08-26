package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753 {
	static ArrayList<Edge>[] arr;
	static int[] dist;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//정점의 개수
		int V = Integer.parseInt(st.nextToken());
		//간선의 개수
		int E = Integer.parseInt(st.nextToken());
		//시작 정점의 번호 
		int start = Integer.parseInt(br.readLine());
		
		arr = (ArrayList<Edge>[])new ArrayList[V+1];
		dist = new int[V+1];
		//초기화 
		for(int i = 1 ; i <= V ; i++) {
			arr[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		//입력 
		for(int i = 0 ; i < E ; i ++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Edge(v, w));
		}
		//dijkstra
		dist[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		while(pq.size() > 0) {
			Edge curr = pq.poll();
			for(Edge edge : arr[curr.des]) {
				if(dist[edge.des] > dist[curr.des] + edge.w) {
					dist[edge.des] = dist[curr.des] + edge.w;
					pq.add(new Edge(edge.des, dist[edge.des]));
				}
			}
		}
		for(int i = 1; i <= V; i ++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
	
	}
	static class Edge implements Comparable<Edge>{
		int des;
		int w;
		public Edge(int des, int w) {
			this.des = des;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}
