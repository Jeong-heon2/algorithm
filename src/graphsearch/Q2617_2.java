package graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
//dfs �� visited�� �߰��ϰ� ���湮�Ҷ����� count�� �÷��ִ� ������ �����ϴϱ� ����ߴ�. 
public class Q2617_2 {
	public static void main(String[] args) throws IOException {
		int ans = 0;
		//�Է� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//������ ����
		int N = Integer.parseInt(st.nextToken());
		//���￡ �÷����� ���� ����
		int M = Integer.parseInt(st.nextToken());
		//�׷���  �迭�� �ε��� > ������ ��ȣ  
		Node[] graph = new Node[N+1];
		boolean[] visited = new boolean[N+1];
		//�迭 �ʱ�ȭ
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
		
		//�׷����� ���鼭 ����Ʈ�� ������ N/2 ���� ū ������ ã�´�  >  �� ������ �߰��� �� �� ����.
		for(int i = 1 ; i <= N ; i++) {
			Node node = graph[i];
			Arrays.fill(visited, false);
			//�ڱ⺸�� ������ ������ ����
			int l_cnt = getLightCnt(node, graph, visited, i);
			//�ڱ⺸�� ���ſ� ������ ����
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
	//�� ���� �ڱ⺸�� ���ſ� ��� ��ȣ ����Ʈ, ������ ��� ��ȣ����Ʈ�� ������ �ִ�.
	static class Node{
		ArrayList<Integer> lightList = new ArrayList<>();
		ArrayList<Integer> heavyList = new ArrayList<>();
	}

}
