package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {
	private static int M;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());//배추밭의 가로길이
			N = Integer.parseInt(st.nextToken());//배추밭의 세로길이
			int K = Integer.parseInt(st.nextToken());//배추가심어져있는 위치의 개수
			int[][] arr = new int[N][M];
			for(int k = 0 ; k<K; k++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st2.nextToken());
				int Y = Integer.parseInt(st2.nextToken());
				arr[Y][X] = 1;
			}
			for(int j=0; j<N; j++) {
				for(int s=0; s<M; s++) {
					if(arr[j][s] == 1) {
						recursiveDFS(arr,j,s);
						ans++;
					}
				}
			}
			System.out.println(ans);
			ans = 0;
		}
	}
	public static void recursiveDFS(int[][] G, int startX,int startY) {
		if(G[startX][startY]==0) return;
		else {
			G[startX][startY] = 0;
			//동서남북 방문
			if(startY+1<M) {//동
				recursiveDFS(G,startX,startY+1);
			}
			if(startY-1>=0) {//서
				recursiveDFS(G,startX,startY-1);
			}
			if(startX+1<N) {//남
				recursiveDFS(G,startX+1,startY);
			}
			if(startX-1>=0) {//북
				recursiveDFS(G,startX-1,startY);
			}
			return;
		}
	}
}
