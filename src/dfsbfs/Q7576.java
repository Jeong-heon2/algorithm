package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
	static int ans;
	static boolean[][] isMarked;
	static boolean[][] isinQueue;
	static int N;
	static int M;
	static int days = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M+1][N+1];
		isMarked = new boolean[M+1][N+1];
		isinQueue = new boolean[M+1][N+1];
		ArrayList<Point> StartPoint = new ArrayList<Point>();
		
		int count_0 = 0;
		int ans = 1;
		for(int i=1 ; i<=M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N ; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
				isMarked[i][j] = false;
				isinQueue [i][j] = false;
				if(arr[i][j] == 1) {
					Point point = new Point(i,j);
					StartPoint.add(point);
 				}
				else if(arr[i][j] == 0) {
					count_0++;
				}
			}
		}
		if(count_0 == 0) System.out.println(0);//애초에 모든 토마토가 익어있다.(안익은 토마토가 없다 )
		else if((count_0 != 0) &&(StartPoint.size() == 0)) {//애초에 익은 토마토가 하나도 없다
			System.out.println(-1);
		}
		else{
			BFS(arr,StartPoint);
			for(int i=1 ; i<=M ; i++) {
				for(int j = 1; j <= N ; j++) {
					if(arr[i][j]==0) {
						ans = -1;
			    		break;
					}
				}
				if(ans == -1) break;
			}
			if (ans != -1) {
				System.out.println(days);
			}
			else System.out.println(ans);
		}
		
	}
	public static void BFS(int[][] arr,ArrayList<Point> StartPoint) {
		Queue<Point> Q = new LinkedList<Point>();
		for(int i = 0 ; i < StartPoint.size() ; i ++) {
			Point point = new Point(StartPoint.get(i).x,StartPoint.get(i).y);
			Q.add(point);
			isinQueue[point.x][point.y] = true;
		}
		int[] seq = {1,-1,1,-1};//방문순서 동서남북
		while(Q.size()>0) {
			ArrayList<Point> currentPoints = new ArrayList<Point>();
			int qsize = Q.size();
			for(int k = 0 ; k < qsize ; k++) {
				currentPoints.add(Q.poll());
				Point currentPoint = new Point(currentPoints.get(k).x,currentPoints.get(k).y);
				int x = currentPoint.x;
				int y = currentPoint.y;
				arr[x][y] = 1;
				isMarked[x][y] = true;//큐에서 빼면 방문
				int j = 0; // j = 0 , 1, 2, 3  동 , 서 , 남 ,북 방문
				for (int i : seq) {
					if(j == 0) {
						if(y + i>N) {//동쪽 방문할건데 배열 범위 벗어나버렸나?
							j++;
							continue;
						}
						else {
							if((!isMarked[x][y+i]) &&
									(!isinQueue[x][y+i])){
								Point point = new Point(x,y+i);
								if(arr[point.x][point.y] == 0 ) {
									Q.add(point);
									isinQueue[point.x][point.y] = true;
								}
							}
						}
					}
					else if(j ==1) {
						if(y +i == 0) {
							j++;
							continue;
						}
						else {
							if((!isMarked[x][y+i]) &&
									(!isinQueue[x][y+i])){
								Point point = new Point(x,y+i);
								if(arr[point.x][point.y] == 0 ) {
									Q.add(point);
									isinQueue[point.x][point.y] = true;
								}
							}
						}
					}
					else if(j == 2) {
						if(x + i > M) {
							j++;
							continue;
						}
						else {
							if((!isMarked[x+i][y]) &&
									(!isinQueue[x+i][y])){
								Point point = new Point(x+i,y);
								if(arr[point.x][point.y] == 0) {
									Q.add(point);
									isinQueue[point.x][point.y] = true;
								}
							}
						}
					}
					else if(j == 3) {
						if(x+ i == 0) {
							j++;
							continue;
						}
						else {
							if((!isMarked[x+i][y]) &&
									(!isinQueue[x+i][y])){
								Point point = new Point(x+i,y);
								if(arr[point.x][point.y] == 0) {
									Q.add(point);
									isinQueue[point.x][point.y] = true;
								}
							}
						}
					}
					j++;
				}
			}
			days++;
		}
		return;
	}

}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
