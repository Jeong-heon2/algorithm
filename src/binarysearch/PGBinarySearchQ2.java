package binarysearch;
import java.util.*;
//프로그래머스 징검다리 
public class PGBinarySearchQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Solution {
	    public int solution(int distance, int[] rocks, int n) {
	        int ans = distance;
	        Arrays.sort(rocks);
	        int l = 1;
	        int r = distance;
	        while(l < r){
	            int mid = (l+r)/2;
	            if(getRemoveRockCnt(mid, rocks, distance) <= n){
	                ans = mid;
	                l = mid+1;
	            }else{
	                r = mid;
	            }
	        }
	        return ans;
	    }
	    private int getRemoveRockCnt(int mid, int[] rocks, int d){
	        int cnt = 0;//제거된 돌의 개수 
	        int pre = 0;
	        int j = 0;
	        //mid 보다 작은 간격이 없도록  돌을 제거 
	        while(j < rocks.length){
	        	//간격이 mid보다 작으면 rocks[j]를 제거 . 
	            if(rocks[j]-pre < mid){
	                cnt++;
	            }else{
	                pre = rocks[j];
	            }
	            j++;
	        }
	        //마지막 도착지 돌까지 확인 
	        if(d - pre < mid) cnt++;
	        return cnt;
	    }
	}

}
