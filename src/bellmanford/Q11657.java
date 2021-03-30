package bellmanford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//���� 11657 Ÿ�Ӹӽ� 
//�������� �⺻ ���� 
//https://www.youtube.com/watch?v=Ppimbaxm8d8 ���� 
public class Q11657 {
	static long[] dist;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//����� ���� , ������ ������ �Է� �ޱ� 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//��� ������ ���� ������ ��� �ڷᱸ�� 
		Edge[] arr = new Edge[M];
		//�ִ� �Ÿ� ���̺��� ���� ���� �ʱ�ȭ 
		dist = new long[N+1];
		for(int i = 1 ; i <= N ; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		//��� ���� ������ �Է¹ޱ� 
		for(int i = 0 ; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i] = new Edge(s, e, w);
		}
		//���� ���� �˰��� ���� 
		if (bellmanford(arr, 1, N, M)) {//���� ��� = 1 
			System.out.println("-1");
		}else {
			// 1 �� ��带 ������ �ٸ� ��� ���� ���� ���� �ִ� �Ÿ� ��� 
			for(int i = 2 ; i <= N ; i++) {
				if(dist[i] == Integer.MAX_VALUE) {
					System.out.println("-1");
				}else {
					System.out.println(dist[i]);
				}
			}
		}
	}
	//�ð����⵵�� O(NM)
	private static boolean bellmanford(Edge[] edges, int start, int n , int m) {
		//���� ��� �ʱ�ȭ 
		dist[start] = 0;
		//��ü n���� ���� �ݺ� 
		for(int i = 0 ; i < n ; i++) {
			//�� �ݺ����� ��� edge�� Ȯ�� 
			for(int j = 0 ; j < m ; j++) {
				int cur = edges[j].s;
				int next = edges[j].d;
				int cost = edges[j].w;
				//���� edge�� ���ļ� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ��� 
				if(dist[cur] != Integer.MAX_VALUE && dist[next] > dist[cur] + cost) {
					dist[next] = dist[cur] + cost;
					//n��° ���忡���� ���� ���� �ȴٸ� ���� ��ȯ�� ����! 
					//why? �ִ� ��ζ�� ���� ���� ������ �� �� ���� ���� ���� ������ ������ �ִ� ��ο��� ��ġ�� ������ ������ ���ƺ��� N-1���Դϴ�. 
					//�׷��� ���� ����Ŭ�� �ִٸ�, N�� °���� ������ ��� �� ���� �߻��ϰ� �˴ϴ�. 
					//���� ���带 N�� ������  ������ N��°�� ������ �߻��ϴ��� üũ�ϸ�  ���� ����Ŭ ���縦 Ȯ���� �� �ֽ��ϴ�. 
					if (i == n - 1) {
						return true;
					}
				}
			}
		}
		return false;
	}
	static class Edge{
		int s;//source ��� 
		int d;//destination ��� 
		int w;//����ġ 
		Edge(int s, int d, int w){
			this.s = s;
			this.d = d;
			this.w = w;
		}
	}
}
