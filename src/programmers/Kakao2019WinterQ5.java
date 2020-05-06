package programmers;
/*
 * 징검다리는 일렬로 놓여 있고 각 징검다리의 디딤돌에는 모두 숫자가 적혀 있으며 
 * 디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어듭니다.
디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며 
이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있습니다.
단, 다음으로 밟을 수 있는 디딤돌이 여러 개인 경우 무조건 가장 가까운 디딤돌로만 건너뛸 수 있습니다.

니니즈 친구들은 개울의 왼쪽에 있으며, 
개울의 오른쪽 건너편에 도착해야 징검다리를 건넌 것으로 인정합니다.
니니즈 친구들은 한 번에 한 명씩 징검다리를 건너야 하며, 
한 친구가 징검다리를 모두 건넌 후에 그 다음 친구가 건너기 시작합니다.

디딤돌에 적힌 숫자가 순서대로 담긴 배열 stones와 
한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 k가 매개변수로 주어질 때, 
최대 몇 명까지 징검다리를 건널 수 있는지 return 하도록 solution 함수를 완성해주세요.

[제한사항]
징검다리를 건너야 하는 니니즈 친구들의 수는 무제한 이라고 간주합니다.
stones 배열의 크기는 1 이상 200,000 이하입니다.
stones 배열 각 원소들의 값은 1 이상 200,000,000 이하인 자연수입니다.
k는 1 이상 stones의 길이 이하인 자연수입니다.
 * 
 */
//첫번째 접근 법 : 효율성을 고려해서  n시간에 해결하는 방법을 고민했다,,
//하나씩 꺼내 읽으면서 길이 k 인 구간의 총합이 최소값인 구간을 찾고
// 그 구간에서 최대값이 정답
public class Kakao2019WinterQ5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(int[] stones, int k) {
	        long minSum = 0; // 길이 k의 징검다리 총합값의 최소값
	        //초기값 세팅
	        int front = stones[0];// 길이 k의 징검다리 첫번째 값
	        int end = stones[k-1];// 길이 k의 징검다리 마지막 값
	        int minSumMax = 0; //최소 값 구간에서 최대값
	        for(int i = 0 ; i < k ; i ++){
	            minSum += stones[i];
	            minSumMax = Math.max(minSumMax,stones[i]);
	        }
	        for(int i = k ; i < stones.length ; i ++){
	            front = stones[i-k+1];
	            end = stones[i];
	            long sum = minSum + end - front;
	            if(minSum >= sum){//더 작은 값의 구간을 찾으면  갱신한다.
	                minSum = sum;
	                int max = 0;
	                for(int j = i ; j >= i-k+1 ; j --){
	                    max = Math.max(max,stones[j]);
	                }
	                minSumMax = Math.min(minSumMax,max);
	            }            
	        }
	        return minSumMax;
	    }
	}
	//결과  정확성 : 53.8   효율성 : 15.4  ,,,

}
