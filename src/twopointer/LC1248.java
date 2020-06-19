package twopointer;

import java.util.LinkedList;

/*
Given an array of integers nums and an integer k. 
A subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.
 */
//인덱스로 개수를 구한다는 아디이어 
public class LC1248 {

	public static void main(String[] args) {
		numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,1,2,2}, 2);

	}
	public static int numberOfSubarrays(int[] nums, int k) {
		
		LinkedList<Integer> deq = new LinkedList();
		deq.add(-1);
		int res = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] % 2 == 1) deq.add(i);
		    if (deq.size() > k + 1) deq.pop();
		    if (deq.size() == k + 1) res += deq.get(1) - deq.get(0);
		}
		  
		return res;
	}

}
