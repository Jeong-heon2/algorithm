package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1941 {	
	static int ans;
	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		ans = 0;
		for(int i = 0 ; i < 5 ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean[] visited = new boolean[25];
		combination(visited, 0, 25, 7);
		System.out.println(ans);
	}
	private static void combination(boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			//'S' 학생이 4명 이상인가?
			int cnt = 0;
			int[] bfsStart = new int[2];
			boolean[][] choiced = new boolean[5][5];
			for(int i = 0 ; i < 25 ; i++) {
				if(visited[i]) {
					int y = i/5;
					int x = i%5;
					bfsStart[0] = y;
					bfsStart[1] = x;
					choiced[y][x] = true;
					if(map[y][x] == 'S') cnt++;
				}
			}
			if(cnt >= 4) {
				//서로 인접해있는가? 
				if(bfs(choiced, bfsStart)) {
					ans++;
				}
			}
			
		}else {
			for(int i = start; i < 25 ; i++) {
				visited[i] = true;
				combination(visited, i+1, n, r - 1);
				visited[i] = false;
			}
		}
	}
	private static boolean bfs(boolean[][] choiced, int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		boolean[][] visited = new boolean[5][5];
		visited[start[0]][start[1]] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0 ;i < 4 ; i++) {
				int ny = dy[i] + cur[0];
				int nx = dx[i] + cur[1];
				if(isRanged(ny,nx) && !visited[ny][nx] && choiced[ny][nx]) {
					cnt++;
					q.offer(new int[] {ny,nx});
					visited[ny][nx] = true;
				}
			}
		}
		if(cnt == 7) return true;
		else return false;
	}
	private static boolean isRanged(int y , int x) {
		if(y<0 || y>= 5 || x<0 || x >=5) {
			return false;
			
		}else {
			return true;
		}
	}

}
