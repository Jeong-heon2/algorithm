package quiz;

import java.util.ArrayList;

public class Line2021����Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public int[] solution(int endingTime, int[][] jobs) {
	        ArrayList<Integer> list = new ArrayList<>();
	        //jobs ó�� ���� ������ �ùķ��̼� 
	        int curTime = 0;
	        for(int i = 0 ; i < jobs.length; i++){
	            int tmp = curTime;
	            if(curTime < jobs[i][1]) curTime = jobs[i][1];
	            if(curTime < jobs[i][2]){
	                //curTime�� valid time���� ������ �ϴ� ����� 
	                curTime += jobs[i][3];
	                if(curTime < jobs[i][2] && curTime < endingTime){
	                    list.add(jobs[i][0]);
	                }
	            }else{
	                curTime = tmp;
	            }
	        }
	        int len = list.size();
	        int[] answer = new int[len];
	        for(int i = 0 ; i < len; i++){
	            answer[i] = list.get(i);
	        }
	        return answer;
	    }
	}
}
