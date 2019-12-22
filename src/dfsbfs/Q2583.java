package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2583 {
	static int M;
	static int N;
	static int K;
	static int count_area = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M+1][N+1];
		int count_rec = 0;
		ArrayList<Integer> list_area = new ArrayList<Integer>();
		for(int i = 0 ; i < K ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st2.nextToken());
			int y1 = Integer.parseInt(st2.nextToken());
			int x2 = Integer.parseInt(st2.nextToken());
			int y2 = Integer.parseInt(st2.nextToken());
			for(int j = x1+1; j <=x2;j++) {
				for(int s = y1+1; s<=y2 ; s++) {
					arr[s][j] = 1;
				}
			}
		}
		for(int i = 1; i<=M; i++) {
			for(int j = 1; j<=N; j++) {
				if(arr[i][j] == 0) {
					DFS(arr,j,i);
					count_rec++;
					list_area.add(count_area);
					count_area = 0;
				}
			}
		}
		System.out.println(count_rec);
		Collections.sort(list_area);
		for(int i = 0 ; i < list_area.size(); i++) {
			System.out.print(list_area.get(i)+" ");
		}
	}
	public static void DFS(int[][] arr, int startX,int startY) {

		recursiveDFS(arr,startX,startY);
	}
	public static void recursiveDFS(int[][] arr, int startX,int startY) {
		if(arr[startY][startX] == 1) return;
		else {
			count_area++;
			arr[startY][startX] = 1;
			if(startX+1<=N) recursiveDFS(arr,startX+1,startY);//동쪽 방문
			if(startX-1>=1) recursiveDFS(arr,startX-1,startY);//서쪽
			if(startY-1>=1) recursiveDFS(arr,startX,startY-1);
			if(startY+1<=M) recursiveDFS(arr,startX,startY+1);
			return;
		}
	}
}
