package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17142 {
	static int[][] map;
	static ArrayList<int[]> virus;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int ans;
	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		virus = new ArrayList<>();
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if(v == 2) virus.add(new int[] {i,j});
			}
		}
		ans = Integer.MAX_VALUE;
		boolean[] visited = new boolean[virus.size()];
		combi(visited, 0, virus.size(), M);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	private static void combi(boolean[] visited, int start,int n, int r) {
		if(r== 0) {
			//deep copy
			int clonedMap[][] = new int[N][N];
			for(int i=0; i< N; i++){
	            System.arraycopy(map[i], 0, clonedMap[i], 0, N);
	        }
			Queue<int[]> q = new LinkedList<>();
			boolean[][] check = new boolean[N][N];
			for(int i = 0 ; i < n ; i++) {
				if(visited[i]) {
					int[] v = virus.get(i);
					q.offer(v);
					clonedMap[v[0]][v[1]] = 3;//활성바이러스 
					check[v[0]][v[1]] = true;
				}
			}
			bfs(clonedMap, q, check );
			
		}else {
			for(int i = start; i < n ; i++) {
				visited[i] = true;
				combi(visited, i+1, n, r-1);
				visited[i] = false;
			}
		}
	}
	private static void bfs(int[][] clonedMap, Queue<int[]> q, boolean[][] visited ) {
		int time = 0;
		int cnt = -1;
		boolean flag = false;
		while(!q.isEmpty()) {
			int qSize = q.size();
			flag = false;
			while(qSize-- >0) {
				int[] cur = q.poll();
				if(clonedMap[cur[0]][cur[1]] != 2) {
					flag = true;
				}
				for(int i = 0 ; i <  4 ; i++) {
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];
					if(isRanged(ny, nx) && clonedMap[ny][nx] != 1 && !visited[ny][nx]) {
						q.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
						if(clonedMap[ny][nx] == 0) {
							clonedMap[ny][nx] = 3;
						}
					}
				}
			}
			cnt++;
			//현재 단계에서  빈칸이었던 곳이 하나라도 있으면 time 증가 
			//현재 단계에서 모든 좌표가  비활성 바이러스라면 cnt만 증가시키고 time 증가시키지 않는다. 
			if(flag) {
				time += cnt;
				cnt = 0;
			}
		}
		for(int i  = 0 ; i < N ; i++) {
			for(int j = 0 ; j <N ; j++) {
				if(clonedMap[i][j] == 0) {//빈칸이 남아있다면 
					return;
				}
			}
		}
		//빈칸이 남아있지 않고 모두 방문했음 
		ans = Math.min(ans, time);
	}
	private static boolean isRanged(int y, int x) {
		if(y < 0 || y >= N || x < 0 || x >=N) return false;
		return true;
	}

}
