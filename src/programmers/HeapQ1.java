package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
�ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. 
��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������
 �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.

���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��,
 ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
[���� ����]
scoville�� ���̴� 2 �̻� 1,000,000 �����Դϴ�.
K�� 0 �̻� 1,000,000,000 �����Դϴ�.
scoville�� ���Ҵ� ���� 0 �̻� 1,000,000 �����Դϴ�.
��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return �մϴ�.
 */

//ó�� ���ٹ� : �켱���� ť (�ּ� ��)
public class HeapQ1 {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[]{1,2},7));
	}
	public static int solution(int[] scoville, int K) {
		//�ּ����� �����
		PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (Integer)o1 > (Integer)o2 ? 1 : -1;
			}
		});
		
		int size = scoville.length;
		for(int i = 0 ; i < size ; i ++) {
			pQ.offer(scoville[i]);
		}
		int count = 0;
		do {
			int curr = pQ.peek();
			if(curr < K ) {
				//�̾Ƽ� ����
				try {
					int food1 = pQ.poll();
					int food2 = pQ.poll();
					if(food1 > food2) {
						pQ.offer(food2 + (food1*2));
					}else {
						pQ.offer(food1 + (food2*2));
					}
					count++;
				}catch(Exception e) {
					//pQ�� ����µ� poll�ϸ� null�� ��ȯ�Ǿ ���ܰ� �Ͼ ���̴�
					//�� ���� ���ں��� K�̻����� ����� �� �� ���� ����̴�.
					return -1;
				}
			}else break;
		}while(true);
		return count;
    }

}
