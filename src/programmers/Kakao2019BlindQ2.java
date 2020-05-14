package programmers;
/*
 실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
[제한사항]
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages의 길이는 1 이상 200,000 이하이다.
stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

//접근법  , DP 
public class Kakao2019BlindQ2 {

	public static void main(String[] args) {
		int[] stages = 	{2, 1, 2, 6, 2, 4, 3, 3};
		int N = 5;
		int[] result = solution(N,stages);
		for(int i : result) System.out.println(i);

	}
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Map.Entry<Integer, Double>> pq = new PriorityQueue<>( new Comparator<Map.Entry<Integer,Double>>() {
			@Override
			public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
				if(o1.getValue() < o2.getValue()) return 1;
				else if(o1.getValue().doubleValue() == o2.getValue().doubleValue()) {
					return o1.getKey() >= o2.getKey() ? 1 : -1;
				}
				else {
					return -1;
				}
			}
        });
        Map<Integer,Double> failMap = new HashMap<>();
        for(int i = 1 ; i <= N ; i++) {
        	failMap.put(i, 0.0);
        }
        Arrays.sort(stages);
        
        int checkStage = setCheckStage(stages,N);
        if(checkStage == N+1) {
        	for(int i = 0 ; i < answer.length ; i ++) {
        		answer[i] = i+1;
        	}
        	return answer;
        }
        int cnt = 0;
        int stageCnt = 0;
        for(int i = stages.length-1 ; i >= 0 ; i--) {
        	int currStage = stages[i];
        	cnt++;
        	if(currStage > N) {
        		//do nothing cnt만 증가되어야함
        	}else if(currStage == checkStage) {
        		stageCnt++;
        	}else if(currStage<checkStage) {
        		failMap.put(checkStage, getFail((double)stageCnt,(double)(cnt-1))); 
        		checkStage = currStage;
        		stageCnt = 1;
        	}
        	if(i == 0) {
        		failMap.put(checkStage, getFail((double)stageCnt,(double)(cnt-1)));
        	}
        }
        Set<Map.Entry<Integer, Double>> entries = failMap.entrySet();
        for(Map.Entry<Integer, Double> entry : entries) {
        	pq.offer(entry);
        }
        for(int i = 0 ; i < answer.length ; i ++) {
        	answer[i] = pq.poll().getKey();
        }
        
        return answer;
    }
	//정렬된 stages를 거꾸로 읽어서  N이하 가장 큰 값을 찾는다
	public static int setCheckStage(int[] stages,int N) {
		for(int i = stages.length-1 ; i >= 0 ; i--) {
			if(stages[i] <= N) return stages[i];
		}
		return N+1;
	}
	public static double getFail(double nonClear , double players) {
		return nonClear/players;
	}

}
