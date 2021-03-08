package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17779 {
	static int[][] arr;
	static int N;
	static int[][] map;
	static int ans;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		map = new int[N+1][N+1];
		ans = Integer.MAX_VALUE;
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(ans);
	}
	private static void solve() {
		for(int i = 0 ; i < N*N ; i++) {
			//기준점 
			int x = i/N +1;
			int y = i%N +1;
			for(int d1 = 1; d1 < N ; d1++) {
				for(int d2 = 1 ; d2 < N ; d2++) {
					if(x+d1+d2<=N && 1 <= y-d1 && y+d2 <= N) {
						divide(x, y, d1, d2);
					}
				}
			}
		}
	}
	//선거구 나눠서 map에 저장 
	private static void divide(int x, int y, int d1, int d2) {
		for(int i = 1 ; i <= N ;i++) {
			Arrays.fill(map[i], 0);
		}
		//경계선 긋기
		for(int i = x, j = y ; i <= x + d1 && j >= y - d1; i++, j--) {
			map[i][j] = 5;
		}
		for(int i = x, j = y ; i <= x + d2 && j <= y + d2; i++, j++) {
			map[i][j] = 5;
		}
		for(int i = x + d1, j = y - d1 ; i <= x + d1 + d2 && j <= y- d1 + d2; i++, j++) {
			map[i][j] = 5;
		}
		for(int i = x + d2, j = y + d2 ; i <= x + d1 + d2 && j >= y- d1 + d2; i++, j--) {
			map[i][j] = 5;
		}
		
		//1,1 은 항상 1번 선거구  1,N은 항상 2번 선거구 ... 
		boolean[][] visited = new boolean[N+1][N+1];
		int max = 0;
		int min = Integer.MAX_VALUE;
		int res = bfs(new int[] {1,1}, visited, 1, x, y, d1, d2);
		max = Math.max(max, res);
		min = Math.min(min, res);
		
		res = bfs(new int[] {1,N}, visited, 2, x, y, d1, d2);
		max = Math.max(max, res);
		min = Math.min(min, res);
		
		res = bfs(new int[] {N,1}, visited, 3, x, y, d1, d2);
		max = Math.max(max, res);
		min = Math.min(min, res);
		
		res = bfs(new int[] {N,N}, visited,  4, x, y, d1, d2);
		max = Math.max(max, res);
		min = Math.min(min, res);
		//5번 선거구 값 구하기 
		res = 0;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1; j<= N ; j++) {
				if(map[i][j] == 5 || map[i][j] == 0) {
					res += arr[i][j];
				}
			}
		}
		max = Math.max(max, res);
		min = Math.min(min, res);
		
		ans = Math.min(ans, max - min);
		
	}
	//n : 선거구 번호 
	private static int bfs(int[] start, boolean[][] visited, int n, int x, int y , int d1, int d2) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		int sum = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			sum += arr[cur[0]][cur[1]];
			map[cur[0]][cur[1]] = n;
			for(int i = 0 ; i< 4 ; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(isRanged(nx, ny) && !visited[nx][ny] && map[nx][ny] != 5) {
					boolean flag = false;
					switch(n) {//1~4선거구 조건 확인 
						case 1:{
							if(nx < x+d1 && ny <= y) {
								flag = true;
							}
							break;
						}
						case 2:{
							if( nx <= x+d2 && ny <= N) {
								flag = true;
							}
							break;
						}
						case 3:{
							if(x+d1 <= nx && ny < y -d1 + d2) {
								flag = true;
							}
							break;
						}
						case 4:{
							if(x+d2 < nx && y-d1+d2 <= ny ) {
								flag = true;
							}
							break;
						}
					}
					if(flag) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
					
				}
			}
		}
		return sum;
	}
	private static boolean isRanged(int x, int y) {
		if(x < 1 || x > N || y < 1 || y > N) return false;
		return true;
	}
}
