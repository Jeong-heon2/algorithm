package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//크루스칼 알고리즘 구현 기본
//입력은 첫 째줄에 정점개수 , 둘째줄에 간선개수 
//셋째줄부터  간선개수만큼  노드번호 노드번호 가중치  이런식으로  노드정보입력.
//출력은 최소신장트리 비용 
//union find , priority Queue 이용.
class Edge implements Comparable<Edge>{
	//연결된 노드 번호
	int s;
	int e;
	//가중치 
	int v; 
	Edge(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	//작은것이 우선순위 
	@Override
	public int compareTo(Edge o) {
		return this.v > o.v ? 1 : -1;
	}
	
}
public class Kruskal {
	//사이클 확인용 
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 노드 개수 
		int E = Integer.parseInt(br.readLine()); // 에지 개수 
		parents = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			parents[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		while(E-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Edge(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int result = 0;
		while(pq.size() > 0) {
			//가중치가 가장 작은 에지부터 튀어나옴. 
			Edge edge = pq.poll();
			
			//사이클이 생기면 안 되니까 건너뛴다.
			if(isSameParents(edge.e,edge.s)) continue;
			
			//이 에지를 선택하겠다 
			union(edge.e, edge.s);
			result += edge.v;
		}
		System.out.println(result);
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
