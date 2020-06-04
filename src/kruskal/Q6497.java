package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*���³�
���� ���ε��� �� �θ� �Ϸ翡 ���� ���� ����ŭ ���� ���µ�, 
�Ϻθ� �ҵ��Ͽ� �׸�ŭ�� ���� ������ �� �ִ�.
�׷��� ���� � �� ���� �շ��� ��, 
���� ���� ���� ���� ���� �ݵ�� ������ �Ѵٸ� �����ϴ�. 
�׷��� ���ÿ� �ִ� ��� �� �� �ֿ� ����, ���� ���� �游���� ���θ� �շ��� �� �־�� �Ѵ�.
�� ������ ��Ű�鼭 ������ �� �ִ� �ִ� �׼��� ���Ͻÿ�.

[�Է�]
�Է��� ���� ���� �׽�Ʈ ���̽��� ���еǾ� �ִ�.
�� �׽�Ʈ ���̽��� ù° �ٿ��� ���� �� m�� ���� �� n�� �־�����. (1 �� m �� 200000, m-1 �� n �� 200000)
�̾ n���� �ٿ� �� �濡 ���� ���� x, y, z�� �־����µ�, 
�̴� x�� ���� y�� �� ���̿� ����� ���ΰ� ������ �� �Ÿ��� z���Ͷ�� ���̴�. 
(0 �� x, y < m, x �� y)
���ô� �׻� ���� �׷����� �����̰�(��, � �� ���� ��� ���� �շ��� �� �ִ� ��ΰ� �ִ�), 
���û��� ��� ���� �Ÿ� ���� 231���ͺ��� �۴�.
�Է��� �������� ù �ٿ� 0�� 2�� �־�����.

[���]
�� �׽�Ʈ ���̽����� �� �ٿ� ���� ������ �� �ִ� �ִ� ����� ����Ѵ�.
 */
//���ٹ� : kruskal �˰������� �ּ� ���д� Ʈ���� ���ϰ�
//��ü ���� ����� ���� - �ּ� ���д� Ʈ�� ��� ���� �� ���Ѵ�.

public class Q6497 {
	static int[] parents;//�θ��� 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//�� �� ����
			int N = Integer.parseInt(st.nextToken());
			//���� ���� 
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			parents = new int[N];
			for(int i = 0 ; i < N ; i++) {
				parents[i] = i;
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			while(M-- > 0) {
				st = new StringTokenizer(br.readLine());
				//��1 
				int h1 = Integer.parseInt(st.nextToken());
				//��2
				int h2 = Integer.parseInt(st.nextToken());
				//��
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
		int v;//��
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
