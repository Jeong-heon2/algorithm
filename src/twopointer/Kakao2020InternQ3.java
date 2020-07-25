package twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
카카오 2020 인턴십 보석 쇼핑
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
        //<보석이름, 현재 window에서 해당 보석의 개수 > 
        HashMap<String, Integer> hm = new HashMap<String,Integer>();
        //window에 해당 
        Queue<String> q = new LinkedList<>();
        int start = 0;
        //현재 window의 시작 지점 
        int start_window = 0;
        //조건을 만족하는 구간의 최소 사이즈 (갱신해나감)
        int len = Integer.MAX_VALUE;
        
        for(String str : gems) {
        	hs.add(str);
        }
        //보석 종류 개수 
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
