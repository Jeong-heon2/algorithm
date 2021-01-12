package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q17025 {
	static int N;
	static int[] goX = {1, -1, 0, 0};
	static int[] goY = {0, 0, 1, -1};
	static int area;
	static int perimeter;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = 0;
		perimeter = 0;
		boolean[][] arr = new boolean[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				if(tmp.charAt(j) == '#') {
					arr[i][j] = true;
				}else {
					arr[i][j] = false;
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(arr[i][j] && !visited[i][j]) {
					int[] res = bfs(arr, visited, new Point(j, i));
					if(res[0] > area) {
						area = res[0];
						perimeter = res[1];
					}else if (res[0] == area) {
						if(res[1] < perimeter) {
							perimeter = res[1];
						}
					}
				}
			}
		}
		System.out.println(area + " " + perimeter);
	}
	public static int[] bfs(boolean[][] arr, boolean[][] visited, Point start) {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		visited[start.y][start.x] = true;
		int[] res = {1,0};// [0] : area ,  [1] : perimeter 
		while(q.size() > 0) {
			Point cur = q.poll();
			//동서남북 조사 
			for(int i = 0 ; i < 4 ; i++) {
				Point next = new Point(cur.x + goX[i] , cur.y + goY[i]);
				if(!isRanged(next)) {//벽 
					res[1]++; //둘래 증가 
				}else {
					if(!visited[next.y][next.x]) {
						if(arr[next.y][next.x]) {//다른 blob과 연결 
							q.offer(next);
							visited[next.y][next.x] = true;
							res[0]++;
						}else {//다른 blob 과 연결 x
							res[1]++;
						}
					}
				}
			}
		}
		return res;
	}
	public static boolean isRanged(Point p) {
		if(p.x < 0 || p.x >= N || p.y < 0 || p.y >= N) return false;
		else return true;
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
