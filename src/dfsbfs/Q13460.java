package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
�Է�]
ù ��° �ٿ��� ������ ����, ���� ũ�⸦ �ǹ��ϴ� �� ���� N, M (3 �� N, M �� 10)�� �־�����. 
���� N���� �ٿ� ������ ����� ��Ÿ���� ���� M�� ���ڿ��� �־�����. �� ���ڿ��� '.', '#', 'O', 'R', 'B' �� �̷���� �ִ�. 
'.'�� �� ĭ�� �ǹ��ϰ�, '#'�� ���� �̵��� �� ���� ��ֹ� �Ǵ� ���� �ǹ��ϸ�, 'O'�� ������ ��ġ�� �ǹ��Ѵ�. 'R'�� ���� ������ ��ġ, 'B'�� �Ķ� ������ ��ġ�̴�.

�ԷµǴ� ��� ������ �����ڸ����� ��� '#'�� �ִ�. ������ ������ �� �� �̸�, ���� ������ �Ķ� ������ �׻� 1���� �־�����.

���]
�ּ� �� �� ���� ���� ������ ������ ���� ���� �� �ִ��� ����Ѵ�. ����, 10�� ���Ϸ� �������� ���� ������ ������ ���� ���� �� ������ -1�� ����Ѵ�.
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
			// R, B ��ġ �˾Ƴ����� 
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
					//blue�� ������ �� ��.
					if(arr[next_b.y][next_b.x] == 'O') continue;
					//��ħ üũ
					if(next_r.x == next_b.x && next_r.y == next_b.y) {
						switch(i) {
							case 0:{
								//��
								if(cur_r.x > cur_b.x) next_b.x--;
								else next_r.x--;
								break;
							}
							case 1:{
								//��
								if(cur_r.x > cur_b.x) next_r.x++;
								else next_b.x++;
								break;
							}
							case 2:{
								//��
								if(cur_r.y > cur_b.y) next_b.y--;
								else next_r.y--;
								break;
							}
							case 3:{
								//��
								if(cur_r.y > cur_b.y) next_r.y++;
								else next_b.y++;
								break;
							}
						}
					}
					if(!visited[next_r.y][next_r.x][next_b.y][next_b.x]) {
						//r�� ���ۿ� �����ٸ� ���� 
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
