package programmers;
/*
 �������� ������ ���� �����Ѵ�.
���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
��ü ���������� ���� N, ������ �̿��ϴ� ����ڰ� ���� �����ִ� ���������� ��ȣ�� ��� �迭 stages�� �Ű������� �־��� ��, 
�������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� �迭�� return �ϵ��� solution �Լ��� �ϼ��϶�.
[���ѻ���]
���������� ���� N�� 1 �̻� 500 ������ �ڿ����̴�.
stages�� ���̴� 1 �̻� 200,000 �����̴�.
stages���� 1 �̻� N + 1 ������ �ڿ����� ����ִ�.
�� �ڿ����� ����ڰ� ���� ���� ���� ���������� ��ȣ�� ��Ÿ����.
��, N + 1 �� ������ ��������(N ��° ��������) ���� Ŭ���� �� ����ڸ� ��Ÿ����.
���� �������� ���� ���������� �ִٸ� ���� ��ȣ�� ���������� ���� ������ �ϸ� �ȴ�.
���������� ������ ������ ���� ��� �ش� ���������� �������� 0 ���� �����Ѵ�.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

//���ٹ�  , DP 
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
        		//do nothing cnt�� �����Ǿ����
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
	//���ĵ� stages�� �Ųٷ� �о  N���� ���� ū ���� ã�´�
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
