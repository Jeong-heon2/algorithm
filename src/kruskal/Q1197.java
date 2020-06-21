package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�Է�
ù° �ٿ� ������ ���� V(1 �� V �� 10,000)�� ������ ���� E(1 �� E �� 100,000)�� �־�����. 
���� E���� �ٿ��� �� ������ ���� ������ ��Ÿ���� �� ���� A, B, C�� �־�����. 
�̴� A�� ������ B�� ������ ����ġ C�� �������� ����Ǿ� �ִٴ� �ǹ��̴�. 
C�� ������ ���� ������, ������ 1,000,000�� ���� �ʴ´�.

�׷����� ������ 1������ V������ ��ȣ�� �Ű��� �ְ�, ������ �� ���� ���̿� ��ΰ� �ִ�. 
�ּ� ���д� Ʈ���� ����ġ�� -2,147,483,648���� ũ�ų� ����, 
2,147,483,647���� �۰ų� ���� �����͸� �Է����� �־�����.

���]
ù° �ٿ� �ּ� ���д� Ʈ���� ����ġ�� ����Ѵ�.
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
