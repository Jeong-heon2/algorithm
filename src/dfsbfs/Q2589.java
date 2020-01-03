package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//ù° �ٿ��� ���� ������ ������ ũ��� ������ ũ�Ⱑ ��ĭ�� ���̿� �ΰ� �־�����. 
//�̾� L�� W�� ǥ�õ� ���� ������ �Ʒ��� ���� ���� �־�����, �� ���� ���̿��� �� ĭ�� ����.
//���� ������ ����, ������ ũ��� ���� 50�����̴�.
//ù° �ٿ� ������ ���� �ִ� �� �� ���̸� �ִ� �Ÿ��� �̵��ϴ� �ð��� ����Ѵ�.
public class Q2589 {
	static int ans;
	static int N;
	static int M;
	static class Point{
		int x;
		int y;
		char ch;
		public Point(int x, int y,char ch) {
			this.x = x;
			this.y = y;
			this.ch = ch;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Point[][] points = new Point[N+1][M+1];
		for(int i = 1 ; i <=N ; i ++) {
			String line = br.readLine();
			for(int j = 1; j <= M ; j ++) {
				points[i][j] = new Point(j,i,line.charAt(j-1));
			}
		}
		for(int i =1 ; i<=N ; i++) {
			for(int j =1 ; j<=M ; j++) {
				if(points[i][j].ch == 'L') {
					BFS(points,points[i][j]);
				}
			}
		}
		System.out.println(ans);
	}
	public static void BFS(Point[][] points, Point startPoint) {
		boolean[][] isinQueue = new boolean[N+1][M+1];
		boolean[][] isMarked = new boolean[N+1][M+1];
		Queue<Point> q = new LinkedList<Point>();
		q.add(startPoint);
		isinQueue[startPoint.y][startPoint.x] = true;
		int count = 0;
		while(q.size()>0) {
			int qsize = q.size();
			for(int i =0; i<qsize; i++) {
				Point currPoint = q.poll();
				isMarked[currPoint.y][currPoint.x] = true;
				if(ans<count) ans = count;
				//�������� �湮
				int x = currPoint.x;
				int y = currPoint.y;
				//��
				if(x<M) {
					if(points[y][x+1].ch == 'L') {
						if(!isinQueue[y][x+1] && !isMarked[y][x+1]) {
							q.add(points[y][x+1]);
							isinQueue[y][x+1] = true;
						}
					}
				}
				//��
				if(x>1) {
					if(points[y][x-1].ch == 'L') {
						if(!isinQueue[y][x-1] && !isMarked[y][x-1]) {
							q.add(points[y][x-1]);
							isinQueue[y][x-1] = true;
						}
					}
				}
				//��
				if(y<N) {
					if(points[y+1][x].ch == 'L') {
						if(!isinQueue[y+1][x] && !isMarked[y+1][x]) {
							q.add(points[y+1][x]);
							isinQueue[y+1][x] = true;
						}
					}
				}
				//��
				if(y>1) {
					if(points[y-1][x].ch == 'L') {
						if(!isinQueue[y-1][x] && !isMarked[y-1][x]) {
							q.add(points[y-1][x]);
							isinQueue[y-1][x] = true;
						}
					}
				}
			}
			count++;
		}
	}
}
