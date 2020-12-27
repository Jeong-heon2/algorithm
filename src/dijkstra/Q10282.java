package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�Է�]
ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �׽�Ʈ ���̽��� ������ �ִ� 100���̴�. �� �׽�Ʈ ���̽��� ������ ���� �̷���� �ִ�.

ù° �ٿ� ��ǻ�� ���� n, ������ ���� d, ��ŷ���� ��ǻ���� ��ȣ c�� �־�����(1 �� n �� 10,000, 1 �� d �� 100,000, 1 �� c �� n).
�̾ d���� �ٿ� �� �������� ��Ÿ���� ���� a, b, s�� �־�����(1 �� a, b �� n, a �� b, 0 �� s �� 1,000). �̴� ��ǻ�� a�� ��ǻ�� b�� �����ϸ�, ��ǻ�� b�� �����Ǹ� s�� �� ��ǻ�� a�� �������� ���Ѵ�.
�� �׽�Ʈ ���̽����� ���� ������ (a, b)�� �� �� �̻� �������� �ʴ´�.

���]
�� �׽�Ʈ ���̽����� �� �ٿ� ���� �� �����Ǵ� ��ǻ�� ��, ������ ��ǻ�Ͱ� �����Ǳ���� �ɸ��� �ð��� �������� �������� ����Ѵ�.
 */
//������ �����ϴ� �ڷᱸ��, stringbuilder��� �ϸ� �ð��� �� ���� �� ���� ������? 
public class Q10282 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//test case
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int[] dist ;
			StringTokenizer st = new StringTokenizer(br.readLine());
			//count of computers
			int n = Integer.parseInt(st.nextToken());
			//count of dependencies
			int d = Integer.parseInt(st.nextToken());
			//num of hacked com
			int c = Integer.parseInt(st.nextToken());
			
			dist = new int[n+1];
			@SuppressWarnings("unchecked")
			ArrayList<Edge>[] arr = (ArrayList<Edge>[])new ArrayList[n+1];
			for(int i = 1 ; i <= n ; i ++) {
				arr[i] = new ArrayList<>();
				dist[i] = Integer.MAX_VALUE;
			}
			for(int i = 0 ; i < d ; i ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				arr[b].add(new Edge(a, s));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			dist[c] = 0;
			pq.add(new Edge(c, 0));
			
			while(pq.size() > 0) {
				Edge curr = pq.poll();
				for(Edge e : arr[curr.e]) {
					if(dist[e.e] > dist[curr.e] + e.w) {
						dist[e.e] = dist[curr.e] + e.w;
						pq.add(new Edge(e.e, dist[e.e]));
					}
				}
			}
			int max = 0;
			int cnt = 0;
			for(int i = 1 ; i <= n ; i++) {
				if(dist[i] != Integer.MAX_VALUE) {
					cnt ++;
					if(max < dist[i]) max = dist[i];
				}
			}
			System.out.println(cnt + " " + max);
		}

	}
	static class Edge implements Comparable<Edge>{
		int e;
		int w;
		Edge(int e, int w){
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w ;
		}
	}
}
