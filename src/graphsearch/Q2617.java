package graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 백준 2617 구슬찾
첫 줄은 구슬의 개수를 나타내는 정수 N(1 ≤ N ≤ 99)과 저울에 올려 본 쌍의 개수 M(1 ≤ M ≤ N(N-1)/2)이 주어진다.
그 다음 M 개의 줄은 각 줄마다 두 개의 구슬 번호가 주어지는데, 앞 번호의 구슬이 뒤 번호의 구슬보다 무겁다는 것을 뜻한다.
모양은 같으나, 무게가 모두 다른 N개의 구슬이 있다. N은 홀수이며, 구슬에는 번호가 1,2,...,N으로 붙어 있다. 
이 구슬 중에서 무게가 전체의 중간인 (무게 순서로 (N+1)/2번째) 구슬을 찾기 위해서 아래와 같은 일을 하려 한다.
첫 줄에 무게가 중간이 절대로 될 수 없는 구슬의 수를 출력 한다.
 */
//graph dfs : time over
public class Q2617 {

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
			//자기보다 가벼운 노드들의 개수
			int l_cnt = getLightCnt(node, 0, graph);
			//자기보다 무거운 노드들의 개수
			int h_cnt = getHeavyCnt(node, 0, graph);
			if(l_cnt > N/2 || h_cnt > N/2) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	private static int getLightCnt(Node node, int cnt, Node[] graph) {
		int size = node.lightList.size();
		if(size == 0) {
			return 0;
		}else {
			for(int i : node.lightList) {
				cnt += getLightCnt(graph[i], cnt, graph);
			}
			cnt += size;
			return cnt;
		}
	}
	private static int getHeavyCnt(Node node, int cnt, Node[] graph) {
		int size = node.heavyList.size();
		if(size == 0) {
			return 0;
		}else {
			for(int i : node.heavyList) {
				cnt += getHeavyCnt(graph[i], cnt, graph);
			}
			cnt += size;
			return cnt;
		}
	}
	//각 노드는 자기보다 무거운 노드 번호 리스트, 가벼운 노드 번호리스트를 가지고 있다.
	static class Node{
		ArrayList<Integer> lightList = new ArrayList<>();
		ArrayList<Integer> heavyList = new ArrayList<>();
	}

}
