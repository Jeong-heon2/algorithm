package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*�Է��� ���� ���� �׽�Ʈ ���̽��� �����Ǿ� �ִµ�, 
ù° �ٿ� �׽�Ʈ ���̽��� ���� K(2��K��5)�� �־�����.
�� �׽�Ʈ ���̽��� ù° �ٿ��� �׷����� ������ ���� V(1��V��20,000)�� 
������ ���� E(1��E��200,000)�� �� ĭ�� ���̿� �ΰ� ������� �־�����.
�� �������� 1���� V���� ���ʷ� ��ȣ�� �پ� �ִ�.
�̾ ��° �ٺ��� E���� �ٿ� ���� ������ ���� ������ �־����µ�, 
�� �ٿ� ������ �� ������ ��ȣ�� �� ĭ�� ���̿� �ΰ� �־�����.
K���� �ٿ� ���� �Է����� �־��� �׷����� �̺� �׷����̸� YES, �ƴϸ� NO�� ������� ����Ѵ�.*/
public class Q1707 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			for(int j = 0 ; j <= V; j++) {
				arr.add(new ArrayList<Integer>());
			}
			for(int j = 1; j <= E ; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st2.nextToken());
				arr.get(v1).add(v2);
				arr.get(v2).add(v1);
			}
		}
	}
	public static void BFS(ArrayList<ArrayList<Integer>> G, int start) {
		ArrayList<Boolean> isMarked = new ArrayList<>();
		for(int i = 0 ; i < G.size()+1 ; i++) {
			isMarked.add(false);
		}
		ArrayList<Boolean> isinQueue = new ArrayList<>();
		for(int i = 0 ; i < G.size()+1 ; i++) {
			isinQueue.add(false);
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		isinQueue.set(start, true);
		while(Q.size()>0) {
			
		}
	}

}
