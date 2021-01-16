package algorithm;

public class Kmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabdabcabcabef";
		final int sLen = s.length();
		String t = "abcabe";
		final int tLen = t.length();
		int j = 0;
		int[] pi = failFunc(t);
		int ans = -1;
		for(int i = 0 ; i < sLen; i++, j++) {
			if(s.charAt(i) != t.charAt(j)) {
				if(j != 0) {
					j = pi[j-1] - 1;
					i--;
				}else {
					j = -1;
				}
			}
			if(j == tLen - 1) {
				ans = i - tLen + 1;
				break;
			}
		}
		
		System.out.println(ans);
	}
	public static int[] failFunc(String s) {
		int m = s.length();
		int[] pi = new int[m];
		pi[0] = 0;
		int j = 0;
		for(int i = 1 ; i < m ; i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = pi[j-1];
			}
			if(s.charAt(i) == s.charAt(j)) {
				pi[i] = j++ + 1;
			}else {
				pi[i] = 0;
			}
		}
		return pi;
	}

}
