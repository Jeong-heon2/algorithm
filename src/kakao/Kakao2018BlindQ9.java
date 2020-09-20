package kakao;

import java.util.ArrayList;
import java.util.HashMap;

public class Kakao2018BlindQ9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution("KAKAO");
	}
	static class Solution {
	    public int[] solution(String msg) {
	        int[] answer = {};
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        HashMap<String, Integer> map = new HashMap<>();
	        char c = 'A';
	        for(int i = 0 ; i < 26 ; i++){
	            map.put(String.valueOf((char)(c+i)), i+1);
	        }
	        while(true){
	            //사전에서 현재 입력과 일치하는 가장 긴 문자열 w 찾기
	            String w = "";
	            int idx = 0;
	            int i = 1;
	            for( ; i <= msg.length(); i++){
	                String str = msg.substring(0,i);
	                if(map.containsKey(str)){
	                    idx = map.get(str);
	                    w = str;
	                }else{
	                    break;
	                }
	            }
	            //w에 해당하는 사전의 색인 번호 출력 하고 입력에서 w 제거
	            list.add(idx);
	            msg = msg.substring(--i, msg.length());
	            //입력에서 처리되지 않은 다음 글자가 남아있지 않다면
	            if(msg.length() == 0){
	                break;
	            }else{
	                //남아 있다면  사전등록 
	                c = msg.charAt(0);
	                map.put(w+c, map.size() + 1);
	            }
	        }
	        int size = list.size();
	        answer = new int[size];
	        for(int i = 0 ; i < size ; i++){
	            answer[i] = list.get(i);
	        }
	        return answer;
	    }
	}
}
