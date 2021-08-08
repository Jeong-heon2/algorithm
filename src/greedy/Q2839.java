package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2839 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(dfs(Integer.parseInt(br.readLine()), 0, 0));
		
	}
	private static int dfs(int target, int cur, int cnt) {
		if(cur > target) return -1;
		if(cur == target) {
			return cnt;
		}else {
			int res = dfs(target, cur + 5, cnt +1);
			if(res > 0) return res;
			res = dfs(target, cur + 3, cnt +1);
			if(res > 0) return res;
		}
		return -1;
		
	}

}
