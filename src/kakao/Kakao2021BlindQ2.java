package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Kakao2021BlindQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    HashMap<String,Integer> map;
	    ArrayList<String> list;
	    int[] max;
	    public String[] solution(String[] orders, int[] course) {
	        list = new ArrayList<>();
	        map = new HashMap<>();
	        max = new int[course[course.length-1]+1];//max[i] = max[i]�� ��ǰ���� �� ���� ���� ������ ���� 
	        for(int i = 0 ; i < orders.length; i++){
	            //������ �� ������ ���ڿ��� ���ĺ� ������������ ���� 
	            String str = orders[i];
	            char[] arr = str.toCharArray();
	            Arrays.sort(arr);
	            int n = arr.length;
	            boolean[] visited = new boolean[n];
	            for(int j = 0 ; j < course.length; j++){
	                //course[j]�� �̱� 
	                combi(arr, visited, 0, n, course[j], course[j]);
	            }
	        }
	        for( Map.Entry<String, Integer> elem : map.entrySet() ){
	            int size = elem.getKey().length();
	            //���� ���� �ֹ��� ���ո� ����Ʈ�� �߰� 
	            if(elem.getValue() == max[size]){
	                list.add(elem.getKey());
	            }
	        }
	        int size = list.size();
	        String[] answer = new String[size];
	        for(int i = 0 ; i < size ; i++){
	            answer[i] = list.get(i);
	        }
	        Arrays.sort(answer);
	        return answer;
	    }
	    private void combi(char[] arr, boolean[] visited, int start, int n , int r, int len){
	        if(r == 0){
	            StringBuilder sb = new StringBuilder();
	            for(int i = 0 ; i < n ; i++){
	                if(visited[i]) sb.append(arr[i]);
	            }
	            String s = sb.toString();
	            if(map.containsKey(s)){
	                int cnt = map.get(s);
	                map.put(s, ++cnt);
	                //len�� ��ǰ ���� �� ���� ���� ������ ���� ã�� 
	                max[len] = Math.max(max[len], cnt);
	            }else{
	                map.put(s,1);
	            }
	        }else{
	            for(int i = start; i < n ; i++){
	                visited[i] = true;
	                combi(arr, visited, i+1, n , r-1,len);
	                visited[i] = false;
	            }
	        }
	    }
	}

}
