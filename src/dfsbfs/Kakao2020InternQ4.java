package dfsbfs;
/*
카카오 2020 인턴십 경주로 건설
dfs 시간초과 
 */
public class Kakao2020InternQ4 {
	static int ans;
	static int N;
	static int[] goX = {1, -1, 0, 0};
	static int[] goY = {0, 0, 1, -1};
	static int[][] arr;
	public static void main(String[] args) {
		
	}
	public static int solution(int[][] board) {
        ans = Integer.MAX_VALUE;
        arr = board;
        N = board.length;
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        if(board[0][1] == 0) {
        	visited[0][1] = true;
        	dfs(new boolean[N][N], 100, 0, 1, 0);
        	visited[0][1] = false;
        }
        if(board[1][0] == 0) {
        	visited[1][0] = true;
        	dfs(new boolean[N][N], 100, 2, 0, 1);
        }
        return ans;
    }
	// drc : 방향  0 동 ~ 3 
	public static void dfs(boolean[][] visited, int cost, int drc, int x, int y) {
		if(x == N-1 && y == N-1) {
			ans = Math.min(ans, cost);
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + goX[i];
			int ny = y + goY[i];
			if(canGo(nx, ny) && !visited[ny][nx]) {
				visited[ny][nx] = true;
				if(drc == i) {//진행방향이 일치  코너 x
					dfs(visited, cost + 100, i, nx, ny);
				}else {
					dfs(visited, cost + 600, i, nx, ny);
				}
				visited[ny][nx] = false;
			}
			
		}
	}
	static boolean canGo(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N || arr[y][x] == 1) return false;
		else return true;
	}

}
