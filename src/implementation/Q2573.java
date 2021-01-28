package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2573 {
	static int N;
	static int M;
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	static int[][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		while(!find()) {
			ans++;
			boolean[][] visited = new boolean[N][M];
			boolean flag = false;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] > 0 && !visited[i][j]) {
						melt(new int[] {i,j}, visited);
						flag = true;
					}
				}
			}
			if(!flag) {//다 녹음 
				ans = 0;
				break;
			}
		}
		System.out.println(ans);
	}
	public static void melt(int[] start, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		int[][] tmp = new int[N][M];//빼줘야할 양을 저장 
		while(q.size() > 0) {
			int[] cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int[] next = new int[2];
				next[0] = cur[0] + goY[i];
				next[1] = cur[1] + goX[i];
				if(isRanged(next)) {
					if(!visited[next[0]][next[1]] && map[next[0]][next[1]] > 0) {
						q.offer(next);
						visited[next[0]][next[1]] = true;
					}
					if(map[next[0]][next[1]] == 0) {
						tmp[cur[0]][cur[1]] += 1;
					}
				}
			}
		}
		for(int i  = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				int v = map[i][j] - tmp[i][j];
				if(v < 0) {
					map[i][j] = 0;
				}else {
					map[i][j] = v;
				}
			}
		}
	}
	public static boolean find() {
		boolean[][] visited = new boolean[N][M];
		int cnt = 0 ;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M; j++) {
				if(map[i][j] > 0 && !visited[i][j]) {
					if(cnt == 1) {
						//두개이상으로 분리되었음 
						return true;
					}
					check(new int[]{i,j}, visited);
					cnt++;
				}
			}
		}
		return false;
	}
	public static void check(int[] start, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		while(q.size() > 0) {
			int[] cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int[] next = new int[2];
				next[0] = cur[0] + goY[i];
				next[1] = cur[1] + goX[i];
				if(isRanged(next) && !visited[next[0]][next[1]] && map[next[0]][next[1]] > 0) {
					q.offer(next);
					visited[next[0]][next[1]] = true;
				}
			}
		}
	}
	public static boolean isRanged(int[] p) {
		if(p[0] < 0 || p[0] >= N || p[1] < 0 || p[1] >= M) return false;
		return true;
	}

}
