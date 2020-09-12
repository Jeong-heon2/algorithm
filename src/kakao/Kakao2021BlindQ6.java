package kakao;

public class Kakao2021BlindQ6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Solution {
		int[] goX = {1, -1, 0 ,0};
		int[] goY = {0, 0, 1, -1};
		int[][] arr;
		int ans;
	    public int solution(int[][] board, int r, int c) {
	        int answer = 0;
	        arr = board;
	        ans = Integer.MAX_VALUE;
	        return answer;
	    }
	    public void dfs(Point cur, Point front_card, int cnt) {
	    	if(cnt >= 112) return;
	    	else {
	    		int cur_card = arr[cur.y][cur.x];
	    		//press enter 
	    		//2개? 
	    		if(cur_card != 0) {
	    			cnt++;
		    		if(front_card != null) {
		    			if(front_card.card == cur_card) {
		    				//delete
		    				//arr이 전부 0이냐  그럼 cnt를 기록 후 return
		    				arr[front_card.y][front_card.x] = 0;
		    				arr[cur.y][cur.x] = 0;
		    				boolean flag = true;
		    				for(int i = 0 ; i < 3 ; i++) {
		    					for(int j = 0 ; j < 3 ; j++) {
		    						if(arr[i][j] != 0) {
		    							flag = false;
		    						}
		    					}
		    				}
		    				if(flag) {
		    					ans = Math.min(ans, cnt);
		    					return;
		    				}
		    			}
		    			front_card = null;
		    		}
	    		}
	    		//press not
	    		for(int i = 0 ; i < 4 ; i++) {
	    			int nx = goX[i];
	    			int ny = goY[i];
	    			Point cp = ctrlPoint(i, cur);
	    			if(cp != cur) {
	    				dfs(cp, front_card, cnt + 1);
	    			}
	    			if(isRanged(ny, nx)) {
	    				dfs(new Point(ny, nx), front_card, cnt + 1);
	    			}
	    		}
	    		
	    	}
	    }
	    
	    public Point ctrlPoint(int dir, Point cur) {
	    	switch(dir){
		    	case 0 : {
		    		int nx = cur.x + 1;
		    		while(true) {
		    			if(isRanged(cur.y, nx)) {
		    				if(arr[cur.y][nx] != 0) {
		    					return new Point(cur.y, nx);
		    				}else {
		    					nx++;
		    				}
		    			}else {
		    				return new Point(cur.y, 3);
		    			}
		    		}
		    	}
		    	case 1 : {
		    		int nx = cur.x - 1;
		    		while(true) {
		    			if(isRanged(cur.y, nx)) {
		    				if(arr[cur.y][nx] != 0) {
		    					return new Point(cur.y, nx);
		    				}else {
		    					nx--;
		    				}
		    			}else {
		    				return new Point(cur.y, 0);
		    			}
		    		}
		    	}
		    	case 2 : {
		    		int ny = cur.y + 1;
		    		while(true) {
		    			if(isRanged(ny, cur.x)) {
		    				if(arr[ny][cur.y] != 0) {
		    					return new Point(ny, cur.x);
		    				}else {
		    					ny++;
		    				}
		    			}else {
		    				return new Point(3, cur.x);
		    			}
		    		}
		    	}
		    	case 3 : {
		    		int ny = cur.y - 1;
		    		while(true) {
		    			if(isRanged(ny, cur.x)) {
		    				if(arr[ny][cur.y] != 0) {
		    					return new Point(ny, cur.x);
		    				}else {
		    					ny--;
		    				}
		    			}else {
		    				return new Point(0, cur.x);
		    			}
		    		}
		    	}
	    	}
	    	return cur;
	    }
	    public boolean isRanged(int y, int x) {
	    	if(y < 0 || y > 3 || x < 0 || x > 3) return false;
	    	return true;
	    }
	    class Point{
	    	int x;
	    	int y;
	    	int card = 0;
	    	public Point(int y , int x) {
	    		this.y = y;
	    		this.x = x;
	    	}
	    }
	}

}
