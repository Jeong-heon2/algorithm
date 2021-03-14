package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1918 {
	static int idx;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		idx = 0;
		System.out.println(solve(str));
	}
	private static String solve(String str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(; idx < str.length(); idx++) {
			char ch = str.charAt(idx);
			if(ch ==')') {
				//스택에 남아있는 것들을 붙인다. 
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				return sb.toString();
			}
			if(ch >= 'A' && ch <= 'Z') {
				sb.append(ch);
			}else if(ch == '(') {
				idx++;
				String tmp = solve(str);
				sb.append(tmp);
				
			}else {
				//연산자인 경우 
				//스택 맨위에 *,/ 가 있으면 꺼내서  sb에 붙인다 
				if(!stack.empty()) {
					char top = stack.pop();
					if(top == '*' || top == '/') {
						sb.append(top);
					}else {
						stack.push(top);
					}
				}
				//*,/는 스택에 넣는다 
				//-,+ 가 나오면  스택에 있는걸 다 붙이고 스택에 넣는다 .
				if(ch == '+' || ch == '-') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				}
				stack.push(ch);
			}
			
		}
		//스택에 남아있는 것들을 붙인다. 
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}
