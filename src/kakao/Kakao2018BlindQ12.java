package kakao;

public class Kakao2018BlindQ12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(2, 4, 2, 1);
	}
	static class Solution {
	    public String solution(int n, int t, int m, int p) {
	        StringBuilder sb = new StringBuilder();
	        int num = 0;
	        while(sb.length() < t*m){
	            String str = getN_string(num, n);
	            sb.append(str);
	            num++;
	        }
	        String str = sb.toString();
	        sb = new StringBuilder();
	        int i = 0;
	        while(sb.length() != t){
	            sb.append(str.charAt(p + m*i++ - 1));
	        }
	        return sb.toString();
	    }
	    //10진수 -> n진법 string
	    public String getN_string(int num, int n){
	        int m = 0; //몫
	        int r = 0; //나머지 
	        String res = "";
	        if(num / n != 0){
	            m = num / n ;
	            r = num % n;
	            while(m != 0){
	                if(r >= 10){
	                    res = getAlphabet(r) + res;
	                }else{
	                    res = String.valueOf(r) + res;
	                }
	                r = m % n;
	                m = m / n;
	            }
	            if(r >= 10){
	                res = getAlphabet(r) + res;
	            }else{
	                res = String.valueOf(r) + res;
	            }
	        }else{
	            r = num % n ;
	            if(r >= 10){
	                res = getAlphabet(r);
	            }else{
	                res = String.valueOf(r);
	            }
	        }
	        return res;
	        
	    }
	    public String getAlphabet(int num){
	        switch(num){
	            case 10 :{
	                return "A";
	            }
	            case 11 : {
	                return "B";
	            }
	            case 12 :{
	                return "C";
	            }
	            case 13 : {
	                return "D";
	            }
	            case 14 :{
	                return "E";
	            }
	            case 15 :{
	                return "F";
	            }
	        }
	        return "";
	    }
	}

}
