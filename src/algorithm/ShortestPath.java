package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ShortestPath {
	static int N;
	static int ans = 2147483647;
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st3.nextToken());
		int Y = Integer.parseInt(st3.nextToken());
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i = 0 ; i < N ; i++) list.add(new ArrayList<Integer>());
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		DFS(list,X,Y);
		if(ans == 2147483647) System.out.println(0);
		else System.out.println(ans);
	}
	public static void DFS(ArrayList<ArrayList<Integer>> G, int start,int target) {
	    
		for(int i : G.get(start)) {
			ArrayList<Boolean> isMarked = new ArrayList<>();
			count = 0;
			for(int j = 0 ; j < N ; j++) {
				isMarked.add(false);
			}
			isMarked.set(start, true);
			count++;
			recursiveDFS(G,isMarked,i,target);
		}
	}
	public static void recursiveDFS(ArrayList<ArrayList<Integer>> G, ArrayList<Boolean> isMarked, int start,int target) {
		if (start == target) {
			if(count < ans) ans= count;
			count--;
			return;
		}
		if(isMarked.get(start)) {
			count--;
			return;
		}
		else {
			isMarked.set(start, true);
			for(int e : G.get(start)) {
				count++;
				recursiveDFS(G,isMarked,e,target);
			}
			return;
		}
	}
}
