package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//���α׷��ӽ� ������
//���ٹ� : �켱���� ť (��)
//���� : https://lkhlkh23.tistory.com/113
//�ؿ� ������ ���� �� ���� �Ǵ��ϴ� ���� �߿��� �� �ƴϾ���.
//���������� �켱���� ť�� �־�� �а��縦 �������ָ� �Ǵ� ���̾���.
public class HeapQ2_2 {

	public static void main(String[] args) {

	}
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
 
        int index = 0;
        for (int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index])
            	//���� ���� �� �ִ� ���� �Ǹ�  �켱���� ť�� �־�д�.
                priorityQueue.add(supplies[index++]);
 
            if(stock == 0) {
            	//��� ��������  ť����  �̾Ƽ� ��� ä���.
                stock += priorityQueue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }

}
