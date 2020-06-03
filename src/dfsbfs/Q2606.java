package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//unionfind말고 dfs bfs로도 풀 수 있어 보여서 풀어보았다.
//백준 2606 바이러스
public class Q2606 {
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr;
		arr = new ArrayList[N+1];
		for(int i = 1 ; i < N+1 ; i++) {
			arr[i] = new ArrayList<>();
		}
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			arr[com1].add(com2);
			arr[com2].add(com1);
		}
		BFS(arr, 1, N+1);
		System.out.println(ans);
	}
	public static void BFS(ArrayList<Integer>[] arr, int start, int n) {
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while(q.size() > 0) {
			int curr = q.poll();
			visited[curr] = true;
			for(int e : arr[curr]) {
				//q에 없고 방문하지 않았다면
				if(!q.contains(e) && !visited[e]) {
					q.offer(e);
					ans++;
				}
			}
		}
	}

}
