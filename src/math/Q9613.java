package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9613 {
	static int ans;
	static int[] arr = new int[100];
	static boolean[] visited = new boolean[100];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());//test case
		while(t-- > 0) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				visited[i] = false;
			}
			combi(0, n, 2);
			System.out.println(ans);
		}
	}
	public static void combi(int start, int n, int r) {
		if(r == 0) {
			int[] nums = new int[2];
			int idx = 0;
			for(int i = 0 ; i < n ; i++) {
				if(visited[i]) {
					nums[idx++] = arr[i];
				}
			}
			ans += gcd(nums[0], nums[1]);
		}
		for(int i = start ; i < n ; i++) {
			visited[i] = true;
			combi(i+1, n, r-1);
			visited[i] = false;
		}
	}
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
}
