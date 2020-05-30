package programmers;

import java.util.Stack;
/*
https://keepgoing0328.tistory.com/entry/���α׷��ӽ�-ū-��-�����-�ڹ�
��α׸� �����ߴ�. ���������� �̷� ������ ������ ���� ��ư� ��������.

 */
public class GreedyQ2_2 {

	public static void main(String[] args) {
		System.out.println(solution("4177252841",4));
	}
	public static String solution(String number, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < number.length() ; i++){
            int num = number.charAt(i) - '0';
            while(!st.empty() && k != 0 && num > st.peek()){
                st.pop();
                k--;
            }
            st.push(num);
        }
        if(k!=0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

}
