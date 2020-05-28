package algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//dijkstra algorithm  priority queue
//https://jaesungbong.tistory.com/26
//여러 다른 유형들에 응용할 수 있으려면 머릿속에 기억해야한다. 툭 치면 좔좔 나올 정도로.
//전체적인 흐름의 그림과 함께 머릿속에 넣어두자.
public class Dijkstra {

	static int INF = Integer.MAX_VALUE;
    static int[] dist;// 시작 정점에서 목적 정점까지의 거리
    static boolean[] visit;// 정점을 방문했나 안했나
 
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
         
        int V = sc.nextInt();// 정점의 개수
        int E = sc.nextInt();// 간선의 개수
        int K = sc.nextInt();// 시작 정점의 번호
         
        dist =new int[V +1];// 시작 정점으로부터 목적 정점까지의 최소 거리
        visit =new boolean[V +1];// 방문 했나 안했나
                 
        // 각 정점의 연결된 간선을 저장
        ArrayList<Edge>[] a = (ArrayList<Edge>[])new ArrayList[V +1];
        for (int i =1; i <= V; i++) {
            dist[i] = INF;// 모든 정점은 일단 무한
            a[i] =new ArrayList<Edge>();
        }
        dist[K] =0;// 시작정점과 시작정점의 거리는 0
         
        for (int i =0; i < E; i++) {
            int u = sc.nextInt();// 간선의 시작
            int v = sc.nextInt();// 간선의 끝
            int w = sc.nextInt();// 가중치
            a[u].add(new Edge(v, w));
        }
        sc.close();
        PriorityQueue<Edge> pq =new PriorityQueue<Edge>();// 우선순위 큐
        pq.offer(new Edge(K,0));//시작 정점을 우선순위 큐에 넣음.
 
        while (!pq.isEmpty()) {
            Edge e = pq.poll();// 큐에 들어있는 간선중 가장 가중치가 낮은 것 찾음.
            if (visit[e.dest] ==true) {
                continue;
            }
            visit[e.dest] =true;
            for (Edge k : a[e.dest]) {
            	//이미 방문한 것들은 무시 
                if (visit[k.dest] ==false) {
                	//핵심이 되는 점화식이라 할 수 있겠다.
                    dist[k.dest] = Math.min(dist[k.dest], dist[e.dest] + k.weight);
                    //방문하지 않은 것들은 큐에 넣어준다.
                    pq.offer(new Edge(k.dest, dist[k.dest]));
                }
            }
        }
 
        for (int i =1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            }else {
                System.out.println(dist[i]);
            }
        }
        sc.close();


	}
    static class Edge implements Comparable<Edge>{
		int dest;// 간선의 목적지
	    int weight;// 간선의 가중치
	 
	    Edge(int dest,int weight) {
	        this.dest = dest;
	        this.weight = weight;
	    }
	 
	    @Override
	    public int compareTo(Edge o) {
	        return this.weight - o.weight;
	    }
	}

}
