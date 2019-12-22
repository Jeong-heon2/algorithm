package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11403 {
	static boolean[][] cango;
	public static void main(String[] args)throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> G = new ArrayList<>();
			cango = new boolean[N+1][N+1];
			for(int i = 0 ; i < N+1 ; i++) {
				G.add(new ArrayList<Integer>());
			}
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					int a = Integer.parseInt(st.nextToken());
					if(a == 1) {
						G.get(i).add(j);
					}
				}
			}
			for(int i = 1 ; i <= N ; i++) {
				DFS(G,i,i);
			}
			for(int i = 1; i <= N ; i++) {
				for(int j = 1; j <= N; j++) {
					if(cango[i][j]) {
						System.out.print("1 ");
					}
					else {
						System.out.print("0 ");
					}
				}
				System.out.println();
			}
	}
	public static void DFS(ArrayList<ArrayList<Integer>> G, int start, int first) {//first 는 최초 시작노드
		ArrayList<Boolean> isMarked = new ArrayList<>();
		for(int i = 0 ; i < G.size()+1 ; i++) {
			isMarked.add(false);
		}
		recursiveDFS(G,isMarked,start,first);
	}
	public static void recursiveDFS(ArrayList<ArrayList<Integer>> G, ArrayList<Boolean> isMarked, int start,int first) {
		if(isMarked.get(start)) return;
		else {
			isMarked.set(start, true);
			for(int e : G.get(start)) {//e는 G[start] (arraylist)의 모든 요소들을  대입
				cango[first][e] = true;
				recursiveDFS(G,isMarked,e,first);
			}
			return;
		}
	}
}
