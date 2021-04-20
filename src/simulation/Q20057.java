package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20057 {
	static int[][] map;//모래사장
	static Point cur;
	static int[] dx = {-1,0,1,0};//서남동북 
	static int[] dy = {0,1,0,-1};
	static float[][][] percent;
	public static void main(String[] args)throws Exception {
		percent = new float[4][5][5];
		percent[0] = new float[][]{ 
				{0,0,0.02f,0,0},
				{0,0.1f,0.07f,0.01f,0},
				{0.05f,0,0,0,0},
				{0,0.1f,0.07f,0.01f,0},
				{0,0,0.02f,0,0}
		};
		percent[3] = rotate(percent[0]);
		percent[2] = rotate(percent[3]);
		percent[1] = rotate(percent[2]);
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int mapSize = N+4;
		map = new int[mapSize][mapSize];
		for(int i = 2 ; i < mapSize-2 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 2; j < mapSize-2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cur = new Point(mapSize/2, mapSize/2);//정중앙에서 시작 
		int len = 1;
		while(true) {
			if (move(len, 0)) break;//서 
			if (move(len++, 1)) break;//남 
			if (move(len, 2)) break;//동 
			if (move(len++, 3)) break;//북
		}
		int ans = 0;
		for(int i = 0 ; i < mapSize ; i++) {
			for(int j = 0 ; j < mapSize; j++) {
				if(i >=2 && j >=2 && i < mapSize-2 && j < mapSize-2) continue;
				ans += map[i][j];
			}
		}
		System.out.println(ans);
	}
	//dir방향으로 n번 움직여 
	private static boolean move(int n, int dir) {
		while(n-- > 0) {
			cur.x = cur.x + dx[dir];
			cur.y = cur.y + dy[dir];
			// y = cur , y는 dir 방향으로 이동한 곳
			int sum = 0;
			for(int y = cur.y-2, i = 0 ; i<5 ; y++, i++) {
				for(int x = cur.x-2, j = 0; j<5 ; x++, j++) {
					sum += (int) (percent[dir][i][j]*map[cur.y][cur.x]);
					map[y][x] += percent[dir][i][j]*map[cur.y][cur.x];
				}
			}
			// a = cur + d[dir] . 알파는 dir 방향으로 한칸 더 간 곳 
			map[cur.y+dy[dir]][cur.x+dx[dir]] += map[cur.y][cur.x] - sum;
			map[cur.y][cur.x] = 0;
			if(cur.x == 2 && cur.y == 2) return true;
		}
		return false;
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	// 90 rotate
	static float[][] rotate(float[][] arr) {
	    int n = arr.length;
	    int m = arr[0].length;
	    float[][] rotate = new float[m][n];
	    for (int i = 0; i < rotate.length; i++) {
	        for (int j = 0; j < rotate[i].length; j++) {
	            rotate[i][j] = arr[n-1-j][i];
	        }
	    }
	    return rotate;
	}
}
