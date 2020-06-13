package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
도로검문

 */
public class Q2307 {
	static int ans = 0 ;
	static int min ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//지점의 수
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] arr = (ArrayList<Edge>[])new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i++) {
			arr[i] = new ArrayList<Edge>();
		}
		//도로의 수
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Edge(v,w));
			arr[v].add(new Edge(u,w));
			
		}
		//i는 막을 도로 
        PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[N+1];
        int cnt;
		for(int i = 0 ; i <= M; i ++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = 0;
			pq.offer(new Edge(1, 0));
			//에지를 꺼낼때 마다 count .
			cnt = 0;
			while(pq.size() > 0) {
				Edge edge = pq.poll();
				
				for(Edge e : arr[edge.e]) {
					if(dist[e.e] == Integer.MAX_VALUE) {
                        if(cnt == i) {
                            cnt++;
                            continue;
                        }
						dist[e.e] = Math.min(dist[e.e], dist[edge.e] + e.v);
						pq.offer(new Edge(e.e, dist[e.e]));
                        cnt++;
					}
				}
			}
			if(i == M) {
				min = dist[N];
				break;
			}
			System.out.println(i + " : " +dist[N]);
			if(ans < dist[N]) ans = dist[N];
		}
		System.out.println("min : " + min);
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans - min);
	}
	static class Edge implements Comparable<Edge>{
		int e;
		int v;
		Edge(int e, int v){
			this.e = e;
			this.v = v;
		}
		//오름차순 정렬.
		@Override
		public int compareTo(Edge o) {
			return this.v - o.v;
		}
	}

}
