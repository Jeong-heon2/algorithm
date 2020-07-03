package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�Է�]
ù° �ٿ� ������ ũ�� N(2 �� N �� 20)�� �־�����.

��° �ٺ��� N���� �ٿ� ������ ���°� �־�����. ������ ���´� 0, 1, 2, 3, 4, 5, 6, 9�� �̷���� �ְ�, �Ʒ��� ���� �ǹ̸� ������.

0: �� ĭ
1, 2, 3, 4, 5, 6: ĭ�� �ִ� ������� ũ��
9: �Ʊ� ����� ��ġ
�Ʊ� ���� ������ �� ���� �ִ�.

���]
ù° �ٿ� �Ʊ� �� ���� ���� ������ ��û���� �ʰ� ����⸦ ��Ƹ��� �� �ִ� �ð��� ����Ѵ�.
 */
//���ٹ�: bfs , ���� , �켱����ť 
public class Q16236 {
	static int N;
	public static void main(String[] args)throws Exception {
		//�ʱ�ȭ, �Է¹ޱ� 
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
		//�Ʊ��� ũ�� 
		int size = 2;
		//���� ������� ��� �Ծ��°� ? 
		int cnt = 0;
		//���� ����� �Ա���� �󸶸�ŭ ��������
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
					//���� �� �ִ�.
					arr[cur.y][cur.x] = 0;
					ans += round;
					round = -1;
					cnt++;
					//�ʱ�ȭ 
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
							//nextX, nextY�� �̵��� �� �ִ�.
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
		//��ǥ�� �ǿ��� ������ ���� �����ϱ�.
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
