package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class PG2017KakaoPre01 {
	static int[][] arr;
	static int[] goX = {1, -1, 0, 0};
	static int[] goY = {0, 0, 1, -1};
	static int M;
	static int N;
	public static void main(String[] args) {
		int[] ans = solution(6, 4, new int[][] {
			{1, 1, 1, 1}, 
			{1, 1, 1, 1}, 
			{1, 1, 2, 1}, 
			{1, 1, 1, 1}, 
			{1, 1, 1, 3}, 
			{0, 0, 4, 3}});
		for(int i = 0 ; i < ans.length ; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        arr = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		arr[i][j] = picture[i][j];
        	}
        }
        M = m;
        N = n;
        for(int i = 0 ; i < m ; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		if(arr[i][j] != 0) {
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, arr[i][j]));
        			numberOfArea++;
        		}
        	} 
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	public static int bfs(int y, int x, int target) {
		
		Queue<Integer> qX = new LinkedList<>();
		Queue<Integer> qY = new LinkedList<>();
		//area size
		int size = 0;
		
		qY.offer(y);
		qX.offer(x);
		
		while(qX.size() > 0) {
			int curX = qX.poll();
			int curY = qY.poll();
			//visit
			arr[curY][curX] = 0;
			size++;
			
			for(int i = 0 ; i < 4 ; i++) {
				int nextX = curX + goX[i];
				int nextY = curY + goY[i];
				
				if(isRanged(nextX, nextY)){
					//방문하지 않았다면 
					if((!qX.contains(nextX) || !qY.contains(nextY))&& arr[nextY][nextX] == target) {
						qX.offer(nextX);
						qY.offer(nextY);
					}
				}
			}
			
		}
		return size;
		
	}
	public static boolean isRanged(int x, int y) {
		if(x >= 0 && x < N && y >=0 && y <M) return true;
		else return false;
	}
}
