package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*전력난
길의 가로등을 켜 두면 하루에 길의 미터 수만큼 돈이 들어가는데, 
일부를 소등하여 그만큼의 돈을 절약할 수 있다.
그러나 만약 어떤 두 집을 왕래할 때, 
불이 켜져 있지 않은 길을 반드시 지나야 한다면 위험하다. 
그래서 도시에 있는 모든 두 집 쌍에 대해, 불이 켜진 길만으로 서로를 왕래할 수 있어야 한다.
위 조건을 지키면서 절약할 수 있는 최대 액수를 구하시오.

[입력]
입력은 여러 개의 테스트 케이스로 구분되어 있다.
각 테스트 케이스의 첫째 줄에는 집의 수 m과 길의 수 n이 주어진다. (1 ≤ m ≤ 200000, m-1 ≤ n ≤ 200000)
이어서 n개의 줄에 각 길에 대한 정보 x, y, z가 주어지는데, 
이는 x번 집과 y번 집 사이에 양방향 도로가 있으며 그 거리가 z미터라는 뜻이다. 
(0 ≤ x, y < m, x ≠ y)
도시는 항상 연결 그래프의 형태이고(즉, 어떤 두 집을 골라도 서로 왕래할 수 있는 경로가 있다), 
도시상의 모든 길의 거리 합은 231미터보다 작다.
입력의 끝에서는 첫 줄에 0이 2개 주어진다.

[출력]
각 테스트 케이스마다 한 줄에 걸쳐 절약할 수 있는 최대 비용을 출력한다.
 */
//접근법 : kruskal 알고리즘으로 최소 스패닝 트리를 구하고
//전체 에지 비용의 총합 - 최소 스패닝 트리 비용 총합 을 구한다.

public class Q6497 {
	static int[] parents;//부모노드 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//집 의 개수
			int N = Integer.parseInt(st.nextToken());
			//길의 개수 
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			parents = new int[N];
			for(int i = 0 ; i < N ; i++) {
				parents[i] = i;
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			while(M-- > 0) {
				st = new StringTokenizer(br.readLine());
				//집1 
				int h1 = Integer.parseInt(st.nextToken());
				//집2
				int h2 = Integer.parseInt(st.nextToken());
				//비
				int val = Integer.parseInt(st.nextToken());
				pq.offer(new Edge(h1,h2,val));
			}
			int res = 0;
			int sum = 0;
			while(pq.size() > 0) {
				Edge edge = pq.poll();
				sum += edge.v;
				if(isSameParents(edge.e, edge.s)) continue;
				union(edge.s, edge.e);
				res += edge.v;
			}
			System.out.println(sum - res);
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
	private static boolean isSameParents(int x, int y) {
		if(find(x) == find(y)) return true;
		else return false;
	}
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int v;//비
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
