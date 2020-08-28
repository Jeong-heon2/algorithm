package kakao;

public class Kakao2020BlindQ1_2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("aabbaccc"));

	}
	static class Solution {
	    public int solution(String s) {
	        int answer = s.length();
	        //1개 단위 압축 > 그냥 s의 길이
	        //2개 단위 압축 > s의 첫번쨰 부터 2개씩 묶어서 같은애들 묶어나간다
	        //묶을 때 마다 개수 카운팅 
	        //전체 길이구하기
	        //3개 단위 압축 > 같은 과정 
	        //...
	        //s/2개단위 압축 까지 반복 
	        for(int i = 1; i <= s.length() ; i++) {
	        	String str = compress(s, i);
	        	answer = Math.min(answer, str.length());
	        }
	        return answer;
	    }
	    private String compress(String s, int n) {
	    	//s의 시작점 부터 n개씩 확인 
	    	StringBuilder sb = new StringBuilder();
	    	int cnt = 1;
	    	int start = 0;
	    	int end = start + n;
	    	String prev = s.substring(start, n);
	    	for(start += n, end += n ; start < s.length() && end <= s.length() ; start += n, end += n) {
	    		String cur = s.substring(start, end);
	    		if(prev.equals(cur)) {
	    			cnt++;
	    		}else {
	    			if(cnt > 1) {
	    				sb.append(cnt);
	    			}
	    			cnt = 1;
	    			sb.append(prev);
	    		}
	    		prev = cur;
	    	}
	    	String last = "";
	    	if(start < s.length()) {
	    		last = s.substring(start);
	    	}
	    	if(cnt > 1) {
	    		sb.append(cnt);
	    	}
	    	sb.append(prev);
	    	sb.append(last);
	    	
	    	return sb.toString();
	    }
	}

}
