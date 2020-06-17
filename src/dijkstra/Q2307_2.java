package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*���� �˹�
1.�ּҰ��, �ּҰ���� ��� �� ��� ���Ѵ���
2.�ּҰ�ο� ���Ե� �����鸸 �ϳ��� �����ϰ� �ٽ� ���ͽ�Ʈ�� ������ �ּҺ���� ���Ѵ�.
2���� ���� ����� �ִ밪�� ���� ��, �ּ� ��ο� ���ָ� ����.
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
					//��ε� ������Ʈ
					path[e.to] = edge.to;
					pq.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
		min = dist[N];
		//�ּ� ��� : path , �ּҰ�� ����ġ : min
		//path[i] = j �϶� , �ּ� ��θ� ���� i��带 �湮�ϱ� ���ؼ��� j��� > i���� �湮�ؾ��Ѵ�.
		
		
		int to = N;
		int max = 0;
		do {
			//from ���� to ��带 �մ� ������ �̹� ���忡�� ���ܽ�Ų��. 
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
