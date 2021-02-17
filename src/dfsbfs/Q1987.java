package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1987 {
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	static int R;
	static int C;
	static int ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		R = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);
		ans = 1;
		char[][] map = new char[R][C];
		for(int i = 0 ; i < R ;i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		boolean[] visited = new boolean['Z'-'A' + 1];
		visited[map[0][0] - 'A'] = true;
		dfs(map, visited, 0, 0 , 1);
		System.out.println(ans);
	}
	public static void dfs(char[][] map, boolean[] visited, int x, int y, int depth) {
		for(int i = 0 ; i < 4 ; i++) {
			int ny = y + goY[i];
			int nx = x + goX[i];
			if(isRanged(ny, nx)) {
				int idx = map[ny][nx] - 'A';
				if(!visited[idx]) {
					ans = Math.max(depth + 1, ans);
					visited[idx] = true;
					dfs(map, visited, nx, ny, depth + 1);
					visited[idx] = false;
				}
			}
		}
	}
	public static boolean isRanged(int y, int x) {
		if(y < 0 || y >= R || x < 0 || x >= C) {
			return false;
		}
		return true;
	}

}
