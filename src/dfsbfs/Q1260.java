package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {//DFS BFS 기본문제
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws Exception{
		//첫째줄에  정점개수 / 간선개수 / 시작위치 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		ans = new ArrayList<>();
		// 정점개수만큼  arraylist<int>의 arraylist만들기
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0 ; i <= V ; i ++) {
			graph.add(new ArrayList<Integer>());
		}
		//연결할 두 노드 번호 입력
		//해당 인덱스에 숫자 추가하기  
		//예를들어 1 2   /  1 3   입력되면
		//arraylist<int> = [ 0 ,[ 2,3] ]   >> 1인덱스 (1번노드에) 2 3 연결
		for(int i = 1 ; i <= E ; i ++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			//각 노드는 인덱스0번부터 채워짐에 유의
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for(int i = 1; i<= V ; i ++) {
			Collections.sort(graph.get(i));
		}
		DFS(graph,start);//1은 시작노드
		for(int i = 0 ; i < ans.size() ; i ++) {
			System.out.print(ans.get(i)+" ");
		}
		ans.clear();
		System.out.println();
		BFS(graph,start);
		for(int i = 0 ; i < ans.size() ; i ++) {
			System.out.print(ans.get(i)+" ");
		}
		
	}
	public static void DFS(ArrayList<ArrayList<Integer>> G, int start) {
		ArrayList<Boolean> isMarked = new ArrayList<>();
		for(int i = 0 ; i < G.size()+1 ; i++) {
			isMarked.add(false);
		}
		recursiveDFS(G,isMarked,start);
	}
	public static void recursiveDFS(ArrayList<ArrayList<Integer>> G, ArrayList<Boolean> isMarked, int start) {
		if(isMarked.get(start)) return;
		else {
			ans.add(start);
			isMarked.set(start, true);
			for(int e : G.get(start)) {//e는 G[start] (arraylist)의 모든 요소들을  대입
				recursiveDFS(G,isMarked,e);
			}
			return;
		}
	}
	public static void BFS(ArrayList<ArrayList<Integer>> G,int start) {
		ArrayList<Boolean> isMarked = new ArrayList<>();
		for(int i = 0 ; i < G.size()+1 ; i++) {
			isMarked.add(false);
		}
		ArrayList<Boolean> isinQueue = new ArrayList<>();
		for(int i = 0 ; i < G.size()+1 ; i++) {
			isinQueue.add(false);
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		isinQueue.set(start, true);
		while (Q.size()>0) {
			int current = Q.poll();
			ans.add(current);
			isMarked.set(current, true);
			for(int e : G.get(current)) {
				if((isMarked.get(e) == false) && (isinQueue.get(e) == false)){
					Q.add(e);
					isinQueue.set(e, true);
				}
			}
		}
		return;
	}
}
