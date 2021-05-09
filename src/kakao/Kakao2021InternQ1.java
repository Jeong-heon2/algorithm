package kakao;

import java.util.HashMap;

public class Kakao2021InternQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = solution("123");
		System.out.println(a);
	}
	public static int solution(String s) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int size = s.length();
        for(int i = 0 ; i < size; i++){
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9') {
            	sb.append(ch);
            }
            else{
                ans.append(ch);
            }
            if(map.containsKey(sb.toString())){
                ans.append(String.valueOf(map.get(sb.toString())));
                sb.setLength(0);
            }
        }
        return Integer.parseInt(ans.toString());
    }

}
