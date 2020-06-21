package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�躸�� 
�Է�]
ù° �ٿ� �赵 ���� ����� �� N, ���� ���� ����� �� M�� �־�����. 
�̾ ��° �ٺ��� N���� �ٿ� ���� �赵 ���� ����� �̸���, N+2° �ٺ��� ���� ���� ����� �̸��� ������� �־�����. �̸��� ���� ���� ���� �ҹ��ڷθ� �̷������, 
�� ���̴� 20 �����̴�. N, M�� 500,000 ������ �ڿ����̴�.

���]
�躸���� ���� �� ����� ���������� ����Ѵ�.
 */
public class Q1764 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//�赵���� �����
		int N = Integer.parseInt(st.nextToken());
		//�������� �����
		int M = Integer.parseInt(st.nextToken());
		//�赵���� ����� ���� 
		HashMap<String, Boolean> unKnowns = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			unKnowns.put(br.readLine(), true);
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i = 0 ; i < M ; i++) {
			String name = br.readLine();
			if(unKnowns.containsKey(name)) {
				pq.offer(name);
			}
		}
		System.out.println(pq.size());
		while(pq.size() > 0) {
			System.out.println(pq.poll());
		}
	}

}
