package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
[���� ����]
�����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.

���� ��� �����̰� ���� ���� �Ʒ��� ���� ���� �����̰� ���׶� �Ȱ�, �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� 
�������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.

����	�̸�
��	���׶� �Ȱ�, ���� ���۶�
����	�Ķ��� Ƽ����
����	û����
�ѿ�	�� ��Ʈ
�����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

[���ѻ���]
clothes�� �� ���� [�ǻ��� �̸�, �ǻ��� ����]�� �̷���� �ֽ��ϴ�.
�����̰� ���� �ǻ��� ���� 1�� �̻� 30�� �����Դϴ�.
���� �̸��� ���� �ǻ��� �������� �ʽ��ϴ�.
clothes�� ��� ���Ҵ� ���ڿ��� �̷���� �ֽ��ϴ�.
��� ���ڿ��� ���̴� 1 �̻� 20 ������ �ڿ����̰� ���ĺ� �ҹ��� �Ǵ� '_' �θ� �̷���� �ֽ��ϴ�.
�����̴� �Ϸ翡 �ּ� �� ���� �ǻ��� �Խ��ϴ�.
 */

//���ٹ� 1 : ���� + HashMap
//face , head �� ������� , 
//face , head, face + head  ��  ����
//�� ��쿡��  ����� ���� ���Ѵ�.  
public class HashQ3 {
	static int answer = 0;
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}
    public static int solution(String[][] clothes) {
        ArrayList<String> types = new ArrayList<>();
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
//�׽�Ʈ ���̽� 1������ �ð��ʰ� ������ ����. �ڵ尡 ��ȿ�����ΰ� ����. ȿ������ ����� ã��.
