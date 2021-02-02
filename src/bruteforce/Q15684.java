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
		int[][] map = new int[H+1][N+1];// 0 ��ٸ� ����   1: �� -> ��  , 2 : �� -> �� 
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
				//��ٸ��� �׻� �� ->�� �� ���� �ٰ� ����.
				if(map[y][x] != 0|| x == n) continue;//��ٸ��� �̹� �������ְų�  , �� -> �� �� ��ٸ��� �����Ƿ� x == n �̸� �ǳʶ� 
				if(isPossible(map, y, x)) {//��ٸ��� ���� �� �ִٸ� 
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
			//�����ʸ� üũ 
			if(map[y][x+1] != 0) return false;
			return true;
		}else {
			//�� �������� �� -> ��  ���� ��ٸ��� ���Ҵٸ�  ���� �� -> �� ���� ��ٸ��� ���� �� ���� 
			if(map[y][x+1] == 1) return false;
			return true;
		}
	}
	//��ٸ� Ÿ�� 
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
