package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
[문제 설명]
스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 
다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

종류	이름
얼굴	동그란 안경, 검정 선글라스
상의	파란색 티셔츠
하의	청바지
겉옷	긴 코트
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

[제한사항]
clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
같은 이름을 가진 의상은 존재하지 않습니다.
clothes의 모든 원소는 문자열로 이루어져 있습니다.
모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
스파이는 하루에 최소 한 개의 의상은 입습니다.
 */

//접근법 1 : 조합 + HashMap
//face , head 두 종류라면 , 
//face , head, face + head  로  조합
//각 경우에서  경우의 수를 구한다.  
public class HashQ3 {
	static int answer = 0;
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}
    public static int solution(String[][] clothes) {
        ArrayList<String> types = new ArrayList<>();
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
        		types.add(type);
        	}
        }
        int size = types.size();
        boolean[] visited = new boolean[size];
        for(int i = 1 ; i <= size ; i ++) {
        	combination(types, map, visited, 0, size, i);
        }
        return answer;
    }
	private static void combination(ArrayList<String> list, Map<String,HashMap<String,Boolean>> map, 
			boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        answer += calcul( list, map, visited, n );
	        return;
	    } 
	    for(int i = start; i<n; i++) {
	        visited[i] = true;
	        combination(list, map, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
    private static int calcul(ArrayList<String> list, Map<String,HashMap<String,Boolean>> map, boolean[] visited, int n) {
    	int res = 1;
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                res *= map.get(list.get(i)).size();
        }
        return res;
    }
}
//테스트 케이스 1번에서 시간초과 오류가 떴다. 코드가 비효율적인가 보다. 효율적인 방법을 찾자.
