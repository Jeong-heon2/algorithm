package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1644 {
	static int[] prime;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ans = 0;
		//에라토스테네스의 체 
		prime = new int[N+1];
		for(int i = 2 ; i <= N; i++) {
			prime[i] = i;
		}
		for(int i = 2 ; i*i <= N ; i++) {
			if(prime[i] == 0) continue;
			for(int j = 2*i ; j <= N ; j += i) {
				prime[j] = 0;
			}
		}
		//소수 리스트 
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 2 ; i <= N ; i++) {
			if(prime[i] != 0) {
				list.add(prime[i]);
			}
		}
		solve(list, list.size(), N);
		System.out.println(ans);
	}
	private static void solve(ArrayList<Integer> list, int n, int target) {
		for(int i = 0 ; i < n ; i++) {
			int sum = 0;
			for(int j = i ; j < n ; j++) {
				sum += list.get(j);
				if(sum == target) {
					ans++; break;
				}else if(sum > target) break;
			}
		}
	}

}
