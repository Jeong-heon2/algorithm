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
	            //�������� ���� �Է°� ��ġ�ϴ� ���� �� ���ڿ� w ã��
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
	            //w�� �ش��ϴ� ������ ���� ��ȣ ��� �ϰ� �Է¿��� w ����
	            list.add(idx);
	            msg = msg.substring(--i, msg.length());
	            //�Է¿��� ó������ ���� ���� ���ڰ� �������� �ʴٸ�
	            if(msg.length() == 0){
	                break;
	            }else{
	                //���� �ִٸ�  ������� 
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
