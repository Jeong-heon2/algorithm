package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
	static int F;
	static int[] goX;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		goX = new int[2];
		goX[0] = U;
		goX[1] = -D;
		int res = bfs(S,G);
		if(res == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(res);
		}

	}
	public static int bfs(int s, int g) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[F+1];
		if(s == g) return 0;
		q.offer(s);
		visited[s] = true;
		int cnt = 0;
		while(q.size() > 0) {
			int qSize = q.size();
			for(int i = 0 ; i < qSize ; i++) {
				int cur = q.poll();
				for(int j : goX) {
					int nx = cur + j;
					if(isRanged(nx) && !visited[nx]) {
						if(nx == g) return cnt + 1;
						q.offer(nx);
						visited[nx] = true;
					}
				}
			}
			cnt ++;
		}
		return -1;
	}
	public static boolean isRanged(int x) {
		if(x > F || x < 1) return false;
		return true;
	}
}
