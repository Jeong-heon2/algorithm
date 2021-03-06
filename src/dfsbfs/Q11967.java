package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q11967 {
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	static boolean[][] map;
	static ArrayList<int[]>[][] infos;
	static boolean[][] infosVisited;
	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		map = new boolean[N+1][N+1];
		infosVisited = new boolean[N+1][N+1]; // 불키는 작업을 했는가? 
		infos = new ArrayList[N+1][N+1];
		for(int i = 1 ; i <= N ; i++ ) {
			for(int j = 1 ; j <= N ; j++) {
				infos[i][j] = new ArrayList<>();
			}
		}
		for(int i = 1 ; i <= M ; i++) {
			tmp = br.readLine().split(" ");
			infos[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])].add(new int[]{Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3])});
		}
		br.close();
		bfs();
		int ans = 0;
		for(int i = 1 ; i <= N ; i++ ) {
			for(int j = 1 ; j <= N ; j++) {
				if(map[i][j]) ans++;
			}
		}
		System.out.println(ans);
	}
	private static void bfs() {
		boolean[][] visited = new boolean[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{1,1});
		visited[1][1] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			//불켜기 
			if(infos[cur[0]][cur[1]].size() > 0 && !infosVisited[cur[0]][cur[1]]) {
				for(int[] p : infos[cur[0]][cur[1]]) {
					map[p[0]][p[1]] = true;
				}
				//불켰으면 visited 초기화 
				for(int i = 0 ; i < N ; i++) {
					Arrays.fill(visited[i], false);
				}
				visited[cur[0]][cur[1]]= true;
				infosVisited[cur[0]][cur[1]] = true;
			}
			map[cur[0]][cur[1]] =true;
			//불켜진 곳으로 이동 
			for(int i = 0 ; i < 4 ; i++) {
				int ny = cur[0] + goY[i];
				int nx = cur[1] + goX[i];
				//불켜져있고 방문하지 않았다면 
				if(isRanged(ny, nx) && map[ny][nx] && !visited[ny][nx]) {
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
	}
	private static boolean isRanged(int y, int x) {
		if(y < 1 || y > N || x<1 || x > N) return false;
		return true;
	}

}
