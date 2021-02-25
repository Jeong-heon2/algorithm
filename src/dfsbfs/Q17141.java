package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17141 {
	static int ans;
	static int N;
	static int M;
	static int[][] map;
	static int[] goX = { 1, -1 , 0 , 0};
	static int[] goY = {0, 0, 1, -1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		ArrayList<int[]> listVirus = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j  = 0 ; j < N ; j++) {
				int v = Integer.parseInt(st.nextToken());
				
				if(v == 2) {
					listVirus.add(new int[] {i, j});
					map[i][j] = 0;
				}else {
					map[i][j] = v;
				}
			}
		}
		boolean[] visited = new boolean[listVirus.size()];
		combi(listVirus, visited, 0, listVirus.size(), M);
		if(ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}
	//벽 3개치기 조합 알고리즘 
	//list : 바이러스를 놓을 수 있는 좌표들 
	private static void combi(ArrayList<int[]> listVirus, boolean[] visited, int start, int n , int r) {
		if(r == 0) {
			//deep copy
			int clonedMap[][] = new int[N][N];
			for(int i=0; i< N; i++){
	            System.arraycopy(map[i], 0, clonedMap[i], 0, N);
	        }
			ArrayList<int[]> selectedVirus = new ArrayList<>();
			for(int i = 0 ; i < n ; i++) {
				if(visited[i]) {
					int[] p = listVirus.get(i);
					selectedVirus.add(p);
					clonedMap[p[0]][p[1]] = 2;
				}
			}
			int res = spread(clonedMap, selectedVirus);
			if(check(clonedMap)) {
				//빈칸이 없음 
				ans = Math.min(res, ans);
			}
		}else {
			for(int i = start ;  i < n ; i++) {
				visited[i] = true;
				combi(listVirus, visited, i+1, n, r-1);
				visited[i] = false;
			}
		}
	}
	private static boolean isRanged(int y, int x) {
		if(y < 0 || y >= N || x < 0 || x >= N) return false;
		return true;
	}
	//바이러스 퍼지기 
	private static int spread(int[][] clonedMap , ArrayList<int[]> listVirus) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		for(int[] p : listVirus) {
			q.offer(p);
			visited[p[0]][p[1]] = true;
		}
		int round = -1;
		while(q.size() > 0) {
			int qSize = q.size();
			while(qSize-- > 0) {
				int[] cur = q.poll();
				for(int i = 0 ; i < 4 ; i++) {
					int nx = goX[i] + cur[1];
					int ny = goY[i] + cur[0];
					if(isRanged(ny, nx) && !visited[ny][nx] && clonedMap[ny][nx] == 0) {
						clonedMap[ny][nx] = 2;
						visited[ny][nx] = true;
						q.offer(new int[] {ny, nx});
					}
				}
			}
			round++;
		}
		return round;
		
	}
	//안전구역 남아있는지 체크 
	private static boolean check(int[][] clonedMap) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j< N ; j++) {
				if(clonedMap[i][j] == 0) return false;
			}
		}
		return true;
	}

}