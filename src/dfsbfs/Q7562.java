package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
//각 테스트 케이스는 세 줄로 이루어져 있다. 
//첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 
//체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 
//둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
//각 테스트 케이스마다 나이트가 몇 번만에 이동할 수 있는지 출력한다.
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
