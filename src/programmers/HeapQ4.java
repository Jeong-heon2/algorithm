package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
/* 프로그래머스 이중우선순위 큐
이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.
이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

[제한사항]
operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
operations의 원소는 큐가 수행할 연산을 나타냅니다.
원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
 */
//접근 법 :  우선순위 큐 두개를 이용했다.
//근데 이렇게 푸는게 맞나?,,  힙을 실제로 구현하여 풀어야하나?
public class HeapQ4 {

	public static void main(String[] args) {
		//test case
		int[] result = solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	public static int[] solution(String[] operations) {
        //최소힙
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        //최대힙
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
            //{명령어, 숫자}
            //명령어
            String order = strArr[0];
            //숫자
            int num = Integer.parseInt(strArr[1]);
            if(order.equals("I")){
                pq.offer(num);
                rpq.offer(num);
            }else{
                //예외처리 : 큐 비어있는 경우 무시,  하나만 삭제
                try{
                    if(num == 1){//최대값 삭제
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
