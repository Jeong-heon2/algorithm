package binarysearch;
import java.util.*;
//���α׷��ӽ� ¡�˴ٸ� 
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
	        int cnt = 0;//���ŵ� ���� ���� 
	        int pre = 0;
	        int j = 0;
	        //mid ���� ���� ������ ������  ���� ���� 
	        while(j < rocks.length){
	        	//������ mid���� ������ rocks[j]�� ���� . 
	            if(rocks[j]-pre < mid){
	                cnt++;
	            }else{
	                pre = rocks[j];
	            }
	            j++;
	        }
	        //������ ������ ������ Ȯ�� 
	        if(d - pre < mid) cnt++;
	        return cnt;
	    }
	}

}
