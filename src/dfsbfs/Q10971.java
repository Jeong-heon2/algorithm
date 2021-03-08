package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10971 {
	static int N;
	static int ans;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		arr = new int[10][10];
		visited = new boolean[10];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i++) {
			dfs(i, i, 0, 0);
		}
		System.out.println(ans);
	}
	
	private static void dfs(int start, int y, int sum, int cnt) {
		if(cnt == N && start == y) {
			if(ans > sum) ans = sum;
			return;
		}
		for(int x = 0 ; x < N ; x++) {
			if(arr[y][x] == 0) continue;//연결되지 않은 경우 
			//방문 하지않고 , 0 보다 큰 경우 
			if(!visited[y] && arr[y][x] > 0) {
				visited[y] = true;
				sum+= arr[y][x];
				
				if(sum <= ans) {
					dfs(start, x, sum, cnt+1);
				}
				
				visited[y] = false;
				sum-= arr[y][x];
			}
		}
		
	}

}
