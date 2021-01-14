package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17199 {
	static int N;
	static int walkwaySize;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		walkwaySize = N-1;
		arr = (ArrayList[])new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < walkwaySize ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b].add(a);
		}
		int ans = 0;
		for(int i = 1; i <= N ; i++) {
			if(bfs(i)) ans = i;
		}
		if(ans == 0 ) System.out.println(-1);
		else System.out.println(ans);
		
	}
	public static boolean bfs(int start) {
		boolean[] visited = new boolean[N+1];
		visited[0] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while(q.size() > 0) {
			int cur = q.poll();
			for(int next : arr[cur]) {
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		
		//하나라도 방문 안 한 곳이 있다면 false
		for(boolean bool : visited) {
			if(!bool) return false;
		}
		return true;
	}

}
