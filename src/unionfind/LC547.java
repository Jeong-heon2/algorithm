package unionfind;

public class LC547 {

	public static void main(String[] args) {
		int[][] arr = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		Solution s = new Solution();
		System.out.println(s.findCircleNum(arr));
	}
	static class Solution {
	    int[] parents = new int[200];
	    public int findCircleNum(int[][] M) {
	        int N = M.length;
	        for(int i = 0; i < parents.length ; i++){
	            parents[i] = i;
	        }
	        for(int i = 0 ; i < N ; i++){
	            for(int j = i+1 ; j < N ; j++){
	                if(M[i][j] == 1){
	                    union(i, j);
	                }
	            }
	        }
	        boolean[] visited = new boolean[N];
	        for(int i = 0 ; i < N ; i++){
	            visited[find(i)] = true;
	        }
	        int cnt = 0;
	        for(int i = 0 ; i < N ; i++){
	            if(visited[i]) cnt++ ;
	        }
	        return cnt;
	    }
	    private int find(int x){
	        if(parents[x] == x){
	            return x;
	        }else{
	            return parents[x] = find(parents[x]);
	        }
	    }
	    private void union(int x, int y){
	        x = find(x);
	        y = find(y);
	        if(x != y){
	        	if(y > x) {
	        		parents[y] = x;
	        	}else {
	        		parents[x] = y;
	        	}
	        }
	    }
	}

}
