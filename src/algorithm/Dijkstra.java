package algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//dijkstra algorithm  priority queue
//https://jaesungbong.tistory.com/26
//���� �ٸ� �����鿡 ������ �� �������� �Ӹ��ӿ� ����ؾ��Ѵ�. �� ġ�� ���� ���� ������.
//��ü���� �帧�� �׸��� �Բ� �Ӹ��ӿ� �־����.
public class Dijkstra {

	static int INF = Integer.MAX_VALUE;
    static int[] dist;// ���� �������� ���� ���������� �Ÿ�
    static boolean[] visit;// ������ �湮�߳� ���߳�
 
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
         
        int V = sc.nextInt();// ������ ����
        int E = sc.nextInt();// ������ ����
        int K = sc.nextInt();// ���� ������ ��ȣ
         
        dist =new int[V +1];// ���� �������κ��� ���� ���������� �ּ� �Ÿ�
        visit =new boolean[V +1];// �湮 �߳� ���߳�
                 
        // �� ������ ����� ������ ����
        ArrayList<Edge>[] a = (ArrayList<Edge>[])new ArrayList[V +1];
        for (int i =1; i <= V; i++) {
            dist[i] = INF;// ��� ������ �ϴ� ����
            a[i] =new ArrayList<Edge>();
        }
        dist[K] =0;// ���������� ���������� �Ÿ��� 0
         
        for (int i =0; i < E; i++) {
            int u = sc.nextInt();// ������ ����
            int v = sc.nextInt();// ������ ��
            int w = sc.nextInt();// ����ġ
            a[u].add(new Edge(v, w));
        }
        sc.close();
        PriorityQueue<Edge> pq =new PriorityQueue<Edge>();// �켱���� ť
        pq.offer(new Edge(K,0));//���� ������ �켱���� ť�� ����.
 
        while (!pq.isEmpty()) {
            Edge e = pq.poll();// ť�� ����ִ� ������ ���� ����ġ�� ���� �� ã��.
            if (visit[e.dest] ==true) {
                continue;
            }
            visit[e.dest] =true;
            for (Edge k : a[e.dest]) {
            	//�̹� �湮�� �͵��� ���� 
                if (visit[k.dest] ==false) {
                	//�ٽ��� �Ǵ� ��ȭ���̶� �� �� �ְڴ�.
                    dist[k.dest] = Math.min(dist[k.dest], dist[e.dest] + k.weight);
                    //�湮���� ���� �͵��� ť�� �־��ش�.
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
		int dest;// ������ ������
	    int weight;// ������ ����ġ
	 
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
