package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q17140 {
	static int[][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[3][3];
		for(int i = 0 ; i <3 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(r < map.length && c < map[0].length && map[r][c] == k) {
			System.out.println("0");
			return;
		}
		int cnt = 0;
		boolean flag = true;//true:  r연산 
		while(cnt++ < 100) {
			if(flag) {
				operateR();
			}else {
				operateC();
			}
			
			if(r < map.length && c < map[0].length && map[r][c] == k) {
				System.out.println(cnt);
				return;
			}
			
			if(map.length >= map[0].length) {
				flag = true;
			}else {
				flag = false;
			}
		}
		System.out.println("-1");
	}
	//행 연산 
	private static void operateR() {
		int[][] tmp = new int[100][100];
		int max = 0;
		for(int i = 0 ; i < map.length ; i++) {
			int[] cnt = new int[101];
			for(int j = 0; j < map[0].length ; j++) {
				if(map[i][j] != 0) {
					cnt[map[i][j]]++;
				}
			}
			ArrayList<Number> list = new ArrayList<>();
			for(int j = 1; j<= 100; j++) {
				if(cnt[j] != 0) {
					list.add(new Number(j, cnt[j]));
				}
			}
			Collections.sort(list);
			int idx = 0;
			for(int j = 0; j < list.size() && idx < 100 ; j++) {
				tmp[i][idx++] = list.get(j).n;
				tmp[i][idx++] = list.get(j).cnt;
			}
			max = Math.max(max, idx);
		}
		map = new int[map.length][max];
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < max ; j++) {
				map[i][j] = tmp[i][j];
			}
		}
	}
	//열 연산 
	private static void operateC() {
		int[][] tmp = new int[100][100];
		int max = 0;
		final int cSize = map[0].length;
		for(int i = 0 ; i < cSize ; i++) {
			int[] cnt = new int[101];
			for(int j = 0; j < map.length ; j++) {
				if(map[j][i] != 0) {
					cnt[map[j][i]]++;
				}
			}
			ArrayList<Number> list = new ArrayList<>();
			for(int j = 1; j<= 100; j++) {
				if(cnt[j] != 0) {
					list.add(new Number(j, cnt[j]));
				}
			}
			Collections.sort(list);
			int idx = 0;
			for(int j = 0; j < list.size() ; j++) {
				tmp[idx++][i] = list.get(j).n;
				tmp[idx++][i] = list.get(j).cnt;
			}
			max = Math.max(max, idx);
		}
		map = new int[max][cSize];
		for(int i = 0 ; i < max ; i++) {
			for(int j = 0 ; j < cSize ; j++) {
				map[i][j] = tmp[i][j];
			}
		}
	}
	static class Number implements Comparable<Number>{
		int n;
		int cnt;
		Number (int n , int cnt){
			this.n = n;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Number o) {
			if(this.cnt > o.cnt) {
				return 1;
			}else if(this.cnt == o.cnt) {
				return this.n - o.n;
			}else {
				return -1;
			}
		}
		
	}

}
