package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
입력]
첫째 줄에 별의 개수 n이 주어진다. (1 ≤ n ≤ 100)

둘째 줄부터 n개의 줄에 걸쳐 각 별의 x, y좌표가 실수 형태로 주어지며, 최대 소수점 둘째자리까지 주어진다. 좌표는 1000을 넘지 않는 양의 실수이다.

출력]
첫째 줄에 정답을 출력한다. 절대/상대 오차는 10-2까지 허용한다.
 */
//접근법 : kruskal 
public class Q4386 {
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//별의 개수
		int n = Integer.parseInt(br.readLine());
		Star[] stars = new Star[n];
		parents = new int[n];
		for(int i = 0 ; i < n; i++) {
			parents[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			stars[i] = new Star(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()));
			//i번 별과 0 ~ i-1번 별의 에지를 생성 
			for(int j = 0 ; j < i ; j++) {
				float w = getW(stars[i].x, stars[i].y, stars[j].x, stars[j].y);
				pq.offer(new Edge(i, j, w));
			}
		}
		float ans = 0f;
		while(pq.size() > 0) {
			Edge e = pq.poll();
			if(find(e.e) == find(e.s)) continue;
			union(e.e , e.s);
			ans += e.w;
		}
		System.out.println(ans);
		
		
	}
	static int find(int x) {
		if(parents[x] == x) return x;
		else return parents[x] = find(parents[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(y > x) parents[y] = x;
			else parents[x] = y;
		}
	}
	static float getW(float x, float y, float x2, float y2) {
		return (float) Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2));
	}
	static class Star{
		float x;
		float y;
		Star(float x, float y){
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge>{
		int e;
		int s;
		float w;
		Edge(int e, int s, float w){
			this.e = e;
			this.s = s;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w > o.w ? 1 : -1;
		}
	}

}
