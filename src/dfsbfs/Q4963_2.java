package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4963_2 {
	static int w;
	static int h;
	static int[][] arr = new int[50][50];
	static boolean[][] visited = new boolean[50][50];
	static int[] goX = {1,-1,0,0,1,-1,-1,1};
	static int[] goY = {0,0,1,-1,-1,-1,1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] tmp = br.readLine().split(" ");
			w = Integer.parseInt(tmp[0]);
			h = Integer.parseInt(tmp[1]);
			if(w == 0 && h == 0) break;
			for(int i = 0 ; i < h ; i++) {
				tmp = br.readLine().split(" ");
				for(int j = 0 ; j < w ; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
					visited[i][j] = false;
				}
			}
			int cnt = 0;
			for(int i = 0 ; i < h ; i++) {
				for(int j = 0 ; j < w ; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static void dfs(int y, int x) {
		if(visited[y][x]) return;
		visited[y][x] = true;
		for(int i = 0 ; i < 8 ; i++) {
			int nX = x + goX[i];
			int nY = y + goY[i];
			if(nX < 0 || nX >=w || nY < 0 || nY >= h) continue;
			if(!visited[nY][nX] && arr[nY][nX] == 1) dfs(nY,nX);
		}
	}
}
