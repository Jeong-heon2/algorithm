package codingtestex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NaverWebtoonQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Solution {
		boolean[][] map;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int H;
		int W;
		int ans;
	    public int solution(int[] bricks, int n, int k) {
	        map = new boolean[n][bricks.length];
	        H = n;
	        W = bricks.length;
	        ans = Integer.MAX_VALUE;
	        for(int i = 0 ; i < W ; i++) {
	        	int len = bricks[i];
	        	for(int j = 0 ; j < len ; j++) {
	        		map[j][i] = true;
	        	}
	        }
	        for(int i = 1; i <= W ; i++) {
	        	boolean[] visited = new boolean[W];
	        	combination(bricks, visited, 0, W, i, k);
	        }
	        return ans;
	    }
	    private void combination(int[] bricks, boolean[] visited, int start, int n, int r, int k) {
	    	if(r==0) {
	    		// 벽돌을 쌓을 위치 (가로 위치) 
	    		ArrayList<Integer> choices = new ArrayList<>();
	    		int sum = 0;//쌓을 벽돌 개수 
	    		for(int i = 0 ; i < n ; i ++) {
	    			if(visited[i]) {
	    				choices.add(i);
	    				sum += H - bricks[i];
	    			}
	    		}
	    		int cnt = getBoundNum(choices);
	    		if(cnt == k) {
	    			ans = Math.min(ans, sum);
	    		}
	    	}else {
	    		for(int i = start ; i < n ; i++) {
	    			visited[i] = true;
	    			combination(bricks, visited, i + 1 , n , r-1, k);
	    			visited[i] = false;
	    		}
	    	}
	    }
	    private int getBoundNum(ArrayList<Integer> choices) {
	    	int cnt = 0;
	    	boolean[][] visited = new boolean[map.length][W];
	    	for(int i = 0 ; i < H; i++) {
	    		for(int j = 0 ; j < W; j++) {
	    			//물이고 아직 방문 x면  
	    			if(!map[i][j] && !visited[i][j] && !choices.contains(j)) {
	    				bfs(visited, new int[] {i,j}, choices);
	    				cnt++;
	    			}
	    		}
	    	}
	    	return cnt;
	    }
	    private void bfs(boolean[][] visited, int[] start, ArrayList<Integer> choices) {
	    	Queue<int[]> q = new LinkedList<int[]>();
	    	q.offer(start);
	    	visited[start[0]][start[1]] = true;
	    	while(!q.isEmpty()) {
	    		int[] cur = q.poll();
	    		for(int i = 0 ; i < 4 ; i++) {
	    			int nx = cur[1] +dx[i];
	    			int ny = cur[0] +dy[i];
	    			if(nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
	    			if(!visited[ny][nx] && !map[ny][nx] && !choices.contains(nx)) {
	    				q.offer(new int[] {ny,nx});
	    				visited[ny][nx] = true;
	    			}
	    		}
	    	}
	    }
	}

}
