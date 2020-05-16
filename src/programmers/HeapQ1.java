package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을
 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
[제한 사항]
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 */

//처음 접근법 : 우선순위 큐 (최소 힙)
public class HeapQ1 {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[]{1,2},7));
	}
	public static int solution(int[] scoville, int K) {
		//최소힙을 만든다
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
				//뽑아서 섞기
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
					//pQ가 비었는데 poll하면 null이 반환되어서 예외가 일어날 것이다
					//이 경우는 스코빌을 K이상으로 만들어 줄 수 없는 경우이다.
					return -1;
				}
			}else break;
		}while(true);
		return count;
    }

}
