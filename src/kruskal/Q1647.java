package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*도시 분할 계획
마을의 이장은 마을을 두 개의 분리된 마을로 분할할 계획을 가지고 있다.
마을을 분할할 때는 각 분리된 마을 안에 집들이 서로 연결되도록 분할해야 한다. 
각 분리된 마을 안에 있는 임의의 두 집 사이에 경로가 항상 존재해야 한다는 뜻이다. 
마을에는 집이 하나 이상 있어야 한다.

그렇게 마을의 이장은 계획을 세우다가 마을 안에 길이 너무 많다는 생각을 하게 되었다. 
일단 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다. 
그리고 각 분리된 마을 안에서도 임의의 두 집 사이에 경로가 항상 존재하게 하면서 길을 더 없앨 수 있다. 
마을의 이장은 위 조건을 만족하도록 길들을 모두 없애고 나머지 길의 유지비의 합을 최소로 하고 싶다. 이것을 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 집의 개수N, 길의 개수M이 주어진다. N은 2이상 100,000이하인 정수이고, M은 1이상 1,000,000이하인 정수이다. 
그 다음 줄부터 M줄에 걸쳐 길의 정보가 A B C 세 개의 정수로 주어지는데 A번 집과 B번 집을 연결하는 길의 유지비가 C (1 ≤ C ≤ 1,000)라는 뜻이다.
[출력]
첫째 줄에 없애고 남은 길 유지비의 합의 최솟값을 출력한다.
 */
//접근법 : 크루스칼 알고리즘으로 최소스패닝트리를 구하고 거기서 최대 가중치를 가지는 에지를 제거
class Edge2 implements Comparable<Edge2>{
	int s;
	int e;
	int v;
	Edge2(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	@Override
	public int compareTo(Edge2 o) {
		return this.v > o.v ? 1 : -1;
	}
	
}
public class Q1647 {
	static int[] parents;//부모 노드가 누구인지
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//전체 마을 수
		int N = Integer.parseInt(st.nextToken());
		//길의 수
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			parents[i] = i;
		}
		PriorityQueue<Edge2> pq = new PriorityQueue<>();
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Edge2(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int result = 0;
		int max = 0;
		while(pq.size() > 0) {
			Edge2 edge = pq.poll();
			if(isSameParents(edge.s, edge.e)) continue;
			union(edge.s, edge.e);
			result += edge.v;
			max = Math.max(edge.v, max);
		}
		System.out.println(result - max);
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

}
