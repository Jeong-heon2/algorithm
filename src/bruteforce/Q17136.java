package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17136 {
	static int[] papersCnt = {0,5,5,5,5,5}; 
	static int[][] map;
	static int cnt1;
	static int ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		cnt1 = 0;
		ans = Integer.MAX_VALUE;
		for(int i = 0 ; i <10 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< 10 ; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if(a==1) {
					cnt1++;
				}
			}
		}
		if(cnt1 == 0) {
			System.out.println(0); return;
		}
		for(int i = 0 ; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				if(map[i][j] == 1) {
					dfs(j,i,0,0);
					break;
				}
			}
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	//지운 1의 개수 : cnt ,   사용한 색종이 개수 : paper 
	private static void dfs(int x, int y, int cnt, int paper) {
		for(int i = 1; i <=5 ; i++) {
			if(papersCnt[i] > 0) {
				if(check(x,y,i)) {
					setMap(x,y,i,0);
					papersCnt[i]--;
					if(cnt1 == cnt + i*i) {
						ans = Math.min(ans, paper+1);
						setMap(x,y,i,1);
						papersCnt[i]++;
						continue;
					}
					int[] next = findNext(x, y);
					dfs(next[1], next[0], cnt + i*i, paper + 1);
					setMap(x,y,i,1);
					papersCnt[i]++;
					
				}
			}
		}
		
	}
	private static int[] findNext(int x, int y) {
		int[] next = new int[2];
		for(int i = y ; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				if(map[i][j] == 1) {
					next[0] = i;
					next[1] = j;
					return next;
				}
			}
		}
		return next;
	}
	private static boolean check(int x, int y, int size) {
		for(int i = y ; i < y+size ; i++) {
			for(int j = x ; j < x + size ; j++) {
				//색종이는 경계밖으로 나가면 안 된다 
				if(i >= 10 || j >= 10) return false;
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	private static void setMap(int x, int y, int size, int val) {
		for(int i = y ; i < y+size ; i++) {
			for(int j = x ; j < x + size ; j++) {
				map[i][j] = val;
			}
		}
	}

}
