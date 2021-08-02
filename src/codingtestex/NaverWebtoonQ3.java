package codingtestex;

import java.util.LinkedList;
import java.util.Queue;

public class NaverWebtoonQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
		
	    public int solution(int[] m) {
	        return bfs(m);
	    }
	    private int bfs(int[] m) {
	    	Queue<Integer> q = new LinkedList<>();
	    	boolean[] visited = new boolean[m.length];
	    	q.offer(0);
	    	visited[0] = true;
	    	int target = m.length -1;
	    	int cnt = 0;//주사위 굴린 횟수 
	    	while(!q.isEmpty()) {
	    		int qSize = q.size();
	    		if(qSize > 0) cnt++;
	    		while(qSize-- > 0) {
	    			int cur = q.poll();
		    		for(int i = 1; i <= 6 ; i++) {
		    			int next = cur + i;
		    			if(next >= target) return cnt;
		    			if(!visited[next]) {
		    				visited[next] = true;
		    				int n = m[next];
		    				boolean flag = true;//flag가 true면 next를 큐에 넣어라 
		    				while(n != 0) {
		    					next += n;
		    					if(next < 0) {
		    						next = 0;
		    						flag = false;
		    						break;
		    					}else if (next >= target) return cnt;
		    					else{
		    						if(visited[next]) {
			    						flag = false;
			    						break;
			    						//이미 방문 한 곳이면 더 갈 필요 없다. 큐에도 넣을 필요 없음 
			    					}
		    						visited[next] = true;
		    						n = m[next];
		    					}
		    				}
		    				if(flag) q.offer(next);
		    			}
		    			
		    		}
	    		}
	    		
	    	}
	    	return cnt;
	    }
	}
}
