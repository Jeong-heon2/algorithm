package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
���� �ֻ��� ������ 
       back
west  bottom  east
	   front
	   top
	   
 */
public class Q14499 {
	static int bottom;
	static int top;
	static int front;
	static int back;
	static int east;
	static int west;
	static int[][] arr;
	//�����ϳ� 
	static int[] goX = {0, 1, -1, 0, 0};
	static int[] goY = {0, 0, 0, -1, 1};
	static int N;
	static int M;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//���� 
		N = Integer.parseInt(st.nextToken());
		//���� 
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		//�ֻ��� ���� ���� ��ǥ 
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		//����� ����
		int k = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <  M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < k ; i++) {
			//�̵��� ���� 
			int d = Integer.parseInt(st.nextToken());
			int nx = x + goX[d];
			int ny = y + goY[d];
			if(isRanged(nx, ny)) {
				move(x = nx, y = ny, d);
				System.out.println(top);
			}
		}
	
	}
	public static boolean isRanged(int x, int y) {
		if(x >= 0 && x < M && y >= 0 && y < N) return true;
		return false;
	}
	public static void move(int x, int y, int d) {
		int b_back = back;
		int b_bottom = bottom;
		int b_west = west;
		int b_front = front;
		int b_top = top;
		int b_east = east;
		if(d == 1) {//��
			east = b_top;
			bottom = b_east;
			top = b_west;
			west = b_bottom;
		}else if(d == 2) {//�� 
			bottom = b_west;
			top = b_east;
			west = b_top;
			east = b_bottom;
		}else if(d == 4) {//�� 
			bottom = b_front;
			front = b_top;
			back = b_bottom;
			top = b_back;
		}else {//��
			top = b_front;
			bottom = b_back;
			front = b_bottom;
			back = b_top;
		}
		if(arr[y][x] == 0) {
			arr[y][x] = bottom;
		}else {
			bottom = arr[y][x];
			arr[y][x] = 0;
		}
	}

}
