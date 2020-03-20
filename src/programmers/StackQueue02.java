package programmers;
import java.util.*;
public class StackQueue02 {

	public static void main(String[] args) {
		int[] arr = {10};
		
		int a = solution(100,100,arr);
		System.out.println(a);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int i = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(truck_weights[i]);
        int state = weight-truck_weights[i];
        i++;
        answer++;
        do{
        	if(i<truck_weights.length) {
        		if(state-truck_weights[i]>=0){
                    q.add(truck_weights[i]);
                    state = state - truck_weights[i];
                    i++;
                }
                else{
                    q.add(0);
                }
        	}
        	else {
        		q.add(0);
        	}
            if(state == weight) {
            	answer++;
            	break;
            }
            if(q.size() >= bridge_length){
                state = state + q.poll();
            }
            answer++;
        }while(true);
        return answer;
    }

}
