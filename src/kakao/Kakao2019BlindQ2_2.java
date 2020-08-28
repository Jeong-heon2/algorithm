package kakao;

import java.util.Arrays;

import utils.ArrayInputConvert;

public class Kakao2019BlindQ2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = ArrayInputConvert.convertInput("[4,4,4,4,4]");
		System.out.println(str);
		int[] stages = {4,4,4,4,4};
		int[] res = s.solution(4, stages);
		for(int i = 0 ; i < res.length ; i++) {
			System.out.println(res[i]);
		}
 	}
	static class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        Stage[] stage_arr = new Stage[N];
	        for(int i = 0 ; i < N ; i++) {
	        	stage_arr[i] = new Stage(0, 0, i+1);
	        }
	        for(int i = 0 ; i < stages.length ; i++) {
	        	counting(stage_arr, stages[i], N);
	        }
	        Arrays.sort(stage_arr);
	        for(int i = 0 ; i < N ; i ++) {
	        	answer[i] = stage_arr[i].num;
	        }
	        return answer;
	    }
	    public void counting(Stage[] stage_arr, int val, int n) {
	    	if(val > n) {
	    		stage_arr[n-1].clear_players++;
	    		val = n-1;
	    	}else {
	    		stage_arr[--val].in_players++;
	    	}
	    	for(int i = val - 1 ; i >= 0 ; i--) {
	    		stage_arr[i].clear_players++;
	    	}
	    }
	    class Stage implements Comparable<Stage>{
			int in_players;
			int clear_players;
			int num;
			public Stage(int in, int clear, int n) {
				this.in_players = in;
				this.clear_players = clear;
				this.num = n;
			}
			public double getFailPercent() {
				if(in_players + clear_players == 0) {
					return 0;
				}
				return (double)in_players/(in_players+clear_players);
			}
			@Override
			public int compareTo(Stage o) {
				double result = this.getFailPercent() - o.getFailPercent();
				if(result > 0) return -1;
				else if(result == 0) {
					return this.num - o.num;
				}else {
					return 1;
				}
			}
			
		}
	}
	

}
