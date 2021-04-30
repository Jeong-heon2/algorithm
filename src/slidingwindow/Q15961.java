package slidingwindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15961 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[d+1];
		int[] check = new int[d+1];//��ȣ�� ť�� � ����ִ��� 
		int[] arr = new int[N];
		for(int i = 0 ; i <N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Queue<int[]> q = new LinkedList<>();
		int ans = 0;
		int cnt = 0; //�ߺ� ���� 
		for(int i = 0 ; i < N + k; i++) {
			int cur = arr[i%N];
			if(!q.isEmpty() && i - q.peek()[0] >= k) {
				int[] out = q.poll();
				if(check[out[1]]>=2) {
					//�ߺ��ؼ� ����ִ� �� ���ٸ� ���� ���ϱ�  cnt -- 
					cnt--;
				}
				check[out[1]]--;
				if(check[out[1]] == 0) {
					visited[out[1]] = false;
				}
			}
			if(!visited[cur]) {
				visited[cur] = true;
			}else {
				cnt++;
			}
			check[cur]++;
			q.offer(new int[] {i, cur});
			int size = q.size();
			//���� �����쿡 ���� ��ȣ�� ���ԵǾ� �ִٸ� 
			if(visited[c]) {
				ans = Math.max(ans, size - cnt);
			}else {
				ans = Math.max(ans, size+1 - cnt);
			}
		}
		System.out.println(ans);
	}

}
