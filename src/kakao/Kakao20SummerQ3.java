package kakao;

import java.util.HashMap;
import java.util.Map;

public class Kakao20SummerQ3 {

	public static void main(String[] args) {
		String[] a = {"XYZ","XYZ","XYZ"};
		solution(a);
	}
	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < gems.length ; i++) {
        	String str = gems[i];
        	if(!map.containsKey(str)) {
        		map.put(str, 1);
        	}
        }
        int min = Integer.MAX_VALUE;
        //보석 종류의 개수
        int size = map.size();
        for(int i = 0 ; i < gems.length ; i++) {
        	int cnt = 0;
        	HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);
        	for(int j = i ; j < gems.length ; j ++) {
        		String s = gems[j];
        		if(map2.get(s) == 1) {
        			cnt++;
        			map2.put(s, 2);
        			if(cnt == size) {
            			if(min > (j - i)) {
            				answer[0] = i+1;
            				answer[1] = j+1;
            				min = j-i;
            				break;
            			}
            		}
        		}	
        	}
        }
        
        return answer;
    }

}
