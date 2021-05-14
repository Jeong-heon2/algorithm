package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q16964 {
	static int[] route;
	static int idx;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		route = new int[N];
		idx = 1;
		arr = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 1 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		if(dfs(visited, 1)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	private static boolean dfs(boolean[] visited, int s) {
		boolean flag = false;//s에서 다음 노드로 방문할 곳이 있는지 
		for(int next : arr[s]) {
			if(!visited[next]) {
				flag = true;
				if(next == route[idx]) {
					visited[next] = true;
					idx++;
					if(!dfs(visited, next)) {
						return false;
					}else {
						return true;
					}
				}
			}
		}
		if(flag) {
			//방문할 곳들이 있었는데 입력으로 주어진 길과 다름 
			return false;
		}
		return true;
	}

}
