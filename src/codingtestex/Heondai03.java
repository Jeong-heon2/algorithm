package codingtestex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Heondai03 {
	static int[][] input = {
			{3,2,3,2},
			{2,1,1,2},
			{1,1,2,1},
			{4,1,1,1}
			};	
	static boolean[][] isMarked = new boolean[4][4];
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	static int ans = -1;
	public static void main(String[] args) throws Exception {
		for(int i = 0 ; i < input.length ; i++) {
			for(int j = 0 ; j < input[0].length ; j++) {
				if(!isMarked[i][j]) {
					if(ans < BFS(i,j,input[i][j])) {
						ans = BFS(i,j,input[i][j]);
					}
				}
			}
		}
	}
	private static int BFS(int r, int c,int target) {
		int count = -1;
		boolean[][] isInQueue = new boolean[4][4];
		Queue<Point> Q = new LinkedList<Point>();
		Q.add(new Point(c,r));
		
		isInQueue[c][r] = true;
		
		while(!Q.isEmpty()) {
			int qsize = Q.size();
			for(int i = 0 ; i< qsize ; i++) {
				Point curr_point = Q.poll();
				isMarked[curr_point.y][curr_point.x] = true;
				for(int j = 0 ; j<4; j++) {
					int gX = goX[j];
					int gY = goY[j];
					int nX = curr_point.x+gX;
					int nY = curr_point.y+gY;
					if(isRanged(nX,nY)) {
						if(!isMarked[nX][nY]&&!isInQueue[nX][nY]
								&&(target == input[nX][nY])) {
							Q.add(new Point(nX,nY));
							isInQueue[nX][nY] = true;
						}
					}
				}
			}
			count++;
		}
		if(count == 0) {
			return -1;
		}
		else {
			return count;
		}
	}
	private static boolean isRanged(int x, int y) {
		if((x>=0)&&(x<4)&&(y>=0)&&(y<4)){
			return true;
		}
		else return false;
	}
	static class Point {
		int x;
		int y;
		public Point(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
	

}
