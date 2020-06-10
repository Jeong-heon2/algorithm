package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*�ּҺ�� ���ϱ�
[�Է�]
ù° �ٿ� ������ ���� N(1 �� N �� 1,000)�� �־����� ��° �ٿ��� ������ ���� M(1 �� M �� 100,000)�� �־�����.
 �׸��� ��° �ٺ��� M+2�ٱ��� ������ ���� ������ ������ �־�����. ���� ó������ �� ������ ��� ������ ��ȣ�� �־�����. 
 �׸��� �� �������� �������� ���� ��ȣ�� �־����� �� �� ���� ����� �־�����. ���� ����� 0���� ũ�ų� ����, 100,000���� ���� �����̴�.
�׸��� M+3° �ٿ��� �츮�� ���ϰ��� �ϴ� ���� ������� ���ù�ȣ�� �������� ���ù�ȣ�� �־�����.
 ��������� �������� �� �� �ִ� ��츸 �Է����� �־�����.

[���]
ù° �ٿ� ��� ���ÿ��� ���� ���ñ��� ���µ� ��� �ּ� ����� ����Ѵ�.
 */
public class Q1916 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//������ ����
		int N = Integer.parseInt(br.readLine());
		//������ ����
		int M = Integer.parseInt(br.readLine());
		
		int[] dist = new int[N+1];
		ArrayList<Edge>[] arr = (ArrayList<Edge>[])new ArrayList[N+1];
		//�ʱ�ȭ
		for(int i = 0 ; i < N+1; i++) {
			arr[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		//�Է�
		for(int i = 1 ; i <= M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[s].add(new Edge(e, v));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
		br.close();
		
		//dijkstra
		//���۳�忡�� ���۳��ΰ��� ����� 0�̹Ƿ� 
		dist[start] = 0; 
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.offer(new Edge(start, 0));
		
		while(pq.size() > 0) {
			Edge edge = pq.poll();
			if(visited[edge.dest]) continue;
			visited[edge.dest] = true;
			for(Edge e : arr[edge.dest]) {
				if(!visited[e.dest]) {
					dist[e.dest] = Math.min(dist[e.dest], dist[edge.dest] + e.val);
					//���������� dist������ edge�� �ٽ� ���� ť�� �־��ش�. 
					pq.offer(new Edge(e.dest, dist[e.dest]));
				}
			}
		}
		System.out.println(dist[destination]);
		
		

	}
	static class Edge implements Comparable<Edge>{
		int dest;
		int val;
		Edge(int d, int v){
			this.dest = d;
			this.val = v;
		}
		@Override
		public int compareTo(Edge o) {
			return this.val > o.val ? 1 : -1;
		}
	}

}
