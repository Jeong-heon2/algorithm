package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//�Է��� ù° �ٿ��� �׽�Ʈ ���̽��� ������ �־�����.
//�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�. 
//ù° �ٿ��� ü������ �� ���� ���� l(4 �� l �� 300)�� �־�����. 
//ü������ ũ��� l �� l�̴�. ü������ �� ĭ�� �� ���� �� {0, ..., l-1} �� {0, ..., l-1}�� ��Ÿ�� �� �ִ�. 
//��° �ٰ� ��° �ٿ��� ����Ʈ�� ���� �ִ� ĭ, ����Ʈ�� �̵��Ϸ��� �ϴ� ĭ�� �־�����.
//�� �׽�Ʈ ���̽����� ����Ʈ�� �� ������ �̵��� �� �ִ��� ����Ѵ�.
public class Q7562 {
	static int[] goX = { 1,2,2,1,-1,-2,-2,-1};
	static int[] goY = { 2,1,-1,-2,-2,-1,1,2};
	static int ans=-1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T ; t++) {
			int I = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st2.nextToken());
			int endY = Integer.parseInt(st2.nextToken());
			BFS(I,startX,startY,endX,endY);
			System.out.println(ans);
			ans = -1;
		}
	}
	public static void BFS(int I,int startX,int startY,int endX,int endY) {
		boolean[][] isMarked = new boolean[I][I];
		boolean[][] isinQueue = new boolean[I][I];
		Queue<Point> Q = new LinkedList<Point>();
		Q.add(new Point(startX,startY));
		isinQueue[startX][startY] = true;
		while (Q.size()>0) {
			int qs = Q.size();
			ans++;
			for(int i =0; i < qs ; i++) {
				Point current = Q.poll();
				int currX = current.x;
				int currY = current.y;
				if((currX == endX) && (currY == endY)) return;
				isMarked[startX][startY] = true;
				for(int j = 0 ; j<8 ; j++) {
					if(isRanged(new Point(currX+goX[j],currY+goY[j]),I)){
						if((isMarked[currX+goX[j]][currY+goY[j]] == false)&&
								(isinQueue[currX+goX[j]][currY+goY[j]] == false)) {
							Q.add(new Point(currX+goX[j],currY+goY[j]));
							isinQueue[currX+goX[j]][currY+goY[j]] = true;
						}
					}
				}
			}
		}
		return;
	}
	public static boolean isRanged(Point point,int I) {
		if((point.x<I)&&(point.x>=0)&&(point.y<I)&&(point.y>=0)) return true;
		else return false;
	}
}
