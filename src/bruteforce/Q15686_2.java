package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15686_2 {
	static ArrayList<Point> chickens;
	static ArrayList<Point> houses;
	static int[][] dist; //dist[i][j] : i번집에서 j번 치킨집 최단거리 
	static int N;
	static int[] goX = {1, -1, 0, 0};
	static int[] goY = {0, 0, 1, -1};
	static int ans ;
	public static void main(String[] args) throws Exception{
		//입력 과 초기화 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		chickens = new ArrayList<Point>();
		houses = new ArrayList<Point>();
		ans = Integer.MAX_VALUE;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 1) houses.add(new Point(j, i));
				if(val == 2) chickens.add(new Point(j, i));
			}
		}
		int hSize = houses.size();
		int cSize = chickens.size();
		dist = new int[hSize][cSize];
		
		//houses 돌면서 dist 완성 
		for(int i = 0 ; i < hSize ; i++) {
			for(int j = 0 ; j < cSize ; j ++) {
				dist[i][j] = Math.abs(chickens.get(j).y-houses.get(i).y)+Math.abs(chickens.get(j).x-houses.get(i).x);
			}
		}
		
		//치킨집 조합 
		boolean[] visited = new boolean[cSize];
		for(int i = M ; i >= 1 ; i--) {
			combi(visited, 0, i, cSize);
		}
		System.out.println(ans);
	}
	public static void combi(boolean[] visited, int start, int r, int n) {
		if(r == 0) {
			ans = Math.min(ans, find(visited));
			return;
		}
		for(int i = start ; i < n ; i++) {
			visited[i] = true;
			combi(visited, i+1, r-1, n);
			visited[i] = false;
		}
	}
	public static int find(boolean[] visited) {
		int res = 0;
		for(int i = 0; i < dist.length; i++) {
			//i는 집 번호 
			//j는 치킨 집 번호 
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < visited.length ; j++) {
				if(visited[j]) {
					min = Math.min(min, dist[i][j]);
				}
			}
			res += min;
		}
		return res;
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
