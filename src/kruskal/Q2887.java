package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*행성터널
행성은 3차원 좌표위의 한 점으로 생각하면 된다. 
두 행성 A(xA, yA, zA)와 B(xB, yB, zB)를 터널로 연결할 때 드는 비용은 min(|xA-xB|, |yA-yB|, |zA-zB|)이다.
민혁이는 터널을 총 N-1개 건설해서 모든 행성이 서로 연결되게 하려고 한다. 
이때, 모든 행성을 터널로 연결하는데 필요한 최소 비용을 구하는 프로그램을 작성하시오.
[입력]
첫째 줄에 행성의 개수 N이 주어진다. (1 ≤ N ≤ 100,000) 다음 N개 줄에는 각 행성의 x, y, z좌표가 주어진다. 좌표는 -109보다 크거나 같고, 109보다 작거나 같은 정수이다. 한 위치에 행성이 두 개 이상 있는 경우는 없다. 

[출력]
첫째 줄에 모든 행성을 터널로 연결하는데 필요한 최소 비용을 출력한다.
 */
//접근법 : 노드들을 입력받으면서 리스트에 넣는다, 한 노드가 입력될때마다 
//리스트의 모든 노드들과의 에지를 구해서 우선순위큐에넣는다. 그리고 크루스칼 알고리즘. 
public class Q2887 {
	static int[] parents;//부모노드가 누구인지 
	static int N;//노드 개수 
	static PriorityQueue<Edge> pq;// 에지(터널) 우선순위 큐 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parents = new int[N];
		ArrayList<Node> list = new ArrayList<>();
		pq = new PriorityQueue<>();
		for(int i = 0 ; i < N ; i++) {
			parents[i] = i;
		}
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
					, Integer.parseInt(st.nextToken()));
			for(int j = 0 ; j < list.size() ; j++) {
				Node node2 = list.get(j);
				pq.offer(new Edge(j,i, Math.min(Math.abs(node2.z - node.z), 
							Math.min(Math.abs(node2.x - node.x), 
									Math.abs(node2.y - node.y)))));
			}
			list.add(node);
		}
		int ans = 0;
		while(pq.size() > 0) {
			Edge edge = pq.poll();
			if(isSameParents(edge.s, edge.e)) continue;
			union(edge.s, edge.e);
			ans += edge.v;
		}
		System.out.println(ans);
	}
	static int find (int x) {
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
	static boolean isSameParents(int x, int y) {
		if(find(x) == find(y)) return true;
		else return false;
	}
	static class Node {
		int x;
		int y;
		int z;
		Node(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static class Edge implements Comparable<Edge>{
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
