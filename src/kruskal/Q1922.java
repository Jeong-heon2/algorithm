package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
[�Է�]
ù° �ٿ� ��ǻ���� �� N (1 �� N �� 1000)�� �־�����.
��° �ٿ��� ������ �� �ִ� ���� �� M (1 �� M �� 100,000)�� �־�����.
��° �ٺ��� M+2��° �ٱ��� �� M���� �ٿ� �� ��ǻ�͸� �����ϴµ� ��� ����� �־�����. 
�� ����� ������ �� ���� ������ �־����µ�,
 ���࿡ a b c �� �־��� �ִٰ� �ϸ� a��ǻ�Ϳ� b��ǻ�͸� �����ϴµ� ����� c (1 �� c �� 10,000) ��ŭ ��ٴ� ���� �ǹ��Ѵ�.
 a�� b�� ���� ���� �ִ�.
[���]
��� ��ǻ�͸� �����ϴµ� �ʿ��� �ּҺ���� ù° �ٿ� ����Ѵ�.
 */
class Edge implements Comparable<Edge>{
	int s;
	int e;
	int v;//����ġ
	Edge(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	//���� ���� ����
	@Override
	public int compareTo(Edge o) {
		return this.v > o.v ? 1 : -1;
	}
}
public class Q1922 {
	static int[] parents;//union find �θ�
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//���� ��
		int N = Integer.parseInt(br.readLine());
		//���� ��
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
			//����Ŭ�� ����� �� �Ǵϱ�
			if(isSameParents(edge.s, edge.e)) continue;
			//�� ���� �����ϰڴ�
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
