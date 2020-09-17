package kakao;

public class Kakao2018BlindQ8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Solution {
	    public String solution(String m, String[] musicinfos) {
	        int n = musicinfos.length;
	        m = changeString(m);
	        String max_str = "";
	        int max_time = 0;
	        for(int i = 0 ; i < n; i++){
	            String[] info = musicinfos[i].split(",");
	            info[3] = changeString(info[3]);
	            int M = getMinutes(info[1]) - getMinutes(info[0]);
	            int len = info[3].length();
	            int a = M / len;
	            int b = M % len;
	            StringBuilder sb = new StringBuilder();
	            while(a-- >0){
	                sb.append(info[3]);
	            }
	            for(int j = 0 ; j < b ; j++){
	                sb.append(info[3].charAt(j));
	            }
	            String str = sb.toString();
	            if(str.matches(".*"+m+".*")) {
	                if(max_time < M){
	                    max_str = info[2];
	                    max_time = M;
	                }
	            }
	        }
	        if(max_time == 0){
	            return "(None)";
	        }else{
	            return max_str;
	        }
	        
	    }
	    public int getMinutes(String time){
	        String[] times = time.split(":");
	        int hour = Integer.parseInt(times[0])*60;
	        int min = Integer.parseInt(times[1]);
	        return hour + min;
	    }
	    public String changeString(String s){
	        s = s.replace("C#", "H");
	        s = s.replace("D#", "I");
	        s = s.replace("F#", "J");
	        s = s.replace("G#", "K");
	        s = s.replace("A#", "L");
	        return s;
	    }
	}

}
