package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueue03 {

	public static void main(String[] args) {
		int[] answer = {};
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		answer = solution2(progresses,speeds);

	}
	public static int[] solution2(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> answers = new ArrayList<>();
        Queue<Dev> q = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; i++){
            q.add(new Dev(progresses[i],speeds[i]));
        }
        int days = 0;
        while(q.size()>0){
            Dev currDev = q.poll();
            int count = 1;
            currDev.progress = currDev.progress + currDev.speed*days;
            while(currDev.progress < 100){
                currDev.progress = currDev.progress + currDev.speed;
                days ++;
            }
            int qsize = q.size();
            if(qsize == 1){
                answers.add(count);
                break;
            }
            while(qsize-- >0){
                Dev nextDev = q.peek();
                int nextProgress = nextDev.progress;
                nextProgress = nextProgress + nextDev.speed*days;
                if(nextProgress<100){
                    break;
                }
                else{
                    q.poll();
                    count++;
                }
            }
            answers.add(count);
        }
        answer = new int[answers.size()];
        for(int i = 0 ; i < answer.length ; i ++){
            answer[i] = answers.get(i);
        }
        return answer;
    }
    static class Dev{
        public int progress;
        public int speed;
        public Dev(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
}
