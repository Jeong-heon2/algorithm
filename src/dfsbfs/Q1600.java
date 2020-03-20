package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//첫째 줄에 자연수 K가 주어진다.
//둘째 줄에 격자판의 가로길이 W, 세로길이 H가 주어진다. 
//그 다음 H줄에 걸쳐 W개의 숫자가 주어지는데, 0은 아무것도 없는 평지, 1은 장애물을 뜻한다.
//장애물이 있는 곳으로는 이동할 수 없다. 시작점과 도착점은 항상 평지이다.
//W와 H는 1이상 200이하의 자연수이고, K는 0이상 30이하의 정수이다.

//첫째 줄에 원숭이의 동작수의 최솟값을 출력한다.
//시작점에서 도착점까지 갈 수 없는 경우엔 -1을 출력한다.
public class Q1600 {
	static int K;
	static int W;
	static int H;
	static int[][] arr;
	static boolean isFirst = true;
	static int ans;
	static int[] hx = {1,2,2,1,-1,-2,-2,-1};
	static int[] hy = {-2,-1,1,2,2,1,-1,-2};
	static int[] gox = {1,-1,0,0};
	static int[] goy = {0,0,1,-1};
	public static void main(String[] args)throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H+1][W+1];
		for(int i = 1 ; i<=H ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 1; j<=W; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		DFS();
		
		if(ans == 0) {
			if((W==1)&&(H==1)) System.out.println("0");
			else System.out.println("-1");
		}
		else System.out.println(ans);
	}
	
	public static void DFS() {
		boolean[][] isMarked = new boolean[H+1][W+1];
		int count_horse = 0;
		int count = 0;
		recursiveDFS(isMarked,false,1,H,count,count_horse);
	}
	public static void recursiveDFS(boolean[][] isMarked, boolean isHorse, int x, int y,int count, int count_horse) {
		if(arr[y][x] == 1) return;
		if((y==1)&&(x==W)) {
			if(isFirst) {
				ans = count;
				isFirst = false;
			}else {
				if(count < ans) ans = count;
			}
			return;
		}
		if(isMarked[y][x]) return;
		else {
			if(isHorse) count_horse++;
			isMarked[y][x] = true;
			count++;
			if(count_horse < H) {
				for(int i = 0 ; i< hx.length ; i++) {
					int nx = hx[i]+x;
					int ny = hy[i]+y;
					if(isRanged(nx,ny)) {
						recursiveDFS(isMarked,true,nx,ny,count,count_horse);
					}
				}
			}
			for(int i = 0 ; i< gox.length ; i++) {
				int nx = gox[i]+x;
				int ny = goy[i]+y;
				if(isRanged(nx,ny)) {
					recursiveDFS(isMarked,false,nx,ny,count,count_horse);
				}
			}
			return;
			
		}
	}
	public static boolean isRanged(int x , int y) {
		if((x>W)||(x<1)||(y>H)||(y<1)) return false;
		else return true;
	}
}
