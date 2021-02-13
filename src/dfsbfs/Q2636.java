package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2636 {
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	static int N;
	static int M;
	static int size; //남아있는 치즈 조각 개수 
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		size = 0;
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if ( n == 1) size ++;
			}
		}
		int ans = 0;
		int pre = size;
		while(size > 0) {
			pre = size;
			melting(map);
			ans++;
		}
		System.out.println(ans);
		System.out.println(pre);
	}
	private static void melting(int[][] map) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0,0});
		visited[0][0] = true;

		while(q.size() > 0) {
			int[] cur = q.poll();
			for(int i = 0; i < 4 ; i++) {
				int[] next = new int[] {cur[0]+goY[i] , cur[1]+goX[i]};
				if(isRanged(next) && !visited[next[0]][next[1]] ) {
					if(map[next[0]][next[1]] == 0) {
						//외부 공기 
						q.offer(next);
					}else {
						//치즈가 들어있는 칸 
						size--;
						map[next[0]][next[1]] = 0;
					}
					visited[next[0]][next[1]] = true;
				}
			}
		}
		
		
	}
	private static boolean isRanged(int[] p) {
		if(p[0] < 0 || p[0] >= N || p[1] < 0 || p[1] >= M) return false;
		return true;
	}
	

}
