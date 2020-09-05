package kakao;
import java.util.*;
import java.util.Map.Entry;
public class Kakao2018BlindQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(String str1, String str2) {
	        int equals = 0;
	        int sum = 0;
	        HashMap<String, Integer> set1 = getSet(str1);
	        HashMap<String, Integer> set2 = getSet(str2);
	        if(set1.size() == 0 && set2.size()==0){
	            return 65536;
	        }
	        for(Entry<String, Integer> e : set1.entrySet()) {
				String key = e.getKey();
	            int v = e.getValue();
	            if(set2.containsKey(key)){
	                int v2 = set2.get(key);
	                equals += Math.min(v, v2);
	                sum += Math.max(v, v2);
	            }else{
	                sum += v;
	            }
			}
	        for(Entry<String, Integer> e : set2.entrySet()) {
				String key = e.getKey();
	            int v = e.getValue();
	            if(!set1.containsKey(key)) sum += v;
			}
	        double res = (double)equals/(double)sum;
	        
	        return (int)(res*65536);
	    }
	    //문자열 2개씩 끊어서 집합 만들기
	    public HashMap<String, Integer> getSet(String str){
	        HashMap<String, Integer> map = new HashMap<>();
	        for(int i = 0 ; i < str.length()-1 ; i++){
	            String s = str.substring(i, i+2).toLowerCase();
	            if(s.matches("^[a-zA-X]+$")){
	                if(map.containsKey(s)){
	                    int cnt = map.get(s);
	                    map.put(s, ++cnt);
	                }else{
	                    map.put(s, 1);
	                }
	            }
	        }
	        return map;
	    }
	}

}
