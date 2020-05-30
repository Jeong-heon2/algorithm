package graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
//dfs 에 visited를 추가하고 노드방문할때마다 count를 늘려주는 식으로 수정하니까 통과했다. 
public class Q2617_2 {
	public static void main(String[] args) throws IOException {
		int ans = 0;
		//입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//구슬의 개수
		int N = Integer.parseInt(st.nextToken());
		//저울에 올려보는 쌍의 개수
		int M = Integer.parseInt(st.nextToken());
		//그래프  배열의 인덱스 > 구슬의 번호  
		Node[] graph = new Node[N+1];
		boolean[] visited = new boolean[N+1];
		//배열 초기화
		for(int i = 1 ; i <= N ; i++) {
			graph[i] = new Node();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int heavy = Integer.parseInt(st.nextToken());
			int light = Integer.parseInt(st.nextToken());
			graph[heavy].lightList.add(light);
			graph[light].heavyList.add(heavy);
		}
		
		//그래프를 돌면서 리스트의 개수가 N/2 보다 큰 노드들을 찾는다  >  이 노드들은 중간이 될 수 없다.
		for(int i = 1 ; i <= N ; i++) {
			Node node = graph[i];
			Arrays.fill(visited, false);
			//자기보다 가벼운 노드들의 개수
			int l_cnt = getLightCnt(node, graph, visited, i);
			//자기보다 무거운 노드들의 개수
			Arrays.fill(visited, false);
			int h_cnt = getHeavyCnt(node, graph, visited, i);
			if(l_cnt > N/2 || h_cnt > N/2) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	private static int getLightCnt(Node node, Node[] graph, boolean[] visited, int curr) {
		visited[curr] = true;
        int cnt = 0;
        for(int i : node.lightList) {
				if(!visited[i]) {
                    cnt++;
					cnt += getLightCnt(graph[i], graph, visited, i);
				}
		}
		return cnt;
	}
	private static int getHeavyCnt(Node node,  Node[] graph, boolean[] visited, int curr) {
        int cnt = 0;
        visited[curr] = true;
        for(int i : node.heavyList) {
				if(!visited[i]) {
                    cnt++;
					cnt += getHeavyCnt(graph[i], graph, visited, i);
				}
		}
		return cnt;
	}
	//각 노드는 자기보다 무거운 노드 번호 리스트, 가벼운 노드 번호리스트를 가지고 있다.
	static class Node{
		ArrayList<Integer> lightList = new ArrayList<>();
		ArrayList<Integer> heavyList = new ArrayList<>();
	}

}
