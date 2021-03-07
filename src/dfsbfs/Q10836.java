package dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10836 {
	static int[][] map;
	static int M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp = br.readLine().split(" ");
		M = Integer.parseInt(tmp[0]);
		int N = Integer.parseInt(tmp[1]);
		map = new int[M][M];
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = 1;
			}
		}
		int[][] growth = new int[M][M];
		while(N-- > 0) {
			tmp = br.readLine().split(" ");
			int[] day_growth = new int[3];
			day_growth[0] = Integer.parseInt(tmp[0]);
			day_growth[1] = Integer.parseInt(tmp[1]);
			day_growth[2] = Integer.parseInt(tmp[2]);
			
			int i = M-1;
			int j = 0;
			int idx = 0;
			while(i >= 0) {
				if(day_growth[idx] == 0) {
					idx++;
					continue;
				}
				growth[i--][j] += idx;
				day_growth[idx]--;
			}
			i = 0;
			j = 1;
			while(j <= M-1) {
				if(day_growth[idx] == 0) {
					idx++;
					continue;
				}
				growth[i][j++] += idx;
				day_growth[idx]--;
			}
		}
		grow(growth);
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < M; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static void grow(int[][] growth) {
		for(int i = M-1 , j= 0; i >= 0 ; i--) {
			map[i][j] += growth[i][j];
		}
		for(int i = 0 , j= 1; j < M ; j++) {
			map[i][j] += growth[i][j];
		}
		for(int i = 1 ; i < M ; i++) {
			for(int j = 1; j < M ; j++) {
				//좌 좌상  상 과 비교할때 가장 많이 자란 에벌래는 무조건 상이다. 
				map[i][j] += growth[i-1][j];
				growth[i][j] = growth[i-1][j];
			}
		}
	}

}
