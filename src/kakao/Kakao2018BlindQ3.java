package kakao;
import java.util.*;

import utils.ArrayInputConvert;
public class Kakao2018BlindQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ArrayInputConvert.convertInput("[\"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\"]"));
		String[] tables = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		Solution sl = new Solution();
		sl.solution(10, 60, 45, tables);
	}
	
	static class Solution {
	    public String solution(int n, int t, int m, String[] timetable) {
	        Bus[] buses = new Bus[n];
	        Arrays.sort(timetable, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
	                int s1_times = Integer.parseInt(s1.substring(0,2))*60 + Integer.parseInt(s1.substring(3));
	                int s2_times = Integer.parseInt(s2.substring(0,2))*60 + Integer.parseInt(s2.substring(3));
	                return s1_times - s2_times;
				}
			});
	        int arrival_time = 9*60 - t;
	        int idx = 0;
	        for(int i = 0; i < n ; i++){
	            arrival_time += t;
	            buses[i] = new Bus(arrival_time);
	            while(idx < timetable.length){
	                int crew = Integer.parseInt(timetable[idx].substring(0,2))*60 + Integer.parseInt(timetable[idx].substring(3));
	                if(crew <= arrival_time){
	                    buses[i].passengers.add(crew);
	                    idx++;
	                    if(buses[i].passengers.size() == m) break;
	                }else{
	                    break;
	                }
	            }
	        }
	        int last = buses[n-1].passengers.size();
	        if(last == m){
	            //buses[n-1]의 마지막 손님의 도착시간 -1분 
	            int ans = buses[n-1].passengers.get(last-1) - 1;
	            return getMinutesToString(ans);
	        }else{
	            //buses[n-1]의 도착시간 
	            int ans = buses[n-1].arrival;
	            return getMinutesToString(ans);
	            
	        }
	    }
	    public String getMinutesToString(int ans){
	        int hour = ans / 60;
	        int minutes = ans % 60;
	        String s_hour = String.valueOf(hour);
	        String s_minutes = String.valueOf(minutes);
	        if(s_hour.length() == 1) s_hour = "0" + s_hour;
	        if(s_minutes.length() == 1) s_minutes = "0" + s_minutes;
	        return s_hour + ":" + s_minutes;
	        
	    }
	    class Bus{
	        int arrival;
	        ArrayList<Integer> passengers;
	        public Bus(int arrival){
	            this.arrival = arrival;
	            this.passengers = new ArrayList<>();
	        }
	    }
	}

}
