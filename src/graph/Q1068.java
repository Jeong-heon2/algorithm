package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
�Է�]
ù° �ٿ� Ʈ���� ����� ���� N�� �־�����. 
N�� 50���� �۰ų� ���� �ڿ����̴�. ��° �ٿ��� 0�� ������ N-1�� ������, �� ����� �θ� �־�����. 
���� �θ� ���ٸ� (��Ʈ) -1�� �־�����. ��° �ٿ��� ���� ����� ��ȣ�� �־�����.

���]
ù° �ٿ� �Է����� �־��� Ʈ������ �Է����� �־��� ��带 ������ ��, ���� ����� ������ ����Ѵ�.
 */
//���ٹ� : bfs 
public class Q1068 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer>[] arr = (ArrayList<Integer>[])new ArrayList[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = new ArrayList<>();
		}
		//root node 
		int rootN = 0;
		for(int i = 0 ; i < N ; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(cur != -1) {
				arr[cur].add(i);
			}else {
				rootN = i;
			}
		}
		//bfs
		int ans = 0;
		arr[Integer.parseInt(br.readLine())] = null;
		Queue<Integer> q = new LinkedList<>();
		q.add(rootN);
		while(q.size() > 0) {
			int curr = q.poll();
			boolean check = true;
			//root�� �������� ��������.
			if(arr[curr] != null) {
				for(int next : arr[curr]) {
					if(arr[next] != null) {
						q.add(next);
						check = false;
					}
				}
				//�ڽ� ��带 ť�� �߰��������ߴ� > ���� ����. 
				if(check) ans++;
			}
		}
		System.out.println(ans);

	}
}
