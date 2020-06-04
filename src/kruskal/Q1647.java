package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*���� ���� ��ȹ
������ ������ ������ �� ���� �и��� ������ ������ ��ȹ�� ������ �ִ�.
������ ������ ���� �� �и��� ���� �ȿ� ������ ���� ����ǵ��� �����ؾ� �Ѵ�. 
�� �и��� ���� �ȿ� �ִ� ������ �� �� ���̿� ��ΰ� �׻� �����ؾ� �Ѵٴ� ���̴�. 
�������� ���� �ϳ� �̻� �־�� �Ѵ�.

�׷��� ������ ������ ��ȹ�� ����ٰ� ���� �ȿ� ���� �ʹ� ���ٴ� ������ �ϰ� �Ǿ���. 
�ϴ� �и��� �� ���� ���̿� �ִ� ����� �ʿ䰡 �����Ƿ� ���� �� �ִ�. 
�׸��� �� �и��� ���� �ȿ����� ������ �� �� ���̿� ��ΰ� �׻� �����ϰ� �ϸ鼭 ���� �� ���� �� �ִ�. 
������ ������ �� ������ �����ϵ��� ����� ��� ���ְ� ������ ���� �������� ���� �ּҷ� �ϰ� �ʹ�. �̰��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù° �ٿ� ���� ����N, ���� ����M�� �־�����. N�� 2�̻� 100,000������ �����̰�, M�� 1�̻� 1,000,000������ �����̴�. 
�� ���� �ٺ��� M�ٿ� ���� ���� ������ A B C �� ���� ������ �־����µ� A�� ���� B�� ���� �����ϴ� ���� ������ C (1 �� C �� 1,000)��� ���̴�.
[���]
ù° �ٿ� ���ְ� ���� �� �������� ���� �ּڰ��� ����Ѵ�.
 */
//���ٹ� : ũ�罺Į �˰������� �ּҽ��д�Ʈ���� ���ϰ� �ű⼭ �ִ� ����ġ�� ������ ������ ����
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
	static int[] parents;//�θ� ��尡 ��������
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//��ü ���� ��
		int N = Integer.parseInt(st.nextToken());
		//���� ��
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
