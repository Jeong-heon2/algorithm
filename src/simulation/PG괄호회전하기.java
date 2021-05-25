package simulation;

import java.util.ArrayList;
import java.util.Stack;

public class PG괄호회전하기 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("([{)}]"));
	}
	static class Solution {
	    static ArrayList<Character> open = new ArrayList<>();
	    static ArrayList<Character> close = new ArrayList<>();
	    public int solution(String s) {
	        int answer = 0;
	        open.add('['); open.add('{'); open.add('(');
	        close.add(']'); close.add('}'); close.add(')');
	        int size = s.length();
	        if(check(s, size)) answer++;
	        for(int i = 1 ; i < size ; i++){
	            //회전
	            String rotateStr = s.substring(i, size) + s.substring(0, i);
	            if(check(rotateStr, size)) answer++;
	        }
	        return answer;
	    }
	    private static boolean check(String s, int size){
	        Stack<Character> stack = new Stack<>();
	        boolean flag = true;
	        for(int i= 0 ; i < size ; i++){
	            char ch = s.charAt(i);
	            if(open.contains(ch)){
	                //열린 괄호면 스택에 넣는다 
	                stack.push(ch);
	            }else{
	                //닫힌 괄호인데 스택에 아무것도 없으면 false 
	                if(stack.size() == 0) return false;
	                //마지막 열린 괄호와 같은 종류의 괄호인지 
	                else if(stack.peek() == open.get(close.indexOf(ch))) stack.pop();
	                else return false;
	            }
	        }
	        if(stack.size() == 0 ) return true;
	        return false;
	    }
	}
}
