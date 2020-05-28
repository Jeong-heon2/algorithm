package codingtestex;

import java.util.HashMap;
public class SumCo2020Q1 {

	public static void main(String[] args) {
		System.out.println(solution(9999));
	}
	public static int solution(int p) {
        int answer = p+1;
        do {
        	if(isRight(answer)) return answer;
        	else answer++;
        }while(true);
        
    }
	public static boolean isRight(int a) {
		String str = String.valueOf(a);
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			//Áßº¹ÀÌ ÀÕÀ¸¸é ¾ÈµÊ
			if(map.containsKey(ch)) return false;
			else map.put(ch, 0);
		}
		return true;
	}

}
