package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
백준 로봇 청소기
bfs 
조건 이해하기 힘들었다.
 */
public class Q14503 {
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//세로 크기
		N = Integer.parseInt(st.nextToken());
		//가로 크기
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		//로봇의 초기 위치 
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		//방향
		int d = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(c,r,d));
		arr[r][c] = -1;
		int ans = 1;
		while(q.size() > 0) {
			Point cur = q.poll();
			
			boolean flag = false;
			Point left = cur;
			for(int i = 0 ; i < 4 ; i ++) {
				left = getLeftPoint(new Point(cur.x, cur.y, left.d));
				if(arr[left.y][left.x] == 0) {
					//cleaning
					arr[left.y][left.x] = -1;
					ans ++;
					q.offer(left);
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				Point back = getBackPoint(cur);
				if(!isRock(back)) {
					q.offer(back);
				}
			}
		}
		System.out.println(ans);
		
	}
	//왼쪽 방향으로 한칸 전진한 좌표 
	public static Point getLeftPoint(Point p) {
		switch(p.d) {
			case 0 :{//북 
				//서 좌표 
				return new Point(p.x -1, p.y, 3);
			}
			case 1 :{//동 
				//북 좌표 
				return new Point(p.x, p.y -1, 0);
			}
			case 2 :{//남 
				// 동 
				return new Point(p.x + 1, p.y, 1);
			}
			case 3 :{//서 
				//남 
				return new Point(p.x, p.y + 1, 2);
			}
		}
		return null;
	}
	//후진한 좌표 
	public static Point getBackPoint(Point p) {
		switch(p.d) {
			case 0 :{//북 
				//남 
				return new Point(p.x, p.y + 1, p.d);
			}
			case 1 :{//동 
				//서  
				return new Point(p.x - 1, p.y, p.d);
			}
			case 2 :{//남 
				//북 
				return new Point(p.x, p.y - 1, p.d);
			}
			case 3 :{//서 
				//동 
				return new Point(p.x + 1, p.y, p.d);
			}
		}
		return null;
	}
	//벽인지 체크 
	public static boolean isRock(Point p) {
		if(arr[p.y][p.x] == 1) return true;
		else return false;
	}
	static class Point {
		int x;
		int y;
		int d;
		Point(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
