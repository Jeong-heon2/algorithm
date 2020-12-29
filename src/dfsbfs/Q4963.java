package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q4963 {
	static int[] goX = {1,-1,0,0,1,-1,-1,1};
	static int[] goY = {0,0,1,-1,-1,-1,1,1};
	static int w;
	static int h;
	static boolean[][] visited = new boolean[50][50];
	static int[][] arr = new int[50][50];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			String[] tmp = br.readLine().split(" ");
			w = Integer.parseInt(tmp[0]);
			h = Integer.parseInt(tmp[1]);
			if(w == 0 & h == 0) break;
			for(int i = 0 ; i < h ; i++) {
				tmp = br.readLine().split(" ");
				for(int j = 0 ; j < w ; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
					visited[i][j] = false;
				}
			}
			int ans = 0;
			for(int i = 0 ; i < h ; i++) {
				for(int j = 0 ; j < w ; j++) {
					if(!visited[i][j] && arr[i][j] == 1) {
						bfs(arr, i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
			
		}while(true);
	}
	public static void bfs(int[][] arr, int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		while(q.size() > 0) {
			Point cur = q.poll();
			for(int i = 0 ; i < 8; i++) {
				int nextX = cur.x + goX[i];
				int nextY = cur.y + goY[i];
				if(!isRanged(nextX, nextY)) continue;
				if(arr[nextY][nextX] == 1 && !visited[nextX][nextY]) {
					q.add(new Point(nextX, nextY));
					visited[nextY][nextX] = true;
				}
			}
		}
		
	}
	public static boolean isRanged(int x, int y) {
		if(x < 0 || x >= w || y < 0 || y >= h) return false;
		return true;
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
