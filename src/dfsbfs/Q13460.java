package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
입력]
첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 
다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로 이루어져 있다. 
'.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.

입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.

출력]
최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.
 */
public class Q13460 {
	static char[][] arr;
	static boolean[][][][] visited;
	static int N;
	static int M;
	static int[] goX = {1, -1, 0, 0};
	static int[] goY = {0, 0, 1, -1};
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//board vertical, horizontal
		//vertical
		N = Integer.parseInt(st.nextToken());
		//horizontal
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = br.readLine().toCharArray();
			// R, B 위치 알아내야함 
		}
		Point start_r_pos = null;
		Point start_b_pos = null;
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(arr[i][j] == 'R') start_r_pos = new Point(j, i);
				if(arr[i][j] == 'B') start_b_pos = new Point(j, i);
			}
		}
		visited = new boolean[N][M][N][M];
		Queue<Point> q_r = new LinkedList<>();
		Queue<Point> q_b = new LinkedList<>();
		q_r.offer(start_r_pos);
		q_b.offer(start_b_pos);
		visited[start_r_pos.y][start_r_pos.x][start_b_pos.y][start_b_pos.x] = true;
		int round = 0;
		boolean gotAns = false;
		while(q_r.size() > 0) {
			int qSize = q_r.size();
			round++;
			while(qSize--> 0) {
				Point cur_r = q_r.poll();
				Point cur_b = q_b.poll();
				for(int i = 0 ; i < 4 ; i++) {
					Point next_r = getNextPoint(cur_r, goX[i], goY[i]);
					Point next_b = getNextPoint(cur_b, goX[i], goY[i]);
					//blue가 빠지면 안 됨.
					if(arr[next_b.y][next_b.x] == 'O') continue;
					//겹침 체크
					if(next_r.x == next_b.x && next_r.y == next_b.y) {
						switch(i) {
							case 0:{
								//동
								if(cur_r.x > cur_b.x) next_b.x--;
								else next_r.x--;
								break;
							}
							case 1:{
								//서
								if(cur_r.x > cur_b.x) next_r.x++;
								else next_b.x++;
								break;
							}
							case 2:{
								//남
								if(cur_r.y > cur_b.y) next_b.y--;
								else next_r.y--;
								break;
							}
							case 3:{
								//북
								if(cur_r.y > cur_b.y) next_r.y++;
								else next_b.y++;
								break;
							}
						}
					}
					if(!visited[next_r.y][next_r.x][next_b.y][next_b.x]) {
						//r만 구멍에 빠졌다면 정답 
						if(arr[next_r.y][next_r.x] == 'O' && arr[next_b.y][next_b.x] != 'O') {
							gotAns = true;
							break;
						}
						visited[next_r.y][next_r.x][next_b.y][next_b.x] = true;
						q_r.offer(next_r);
						q_b.offer(next_b);
					}
				}
				if(gotAns) break;
			}
			if(gotAns) break;
		}
		if(!gotAns || round > 10) System.out.println(-1);
		else System.out.println(round);
		
	}
	static Point getNextPoint(Point cur, int px, int py) {
		Point next = new Point(cur.x + px, cur.y + py);
		if(arr[cur.y][cur.x] == 'O' || arr[next.y][next.x] == '#') {
			return cur;
		}
		return getNextPoint(next, px, py);
	}
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
