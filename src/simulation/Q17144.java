package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17144 {
	static int[][] map;
	static int R;
	static int C;
	static int T;
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	static int[] rtdX = {1,0,-1,0};
	static int[] rtdY = {0,-1,0,1};
	static int[] tdY = {0, 1, 0, -1};
	static int ux = -1, uy = -1, dx = -1, dy = -1; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if(v == -1) {
					if(ux == -1) {
						ux = j;
						uy = i;
					}else {
						dx = j;
						dy = i;
					}
				}
				
			}
		}
		while(T-- > 0) {
			dust();
			cleaner();
		}
		int ans = 0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] != -1) {
					ans += map[i][j];
				}
			}
		}
		System.out.println(ans);
	}
	//미세먼지 확산
	private static void dust() {
		int[][] tmp = new int[R][C];
		for(int i = 0 ; i < R ; i ++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] > 0) {
					//동서남북 확산
					int val = map[i][j] / 5;
					int cnt = 0;
					for(int k = 0 ; k < 4 ; k++) {
						int nx = j + goX[k];
						int ny = i + goY[k];
						if(isRanged(nx, ny) && map[ny][nx] != -1) {
							tmp[ny][nx] += val;
							cnt++;
						}
					}
					map[i][j] -= cnt*val;
				}
			}
		}
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				map[i][j] += tmp[i][j];
			}
		}
	}
	private static boolean isRanged(int x, int y) {
		if(y < 0 || y >= R || x < 0 || x >= C) {
			return false;
		}else {
			return true;
		}
	}
	//공기청정기 작동
	private static void cleaner() {
		//위쪽 반시계
		int x = ux;
		int y = uy;
		int pre = 0;
		for(int i = 0 ; i < 4 ; i++) {
			x += rtdX[i];
			y += rtdY[i];
			while(isRanged(x, y) && (x != ux || y != uy)) {
				int tmp = map[y][x];
				map[y][x] = pre;
				pre = tmp;
				x += rtdX[i];
				y += rtdY[i];
			}
			x -= rtdX[i];
			y -= rtdY[i];
		}
		//아래 반시계
		x = dx;
		y = dy;
		pre = 0;
		for(int i = 0 ; i < 4 ; i++) {
			x += rtdX[i];
			y += tdY[i];
			while(isRanged(x, y) && (x != dx || y != dy)) {
				int tmp = map[y][x];
				map[y][x] = pre;
				pre = tmp;
				x += rtdX[i];
				y += tdY[i];
			}
			x -= rtdX[i];
			y -= tdY[i];
		}
	}
}
