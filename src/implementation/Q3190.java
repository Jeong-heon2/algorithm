package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
입력]
첫째 줄에 보드의 크기 N이 주어진다. (2 ≤ N ≤ 100) 다음 줄에 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)
다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미한다. 
사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
다음 줄에는 뱀의 방향 변환 횟수 L 이 주어진다. (1 ≤ L ≤ 100)
다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데,  정수 X와 문자 C로 이루어져 있으며. 
게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다.
 X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.

출력]
첫째 줄에 게임이 몇 초에 끝나는지 출력한다.
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
			//사과라면 
			if(arr[y][x] == -1) len++;
			//방문했던 시간을 남긴다.
			arr[y][x] = time++;
			//다음 이동할 곳으로 좌표 설정. 
			x = x + goX[direction];
			y = y + goY[direction];
		}
		
		
	}
	static boolean isEnd(int x, int y, int n, int[][] arr, int time, int len) {
		//벽에 부딪혔는가 
		if(x <= 0 || x > n || y <= 0 || y > n) return true;
		//자기 몸에 부딪혔는가 
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
