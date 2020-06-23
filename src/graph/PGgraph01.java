package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
���� �� ���

����� ���� n, ������ ���� ������ ��� 2���� �迭 vertex�� �Ű������� �־��� ��, 
1�� ���κ��� ���� �ָ� ������ ��尡 �� �������� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���]
����� ���� n�� 2 �̻� 20,000 �����Դϴ�.
������ ������̸� �� 1�� �̻� 50,000�� ������ ������ �ֽ��ϴ�.
vertex �迭 �� �� [a, b]�� a�� ���� b�� ��� ���̿� ������ �ִٴ� �ǹ��Դϴ�.
 */
//bfs ���鼭 ������ ���忡 ť�� �߰��� ��� ������ ����. 
public class PGgraph01 {

	public static void main(String[] args) {

	}
	public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        ArrayList<Integer>[] arr = (ArrayList<Integer>[])new ArrayList[n+1];
        for(int i = 1 ; i <= n  ; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < edge.length ; i++){
            arr[edge[i][0]].add(edge[i][1]);
            arr[edge[i][1]].add(edge[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int round = 1;
        int cnt = 0;
        int ans = 0;
        dist[1] = -1;
        while(q.size() > 0){
            int qsize = q.size();
            cnt = 0;
            while(qsize-- > 0){
                int curr = q.poll();
                for(int e : arr[curr]){
                    if(dist[e] == 0){
                        dist[e] = round;
                        q.offer(e);
                        cnt++;
                    }
                }
            }
            if(cnt != 0)  ans = cnt;
            round++;
        }
        
        return ans;
    }

}
