package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*�༺�ͳ�
�༺�� 3���� ��ǥ���� �� ������ �����ϸ� �ȴ�. 
�� �༺ A(xA, yA, zA)�� B(xB, yB, zB)�� �ͳη� ������ �� ��� ����� min(|xA-xB|, |yA-yB|, |zA-zB|)�̴�.
�����̴� �ͳ��� �� N-1�� �Ǽ��ؼ� ��� �༺�� ���� ����ǰ� �Ϸ��� �Ѵ�. 
�̶�, ��� �༺�� �ͳη� �����ϴµ� �ʿ��� �ּ� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
[�Է�]
ù° �ٿ� �༺�� ���� N�� �־�����. (1 �� N �� 100,000) ���� N�� �ٿ��� �� �༺�� x, y, z��ǥ�� �־�����. ��ǥ�� -109���� ũ�ų� ����, 109���� �۰ų� ���� �����̴�. �� ��ġ�� �༺�� �� �� �̻� �ִ� ���� ����. 

[���]
ù° �ٿ� ��� �༺�� �ͳη� �����ϴµ� �ʿ��� �ּ� ����� ����Ѵ�.
 */
//���ٹ� : ������ �Է¹����鼭 ����Ʈ�� �ִ´�, �� ��尡 �Էµɶ����� 
//����Ʈ�� ��� ������� ������ ���ؼ� �켱����ť���ִ´�. �׸��� ũ�罺Į �˰���. 
public class Q2887 {
	static int[] parents;//�θ��尡 �������� 
	static int N;//��� ���� 
	static PriorityQueue<Edge> pq;// ����(�ͳ�) �켱���� ť 
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
