package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2167 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N+1][M+1];
		for(int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<M+1 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int T = Integer.parseInt(br.readLine());
		for(int a = 0; a< T; a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int b = i ; b < x+1 ; b++) {
				for (int c = j ; c < y+1 ; c++) {
					sum += arr[b][c];
				}
			}
			System.out.println(sum);
		}
	}
}
