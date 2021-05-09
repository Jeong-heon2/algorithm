package kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QKakao2021InternQ4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        Node[] arr = new Node[n+1];
        
        for(int i = 1 ; i <= n ; i++) {
        	arr[i] = new Node(i);
        }
        for(int i = 0 ; i< traps.length ; i++) {
        	arr[traps[i]].isTrap = true;
        }
        
        for(int i = 0 ; i <roads.length ; i++) {
        	int s = roads[i][0];
        	int d = roads[i][1];
        	int w = roads[i][2];
        	arr[s].outEdges.add(new Edge(s,d,w));
        	arr[d].inEdges.add(new Edge(s,d,w));
        }
        bfs(arr, start, end, n, traps);
        return answer;
    }
	//트랩은 2번 방문 까지 허용 
    private static void bfs(Node[] arr, int start, int end, int n, int[] traps) {
    	int[] visited = new int[n];
    	Queue<Node> q = new LinkedList<>();
    	q.offer(arr[start]);
    	int min = Integer.MAX_VALUE;
    	while(!q.isEmpty()) {
    		int qSize = q.size();
    		while(qSize-- > 0) {
    			Node cur = q.poll();
        		//cur노드의 모든 outEdges 
        		if(cur.isTrap) {
        			visited[cur.n] ++;
        			if(cur.state) {
        				cur.state = false;
            			for(Edge next : cur.inEdges) {
                			//inEdges의 source가 다음 목적지 
            				if(arr[next.s].isTrap) {
            					if(visited[next.s] < 2) {
            						q.offer(arr[next.s]);
                					visited[next.s]++;
            					}
            				}else {
            					if(visited[next.s] < 1) {
                					q.offer(arr[next.s]);
                					visited[next.s]++;
                				}
            				}
            				
                		}
        			}else {
        				cur.state = true;
        				for(Edge next : cur.outEdges) {
                			//outEdges의 dest가 다음 목적지 
        					if(arr[next.d].isTrap) {
            					if(visited[next.d] < 2) {
            						q.offer(arr[next.d]);
                					visited[next.d]++;
            					}
            				}else {
            					if(visited[next.d] < 1) {
                					q.offer(arr[next.d]);
                					visited[next.d]++;
                				}
            				}
                		}
        			}
        		}
        		if(!cur.isTrap && visited[cur.n] < 1) {
        			for(Edge next : cur.outEdges) {
            			//다음 노드가 
        				if(visited[next.d] < 1) {
        					q.offer(arr[next.d]);
        					visited[next.d]++;
        				}
        				
            		}
        		}
    		}
    		
    		
    	}
    	
    }
    static class Node{
    	ArrayList<Edge> inEdges = new ArrayList<>();
    	ArrayList<Edge> outEdges = new ArrayList<>();
    	boolean isTrap = false;
    	boolean state = true;;//state 이 false면 outEdge가 inEdge 됨 
    	int n;
    	Node(int n ){
    		this.n = n;
    	}
    }
    static class Edge{
    	int s;
    	int d;
    	int w;
    	public Edge(int s, int d, int w) {
    		this.s = s;
    		this.d = d;
    		this.w = w;
    	}
    }

}
