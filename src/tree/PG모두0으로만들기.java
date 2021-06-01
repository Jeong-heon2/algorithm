package tree;

import java.util.ArrayList;

public class PG모두0으로만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    ArrayList<Integer>[] arr;
	    boolean[] visited;
	    long ans;
	    long[] long_a;
	    public long solution(int[] a, int[][] edges) {
	        this.ans = 0;
	        this.arr = new ArrayList[a.length];
	        this.visited = new boolean[a.length];
	        long sum = 0;
	        this.long_a = new long[a.length];
	        for(int i = 0 ; i < a.length;  i++){
	            sum += a[i];
	            arr[i] = new ArrayList<>();
	            long_a[i] = a[i];
	        }
	        for(int i = 0 ; i < edges.length; i++){
	            arr[edges[i][0]].add(edges[i][1]);
	            arr[edges[i][1]].add(edges[i][0]);
	        }
	        if(sum != 0) return -1;
	        
	        dfs(0);
	        
	        return ans;
	    }
	    private long dfs(int n){
	        this.visited[n] = true;
	        for(int i = 0; i < arr[n].size(); i++){
	            int next = arr[n].get(i);
	            if(!visited[next]){
	                long_a[n] += dfs(next);
	            }
	        }
	        this.ans += Math.abs(long_a[n]);
	        return long_a[n];
	    }
	}

}
