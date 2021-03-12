package dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q10159 {
	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] heavyList = new ArrayList[N+1];
		ArrayList<Integer>[] lightList = new ArrayList[N+1];
		for(int i = 1; i <= N ; i++) {
			heavyList[i] = new ArrayList<>();
			lightList[i] = new ArrayList<>();
		}
 		while(M-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int heavy = Integer.parseInt(tmp[0]);
			int light = Integer.parseInt(tmp[1]);
			heavyList[heavy].add(light);
			lightList[light].add(heavy);
		}
 		br.close();
 		
 		for(int i = 1; i <= N ; i++) {
 			int heavy_cnt = bfs(heavyList, i);//i번 보다 무거운 것의 개수 
 			int light_cnt = bfs(lightList, i);//i번 보다 가벼운 것의 개수 
 			bw.write(N - heavy_cnt - light_cnt - 1+"\n");
 		}
 		bw.flush();
 		bw.close();

	}
	private static int bfs(ArrayList<Integer>[] list, int start) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : list[cur]) {
				if(!visited[next]) {
					q.offer(next);
					cnt++;
					visited[next] = true;
				}
			}
		}
		return cnt;
	}

}
