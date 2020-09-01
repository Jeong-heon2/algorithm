package kakao;

import java.util.*;

public class Kakao2019BlindQ4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(int[] food_times, long k) {
	        Comparator<Food> comp_time = (a, b) -> {
	            return a.time - b.time;
	        };
	        Comparator<Food> comp_idx = (a, b) -> {
	            return a.idx - b.idx;
	        };
	        PriorityQueue<Food> pq_time = new PriorityQueue<>(comp_time);
	        PriorityQueue<Food> pq_idx = new PriorityQueue<>(comp_idx);
	        long total = 0;
	        for(int i = 0 ; i < food_times.length; i++){
	            pq_time.offer(new Food(food_times[i], i+1));
	            total += food_times[i];
	        }
	        if(total<=k) return -1;
	        
	        long cycle = food_times.length;
	        long prev = 0;
	        for(int i = 0 ; i < food_times.length ; i++){
	            Food food = pq_time.peek();
	            //k¿¡¼­ »©Áà¾ßÇÏ´Â °ª 
	            long minus = (food.time - prev) * cycle;
	            if(k >= minus){
	                pq_time.poll();
	                if(k == minus){
	                    pq_idx.addAll(pq_time);
	                    return pq_idx.poll().idx;
	                }else{
	                    prev = food.time;
	                    cycle--;
	                    k -= minus;   
	                }
	            }else{
	                pq_idx.addAll(pq_time);
	                long rm = k % cycle;
	                Food f = pq_idx.poll();
	                while(rm-- > 0){
	                    f = pq_idx.poll();
	                }
	                return f.idx;
	            }
	            
	        }
	        
	        return -1;
	    }
	    class Food{
	        int time;
	        int idx;
	        public Food(int time, int idx){
	            this.time = time;
	            this.idx = idx;
	        }
	    }
	}

}
