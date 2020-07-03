package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/*
Jump Game III
Given an array of non-negative integers arr, 
you are initially positioned at start index of the array. 
When you are at index i, you can jump to i + arr[i] or i - arr[i], 
check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.
 */
//Á¢±Ù¹ý : bfs 
public class LC1306 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public boolean canReach(int[] arr, int start) {
	        Queue<Integer> q = new LinkedList<>();
	        q.offer(start);
	        boolean[] visited = new boolean[arr.length];
	        while(q.size() > 0){
	            int idx = q.poll();
	            if(arr[idx] == 0) return true;
	            visited[idx] = true;
	            int next_idx1 = idx + arr[idx];
	            int next_idx2 = idx - arr[idx];
	            if(isRanged(arr, next_idx1) && !visited[next_idx1]){
	                q.offer(next_idx1);
	            }
	            if(isRanged(arr, next_idx2) && !visited[next_idx2]){
	                q.offer(next_idx2);
	            }
	        }
	        return false;
	    }
	    public boolean isRanged(int[] arr, int idx){
	        if(idx >= 0 && idx < arr.length) return true;
	        else return false;
	    }
	}

}
