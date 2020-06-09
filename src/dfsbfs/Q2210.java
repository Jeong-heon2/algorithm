package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*숫자판 점프
5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다.
이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 
각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 
이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며,0으로 시작하는 000123과 같은 수로 만들 수 있다.
숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.
[입력]
다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.
[출력]
첫째 줄에 만들 수 있는 수들의 개수를 출력한다.
 */
public class Q2210 {
	//6자리 수를 담을 자료구조
	static HashSet<String> set = new HashSet<>();
	static int[][] arr;
	//동서남북 
	static int[] goR = {1, -1, 0, 0};
	static int[] goC = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		for(int i = 0 ; i < 5 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < 5 ; ++i) {
			for(int j = 0 ; j < 5 ; j++) {
				Bfs(new Point(i, j));
			}
		}
		System.out.println(set.size());
	}
	public static void Bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		while(q.size() > 0) {
			int qSize = q.size();
			for(int i = 0 ; i < qSize ; i++) {
				Point curr = q.poll();
				curr.line += arr[curr.x][curr.y];
				if(curr.line.length() == 6) {
					set.add(curr.line);
					continue;
				}
				
				//동서남북 큐에 넣기
				for(int j = 0 ; j < 4 ; j ++) {
					Point next = new Point(curr.x + goR[j], curr.y + goC[j]);
					next.line = curr.line;
					if(isRanged(next.x, next.y)) {
						q.add(next);
					}
				}
			}
		}
	}
	public static boolean isRanged(int x, int y) {
		if(x < 0 || x >= 5 || y < 0 || y >= 5) return false;
		else return true;
	}
	static class Point{
		int x;
		int y;
		String line = "";
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
