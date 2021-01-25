package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import simulation.Q20056_2.FireBall;

public class Q20056 {
	static int[] dY = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dX = {0, 1, 1, 1, 0, -1, -1, -1};
	static ArrayList<FireBall>[][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int K = Integer.parseInt(temp[2]);
		
		map = new ArrayList[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for(int i=0; i<M; i++) {
			temp = br.readLine().split(" ");
			int y = Integer.parseInt(temp[0]);
			int x = Integer.parseInt(temp[1]);
			int mass = Integer.parseInt(temp[2]);
			int vel = Integer.parseInt(temp[3]);
			int dir = Integer.parseInt(temp[4]);
			
			FireBall fb = new FireBall(x, y,mass, dir, vel);
			map[y][x].add(fb);
		}
		
		move(map, N, K);
		System.out.println(getAmount(map, N));
		
	}
	public static int getAmount(ArrayList<FireBall>[][] map, int n) {
		int sum = 0;
		for(int i = 1 ; i <= n; i ++) {
			for(int j = 1 ; j <= n ; j++) {
				int size = map[i][j].size();
				if(size > 0) {
					for(FireBall fb : map[i][j]) {
						sum += fb.m;
					}
				}
			}
		}
		return sum;
	}
	public static void move(ArrayList<FireBall>[][] map, int n, int k) {
		while(k-- > 0) {
			//1.모든 파이어볼들이 자신의 방향 d로 속력 s칸 만큼 이동 
			ArrayList<FireBall> tempList = new ArrayList<>();
			for(int i = 1 ; i <= n; i ++) {
				for(int j = 1 ; j <= n ; j++) {
					int size = map[i][j].size();
					if(size > 0) {
						for(int t = 0; t < map[i][j].size() ; t++) {
							FireBall fb = map[i][j].get(t);
							int nx = j + dX[fb.d]*fb.s % n;
							int ny = i + dY[fb.d]*fb.s % n;
							if(nx > n) {
								nx = nx % n;
							}
							else if(nx < 1) {
								nx = n - (Math.abs(nx) % n);
							}
							
							if(ny > n) {
								ny = ny % n;
							}
							else if(ny < 1) {
								ny = n - (Math.abs(ny) % n);
							}
	                        tempList.add(new FireBall(nx, ny, fb.m, fb.d, fb.s));
	                        map[i][j].remove(t--);
						}
					}
				}
			}
			// 실제 이동
			for(FireBall fb : tempList) {
	 			map[fb.x][fb.y].add(fb); 
			}
			//2.이동이 모두 끝난 후, 2개이상의 파이어볼이 있는 칸 
			for(int i = 1 ; i <= n; i ++) {
				for(int j = 1 ; j <= n ; j++) {
					int size = map[i][j].size();
					if(size > 1) {
						int sum_amm = 0;//질량 합
						int sum_speed = 0;//속력  합 
						boolean even = true;
						boolean odd = true;
						for(FireBall fb : map[i][j]) {
							if(fb.d % 2 != 0) even = false;
							else odd = false;
							sum_amm += fb.m;
							sum_speed += fb.s;
						}
						map[i][j].clear();
						int m = sum_amm / 5;
						int s = sum_speed / size;
						if(m != 0) {
							if(even || odd) {//합쳐지는 파이어볼이 모두 홀 수 이거나 짝수이면 
								map[i][j].add(new FireBall(j, i, m, 0, s));
								map[i][j].add(new FireBall(j, i, m, 2, s));
								map[i][j].add(new FireBall(j, i, m, 4, s));
								map[i][j].add(new FireBall(j, i, m, 6, s));
							}else {
								map[i][j].add(new FireBall(j, i, m, 1, s));
								map[i][j].add(new FireBall(j, i, m, 3, s));
								map[i][j].add(new FireBall(j, i, m, 5, s));
								map[i][j].add(new FireBall(j, i, m, 7, s));
							}
						}
					}
				}
			}
		}
	}
	static class FireBall{
		int x;
		int y;
		int m;
		int d;
		int s;
		
		FireBall(int mass, int dir, int vel){
			this.m = mass;
			this.d = dir;
			this.s = vel;
		}
		
		FireBall(int x, int y, int mass, int dir, int vel){
			this.x = x;
			this.y = y;
			this.m = mass;
			this.d = dir;
			this.s = vel;
		}
	}

}
