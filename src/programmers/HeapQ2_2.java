package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//프로그래머스 라면공장
//접근법 : 우선순위 큐 (힙)
//참고 : https://lkhlkh23.tistory.com/113
//해외 공급을 할지 안 할지 판단하는 것이 중요한 게 아니었다.
//부족해지면 우선순위 큐에 넣어둔 밀가루를 공급해주면 되는 것이었다.
public class HeapQ2_2 {

	public static void main(String[] args) {

	}
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
 
        int index = 0;
        for (int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index])
            	//공급 받을 수 있는 날이 되면  우선순위 큐에 넣어둔다.
                priorityQueue.add(supplies[index++]);
 
            if(stock == 0) {
            	//재고가 떨어지면  큐에서  뽑아서 재고를 채운다.
                stock += priorityQueue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }

}
