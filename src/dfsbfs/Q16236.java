package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
입력]
첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.

둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.

0: 빈 칸
1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
9: 아기 상어의 위치
아기 상어는 공간에 한 마리 있다.

출력]
첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.
 */
//접근법: bfs , 정렬 , 우선순위큐 
public class Q16236 {
	static int N;
	public static void main(String[] args)throws Exception {
		//초기화, 입력받기 
		int[] goX = {0, -1, 1, 0};
		int[] goY = {-1, 0, 0, 1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		Point start = new Point(0,0);
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int a =  Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				if(a == 9) {
					start.x = j;
					start.y = i;
					arr[i][j] = 0;
				}
			}
		}
		//bfs 
		PriorityQueue<Point> pq = new PriorityQueue<>();
		PriorityQueue<Point> pq2 = new PriorityQueue<>();
		pq.offer(start);
		pq2.offer(start);
		visited[start.y][start.x] = true;
		//아기상어 크기 
		int size = 2;
		//현재 사이즈에서 몇마리 먹었는가 ? 
		int cnt = 0;
		//이전 물고기 먹기까지 얼마만큼 움직였나
		int round = -1;
		int ans = 0;
		while(pq2.size() > 0) {
			pq = pq2;
			pq2 = new PriorityQueue<>();
			int qsize = pq.size();
			round++;
			for(int j = 0 ; j < qsize ; j++) {
				Point cur = pq.poll();
				if(arr[cur.y][cur.x] < size && arr[cur.y][cur.x] > 0) {
					//먹을 수 있다.
					arr[cur.y][cur.x] = 0;
					ans += round;
					round = -1;
					cnt++;
					//초기화 
					pq.clear();
					pq2.clear();
					qsize = 0;
					visited = new boolean[N][N];
					if(size == cnt) {
						size++;
						cnt = 0;
					}
					visited[cur.y][cur.x] = true;
					pq2.offer(new Point(cur.x, cur.y));
					break;
				}
				for(int i = 0 ; i < 4 ; i++) {
					int nextX = cur.x + goX[i];
					int nextY = cur.y + goY[i];
					if(isRanged(nextX, nextY) && !visited[nextY][nextX]) {
						if(arr[nextY][nextX] <= size) {
							//nextX, nextY로 이동할 수 있다.
							visited[nextY][nextX] = true;
							pq2.offer(new Point(nextX, nextY));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	static boolean isRanged(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < N) return true;
		else return false;
	}
	static class Point implements Comparable<Point>{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		//좌표상 맨왼쪽 맨위가 먼저 오게하기.
		@Override
		public int compareTo(Point o) {
			if(this.y > o.y) return 1;
			else if (this.y == o.y) {
				if(this.x > o.x) return 1;
				else if(this.x == o.x) return 0;
				else return -1;
			}else {
				return -1;
			}
		}
		
	}

}
