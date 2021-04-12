package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://bcp0109.tistory.com/entry/%EC%9C%84%EC%83%81%EC%A0%95%EB%A0%AC-Topological-Sort-Java
public class Topological {
	static int n;
    static int e;
    static int[] indegree;
    static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		n = 7; // 정점 갯수
        e = 9; // 간선 갯수
        indegree = new int[n + 1];
        arr = new ArrayList[n + 1];
        
        for (int i = 0; i < n + 1; i++)
            arr[i] = new ArrayList<>();

        // 간선 목록 v1 -> v2
        int[] v1 = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = {2, 3, 5, 6, 4, 7, 6, 4, 4};
        
        for(int i = 0 ; i < e ; i++) {
        	arr[v1[i]].add(v2[i]);
        	indegree[v2[i]]++;
        }
        topologicalSort();
	}
	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> resultQ = new LinkedList<>();
		for(int i = 1 ; i <= n ; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			resultQ.offer(cur);
			//node가 가리키는 node의 indegree값 감소시키기 
			for(int next : arr[cur]) {
				indegree[next]--;
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		System.out.println(resultQ);
	}
}
