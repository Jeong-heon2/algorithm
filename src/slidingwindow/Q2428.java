package slidingwindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2428 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(arr[0]);
		long ans = 0;
		for(int i = 1 ; i<N; i++) {
			int cur = arr[i];
			while(!q.isEmpty() && q.peek() < cur*0.9) {
				q.poll();
			}
			ans += q.size();
			q.offer(cur);
		}
		System.out.println(ans);
	}

}
