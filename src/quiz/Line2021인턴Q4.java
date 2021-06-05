package quiz;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Line2021����Q4 {

	public static void main(String[] args) {
		int n = 4;
		int[][] queries = {{1,3}, {1,2}, {3,6}, {3,-1}, {4,5}, {2,-1}, {3,-1}, {1,-1}};
		Solution s = new Solution();
		int[] res = s.solution(n, queries);
		System.out.println(res[2]);

	}
	static class Solution {
	    int N;
	    Deque<Integer>[] dqs;
	    ArrayList<Integer> ansList;
	    public int[] solution(int n, int[][] queries) {
	        ansList = new ArrayList<>();
	        //n���� deque 
	        N = n;
	        dqs = new Deque[n+1];
	        for(int i = 1 ; i <= n ; i++){
	            dqs[i] = new ArrayDeque<>();
	        }
	        for(int i = 0 ; i < queries.length ; i++){
	            int[] query = queries[i];
	            if(query[1] > 0){
	                push(query[0], query[1]);
	            }else{
	                pop(query[0]);
	            }
	        }
	        int size = ansList.size();
	        int[] answer = new int[size];
	        for(int i = 0 ; i < size ; i++){
	            answer[i] = ansList.get(i);
	        }
	        return answer;
	    }
	    private void push(int i, int v){
	        //dqs�� ��ü�� ����ִ°� ? 
	        if(isEmpty()){
	            for(int j = 1 ; j <= N ; j++){
	                dqs[j].addFirst(v);
	            }
	        }else{
	            dqs[i].addLast(v);
	        }
	    }
	    private void pop(int i){
	        if(dqs[i].size() == 0) {
	            ansList.add(-1);
	            return;
	        }
	        int popVal = dqs[i].pollLast();
	        ansList.add(popVal);
	        //�߾� ������ ���ٸ� 
	        if(dqs[i].size() == 0){
	            //��� deq�� �߾� ���� ���� 
	            for(int j = 1 ; j <= N ; j++){
	                dqs[j].pollFirst();
	            }
	            //���� �ð�������� ����� �� ã�� (���Ұ� 1���̻� )
	            int k = i + 1;
	            while(true){
	                if(k > N){
	                    k = 1;
	                }
	                if(k == i){
	                    //�� ���� ���� i �� ���ƿ� 
	                    break;
	                }
	                if(dqs[k].size() > 0){
	                    //ã�� 
	                    //pollfirst�� ���ο� �߾� ���� ���� �ȴ�.
	                    int center = dqs[k].pollFirst();
	                    for(int j = 1 ; j <= N ; j++){
	                        dqs[j].addFirst(center);
	                    }
	                    break;
	                }else{
	                    k++;
	                }
	            }
	             
	        }
	    }
	    private boolean isEmpty(){
	        for(int i = 1 ; i <= N ; i++){
	            if(!dqs[i].isEmpty()) return false;
	        }
	        return true;
	    }
	}

}
