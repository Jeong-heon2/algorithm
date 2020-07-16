package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 테트로미노
dfs
 */
public class Q14500 {
	static int ans = 0;
	static int[] goX = {1, -1, 0, 0};
	static int[] goY = {0, 0, 1, -1};
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//세로 크기
		N = Integer.parseInt(st.nextToken());
		//가로 크기
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				visited[i][j] = true;
				dfs(visited, new Point(i,j), 1, arr[i][j]);
				visited[i][j] = false;
				check_exshape(i, j);
			}
		}
		System.out.println(ans);
		
		
	}
	static class Point{
		int y;
		int x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	public static void dfs(boolean[][] visited, Point cur, int depth, int sum) {
		if(depth == 4) {
			if(ans < sum) ans = sum;
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {
			Point next = new Point(cur.y + goY[i], cur.x + goX[i]);
			if(isRanged(next) && !visited[next.y][next.x]) {
				visited[next.y][next.x] = true;
				dfs(visited, next, depth + 1, sum + arr[next.y][next.x]);
				visited[next.y][next.x] = false;
			}
		}
		
	}
	public static boolean isRanged(Point p) {
		if(p.x >= 0 && p.x < M && p.y >=0 && p.y < N) return true;
		return false;
	}
	static void check_exshape(int x, int y){
	    int sum_value = 0;
	    // 1. ㅜ
	    if(x>=0 && x+1 < N && y>=0 && y+2< M){
	        sum_value = arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x+1][y+1];
	        ans = Math.max(ans, sum_value);
	    }

	    // 2. ㅏ
	    if(x >= 0 && x+2 < N && y>=0 && y+1< M){
	        sum_value = arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+1][y+1];
	        ans = Math.max(ans, sum_value);
	    }

	    // 3. ㅗ
	    if(x-1 >= 0&& x < N && y >=0 && y+2 < M){
	        sum_value = arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x-1][y+1];
	        ans = Math.max(ans, sum_value);
	    }

	    // 4. ㅓ
	    if(x-1 >= 0 && x+1 < N && y >=0 && y+1 < M){
	        sum_value = arr[x][y] + arr[x][y+1] + arr[x-1][y+1] + arr[x+1][y+1];
	        ans = Math.max(ans, sum_value);
	    }
	}

}
