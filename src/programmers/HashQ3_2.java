package programmers;

import java.util.HashMap;
import java.util.Map;
/* ������ ���� �������� ���� ȿ�������� Ǯ �� �־���.
���� : https://programmers.co.kr/learn/questions/3685
������ ��� ������ ���� ���ؼ� ����� �ʿ䰡 ������..
������� �Ӹ�:3, ��:2, ��:1 �̶�� �� ������ ������
(3+1) * (2+1)*(1+1) -1 = 13
+1���� ���� ���� �������� ���� ��츦 �߰��� �� 
�������� -1�� �Ѱ��� ��� ������ ���� ���� ��츦 �� ��.
 */
public class HashQ3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}
	public static int solution(String[][] clothes) {
		int ans = 1;
		//<����,<���̸�,visited>>
        Map<String,HashMap<String,Boolean>> map = new HashMap<>();
        for(int i = 0 ; i < clothes.length ; i++) {
        	String name = clothes[i][0];
        	String type = clothes[i][1];
        	if(map.containsKey(type)) {
        		//���� �� �̸� �����ϱ� �Ű� x
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
