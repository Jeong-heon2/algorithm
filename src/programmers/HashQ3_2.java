package programmers;

import java.util.HashMap;
import java.util.Map;
/* 간단한 수학 공식으로 아주 효율적으로 풀 수 있었다.
참고 : https://programmers.co.kr/learn/questions/3685
가능한 모든 조합을 직접 구해서 계산할 필요가 없었다..
예를들어 머리:3, 얼굴:2, 옷:1 이라면 총 가능한 개수는
(3+1) * (2+1)*(1+1) -1 = 13
+1씩을 더한 것은 착용하지 않은 경우를 추가한 것 
마지막에 -1을 한것은 모든 부위를 입지 않은 경우를 뺀 것.
 */
public class HashQ3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}
	public static int solution(String[][] clothes) {
		int ans = 1;
		//<종류,<옷이름,visited>>
        Map<String,HashMap<String,Boolean>> map = new HashMap<>();
        for(int i = 0 ; i < clothes.length ; i++) {
        	String name = clothes[i][0];
        	String type = clothes[i][1];
        	if(map.containsKey(type)) {
        		//같은 옷 이름 없으니까 신경 x
        		map.get(type).put(name, false);
        	}else {
        		HashMap<String,Boolean> mp = new HashMap<>();
        		mp.put(name, false);
        		map.put(type, mp);
        	}
        }
        
        for(Map.Entry<String, HashMap<String,Boolean>> entry : map.entrySet()) {
        	ans *= (entry.getValue().size()+1);
        }
        return ans-1;
	}

}
