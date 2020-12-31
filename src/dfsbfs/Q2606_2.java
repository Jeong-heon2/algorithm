package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2606_2 {
	static int ans = 0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String[] tmp = new String[2];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] arr = (ArrayList<Integer>[])new ArrayList[n+1];
		for(int i = 1; i <= n ; i++) arr[i] = new ArrayList<Integer>();
		boolean[] visited = new boolean[n+1];
		while(m-- > 0) {
			tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			arr[a].add(b);
			arr[b].add(a);
		}
		dfs(arr, visited, 1);
		System.out.println(ans-1);

	}
	public static void dfs(ArrayList<Integer>[] arr, boolean[] visited, int i) {
		visited[i] = true;
		ans++;
		for(int j : arr[i]) {
			if(!visited[j]) dfs(arr,visited, j);
		}
	}
}
