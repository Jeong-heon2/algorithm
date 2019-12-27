package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//3차원 토마토
//첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다.
//M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 
//단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 
//둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 
//즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다.
//각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 
//정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 
//이러한 N개의 줄이 H번 반복하여 주어진다.

public class Q7569 {
	static Queue<Points> Q = new LinkedList<Points>();
	static int M;
	static int N;
	static int H;
	static int[][][] arr;
	static int ans=0;
	static boolean[][][] isinQueue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H+1][M+1][N+1]; // 면 행 렬
		isinQueue = new boolean[H+1][M+1][N+1];
		int count_0 = 0;
		for(int i = 1 ; i<= H ; i++) {
			for(int j = 1; j<= M ; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int k = 1; k<=N ; k++) {
					int a = Integer.parseInt(st2.nextToken());
					arr[i][j][k] = a;
					if(a==0) count_0 ++;
				}
			}
		}
		for(int i = 1 ; i<= H ; i++) {
			for(int j = 1; j<= M ; j++) {
				for(int k = 1; k<=N ; k++) {
					if(arr[i][j][k]==1) {
						Q.add(new Points(i,j,k));
						isinQueue[i][j][k] = true;
					}
					
				}
			}
		}
		BFS();
		if(count_0 == 0) System.out.println(0);
		else {
			for(int i = 1 ; i<= H ; i++) {
				for(int j = 1; j<= M ; j++) {
					for(int k = 1; k<=N ; k++) {
						if(arr[i][j][k]==0) {
							System.out.println(-1);
							System.exit(0);
						}
					}
				}
			}
			System.out.println(ans-1);
		}
	}
	public static void BFS() {
		while (Q.size()>0) {
			int s = Q.size();
			ans++;
			for(int i = 0 ; i < s ; i++) {
				Points current = Q.poll();
				arr[current.x][current.y][current.z] = 1;
				//동서남북위아래를 큐에 넣는데 
				//조건 : Q에 없고 arr[point]가 0이고 N,M,H 범위안에
				if(((current.z) != N)&&(!isinQueue[current.x][current.y][current.z+1])){
					if(arr[current.x][current.y][current.z+1] == 0) {
						Q.add(new Points(current.x,current.y,current.z+1));
						isinQueue[current.x][current.y][current.z+1] = true;
					}
				}
				if(((current.z-1) != 0)&&(!isinQueue[current.x][current.y][current.z-1])) {
					if(arr[current.x][current.y][current.z-1] == 0) {
						Q.add(new Points(current.x,current.y,current.z-1));
						isinQueue[current.x][current.y][current.z-1] = true;
					}
				}
				if(((current.y) != M)&&(!isinQueue[current.x][current.y+1][current.z])) {
					if(arr[current.x][current.y+1][current.z] == 0) {
						Q.add(new Points(current.x,current.y+1,current.z));
						isinQueue[current.x][current.y+1][current.z] = true;
					}
				}
				if(((current.y-1) != 0)&&(!isinQueue[current.x][current.y-1][current.z])) {
					if(arr[current.x][current.y-1][current.z] == 0) {
						Q.add(new Points(current.x,current.y-1,current.z));
						isinQueue[current.x][current.y-1][current.z] = true;
					}
				}
				if(((current.x) != H)&&(!isinQueue[current.x+1][current.y][current.z])) {
					if(arr[current.x+1][current.y][current.z] == 0) {
						Q.add(new Points(current.x+1,current.y,current.z));
						isinQueue[current.x+1][current.y][current.z] = true;
					}
				}
				if(((current.x-1) != 0)&&(!isinQueue[current.x-1][current.y][current.z])) {
					if(arr[current.x-1][current.y][current.z] == 0) {
						Q.add(new Points(current.x-1,current.y,current.z));
						isinQueue[current.x-1][current.y][current.z]= true;
					}
				}
			}
		}
		return;
	}

}
class Points{
	int x;
	int y;
	int z;
	public Points(int x, int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}