package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2146 {
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N;
	static int ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =  Integer.parseInt(br.readLine());
		map  = new int[N][N];
		ans = Integer.MAX_VALUE;
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 2;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] == 1 ) {
					divide(new int[] {i,j}, num++);
				}
			}
		}
		boolean[][] check = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N; j++) {
				//주변에 바다가 있고  한번도 시도해보지 않았다면 
				if(map[i][j] >1) {
					for(int k = 0 ; k < 4 ; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(isRanged(ny, nx)) {
							if(!check[ny][nx] && map[ny][nx] == 0) {
								check[ny][nx] = true;
								find(new int[] {ny,nx}, map[i][j]);
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	//대륙 별로 번호 부여 
	private static void divide(int[] p, int num) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(p);
		map[p[0]][p[1]] = num;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int ny = cur[0] +dy[i];
				int nx = cur[1] + dx[i];
				if(isRanged(ny, nx)) {
					if(map[ny][nx] == 1) {
						map[ny][nx] = num;
						q.offer(new int[] {ny,nx});
					}
				}
			}
		}
	}
	//num 대륙 인근의 바다 위치 : p 
	private static void find(int[] p, int num) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.offer(p);
		visited[p[0]][p[1]] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-- > 0) {
				int[] cur = q.poll();
				for(int i = 0 ; i < 4 ; i++) {
					int ny = cur[0] +dy[i];
					int nx = cur[1] + dx[i];
					if(isRanged(ny, nx)) {
						if(!visited[ny][nx]) {
							if(map[ny][nx] == 0) {
								q.offer(new int[] {ny,nx});
							}else if(map[ny][nx] != num) {
								//다른 대륙에 닿음 
								ans = Math.min(ans, cnt);
								return;
							}
							visited[ny][nx] = true;
						}
					}
				}
			}
			cnt++;
			
		}
	}
	private static boolean isRanged(int y, int x) {
		if(y< 0 ||y >=N ||x<0 || x >=N) return false;
		return true;
	}

}
