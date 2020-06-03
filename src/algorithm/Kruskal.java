package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//ũ�罺Į �˰��� ���� �⺻
//�Է��� ù °�ٿ� �������� , ��°�ٿ� �������� 
//��°�ٺ���  ����������ŭ  ����ȣ ����ȣ ����ġ  �̷�������  ��������Է�.
//����� �ּҽ���Ʈ�� ��� 
//union find , priority Queue �̿�.
class Edge implements Comparable<Edge>{
	//����� ��� ��ȣ
	int s;
	int e;
	//����ġ 
	int v; 
	Edge(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	//�������� �켱���� 
	@Override
	public int compareTo(Edge o) {
		return this.v > o.v ? 1 : -1;
	}
	
}
public class Kruskal {
	//����Ŭ Ȯ�ο� 
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ��� ���� 
		int E = Integer.parseInt(br.readLine()); // ���� ���� 
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
			//����ġ�� ���� ���� �������� Ƣ���. 
			Edge edge = pq.poll();
			
			//����Ŭ�� ����� �� �Ǵϱ� �ǳʶڴ�.
			if(isSameParents(edge.e,edge.s)) continue;
			
			//�� ������ �����ϰڴ� 
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
