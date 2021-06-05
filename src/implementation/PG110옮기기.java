package implementation;

import java.util.Stack;

public class PG110�ű�� {

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
	                
	                if(stack.size()>=2) {       //110�� ����ؼ� �̾���, ���� 110�� �� �̾Ƴ����� ��� ��ġ�� �ص� 110 �� ������ ����
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
	            
	            while(!stack.isEmpty()) {           //���� ���ڿ� �߿��� ���� ������ ���ں��� 1�� �̾����� �κ� idx�� ã��
	                if(!flag && stack.peek()=='1')
	                    idx--;
	                if(!flag && stack.peek()=='0')
	                    flag = true;
	                sb.insert(0, stack.pop());
	            }
	           
	            if(cnt>0) {
	                while(cnt>0) {
	                    sb.insert(idx, "110");    //1�� �����ϸ� idx�� 110�� ������ŭ �߰��ϰ� 0�� �ƿ� ���ٸ� ���ڿ� ���� �߰�
	                    idx += 3;
	                	cnt--;
	            	}
	                
	                
	                answer[i] = sb.toString();
	            }
	            
	            else
	                answer[i] = s[i];           //110�� �������� �ʴٸ� ���ڿ��� ������ 
	        }
	        
	        return answer;
	    }
	}

}
