package twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
īī�� 2020 ���Ͻ� ���� ����
two pointer, hashmap, sliding window, q ,,
 */
public class Kakao2020InternQ3 {

	public static void main(String[] args) {
		int[] ans = solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMR", "SHP", "DIA"});
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
	public static int[] solution(String[] gems) {
        HashSet<String> hs = new HashSet<String>();
        //<�����̸�, ���� window���� �ش� ������ ���� > 
        HashMap<String, Integer> hm = new HashMap<String,Integer>();
        //window�� �ش� 
        Queue<String> q = new LinkedList<>();
        int start = 0;
        //���� window�� ���� ���� 
        int start_window = 0;
        //������ �����ϴ� ������ �ּ� ������ (�����س���)
        int len = Integer.MAX_VALUE;
        
        for(String str : gems) {
        	hs.add(str);
        }
        //���� ���� ���� 
        int size = hs.size();
        
        for(int i = 0 ; i < gems.length ; i++) {
        	String str = gems[i];
        	if(!hm.containsKey(str)) hm.put(str, 1);
        	else hm.put(str, hm.get(str) + 1);
        	q.add(str);
        	while(true) {
        		String front = q.peek();
        		if(hm.get(front) > 1) {
        			hm.put(front, hm.get(front) - 1);
        			q.poll();
        			start_window++;
        		}else {
        			break;
        		}
        	}
        	if(size == hm.size() && len > q.size()) {
        		start = start_window;
        		len = q.size();
        	}
        }
        return new int[] {start + 1, start + len};
    }

}
