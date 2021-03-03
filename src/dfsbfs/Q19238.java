package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q19238 {
	static int[] goX = {1,-1,0,0};
	static int[] goY = {0,0,1,-1};
	static int[][] map;
	static int N;
	static int M;
	static int T;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		T = Integer.parseInt(tmp[2]);
		count = 0 ; //ó���� �°� �� 
		map = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		tmp = br.readLine().split(" ");
		int sY = Integer.parseInt(tmp[0]);
		int sX = Integer.parseInt(tmp[1]);
		int[][] dest = new int[M+2][2];//�մԹ�ȣ (2�� ���� ����. 1�� ���̴ϱ�. ) 
		for(int i = 2 ; i < M+2 ; i++) {
			tmp = br.readLine().split(" ");
			int fY = Integer.parseInt(tmp[0]);
			int fX = Integer.parseInt(tmp[1]);
			int dY = Integer.parseInt(tmp[2]);
			int dX = Integer.parseInt(tmp[3]);
			map[fY][fX] = i;//�մԹ�ȣ ���� 
			dest[i] = new int[]{dY, dX};//�ش� �մ� ��ȣ�� ������ ��ǥ ���� 
		}
		if(!bfs(new int[] {sY,sX}, dest)) {
			System.out.println("-1");
		}else {
			System.out.println(T);
		}
		
	}
	private static boolean bfs(int[] start, int[][] dest) {
		boolean[][] visited  = new boolean[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		int[] passenger = null;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0 ; i < qSize; i++) {
				int[] cur = q.poll();
				for(int j = 0 ; j< 4 ; j++) {
					int ny = cur[0] + goY[j];
					int nx = cur[1] + goX[j];
					if(isRanged(ny,nx) && !visited[ny][nx] && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						q.offer(new int[] {ny,nx});
						if(map[ny][nx] > 1) {//�°��� �ִ� ��ǥ 
							if(passenger == null) {
								passenger = new int[] {ny,nx};
							}else {
								if(ny < passenger[0]) {//���ȣ�� ���� �� �켱 
									passenger = new int[] {ny,nx};
								}else if(ny == passenger[0]) {
									if(nx < passenger[1]) {
										passenger = new int[] {ny,nx};
									}
								}
							}
						}
					}
				}
			}
			T--;
			if(T == 0) return false;
			if(passenger != null) {
				//�°��� ã�� 
				//�������� �̵�, ���� ��� 
				int[] target =  dest[map[passenger[0]][passenger[1]]];
				if(!findDest(passenger, target)) {
					return false;
				}
				count++;
				if(M == count) return true;
				//bfs �ʱ�ȭ ,  �������� ������ġ�� �Ǿ� �ٽ� bfs����
				for(int i = 1 ; i <= N ; i++) {
					Arrays.fill(visited[i], false);
				}
				q.clear();
				q.offer(target);
				map[passenger[0]][passenger[1]] = 0;
				passenger = null;
				visited[target[0]][target[1]] = true;
			}
			
		}
		return false;
	}
	private static boolean findDest(int[] start, int[] target) {
		boolean[][] visited  = new boolean[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0 ; i < qSize; i++) {
				int[] cur = q.poll();
				for(int j = 0 ; j< 4 ; j++) {
					int ny = cur[0] + goY[j];
					int nx = cur[1] + goX[j];
					if(isRanged(ny,nx) && !visited[ny][nx] && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						q.offer(new int[] {ny,nx});
						if(ny == target[0] && nx == target[1]) {
							cnt++;
							T--;
							T += cnt*2;
							return true;
						}
					}
				}
			}
			T--;
			if(T == 0) return false;
			cnt++;
		}
		return false;
	}
	private static boolean isRanged(int y, int x) {
		if(y<1 || y >N || x < 1 || x > N) return false;
		return true;
	}

}
