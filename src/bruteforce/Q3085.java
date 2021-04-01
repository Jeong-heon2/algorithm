package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3085 {
	static char[][] map;
	static int N;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = 0;
		map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		//처음에 최대 개수를 먼저 구해놓는다 . 
		//그리고 교환할떄는  교환한 행,열 부분만 체크한다. 
		for(int i = 0 ; i < N ; i++) {
			searchRow(i);
			searchCol(i);
		}
		//서로 교환한 자리의 행, 열 만 검사하면 됨 
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(j+1 < N) {
					swap(i,j,i,j+1); 
					searchRow(i);
					searchCol(j);
					searchCol(j+1);
					swap(i,j,i,j+1);
				}
				if(i+1 < N) {
					swap(i,j,i+1,j); 
					searchRow(i);
					searchRow(i+1);
					searchCol(j);
					swap(i,j,i+1,j);
				}
			}
		}
		System.out.println(max);
	}
	private static void swap(int y1, int x1, int y2, int x2) {
		char tmp = map[y1][x1]; 
		map[y1][x1] = map[y2][x2]; 
		map[y2][x2] = tmp; 
	}
	
	private static void searchRow(int r) {
		int cnt = 0;
		char prev = ' ';
		for(int i = 0 ; i < N ; i++) {
			if(map[r][i] != prev) {
				max = Math.max(cnt, max);
				cnt = 1;
				prev = map[r][i];
			}else {
				cnt ++;
			}
		}
		max = Math.max(cnt, max);
	}
	private static void searchCol(int c) {
		int cnt = 0;
		char prev = ' ';
		for(int i = 0 ; i < N ; i++) {
			if(map[i][c] != prev) {
				max = Math.max(cnt, max);
				cnt = 1;
				prev = map[i][c];
			}else {
				cnt ++;
			}
		}
		max = Math.max(cnt, max);
	}

}
