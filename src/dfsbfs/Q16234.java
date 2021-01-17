package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16234 {
	static int[][] arr;
	static int N;
	static int[] goX = {1,-1, 0 ,0};
	static int[] goY = {0,0,1,-1};
	static int R;
	static int L;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		boolean flag = true;//인구이동이 일어났는가? 
		while(flag) {
			flag = false;
			//visited reset 
			boolean[][] visited = new boolean[N][N];
			for(int i = 0 ; i <N ; i++) {
				for(int j = 0 ; j <N; j++) {
					if(!visited[i][j] && bfs(new Point(j,i) , visited)) {
						flag = true;
					}
				}
			}
			//인구이동이 있었는가?
			if(flag) ans++;
		}
		System.out.println(ans);
	}
	public static boolean bfs (Point start , boolean[][] visited) {
		
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		visited[start.y][start.x] = true;
		int sum = 0;//연합 인구 수 
		ArrayList<Point> union = new ArrayList<>();//연합 국가들 
		while(q.size() > 0) {
			Point cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				Point next = new Point(cur.x + goX[i] , cur.y + goY[i]);
				if(next.x < 0 || next.x >=N || next.y<0 || next.y >=N ) continue;
				//국가간 인구 간격 
				int interval = Math.abs(arr[cur.y][cur.x] - arr[next.y][next.x]);
				if(!visited[next.y][next.x] && interval >= L && interval <= R ) {
					q.offer(next);
					visited[next.y][next.x] = true;
					sum += arr[next.y][next.x];
					union.add(next);
				}
			}
		}
		int size = union.size();
		if(size == 0) return false;
		else {
			//인구이동이 있었음 
			union.add(start);
			sum += arr[start.y][start.x];
			int average = sum / union.size();
			for(Point p : union) {
				arr[p.y][p.x] = average;
			}
			return true;
		}
		
	}
	static class Point{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
