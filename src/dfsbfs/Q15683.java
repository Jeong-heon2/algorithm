package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 감시 
 * 블로그를 참고해서 풀었다. 꼭 나중에 다시 풀어볼 것. 아주 좋은 문제.
 * https://mygumi.tistory.com/313
 * https://jaejin89.tistory.com/96
 */
public class Q15683 {
	static int[][] arr;
	static ArrayList<CCTV> list;
	static int N;
	static int M;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		//세로 크기 
		N = Integer.parseInt(st.nextToken());
		//가로 
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				if(1 <= num && num <= 5) {
					list.add(new CCTV(num, j, i));
				}
			}
		}
		dfs(0, arr);
		System.out.println(ans);
	}
	public static void dfs(int cctvIdx, int[][] prev) {
		int[][] visited = new int[N][M];
		if(cctvIdx == list.size()) {
			int cnt = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(prev[i][j] == 0) {
						cnt++;
					}
				}
			}
			if(ans > cnt) ans = cnt;
		}else {
			CCTV cctv = list.get(cctvIdx);
			int type = cctv.type;
			int x = cctv.x;
			int y = cctv.y;
			switch (type) {
            case 1:
                for (int k = 0; k < 4; k++) {
                    for (int i = 0; i < N; i++) {
                        visited[i] = Arrays.copyOf(prev[i], M);
                    }
                    detect(visited, y, x, k);
                    dfs(cctvIdx + 1, visited);
                }
                break;
            case 2:
                for (int k = 0; k < 2; k++) {
                    for (int i = 0; i < N; i++) {
                        visited[i] = Arrays.copyOf(prev[i], M);
                    }
                    detect(visited, y, x, k);
                    detect(visited, y, x, k + 2);
                    dfs(cctvIdx + 1, visited);
                }
                break;
            case 3:
                for (int k = 0; k < 4; k++) {
                    for (int i = 0; i < N; i++) {
                        visited[i] = Arrays.copyOf(prev[i], M);
                    }
                    detect(visited, y, x, k);
                    detect(visited, y, x, (k + 1) % 4);
                    dfs(cctvIdx + 1, visited);
                }
                break;
            case 4:
                for (int k = 0; k < 4; k++) {
                    for (int i = 0; i < N; i++) {
                        visited[i] = Arrays.copyOf(prev[i], M);
                    }
                    detect(visited, y, x, k);
                    detect(visited, y, x, (k + 1) % 4);
                    detect(visited, y, x, (k + 2) % 4);
                    dfs(cctvIdx + 1, visited);
                }
                break;
            case 5:
                for (int i = 0; i < N; i++) {
                    visited[i] = Arrays.copyOf(prev[i], M);
                }
                detect(visited, y, x, 0);
                detect(visited, y, x, 1);
                detect(visited, y, x, 2);
                detect(visited, y, x, 3);
                dfs(cctvIdx + 1, visited);
                break;
        }


		}
	}
	public static void detect(int[][] visited, int i, int j, int direction) {
	    switch (direction) {
	        case 0:
	            for (int k = j; k >= 0; k--) {
	                if (arr[i][k] == 6) {
	                    break;
	                }
	                visited[i][k] = 7;
	            }
	            break;
	        case 1:
	            for (int k = i; k >= 0; k--) {
	                if (arr[k][j] == 6) {
	                    break;
	                }
	                visited[k][j] = 7;
	            }
	            break;
	        case 2:
	            for (int k = j; k < M; k++) {
	                if (arr[i][k] == 6) {
	                    break;
	                }
	                visited[i][k] = 7;
	            }
	            break;
	        case 3:
	            for (int k = i; k < N; k++) {
	                if (arr[k][j] == 6) {
	                    break;
	                }
	                visited[k][j] = 7;
	            }
	            break;
	    }
	}

	static class CCTV {
		int type;
		int x;
		int y;
		public CCTV(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}
	}

}
