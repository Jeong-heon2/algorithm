package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2661 {
	static int N;
	static String ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		solve("", 0);
		System.out.println(ans);
	}
	private static boolean solve(String sequence, int r) {
		if(r == N) {
			ans = sequence;
			return true;
		}
		for(int i = 1 ; i<=3 ; i++) {
			String tmp = sequence + String.valueOf(i);
			if(check(tmp)) {
				if(solve(tmp, r+1)) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean check(String sequence) {
		int len =  sequence.length();
		for(int i = 1 ; i <= len/2 ; i++) {
			String a = sequence.substring(len-i);
			String b = sequence.substring(len-2*i, len-i);
			if(a.equals(b)) {
				return false;
			}
		}
		return true;
	}

}
