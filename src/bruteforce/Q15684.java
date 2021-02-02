package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15684 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine())	;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H+1][N+1];// 0 사다리 없음   1: 왼 -> 오  , 2 : 오 -> 왼 
		while(M-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			map[a][b] = 1;
			map[a][b+1] = 2;
		}
		for(int i = 0 ; i <= 3 ; i++) {
			int[][] tmp = map.clone();
			if(combination(tmp, 0, N, H, i)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1); 
	}
	public static boolean combination(int[][] map, int start, int n, int h,int r) {
		if(r==0) {
			boolean flag = true;
			for(int i = 1 ; i <= n ; i++) {
				if(!play(map, i, h)) {
					flag = false;
					break;
				}
			}
			if(flag) return true;
		}else {
			for(int i = start; i < n*h ; i++) {
				int y = i/n + 1;
				int x = i%n + 1;
				//사다리는 항상 왼 ->오 로 놓는 다고 생각.
				if(map[y][x] != 0|| x == n) continue;//사다리가 이미 놓아져있거나  , 왼 -> 오 로 사다리를 놓으므로 x == n 이면 건너뜀 
				if(isPossible(map, y, x)) {//사다리를 놓을 수 있다면 
					map[y][x] = 1;
					int tmp = map[y][x+1];
					map[y][x+1] = 2;
					if(combination(map, i+1, n, h, r-1)) return true;
					map[y][x] = 0;
					map[y][x+1] = tmp;
				}
			}
		}
		return false;
	}
	public static boolean isPossible(int[][] map, int y, int x) {
		if(x == 1) {
			//오른쪽만 체크 
			if(map[y][x+1] != 0) return false;
			return true;
		}else {
			//내 오른쪽이 왼 -> 오  으로 사다리를 놓았다면  나는 오 -> 왼 으로 사다리를 놓을 수 없다 
			if(map[y][x+1] == 1) return false;
			return true;
		}
	}
	//사다리 타기 
	public static boolean play(int[][] map, int x, int h) {
		int i = x;
		int y = 1;
		while(y != h+1) {
			if(map[y][x] == 1) {
				x++;
			}else if(map[y][x] == 2) {
				x--;
			}
			y++;
		}
		if(x == i) return true;
		else return false;
	}

}
