package codingtestex;

import java.util.HashMap;

public class N21_1 {

	public static void main(String[] args) {
		
	}
	//최고, 최저점에 속하고 유일하면 제외? 
	public int solve(int[][] arr) {
		int ans = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int min = Integer.MAX_VALUE;
			int max = 0;
			for(int j = 0 ; j < arr.length ; j++) {
				//arr[j][i] : i번 학생의 점수? 
				int score = arr[j][i];
				if(!map.containsKey(score)) {
					map.put(score, 1);
					min = Math.min(score, min);
					max = Math.max(score, max);
				}else {
					map.put(score, map.get(score)+1);
				}
			}
			if(arr[i][i] == min) {
				
			}
			if(arr[i][i] == max) {
				
			}
		}
		return ans;
	}
}
