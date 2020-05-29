package graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* ���� 2617 ����ã
ù ���� ������ ������ ��Ÿ���� ���� N(1 �� N �� 99)�� ���￡ �÷� �� ���� ���� M(1 �� M �� N(N-1)/2)�� �־�����.
�� ���� M ���� ���� �� �ٸ��� �� ���� ���� ��ȣ�� �־����µ�, �� ��ȣ�� ������ �� ��ȣ�� �������� ���̴ٴ� ���� ���Ѵ�.
����� ������, ���԰� ��� �ٸ� N���� ������ �ִ�. N�� Ȧ���̸�, �������� ��ȣ�� 1,2,...,N���� �پ� �ִ�. 
�� ���� �߿��� ���԰� ��ü�� �߰��� (���� ������ (N+1)/2��°) ������ ã�� ���ؼ� �Ʒ��� ���� ���� �Ϸ� �Ѵ�.
ù �ٿ� ���԰� �߰��� ����� �� �� ���� ������ ���� ��� �Ѵ�.
 */
//graph dfs : time over
public class Q2617 {

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
			//�ڱ⺸�� ������ ������ ����
			int l_cnt = getLightCnt(node, 0, graph);
			//�ڱ⺸�� ���ſ� ������ ����
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
	//�� ���� �ڱ⺸�� ���ſ� ��� ��ȣ ����Ʈ, ������ ��� ��ȣ����Ʈ�� ������ �ִ�.
	static class Node{
		ArrayList<Integer> lightList = new ArrayList<>();
		ArrayList<Integer> heavyList = new ArrayList<>();
	}

}
