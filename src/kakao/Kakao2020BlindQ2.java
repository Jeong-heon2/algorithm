package kakao;
//pseudo-code를 보고 조건에 맞게 정확하게 구현할 수 있는가?

public class Kakao2020BlindQ2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("()))((()"));

	}
	
	static class Solution {
	    public String solution(String p) {
	        String answer = makeCorrect(p);
	        return answer;
	    }
	    public String makeCorrect(String w) {
	    	if(w.length() == 0) return w;
	    	int divideIdx = getDivideIdx(w) + 1;
	    	String u = w.substring(0, divideIdx);
	    	String v = w.substring(divideIdx);
	    	if(isRightString(u)) {
	    		return u + makeCorrect(v);
	    	}else {
	    		String empty = "(" + makeCorrect(v) + ")";
	            u = u.substring(1,u.length()-1);
	            return empty + reverse(u);
	    	}
	    	
	    }
	    //u-v로 분리하는 idx를 반환하는  메서드 
	    public int getDivideIdx(String s) {
	    	//조건 : 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 한
	    	//조건 : v는 빈 문자열이 될 수 있습니다.
	    	//s를 앞에서 부터 읽어 가면서 열린 괄호인지 닫힌 괄호인지 체크하고
	    	//개수를 카운팅 
	    	//open 과 close가 같아지는 순간 리턴 
	    	int open = 0;
	    	int close = 0;
	    	for(int i = 0 ; i < s.length() ; i ++) {
	    		if(s.charAt(i) == '(') open ++;
	    		else close ++;
	    		if(open == close) return i;
	    	}
	    	return 0;
	    }
	    //올바른 문자열인지 체크하는 메서드
	    public boolean isRightString(String s) {
	    	int cnt = 0;
	        for(int i = 0 ; i < s.length(); i++){
	            if(s.charAt(i) == '(') cnt ++;
	            else cnt--;
	            if(cnt<0) return false;
	        }
	        return (cnt == 0) ;
	    }
	    //문자열 괄호방향을 뒤집는 메서드 
	    public String reverse(String s) {
	    	StringBuffer sb = new StringBuffer();
	        for(int i = 0 ; i < s.length() ; i++){
	            if(s.charAt(i) == ')') sb.append('(');
	            else sb.append(')');
	        }
	        return sb.toString();
	    }
	}
	
}
