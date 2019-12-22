package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11724 {//연결 그래프 인지 찾기
	static ArrayList<Boolean> isMarked;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start;
		int ans=0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		isMarked = new ArrayList<>();
		for(int i = 0 ; i <= N ; i++) {
			isMarked.add(false);
		}
		for(int i = 0 ; i <= N ; i++) list.add(new ArrayList<Integer>());
		for(int i = 1 ; i <= M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i = 1 ; i<=N; i++) {
			if(!isMarked.get(i)) {
				start = i;
				ans++;
				DFS(list,start);
			}
		}
		System.out.println(ans);

	}
	public static void DFS(ArrayList<ArrayList<Integer>> G, int start) {
		recursiveDFS(G,isMarked,start);
	}
	public static void recursiveDFS(ArrayList<ArrayList<Integer>> G, ArrayList<Boolean> isMarked, int start) {
		if(isMarked.get(start)) return;
		else {
			isMarked.set(start, true);
			for(int e : G.get(start)) {//e는 G[start] (arraylist)의 모든 요소들을  대입
				recursiveDFS(G,isMarked,e);
			}
			return;
		}
	}
}
