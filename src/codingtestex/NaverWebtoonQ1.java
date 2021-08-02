package codingtestex;


public class NaverWebtoonQ1 {

	public static void main(String[] args) {
		
	}
	static class Solution {
		int ans;
	    public int solution(int[][] sizes) {
	        ans = Integer.MAX_VALUE;
	        for(int i = 0; i <= sizes.length ; i++) {
	        	boolean[] visited = new boolean[sizes.length];
	        	combination(sizes, visited, 0, sizes.length, i);
	        }
	        return ans;
	    }
	    private void combination(int[][] sizes, boolean[] visited, int start, int n , int r) {
	    	if(r == 0) {
	    		swap(visited, sizes);
	    		ans = Math.min(ans, getSize(sizes));
	    		swap(visited, sizes);//다시 원 상태로 
	    	}else {
	    		for(int i = start ; i < n ; i++) {
	    			visited[i] = true;
	    			combination(sizes, visited, i+1, n, r-1);
	    			visited[i] = false;
	    		}
	    	}
	    }
	    private int getSize(int[][] sizes) {
	    	//가로 max * 세로 max 값을 리턴 
	    	int max_h = 0;
	    	int max_w = 0;
	    	for(int i = 0 ; i < sizes.length; i++) {
	    		max_h = Math.max(max_h, sizes[i][0]);
	    		max_w = Math.max(max_w, sizes[i][1]);
	    	}
	    	return max_h * max_w;
	    }
	    private void swap(boolean[] visited, int[][] sizes) {
	    	//선택된 명함만 회전 
    		for(int i = 0 ; i < sizes.length ; i++) {
    			if(visited[i]) {
    				int tmp = sizes[i][0];
    				sizes[i][0] = sizes[i][1];
    				sizes[i][1] = tmp;
    			}
    		}
	    }
	    
	}
}
