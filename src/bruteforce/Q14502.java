package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {
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
		map = new int[N][M];
		ans = 0;
		ArrayList<int[]> listEmpty = new ArrayList<>();
		ArrayList<int[]> listVirus = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j  = 0 ; j < M ; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if(v == 0) listEmpty.add(new int[] {i, j});
				else if(v == 2) listVirus.add(new int[] {i, j});
			}
		}
		boolean[] visited = new boolean[listEmpty.size()];
		combi(listEmpty, listVirus, visited, 0, listEmpty.size(), 3);
		System.out.println(ans);
	}
	//벽 3개치기 조합 알고리즘 
	//list : 빈칸 좌표 리스트 (벽이 쳐질수 있는 공간 좌표들 ) 
	private static void combi(ArrayList<int[]> listEmpty, ArrayList<int[]> listVirus, boolean[] visited, int start, int n , int r) {
		if(r == 0) {
			//deep copy
			int clonedMap[][] = new int[N][M];
			for(int i=0; i< N; i++){
	            System.arraycopy(map[i], 0, clonedMap[i], 0, M);
	        }
			//벽 세우기 
			int test = 0 ;
			for(int i = 0 ; i < n ; i++) {
				if(visited[i]) {
					clonedMap[listEmpty.get(i)[0]][listEmpty.get(i)[1]] = 1;
				}
			}
			spread(clonedMap, listVirus);
			ans = Math.max(getSafeZoneCnt(clonedMap), ans);
		}else {
			for(int i = start ;  i < n ; i++) {
				visited[i] = true;
				combi(listEmpty, listVirus, visited, i+1, n, r-1);
				visited[i] = false;
			}
		}
	}
	private static boolean isRanged(int y, int x) {
		if(y < 0 || y >= N || x < 0 || x >= M) return false;
		return true;
	}
	//바이러스 퍼지기 
	private static void spread(int[][] clonedMap , ArrayList<int[]> listVirus) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		for(int[] p : listVirus) {
			q.offer(p);
			visited[p[0]][p[1]] = true;
		}
		while(q.size() > 0) {
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
		
	}
	//안전구역 개수 세기
	private static int getSafeZoneCnt(int[][] clonedMap) {
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j< M ; j++) {
				if(clonedMap[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}

}
