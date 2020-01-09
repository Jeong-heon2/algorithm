package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//N��M�� ��ķ� ǥ���Ǵ� ���� �ִ�.
//�ʿ��� 0�� �̵��� �� �ִ� ���� ��Ÿ����, 1�� �̵��� �� ���� ���� �ִ� ���� ��Ÿ����. 
//����� (1, 1)���� (N, M)�� ��ġ���� �̵��Ϸ� �ϴµ�, �̶� �ִ� ��η� �̵��Ϸ� �Ѵ�. 
//�ִܰ�δ� �ʿ��� ���� ���� ������ ĭ�� ������ ��θ� ���ϴµ�, �̶� �����ϴ� ĭ�� ������ ĭ�� �����ؼ� ����.
//���࿡ �̵��ϴ� ���߿� �� ���� ���� �μ��� �̵��ϴ� ���� �� �� ��ΰ� ª�����ٸ�, 
//���� �� �� ���� �μ��� �̵��Ͽ��� �ȴ�.
//���� �־����� ��, �ִ� ��θ� ���� ���� ���α׷��� �ۼ��Ͻÿ�.
public class Q2206 {
	static int ans;
	static int N;
	static int M;
	static class Point{
		int x;
		int y;
		int chance;
		public Point(int x, int y,int chance) {
			this.x = x;
			this.y = y;
			this.chance = 1;

		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N+1][M+1];
		for(int i = 1; i <= N ; i++) {
			String line = br.readLine();
			for(int j = 1; j<=M ; j++) {
				arr[i][j] = line.charAt(j-1);
			}
		}
		
		int res = BFS(arr,new Point(1,1,1));
		if(ans == 0) {
			ans = res;
		}
		else if((ans != 0) && (res == -1)) {
			
		}
		else {
			if(ans >res){
				ans = res;
			}
		}
		System.out.println(ans);
	}
	public static int BFS(char[][] arr , Point startPoint) {
		boolean[][] isinQueue = new boolean[N+1][M+1];
		boolean[][] isMarked = new boolean[N+1][M+1];
		Queue<Point> q = new LinkedList<Point>();
		q.add(startPoint);
		isinQueue[1][1] = true;
		int count = 1;
		while(q.size()>0) {
			int qsize = q.size();
			for(int i = 0 ; i<qsize ; i++) {
				Point currPoint = q.poll();
				int x = currPoint.x;
				int y = currPoint.y;
				isMarked[y][x] = true;
				int chance = currPoint.chance;
				if((y==N)&&(x==M)) return count;
				//��
				if(x<M) {
					if(arr[y][x+1] == '0') {
						if(!isinQueue[y][x+1] && !isMarked[y][x+1]) {
							if(chance == 1) {
								q.add(new Point(x+1,y,1));
								isinQueue[y][x+1] = true;
							}
							else {
								q.add(new Point(x+1,y,0));
								isinQueue[y][x+1] = true;
							}
						}
					}
					else {
						if(chance == 1) {
							q.add(new Point(x+1,y,0));
							isinQueue[y][x+1] = true;
						}
					}
				}
				if(x>1) {//��
					if(arr[y][x-1] == '0') {
						if(!isinQueue[y][x-1] && !isMarked[y][x-1]) {
							if(chance == 1) {
								q.add(new Point(x-1,y,1));
								isinQueue[y][x-1] = true;
							}
							else {
								q.add(new Point(x-1,y,0));
								isinQueue[y][x-1] = true;
							}
						}
					}
					else {
						if(chance == 1) {
							q.add(new Point(x-1,y,0));
							isinQueue[y][x-1] = true;
						}
					}
				}
				if(y<N) {//��
					if(arr[y+1][x] == '0') {
						if(!isinQueue[y+1][x] && !isMarked[y+1][x]) {
							if(chance == 1) {
								q.add(new Point(x,y+1,1));
								isinQueue[y+1][x] = true;
							}
							else {
								q.add(new Point(x,y+1,0));
								isinQueue[y+1][x] = true;
							}
						}
					}
					else {
						if(chance == 1) {
							q.add(new Point(x,y+1,0));
							isinQueue[y+1][x] = true;
						}
					}
				}
				if(y>1) {//��
					if(arr[y-1][x] == '0') {
						if(!isinQueue[y-1][x] && !isMarked[y-1][x]) {
							if(chance == 1) {
								q.add(new Point(x,y-1,1));
								isinQueue[y-1][x] = true;
							}
							else {
								q.add(new Point(x,y-1,0));
								isinQueue[y-1][x] = true;
							}
						}
					}
					else {
						if(chance == 1) {
							q.add(new Point(x,y-1,0));
							isinQueue[y-1][x] = true;
						}
					}
				}
			}
			count++;
		}
		return -1;
	}
}
