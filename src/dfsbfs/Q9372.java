package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9372 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t<T ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());//국가의 수
			M = Integer.parseInt(st.nextToken());//비행기 종류 수
			arr = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i <= N ; i++) {
				arr.add(new ArrayList<Integer>());
			}
			for(int i=1; i <= M ; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				arr.get(a).add(b);
				arr.get(b).add(a);
			}
			System.out.println(BFS(1));
		}
		
	}
	public static int BFS(int start) {
		boolean[] isMarked = new boolean[N+1];
		boolean[] isinQueue = new boolean[N+1];
		Arrays.fill(isMarked, false);
		Arrays.fill(isinQueue, false);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		isinQueue[start] = true;
		int count = 0;
		while(q.size()>0) {
			int qs = q.size();
			for(int i =0 ; i<qs ; i++) {
				int curr = q.poll();
				isMarked[curr] = true;
				for(int e : arr.get(curr)) {
					if(!isinQueue[e]&&!isMarked[e]) {
						q.add(e);
						count++;
						isinQueue[e] = true;
					}
				}
			}
		}
		return count;
	}
}
