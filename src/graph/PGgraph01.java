package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
가장 먼 노드

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 
1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

제한사항]
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
 */
//bfs 돌면서 마지막 라운드에 큐에 추가된 노드 개수가 정답. 
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
