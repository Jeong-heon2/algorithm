package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����.
 ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. 
� �� ���� ���̿� ���� ���� ������ ���� �� �ִ�. �Է����� �־����� ������ ������̴�.
 */
public class Q1260_2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i <= N ; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i = 1; i<= V ; i ++) {
			Collections.sort(list.get(i));
		}
		dfs(list, ans, V);
		printAns(ans);
		System.out.println();
		ans.clear();
		bfs(list, ans, V);
		for(int i = 0 ; i < ans.size() ; i ++) {
			System.out.print(ans.get(i)+" ");
		}
		
	}
	public static void dfs(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> ans, int start) {
		ArrayList<Boolean> visited = new ArrayList<>();
		for(int i = 0 ; i <= list.size() ; i++) {
			visited.add(false);
		}
		recursiveDfs(list, visited, ans, start);
	}
	public static void recursiveDfs(ArrayList<ArrayList<Integer>> list, ArrayList<Boolean> visited, ArrayList<Integer> ans, int n) {
		if(visited.get(n)) return;
		ans.add(n);
		visited.set(n, true);
		for(int e : list.get(n)) {
			recursiveDfs(list, visited, ans, e);
		}
		return;
	}
	public static void bfs(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> ans, int start) {
		ArrayList<Boolean> isMarked = new ArrayList<>();
		for(int i = 0 ; i < list.size()+1 ; i++) {
			isMarked.add(false);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		isMarked.set(start, true);
		while(q.size() > 0) {
			int n = q.poll();
			ans.add(n);
			for(int e : list.get(n)) {
				if(!isMarked.get(e)){
					q.add(e);
					isMarked.set(e, true);
				}
			}
		}
	}
	public static void printAns(ArrayList<Integer> ans) {
		for(int i = 0 ; i < ans.size() ; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

}
