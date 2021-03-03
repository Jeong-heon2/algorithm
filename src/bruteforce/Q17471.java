package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17471 {
	static ArrayList<Integer>[] list;
	static int N;
	static int[] populations;
	static int ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		populations = new int[N+1];
		ans = Integer.MAX_VALUE;
		for(int i = 1 ; i<= N ;i++) {
			list[i] = new ArrayList<>();
			populations[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<= N ;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < n ; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int r = 1; r <= N/2 +1 ; r++) {//r : ���տ��� � ������ 
			boolean[] visited = new boolean[N+1];
			combi(visited, 1, r);
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	private static void combi(boolean[] visited, int start, int r) {
		if(r==0) {
			//���ű� 1 : true  ���ű� 2 : false 
			boolean flag1 = false;
			boolean flag2 = false;
			for(int i = 1 ; i <= N ;i++) {
				if(visited[i]) {
					flag1 = check(visited, i, true);
					break;
				}
			}
			for(int i = 1 ; i <= N ;i++) {
				if(!visited[i]) {
					flag2 = check(visited, i, false);
					break;
				}
			}
			if(flag1 && flag2) {
				//���ű��� �� ������ 
				//�α��� ��� 
				ans = Math.min(ans, getCount(visited));
			}
		}else {
			for(int i = start; i <= N ; i++) {
				visited[i] = true;
				combi(visited, i+1, r-1);
				visited[i] = false;
			}
		}
	}
	//�α��� ���
	private static int getCount(boolean[] visited) {
		int amount1 = 0;
		int amount2 = 0;
		for(int i = 1 ; i <= N ;i++) {
			if(visited[i]) {
				amount1 += populations[i];
			}else {
				amount2 += populations[i];
			}
		}
		return Math.abs(amount1 - amount2);
	}
	//flag : start ������ true���� false���� 
	private static boolean check(boolean[] section, int start, boolean flag) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : list[cur]) {
				if(!visited[next] && section[next] == flag) {//���� ���ű��� Ž�� 
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		for(int i = 1 ; i <= N ;i++) {
			if(section[i] == flag) {
				if (!visited[i]) return false;
			}
		}
		return true;
	}

}
