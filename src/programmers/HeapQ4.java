package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
/* ���α׷��ӽ� ���߿켱���� ť
���� �켱���� ť�� ���� ������ �� �� �ִ� �ڷᱸ���� ���մϴ�.

��ɾ�	���� ž(����)
I ����	ť�� �־��� ���ڸ� �����մϴ�.
D 1	ť���� �ִ��� �����մϴ�.
D -1	ť���� �ּڰ��� �����մϴ�.
���� �켱���� ť�� �� ���� operations�� �Ű������� �־��� ��, ��� ������ ó���� �� ť�� ��������� [0,0] ������� ������ [�ִ�, �ּڰ�]�� return �ϵ��� solution �Լ��� �������ּ���.

[���ѻ���]
operations�� ���̰� 1 �̻� 1,000,000 ������ ���ڿ� �迭�Դϴ�.
operations�� ���Ҵ� ť�� ������ ������ ��Ÿ���ϴ�.
���Ҵ� ����ɾ� �����͡� �������� �־����ϴ�.- �ִ�/�ּڰ��� �����ϴ� ���꿡�� �ִ�/�ּڰ��� �� �̻��� ���, �ϳ��� �����մϴ�.
�� ť�� �����͸� �����϶�� ������ �־��� ���, �ش� ������ �����մϴ�.
 */
//���� �� :  �켱���� ť �ΰ��� �̿��ߴ�.
//�ٵ� �̷��� Ǫ�°� �³�?,,  ���� ������ �����Ͽ� Ǯ����ϳ�?
public class HeapQ4 {

	public static void main(String[] args) {
		//test case
		int[] result = solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	public static int[] solution(String[] operations) {
        //�ּ���
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        //�ִ���
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) return -1;
				else if(o1 == o2) return 0;
				else return 1;
			}
        });
        for(int i = 0 ; i < operations.length ; i++){
            String[] strArr = operations[i].split(" ");
            //{��ɾ�, ����}
            //��ɾ�
            String order = strArr[0];
            //����
            int num = Integer.parseInt(strArr[1]);
            if(order.equals("I")){
                pq.offer(num);
                rpq.offer(num);
            }else{
                //����ó�� : ť ����ִ� ��� ����,  �ϳ��� ����
                try{
                    if(num == 1){//�ִ밪 ����
                        int target = pq.peek();
                        pq.remove(target);
                        rpq.remove(target);
                    }else{
                        int target = rpq.peek();
                        pq.remove(target);
                        rpq.remove(target);
                    }
                }catch(Exception e){
                    //do nothing
                }
            }
        }
        try{
            int max = pq.poll();
            int min = rpq.poll();
            return new int[]{max,min};
        }catch(Exception e){
            return new int[]{0,0};
        }
    }

}
