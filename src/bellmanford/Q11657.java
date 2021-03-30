package bellmanford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 11657 타임머신 
//벨만포드 기본 문제 
//https://www.youtube.com/watch?v=Ppimbaxm8d8 참고 
public class Q11657 {
	static long[] dist;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//노드의 개수 , 간선의 개수를 입력 받기 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//모든 간선에 대한 정보를 담는 자료구조 
		Edge[] arr = new Edge[M];
		//최단 거리 테이블을 무한 으로 초기화 
		dist = new long[N+1];
		for(int i = 1 ; i <= N ; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		//모든 간선 정보를 입력받기 
		for(int i = 0 ; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i] = new Edge(s, e, w);
		}
		//벨만 포드 알고리즘 수행 
		if (bellmanford(arr, 1, N, M)) {//시작 노드 = 1 
			System.out.println("-1");
		}else {
			// 1 번 노드를 제외한 다른 모든 노드로 가기 위한 최단 거리 출력 
			for(int i = 2 ; i <= N ; i++) {
				if(dist[i] == Integer.MAX_VALUE) {
					System.out.println("-1");
				}else {
					System.out.println(dist[i]);
				}
			}
		}
	}
	//시간복잡도는 O(NM)
	private static boolean bellmanford(Edge[] edges, int start, int n , int m) {
		//시작 노드 초기화 
		dist[start] = 0;
		//전체 n번의 라운드 반복 
		for(int i = 0 ; i < n ; i++) {
			//매 반복마다 모든 edge를 확인 
			for(int j = 0 ; j < m ; j++) {
				int cur = edges[j].s;
				int next = edges[j].d;
				int cost = edges[j].w;
				//현재 edge를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 
				if(dist[cur] != Integer.MAX_VALUE && dist[next] > dist[cur] + cost) {
					dist[next] = dist[cur] + cost;
					//n번째 라운드에서도 값이 갱신 된다면 음수 순환이 존재! 
					//why? 최단 경로라는 말은 같은 정점을 두 번 지날 일이 없기 때문에 가능한 최단 경로에서 거치는 간선의 개수는 많아봐야 N-1개입니다. 
					//그런데 음수 싸이클이 있다면, N번 째에도 갱신이 적어도 한 번은 발생하게 됩니다. 
					//따라서 라운드를 N번 돌리고  마지막 N번째에 갱신이 발생하는지 체크하면  음수 사이클 존재를 확인할 수 있습니다. 
					if (i == n - 1) {
						return true;
					}
				}
			}
		}
		return false;
	}
	static class Edge{
		int s;//source 노드 
		int d;//destination 노드 
		int w;//가중치 
		Edge(int s, int d, int w){
			this.s = s;
			this.d = d;
			this.w = w;
		}
	}
}
