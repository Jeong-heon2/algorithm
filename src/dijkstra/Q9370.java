package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//최단경로는 유일하지 않을 수 있다. 
public class Q9370 {
	static int[] dist;// 시작 정점에서 목적 정점까지의 거리
    static boolean[] visited;// 정점을 방문했나 안했나
    static ArrayList<Integer>[] before;//바로 전에 방문한 정점 
	public static void main(String[] args) throws Exception{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());// 정점 개수 
			int m = Integer.parseInt(st.nextToken());// 도로 개수 
			int t = Integer.parseInt(st.nextToken());//목적지 후보개수 
			
			dist = new int[n + 1];
			before = (ArrayList<Integer>[])new ArrayList[n + 1];
			visited = new boolean[n + 1];
			ArrayList<Edge>[] arr = (ArrayList<Edge>[])new ArrayList[n + 1];
			for(int i = 1 ; i <= n ; i++) {
				dist[i] = Integer.MAX_VALUE;
				before[i] = new ArrayList<Integer>();
				arr[i] = new ArrayList<Edge>();
			}
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());//시작 정점 
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			dist[s] = 0; // 시작정점과 시작정점 거리는 0 
			for (int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				arr[a].add(new Edge(b,d));
				arr[b].add(new Edge(a,d));//양방향 도로 이므로 
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			pq.offer(new Edge(s, 0));
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(visited[e.d]) continue;
				visited[e.d] = true;
				for(Edge k : arr[e.d]) {//e.d에서 갈 수 있는 도로들 
					if (!visited[k.d]) {
						//방문안 한 정점과 이어져 있다면 
						if(dist[k.d] > dist[e.d] + k.w) {
							dist[k.d] = dist[e.d] + k.w;
							before[k.d].clear();
							before[k.d].add(e.d);
						}else if(dist[k.d] == dist[e.d] + k.w) {
							before[k.d].add(e.d);
						}
						pq.offer(new Edge(k.d, dist[k.d]));//여기서 Edge의 w는 다른의미.  시작점 에서 k.d까지의 최소거리를 의미 . 에지의 가중치가 아님 
					}
					
				}
			}
			int[] candidate = new int[t];
			for(int i = 0 ; i < t ; i++) {
				candidate[i] = Integer.parseInt(br.readLine());
			}
			ArrayList<Integer> ans = new ArrayList<>();
			for(int c : candidate) {
				if(isRight(c, g, h, s)) {
					ans.add(c);
				}
			}
			Collections.sort(ans);
			for(int a : ans) {
				bw.write(a + " ");
			}
			bw.write("\n");
			bw.flush();
			
		}
		br.close();
		bw.close();
	}
	static boolean isRight(int c, int g, int h, int s) {
		if(c == s ) {
			return false;
		}else {
			for(int before : before[c]) {
				if((c == h && before == g)  ||  (c == g && before == h)) {
					return true;
				}else {
					if(isRight(before, g, h , s)) return true;
				}
			}
			return false;
		}
	}
	static class Edge implements Comparable<Edge>{
		int d;//간선의 목적지 
		int w;// 간선의 가중치 
		Edge(int d, int w) {
			this.d = d;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
	}

}
