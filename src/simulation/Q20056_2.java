package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class Q20056_2 {
	static int N, M, K;
	static ArrayList<FireBall>[][] map;
	static int[] dY = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dX = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		K = Integer.parseInt(temp[2]);
		
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
						sum += fb.mass;
					}
				}
			}
		}
		return sum;
	}
	public static void move(ArrayList<FireBall>[][] map, int n, int k) {
		while(k-- > 0) {
			ArrayList<FireBall> tempList = new ArrayList<>();
			
			// 이동
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j].size() != 0) {//파이어볼이 들어있으면 
						for(int t=0; t<map[i][j].size(); t++) {
							FireBall fb = map[i][j].get(t);//파이어볼을 하나씩 꺼낸다 
							
							int dx = j + dX[fb.dir]*fb.vel % N;
							int dy = i + dY[fb.dir]*fb.vel % N;
							

							if(dx > N) {
								dx = dx % N;
							}
							else if(dx < 1) {
								dx = N - (Math.abs(dx) % N);// 격자의 1번 행또는열은 N번 행또는 열과 연결되어있다 
							}
							
							if(dy > N) {
								dy = dy % N;
							}
							else if(dy < 1) {
								dy = N - (Math.abs(dy) % N);
							}
							
							FireBall newFb = new FireBall(dx, dy, fb.mass, fb.dir, fb.vel);
							tempList.add(newFb);
							map[i][j].remove(t--);
						}
					}
				}
			}
			
			// 실제 이동
			for(FireBall fb : tempList) {
	 			map[fb.y][fb.x].add(fb); 
			}
			
			// 2개 이상인지 확인
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j].size() > 1) {
						
						// 파이어볼 하나로 합침
						int newMass = 0;
						int newVel = 0;
						boolean even = true;
						boolean odd = true;
						for(FireBall fb : map[i][j]) {
							newMass += fb.mass;
							newVel += fb.vel;
							
							if(fb.dir % 2 != 0) even = false;
							else odd = false;
						}
						
						
						newMass /= 5;
						newVel /= map[i][j].size();
						
						map[i][j].clear();
						if(newMass != 0) {
							// 모두 홀수 or 짝수
							if(even || odd ) {
								// 0, 2, 4, 6
								map[i][j].add(new FireBall(j, i, newMass, 0, newVel));
								map[i][j].add(new FireBall(j, i, newMass, 2, newVel));
								map[i][j].add(new FireBall(j, i, newMass, 4, newVel));
								map[i][j].add(new FireBall(j, i, newMass, 6, newVel));
							}
							else {
								map[i][j].add(new FireBall(j, i, newMass, 1, newVel));
								map[i][j].add(new FireBall(j, i, newMass, 3, newVel));
								map[i][j].add(new FireBall(j, i, newMass, 5, newVel));
								map[i][j].add(new FireBall(j, i, newMass, 7, newVel));
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
		int mass;
		int dir;
		int vel;
		
		
		FireBall(int x, int y, int mass, int dir, int vel){
			this.x = x;
			this.y = y;
			this.mass = mass;
			this.dir = dir;
			this.vel = vel;
		}
	}
}