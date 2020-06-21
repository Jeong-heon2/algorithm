package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
�Է�]
ù° �ٿ� ������ ũ�� N�� �־�����. (2 �� N �� 100) ���� �ٿ� ����� ���� K�� �־�����. (0 �� K �� 100)
���� K���� �ٿ��� ����� ��ġ�� �־����µ�, ù ��° ������ ��, �� ��° ������ �� ��ġ�� �ǹ��Ѵ�. 
����� ��ġ�� ��� �ٸ���, �� �� �� ���� (1�� 1��) ���� ����� ����.
���� �ٿ��� ���� ���� ��ȯ Ƚ�� L �� �־�����. (1 �� L �� 100)
���� L���� �ٿ��� ���� ���� ��ȯ ������ �־����µ�,  ���� X�� ���� C�� �̷���� ������. 
���� ���� �ð����κ��� X�ʰ� ���� �ڿ� ����(C�� 'L') �Ǵ� ������(C�� 'D')�� 90�� ������ ȸ����Ų�ٴ� ���̴�.
 X�� 10,000 ������ ���� �����̸�, ���� ��ȯ ������ X�� �����ϴ� ������ �־�����.

���]
ù° �ٿ� ������ �� �ʿ� �������� ����Ѵ�.
 */
public class Q3190 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		//size of board
		int N = Integer.parseInt(br.readLine());
		//num of apples
		int K = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		//input apples 
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
		}
		//count of direction change
		int L = Integer.parseInt(br.readLine());
		HashMap<Integer, String> dc_map = new HashMap<>();
		while(L-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dc_map.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		int[] goX = {1, 0, -1, 0};
		int[] goY = {0, 1, 0, -1};
		int direction = 0;//0 : east, 1 : south , 2 : west, 3 : north
		int time = 0;
		int len = 1;
		int x = 1;
		int y = 1;
		while(true) {
			if(isEnd(x, y, N, arr, time, len)) {
				System.out.println(time);
				break;
			}
			if(dc_map.containsKey(time)) {
				direction = getDirection(direction, dc_map.get(time));
			}
			//������ 
			if(arr[y][x] == -1) len++;
			//�湮�ߴ� �ð��� �����.
			arr[y][x] = time++;
			//���� �̵��� ������ ��ǥ ����. 
			x = x + goX[direction];
			y = y + goY[direction];
		}
		
		
	}
	static boolean isEnd(int x, int y, int n, int[][] arr, int time, int len) {
		//���� �ε����°� 
		if(x <= 0 || x > n || y <= 0 || y > n) return true;
		//�ڱ� ���� �ε����°� 
		if(arr[y][x] > 0) {
			if(time - arr[y][x] <= len) return true;
		}
		return false;
	}
	static int getDirection(int curr_direction, String dc) {
		switch(dc) {
			case "D" : {
				if(curr_direction == 3) return 0;
				else return ++curr_direction;
			}
			case "L" : {
				if(curr_direction == 0) return 3;
				else return --curr_direction;
			}
		}
		return curr_direction;
	}
	

}
