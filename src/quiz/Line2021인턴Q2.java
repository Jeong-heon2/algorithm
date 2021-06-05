package quiz;

import java.util.ArrayList;

public class Line2021인턴Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public int[] solution(int endingTime, int[][] jobs) {
	        ArrayList<Integer> list = new ArrayList<>();
	        //jobs 처음 부터 꺼내서 시뮬레이션 
	        int curTime = 0;
	        for(int i = 0 ; i < jobs.length; i++){
	            int tmp = curTime;
	            if(curTime < jobs[i][1]) curTime = jobs[i][1];
	            if(curTime < jobs[i][2]){
	                //curTime이 valid time보다 작으면 일단 실행됨 
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
