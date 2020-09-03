package kakao;

import utils.ArrayInputConvert;

public class Kakao2018BlindQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ArrayInputConvert.convertInput("[\"2016-09-15 20:59:57.421 0.351s\", \"2016-09-15 20:59:58.233 1.181s\", \"2016-09-15 20:59:58.299 0.8s\", \"2016-09-15 20:59:58.688 1.041s\", \"2016-09-15 20:59:59.591 1.412s\", \"2016-09-15 21:00:00.464 1.466s\", \"2016-09-15 21:00:00.741 1.581s\", \"2016-09-15 21:00:00.748 2.31s\", \"2016-09-15 21:00:00.966 0.381s\", \"2016-09-15 21:00:02.066 2.62s\"]");
		System.out.println(s);
		String[] input = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
			
		Solution sl = new Solution();
		sl.solution(input);
	}
	static class Solution {
	    public int solution(String[] lines) {
	        int answer = 0;
	        //lines 앞에서 부터 읽어서
	        //lines[i] 끝나는 시간을 포함시켜서  ~ 1초 간에 처리량을 구한다.
	        //lines[i+1] 끝나는 시간 ~ 1초 간의 처리량을 구한다. 
	        //... lines[N-1] 까지 반복
	        //처리량은 log의 end ~ 1초 간격에  start 시간이 포함되는 log들을 count 
	        int N = lines.length;
	        Log[] logs = new Log[N];
	        for(int i = 0 ; i < N; i++){
	            logs[i] = new Log(lines[i]);
	        }
	        for(int i = 0 ; i < N ; i++){
	            long end = logs[i].end + 1000;
	            int cnt = 1;
	            for(int j = i + 1; j < N ; j++){
	                if(logs[j].start < end){
	                    cnt++;
	                }
	            }
	            answer = Math.max(answer, cnt);
	        }
	        return answer;
	    }
	    class Log {
	        long start;
	        long end;
	        public Log(String line){
	            String s = line.substring(11, 23);
	            s = s.replace(":", "");
	            s = s.replace(".", "");
	            long hour_to_millis = Long.parseLong(s.substring(0,2))*3600000;
	            long minutes_to_millis = Long.parseLong(s.substring(2,4))*60000;
	            long seconds_to_millis = Long.parseLong(s.substring(4,6))*1000;
	            long millis = Long.parseLong(s.substring(6));
	            this.end = hour_to_millis + minutes_to_millis + seconds_to_millis + millis;
	            
	            String e = line.substring(24);
	            e = e.replace(".", "");
	            e = e.replace("s", "");
	            while(e.length() != 4){
	                e += "0";
	            }
	            int interval = Integer.parseInt(e);
	            this.start = end - (long)interval + 1;
	        }
	    }
	}

}
