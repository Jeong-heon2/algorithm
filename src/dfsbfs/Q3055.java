package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q3055 {
	static int R;
	static int C;
	static char[][] map;
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		R = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);
		map = new char[R][C];
		ArrayList<Point> waterList = new ArrayList<>();
		Point kaktus_start_point = new Point(0,0);
		Point target = new Point(0,0);
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0; j < C ; j++) {
				char ch = str.charAt(j);
				if(ch == '*') waterList.add(new Point(j, i));
				else if (ch == 'S') kaktus_start_point.setP(j,i);
				else if (ch == 'D') target.setP(j,i);
				map[i][j] = str.charAt(j);
			}
		}
		int res = bfs(kaktus_start_point, waterList, target);
		if(res == -1 ) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(res);
		}
		
	}
	public static int bfs(Point kaktus_start, ArrayList<Point> waterList, Point target) {
		boolean[][] k_visited = new boolean[R][C];
		boolean[][] w_visited = new boolean[R][C];
		Queue<Point> kq = new LinkedList<>();
		Queue<Point> wq = new LinkedList<>();
		kq.offer(kaktus_start);
		k_visited[kaktus_start.y][kaktus_start.x] = true;
		for(Point p : waterList) {
			wq.offer(p);
			w_visited[p.y][p.x] = true;
		}
		int ans = 1;
		while(kq.size() > 0) {
			int wq_size = wq.size();
			while(wq_size-- > 0){
				Point w_cur = wq.poll();
				for(int j = 0 ; j < 4 ; j++) {
					Point w_next = new Point(goX[j]+w_cur.x , goY[j]+w_cur.y);
					if(isRanged(w_next)&& !w_visited[w_next.y][w_next.x]) {
						
						w_visited[w_next.y][w_next.x] = true;
						if(map[w_next.y][w_next.x] == '.') {
							map[w_next.y][w_next.x] = '*';
							wq.offer(w_next);
						}
						
					}
				}
			}
			int kq_size = kq.size();
			while(kq_size-- > 0) {
				Point k_cur = kq.poll();
				for(int j = 0 ; j < 4 ; j++) {
					Point k_next = new Point(goX[j]+k_cur.x , goY[j]+k_cur.y);
					if(isRanged(k_next)&& !k_visited[k_next.y][k_next.x]) {
						if(map[k_next.y][k_next.x] == 'D') return ans;
						k_visited[k_next.y][k_next.x] = true;
						if(map[k_next.y][k_next.x] == '.') {
							kq.offer(k_next);
						}
						
					}
				}
			}
			ans++;
		}
		return -1;
		
		
		
	}
	public static boolean isRanged(Point p) {
		if(p.x < 0 || p.x >= C || p.y < 0 || p.y >= R) return false;
		return true;
	}
	static class Point {
		int x;
		int y;
		Point (int x, int y){
			this.x = x;
			this.y = y;
		}
		void setP(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
