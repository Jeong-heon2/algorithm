package dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q3109 {
	static int[] goY = {-1,0,1};
	static boolean flag;//»§Áý ±îÁö µµÂøÇßÀ¸¸é Àç±Í Å»Ãâ 
	static char[][] map;
	static int R, C, cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}

		sb.append(cnt);
		bw.write(sb + " ");
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static void dfs(int row, int col) {

		if (col == C - 1) {//»§Áý±îÁö µµÂø. Àç±ÍÅ»Ãâ
			flag = true;
			cnt++;
			return;
		}

		for (int k = 0; k < 3; k++) {
			int nextRow = row + goY[k];
			int nextCol = col + 1;

			if (isRanged(nextRow, nextCol) && map[nextRow][nextCol] == '.') {
				map[row][col] = 'x';
				dfs(nextRow, nextCol);
				if (flag) {
					return;
				}
			}
		}

	}
	public static boolean isRanged(int row, int col) {
		if (row < 0 || row >= R || col < 0 || col >= C) {
			return false;
		}
		return true;
	}
}
