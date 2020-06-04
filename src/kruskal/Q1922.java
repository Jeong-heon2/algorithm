package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
[입력]
첫째 줄에 컴퓨터의 수 N (1 ≤ N ≤ 1000)가 주어진다.
둘째 줄에는 연결할 수 있는 선의 수 M (1 ≤ M ≤ 100,000)가 주어진다.
셋째 줄부터 M+2번째 줄까지 총 M개의 줄에 각 컴퓨터를 연결하는데 드는 비용이 주어진다. 
이 비용의 정보는 세 개의 정수로 주어지는데,
 만약에 a b c 가 주어져 있다고 하면 a컴퓨터와 b컴퓨터를 연결하는데 비용이 c (1 ≤ c ≤ 10,000) 만큼 든다는 것을 의미한다.
 a와 b는 같을 수도 있다.
[출력]
모든 컴퓨터를 연결하는데 필요한 최소비용을 첫째 줄에 출력한다.
 */
class Edge implements Comparable<Edge>{
	int s;
	int e;
	int v;//가중치
	Edge(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	//오름 차순 정렬
	@Override
	public int compareTo(Edge o) {
		return this.v > o.v ? 1 : -1;
	}
}
public class Q1922 {
	static int[] parents;//union find 부모
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//컴터 수
		int N = Integer.parseInt(br.readLine());
		//선의 수
		int M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		for(int i = 1 ; i<=N ; i++) {
			parents[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Edge(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int ans = 0;
		while(pq.size() > 0) {
			Edge edge = pq.poll();
			//사이클이 생기면 안 되니까
			if(isSameParents(edge.s, edge.e)) continue;
			//이 선을 간택하겠다
			union(edge.s, edge.e);
			ans += edge.v;
		}
		System.out.println(ans);
	}
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(y > x) parents[y] = x;
			else parents[x] = y;
		}
	}
	private static boolean isSameParents(int x, int y) {
		if(find(x) == find(y)) return true;
		return false;
	}
}
