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
		boolean[][] map = new boolean[N+1][H+1];// 0 사다리 없음 
		while(M-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			map[a][b] = true;
			map[a][b+1] = true;
		}
		for(int i = 0 ; i <= 3 ; i++) {
			boolean[][] tmp = map.clone();
			if(combination(tmp, 0, N, H, i)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
		//사다리는 항상 왼 ->오 로 놓는 다고 생각. 
	}
	public static boolean combination(boolean[][] map, int start, int n, int h,int r) {
		if(r==0) {
			boolean flag = true;
			for(int i = 1 ; i <= h ; i++) {
				if(!play(map, i, n, h)) {
					flag = false;
					break;
				}
			}
			if(flag) return true;
		}else {
			for(int i = start; i < n*h ; i++) {
				int y = i/h + 1;
				int x = i%h + 1;
				if(map[y][x] || x == h) continue;//왼 -> 오 로 사다리를 놓으므로 x == n 이면 건너뜀 
				if(isPossible(map, y, x)) {//사다리를 놓을 수 있다면 
					map[y][x] = true;
					map[y][x+1] = true;
					if(combination(map, i+1, n, h, r-1)) return true;
					map[y][x] = false;
					map[y][x+1] = false;
				}
			}
		}
		return false;
	}
	public static boolean isPossible(boolean[][] map, int y, int x) {
		if(map[y][x+1]) return false;
		return true;
	}
	//사다리 타기 
	public static boolean play(boolean[][] map, int x, int n, int h) {
		int i = x;
		int y = 1;
		while(y != h) {
			if(map[y][x]) {//사디리와 연결되어있다면 
				if(x == 1) {
					if(map[y][x+1]) {
						x++;
					}
				}else if(x == h) {
					if(map[y][x-1]) {
						x--;
					}
				}else {
					if(map[y][x-1]) {
						x--;
					}else if(map[y][x+1]) {
						x++;
					}
				}
			}
			
			y++;
		}
		if(x == i) return true;
		else return false;
	}

}
