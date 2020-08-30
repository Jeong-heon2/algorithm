package kakao;

import java.util.ArrayList;
import java.util.HashMap;

import utils.ArrayInputConvert;

//https://programmers.co.kr/learn/courses/30/lessons/42890
public class Kakao2019BlindQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ArrayInputConvert.convertInput("[[\"100\",\"ryan\",\"music\",\"2\"],[\"200\",\"apeach\",\"math\",\"2\"],[\"300\",\"tube\",\"computer\",\"3\"],[\"400\",\"con\",\"computer\",\"4\"],[\"500\",\"muzi\",\"music\",\"3\"],[\"600\",\"apeach\",\"music\",\"2\"]]");
		System.out.println(s);
		Solution sl = new Solution();
		/*
		 a,b,c
		 1,b,c
		 a,b,4
		 a,5,c
		 */
		String[][] arr = {{"a","1","4"},{"2","1","5"},{"a","2","4"}};
		
		System.out.println(sl.solution(arr));
	}
	static class Solution {
		ArrayList<Integer> keys;
		String[][] relation;
		int ans;
	    public int solution(String[][] relation) {
	        ans = 0;
	        keys = new ArrayList<>();
	        this.relation = relation;
	        //조합 >  컬럼 1개로만 이루어진 후보키 
	        //    >   2개로만 이루어진 후보키
	        //    >   . ...
	        //각 경우에서 유일성과 최소성을 체크하여 
	        //후보키 개수 ++ 
	        // 유일성 검사 : hashmap   is contain Key?
	        // 최소성 검사 : bitmask >> 0번 컬럼이 이미 후보키에 들어있으면 
	        //                    >> 0번과 조합되는 다른 후보키 후보들은 x  예를들어, 0,1  또는  0,2 
	        int n = relation[0].length; //column 개수 
	        int[] arr = new int[n];
	        for(int i = 0 ; i < n ; i++) {
	        	arr[i] = i;
	        }
 	        for(int i = 1; i <= n ; i++) {
	        	combi(arr, 0, 0, i, n);
	        }
	        return ans;
	    }
	    public void combi(int[] arr, int visited, int start, int r, int n) {
	    	if(r == 0) {
	    		//유일성 ,최소성 검사 
	    		if(checkUnique(visited) && checkMin(visited)) {
	    			keys.add(visited);
	    			ans++;
	    		}
	    		return;
	    	}
	    	for(int i = start ; i < n ; i++) {
	    		visited |= 1 << i;
	    		combi(arr, visited, i + 1 , r - 1, n);
	    		visited &= ~(1 << i);
	    	}
	    }
	    public boolean checkUnique(int visited) {
	    	//visited 에 true 인 idx >  체크할 column 
	    	//relation 에서  체크 
	    	ArrayList<Integer> columns = new ArrayList<>();
	    	int len = visited;
	    	for(int i = 0 ; len > 0 ; i ++, len = len/2) {
	    		if((visited & (1 << i)) != 0) {
	    			columns.add(i);
	    		}
	    	}
	    	HashMap<String, Boolean> map = new HashMap<>();
	    	for(int i = 0 ; i < relation.length ; i++) {
	    		StringBuilder sb = new StringBuilder();
	    		for(int j = 0 ; j < columns.size() ; j++) {
	    			sb.append(relation[i][columns.get(j)]);
	    		}
	    		if(map.containsKey(sb.toString())) {
	    			return false;
	    		}
	    		map.put(sb.toString(), true);
	    	}
	    	return true;
	    }
	    public boolean checkMin(int visited) {
	    	//key에서 하나씩 꺼내서 
	    	//visited랑 비교 하는 데  key의 모든 1 bit가 visited에도 1bit이면 즉 key가 visited에 부분집합이면 
	    	//후보에서 탈락 
	    	for(int k : keys) {
	    		int k_1bitLen = Integer.bitCount(k);
	    		int len = k;
	    		int cnt = 0;
	    		for(int i = 0 ; len > 0 ; i ++, len = len/2) {
	    			if((k & (1 << i)) != 0 && (visited & (1 << i)) != 0) {
	    				//k의 i 자리가 1비트고 visited의 i 자리도 1이면 
	    				cnt++;
	    			}
	    		}
	    		if(k_1bitLen == cnt) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	}
}
