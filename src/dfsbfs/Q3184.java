package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3184 {
	static int R;
	static int C;
	static char[][] arr;
	static boolean[][] isinQueue;
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	static int ansV = 0;
	static int ansO = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R+1][C+1];
		isinQueue = new boolean[R+1][C+1];
		for(int i = 1 ; i <= R ; i ++) {
			String line = br.readLine();
			for(int j = 1 ; j <= C ; j++) {
				arr[i][j] = line.charAt(j-1);
				isinQueue[i][j] = false;
			}
		}
		for(int i = 1; i <= R; i ++) {
			for(int j = 1; j<= C; j++) {
				if(arr[i][j] != '#') {
					BFS(i,j);
				}
			}
		}
		System.out.print(ansO + " " + ansV);
	}
	public static void BFS(int startY, int startX) {
		isinQueue = new boolean[R+1][C+1];
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.add(startX);
		qy.add(startY);
		isinQueue[startY][startX] = true;
		int countV = 0;
		int countO = 0;
		while(qx.size()>0) {
			int x = qx.poll();
			int y = qy.poll();
			char ch = arr[y][x];
			if(ch == 'v') {
				countV++;
			}
			else if(ch == 'o') {
				countO++;
			}
			arr[y][x] = '#';
			for(int i =0 ; i <4 ; i++) {
				int gx = x+goX[i];
				int gy = y+goY[i];
				if(isRanged(gx,gy)) {
					if(!isinQueue[gy][gx]) {
						if(arr[gy][gx] != '#') {
							qx.add(gx);
							qy.add(gy);
							isinQueue[gy][gx] = true;
						}
					}
				}
			}
		}
		if(countV>=countO) {
			ansV += countV;
		}
		else if(countO>countV) {
			ansO += countO;
		}
		
	}
	public static boolean isRanged(int x, int y) {
		if((x>=1)&&(x<=C)&&(y>=1)&&(y<=R)) return true;
		else return false;
	}
}
