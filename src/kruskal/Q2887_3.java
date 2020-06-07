package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//결국에 블로그를 참고했다.
//https://dev-jk.tistory.com/29
//x,y,z 좌표별로 행성을 sort하고 
//sort했을 때 인접한 행성들의 간선을 후보에 넣어주는 방법이다..
public class Q2887_3 {
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Planet[] planets = new Planet[N];
		parents = new int[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			planets[i] = new Planet(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					i);
			parents[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//x순 정렬
		Arrays.sort(planets, (o1, o2) -> o1.x > o2.x ? 1 : -1);
		for(int i = 1 ; i < N ; i++) {
			pq.offer(new Edge(planets[i-1].idx, planets[i].idx, 
					Math.abs(planets[i-1].x - planets[i].x)));
		}
		//y순 정렬
		Arrays.sort(planets, (o1, o2) -> o1.y > o2.y ? 1 : -1);
		for(int i = 1 ; i < N ; i++) {
			pq.offer(new Edge(planets[i-1].idx, planets[i].idx, 
					Math.abs(planets[i-1].y - planets[i].y)));
		}
		//z순 정렬
		Arrays.sort(planets, (o1, o2) -> o1.z > o2.z ? 1 : -1);
		for(int i = 1 ; i < N ; i++) {
			pq.offer(new Edge(planets[i-1].idx, planets[i].idx, 
					Math.abs(planets[i-1].z - planets[i].z)));
		}
		//kruskal
		int ans = 0;
		while(pq.size() > 0) {
			Edge edge = pq.poll();
			if(isSameParents(edge.s, edge.e)) continue;
			union(edge.s, edge.e);
			ans += edge.v;
		}
		System.out.println(ans);
	}
	public static int find(int x) {
		if(parents[x] == x) return x;
		else return parents[x] = find(parents[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if( y > x) parents[y] = x;
			else parents[x] = y;
		}
	}
	public static boolean isSameParents(int x, int y) {
		if(find(x) != find(y)) return false;
		else return true;
	}
	public static class Planet{
		int x;
		int y;
		int z;
		int idx;//행성 고유 번호
		Planet(int x, int y, int z, int idx){
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
	}
	public static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int v;
		Edge(int s, int e, int v){
			this.s = s;
			this.e = e;
			this.v = v;
		}
		@Override
		public int compareTo(Edge o) {
			return this.v > o.v ? 1 : -1;
		}
	}
}
