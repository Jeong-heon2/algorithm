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
				//���ÿ� �����ִ� �͵��� ���δ�. 
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
				//�������� ��� 
				//���� ������ *,/ �� ������ ������  sb�� ���δ� 
				if(!stack.empty()) {
					char top = stack.pop();
					if(top == '*' || top == '/') {
						sb.append(top);
					}else {
						stack.push(top);
					}
				}
				//*,/�� ���ÿ� �ִ´� 
				//-,+ �� ������  ���ÿ� �ִ°� �� ���̰� ���ÿ� �ִ´� .
				if(ch == '+' || ch == '-') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				}
				stack.push(ch);
			}
			
		}
		//���ÿ� �����ִ� �͵��� ���δ�. 
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}
