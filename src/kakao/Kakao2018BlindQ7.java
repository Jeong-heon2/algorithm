package kakao;

public class Kakao2018BlindQ7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution("1S2D*3T");
	}
	static class Solution {
	    
	    public int solution(String dartResult) {
	        int answer = 0;
	        int[] res = new int[3];
	        int len = dartResult.length();
	        int idx = 0;
	        boolean state = false;
	        for(int i = 0 ; i < len ; i++){
	            char cur = dartResult.charAt(i);
	            if(cur >= '0' && cur <= '9'){
	                if(state){
	                    idx++;
	                    state = false;
	                }
	                if(res[idx] != 0){
	                    res[idx] *= 10;
	                    res[idx] += Integer.valueOf(String.valueOf(cur));
	                }else{
	                    res[idx] = Integer.valueOf(String.valueOf(cur));
	                }
	            }else{
	                switch(cur){
	                    case 'S' : {
	                        break;
	                    }
	                    case 'D' : {
	                        int val = res[idx];
	                        res[idx] = val*val;
	                        break;
	                    }
	                    case 'T' : {
	                        int val = res[idx];
	                        res[idx] = val*val*val;
	                        break;
	                    }
	                    case '*' : {
	                        if(idx == 0){
	                            res[idx] *= 2;
	                        }else{
	                            res[idx-1] *= 2;
	                            res[idx] *= 2;
	                        }
	                        break;
	                    }
	                    case '#' : {
	                        res[idx] *= -1;
	                        break;
	                    }
	                }
	                state = true;
	            }
	        }
	        for(int i = 0 ; i < 3 ; i++){
	            answer += res[i];
	        }
	        return answer;
	    }
	}

}
