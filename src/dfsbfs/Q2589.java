package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 
//이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다.
//보물 지도의 가로, 세로의 크기는 각각 50이하이다.
//첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.
public class Q2589 {
	static int ans;
	static int N;
	static int M;
	static class Point{
		int x;
		int y;
		char ch;
		public Point(int x, int y,char ch) {
			this.x = x;
			this.y = y;
			this.ch = ch;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Point[][] points = new Point[N+1][M+1];
		for(int i = 1 ; i <=N ; i ++) {
			String line = br.readLine();
			for(int j = 1; j <= M ; j ++) {
				points[i][j] = new Point(j,i,line.charAt(j-1));
			}
		}
		for(int i =1 ; i<=N ; i++) {
			for(int j =1 ; j<=M ; j++) {
				if(points[i][j].ch == 'L') {
					BFS(points,points[i][j]);
				}
			}
		}
		System.out.println(ans);
	}
	public static void BFS(Point[][] points, Point startPoint) {
		boolean[][] isinQueue = new boolean[N+1][M+1];
		boolean[][] isMarked = new boolean[N+1][M+1];
		Queue<Point> q = new LinkedList<Point>();
		q.add(startPoint);
		isinQueue[startPoint.y][startPoint.x] = true;
		int count = 0;
		while(q.size()>0) {
			int qsize = q.size();
			for(int i =0; i<qsize; i++) {
				Point currPoint = q.poll();
				isMarked[currPoint.y][currPoint.x] = true;
				if(ans<count) ans = count;
				//동서남북 방문
				int x = currPoint.x;
				int y = currPoint.y;
				//동
				if(x<M) {
					if(points[y][x+1].ch == 'L') {
						if(!isinQueue[y][x+1] && !isMarked[y][x+1]) {
							q.add(points[y][x+1]);
							isinQueue[y][x+1] = true;
						}
					}
				}
				//서
				if(x>1) {
					if(points[y][x-1].ch == 'L') {
						if(!isinQueue[y][x-1] && !isMarked[y][x-1]) {
							q.add(points[y][x-1]);
							isinQueue[y][x-1] = true;
						}
					}
				}
				//남
				if(y<N) {
					if(points[y+1][x].ch == 'L') {
						if(!isinQueue[y+1][x] && !isMarked[y+1][x]) {
							q.add(points[y+1][x]);
							isinQueue[y+1][x] = true;
						}
					}
				}
				//북
				if(y>1) {
					if(points[y-1][x].ch == 'L') {
						if(!isinQueue[y-1][x] && !isMarked[y-1][x]) {
							q.add(points[y-1][x]);
							isinQueue[y-1][x] = true;
						}
					}
				}
			}
			count++;
		}
	}
}
