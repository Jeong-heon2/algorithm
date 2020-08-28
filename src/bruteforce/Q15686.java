package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15686 {
	static ArrayList<Point> chickens;
	static ArrayList<Point> houses;
	static int[][] arr;
	static int N;
	static int[] goX = {1, -1, 0, 0};
	static int[] goY = {0, 0, 1, -1};
	static int ans ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		chickens = new ArrayList<Point>();
		houses = new ArrayList<Point>();
		ans = Integer.MAX_VALUE;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int val = Integer.parseInt(st.nextToken());
				arr[i][j] = val;
				if(val == 1) houses.add(new Point(j, i));
				if(val == 2) chickens.add(new Point(j, i));
			}
		}
		int num_chicken = chickens.size();
		boolean[] visited = new boolean[num_chicken];
		for(int i = M ; i >= 1 ; i--) {
			combi(visited, 0, i, num_chicken);
		}
		System.out.println(ans);
		
	}
	public static void combi(boolean[] visited, int start, int r, int n) {
		if(r == 0) {
			ArrayList<Point> choicedList = new ArrayList<>();
			for(int i = 0 ; i < n ; i++) {
				if(visited[i]) {
					choicedList.add(chickens.get(i));
				}
			}
			ans = Math.min(ans, find(choicedList));
			return;
		}
		for(int i = start; i < n ; i++) {
			visited[i] = true;
			combi(visited, i + 1, r - 1, n);
			visited[i] = false;
		}
	}
	public static int find(ArrayList<Point> list) {
		int size = list.size();
		for(int i = 0 ; i < size; i++) {
			Point chicken = list.get(i);
			arr[chicken.y][chicken.x] = 3;
		}
		//bfs
		int res = 0;
		for(int i = 0 ; i < houses.size() ; i++) {
			Point house = houses.get(i);
			res += bfs(house, size);
		}
		
		for(int i = 0 ; i < size ; i++) {
			Point chicken = list.get(i);
			arr[chicken.y][chicken.x] = 2;
		}
		return res;
	}
	public static int bfs(Point house, int size) {
		boolean[][] visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.offer(house);
		visited[house.y][house.x] = true;
		int round = 1;
		while(q.size() > 0) {
			int qSize = q.size();
			for(int i = 0 ; i < qSize; i++) {
				Point cur = q.poll();
				for(int j = 0 ; j < 4 ; j++) {
					int nx = cur.x + goX[j];
					int ny = cur.y + goY[j];
			
					if(isRanged(nx, ny)) {
						if(!visited[ny][nx]) {
							visited[ny][nx] = true;
							q.offer(new Point(nx, ny));
							if(arr[ny][nx] == 3) {
								return round;
							}
						}
					}
					
				}
			}
			
			round++;
		}
		return 0;
	}
	public static boolean isRanged(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		else return true;
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
