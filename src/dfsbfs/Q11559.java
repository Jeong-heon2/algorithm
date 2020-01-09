package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//12*6�� ���ڰ� �־�����.
//�̶� .�� ������̰� .�� �ƴѰ��� ������ ������ �ѿ並 ��Ÿ����.
//R�� ����, G�� �ʷ�, B�� �Ķ�, P�� ����, Y�� ����̴�.(��� �빮�ڷ� �־�����.)
//�Է����� �־����� �ʵ�� �ѿ���� ���� �Ʒ��� ������ ���� ����(�� �ѿ� �Ʒ��� �� ĭ�� �ִ� ���� ����) �̴�.
//���� �־��� ��Ȳ���� ��Ⱑ �Ǵ��� ����϶�. (�ϳ��� ������ �ʴ´ٸ� 0�� ����ϸ� �ȴ�.)

public class Q11559 {
	static char[][] arr;
	static boolean[][] isMarked;
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int ans = 0;
	static boolean check = true;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[13][7];
		isMarked = new boolean[13][7];
		for(int i  = 1 ; i <=12 ; i++) {
			String line = br.readLine();
			for(int j = 1; j <=6 ; j++) {
				arr[i][j] = line.charAt(j-1);
			}
		}
		while(check) {
			initBFS();
		}
		System.out.println(ans);
		
	}
	public static void initBFS() {
		check = false;
		for(int i = 1; i <= 12 ; i++) {
			for(int j = 1; j <= 6 ; j++) {
				if(arr[i][j] != '.') {
					if(isMarked[i][j] == false) {
						BFS(j,i,arr[i][j]);
					}
				}
			}
		}
	}
	public static void BFS(int x, int y,char ch) {
		boolean[][] isinQueue = new boolean[13][7];
		int[] moveX = { 1,-1,0,0};
		int[] moveY = { 0,0,1,-1};
		ArrayList<Point> points = new ArrayList<Point>();
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		isinQueue[y][x] = true;
		int count = 0;
		while(q.size() > 0) {
			Point curr = q.poll();
			int currX = curr.x;
			int currY = curr.y;
			isMarked[currY][currX] = true;
			points.add(curr);
			count ++;
			for(int i = 0; i <4 ; i++) {
				int nextX = currX+moveX[i];
				int nextY = currY+moveY[i];
				if(isRanged(nextX,nextY)) {
					if(!isMarked[nextY][nextX]) {
						if(!isinQueue[nextY][nextX]) {
							if(arr[nextY][nextX] == ch) {
								q.add(new Point(nextX,nextY));
								isinQueue[nextY][nextX] = true;
							}
						}
					}
				}
			}
		}
		if(count >=4) {//�Ͷ߸��� isMarked ����
			for(int i = 0 ; i < points.size() ; i++) {
				int x1 = points.get(i).x;
				int y1 = points.get(i).y;
				for(int j = 1 ; j < 12; j ++) {
					if(isRanged(x1,y1-j)) {
						if(arr[y1-j][x1] == '.') {
							arr[y1-j+1][x1] = '.';
							break;
						}
						else {
							arr[y1-j+1][x1] = arr[y1-j][x1];
						}
					}
				}
			}
			isMarked = new boolean[13][7];
			ans ++;
			check = true;
		}else {
			return;
		}
	}
	public static boolean isRanged(int x, int y) {
		if((x>=1) &&  (x<=6) && (y>=1) && (y<=12)) {
			return true;
		}
		else return false;
	}
}
