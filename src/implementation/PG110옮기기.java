package implementation;

import java.util.Stack;

public class PG110옮기기 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] str = {"1110", "100111100", "0111111010"};
		s.solution(str);
	}

	static class Solution {
	    public static String[] solution(String[] s) {
	        String[] answer = new String[s.length];
	        StringBuilder sb;
	        
	        for(int i=0; i<s.length; i++) {
	            String str = s[i];
	            Stack<Character> stack = new Stack<>();
	            int cnt = 0;
	            
	            for(int j=0; j<str.length(); j++) { 
	                char z = str.charAt(j);
	                
	                if(stack.size()>=2) {       //110을 계속해서 뽑아줌, 먼제 110을 다 뽑아놓으면 어떻게 배치를 해도 110 더 나오진 않음
	                    char y = stack.pop();
	                    char x = stack.pop();
	                    
	                    if(x=='1' && y=='1' && z=='0') {
	                        cnt++;
	                        continue;
	                	}
	                    
	                    else {
	                        stack.push(x);
	                        stack.push(y);
	                        stack.push(z);
	                    }
	                }
	                
	                else
	                    stack.push(z);
	            }
	            
	            int idx = stack.size();
	            boolean flag = false;
	            sb = new StringBuilder();
	            
	            while(!stack.isEmpty()) {           //남은 문자열 중에서 제일 마지막 글자부터 1이 이어지는 부분 idx을 찾음
	                if(!flag && stack.peek()=='1')
	                    idx--;
	                if(!flag && stack.peek()=='0')
	                    flag = true;
	                sb.insert(0, stack.pop());
	            }
	           
	            if(cnt>0) {
	                while(cnt>0) {
	                    sb.insert(idx, "110");    //1이 존재하면 idx에 110을 갯수만큼 추가하고 0이 아예 없다면 문자열 끝에 추가
	                    idx += 3;
	                	cnt--;
	            	}
	                
	                
	                answer[i] = sb.toString();
	            }
	            
	            else
	                answer[i] = s[i];           //110이 존재하지 않다면 문자열은 변하지 
	        }
	        
	        return answer;
	    }
	}

}
