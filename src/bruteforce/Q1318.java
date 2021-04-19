package bruteforce;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Q1318 {
	static int cnt;//전체 경우의 수 
	static int[] res;//각 족보의 경우 
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		cnt = 0;
		res = new int[13];
		combination(new boolean[52], 0, 52, 6);
		for(int i = 0 ; i < 13 ; i++) {
			bw.write(res[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static void combination(boolean[] visited, int start, int n, int r) {
		if(r == 0) {
		}else {
			for(int i = start ; i < n ; i++) {
				visited[i] = true;
				combination(visited, i+1 , n , r-1);
				visited[i] = false;
			}
		}
	}
	private static boolean FourCard(boolean[] visited) {
		for(int i = 0 ; i < 13 ; i++) {
			boolean flag = true;
			for(int j = 0; j < 4 ; j++) {
				int idx = j*13 + i;
				if(!visited[idx]) {
					flag = false;
					break;
				}
			}
			if(flag) return true;
		}
		return false;
	}
	private static boolean straightFlush(boolean[] visited) {
		for(int i = 0 ; i < 4 ; i++) {
			int cnt = 0;
			boolean pre = false;
			for(int j = 0; j < 13 ; j++) {
				int idx = i*13 + j;
				if(pre && visited[idx]) {
					cnt++;
					if(cnt == 4) {
						return true;
					}
				}else {
					cnt = 0;
				}
				pre = visited[idx];
			}
		}
		return false;
	}
	private static boolean royal(boolean[] visited) {
		if(visited[0]&&visited[1]&&visited[2]&&visited[3]&&visited[4]) {
			return true;
		}else if(visited[13]&&visited[14]&&visited[15]&&visited[16]&&visited[17]) {
			return true;
		}else if(visited[26]&&visited[27]&&visited[28]&&visited[29]&&visited[30]) {
			return true;
		}else if(visited[39]&&visited[40]&&visited[41]&&visited[42]&&visited[43]) {
			return true;
		}
		return false;
	}
}
