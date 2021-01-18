package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q18428 {
	static int N ;
	static int[] goX = {1,-1, 0, 0};
	static int[] goY = {0, 0, 1, -1};
	static ArrayList<Point> st_list;
	static char[][] arr;
	static ArrayList<Point> emt_list;
	static boolean ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		st_list = new ArrayList<>();
		emt_list = new ArrayList<>();
		ans = false;
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				char ch = st.nextToken().charAt(0);
				if(ch == 'S') st_list.add(new Point(j, i));
				else if(ch == 'X') emt_list.add(new Point(j, i));
				arr[i][j] = ch;
			}
		}
		
		boolean[] visited = new boolean[emt_list.size()];
		//장애물이 설치 될 3자리 -> 모든 경우의 수 구하기  (조합 알고리즘) 
		combination(emt_list, visited, 0, emt_list.size(), 3);
		if(ans) System.out.println("YES");
		else System.out.println("NO");
	}
	//감시를 피했는지 체크 
	static boolean check() {
		for(Point sd : st_list) {
			for(int i = 0 ; i < 4 ; i++) {
				Point next = new Point(sd.x + goX[i], sd.y + goY[i]);
				while(isRanged(next)) {
					if(arr[next.y][next.x] == 'O') break;
					if(arr[next.y][next.x] == 'T') {
						return false;
					}
					next.x += goX[i];
					next.y += goY[i];
				}
			}
		}
		return true;
	}
	// 사용 예시 : combination(arr, visited, 0, n, r)
	static void combination(ArrayList<Point> list, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	    	Point[] blocks = new Point[3];
	    	int idx = 0;
	    	for (int i = 0; i < n; i++) {
	            if (visited[i] == true) {
	            	blocks[idx++] = list.get(i);
	            }
	        }
	    	for(Point p : blocks ) {
	    		arr[p.y][p.x] = 'O';
	    	}
	    	if(check()) ans = true;
	    	for(Point p : blocks ) {
	    		arr[p.y][p.x] = 'X';
	    	}
	        return;
	    } 
	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(list, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	public static boolean isRanged(Point p) {
		if(p.x < 0 || p.x >= N || p.y < 0 || p.y >= N) return false;
		return true;
	}
	static class Point {
		int x;
		int y;
		Point (int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
