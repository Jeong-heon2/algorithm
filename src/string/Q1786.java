package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1786 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		String p = br.readLine();
		int tLen = t.length();
		int pLen = p.length();
		int[] pi = getFailFunc(p);
		int j = 0;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < tLen ; i++) {
			while(j > 0 && t.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(t.charAt(i) == p.charAt(j)) {
				if(j == pLen - 1) {
					cnt++;
					sb.append(i - pLen + 2 + " ");
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
	public static int[] getFailFunc(String p) {
		int len = p.length();
		int[] pi = new int [len];
		int j = 0;
		for(int i = 1; i < len ; i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) {
				pi[i] = j++ + 1;
			}else {
				pi[i] = 0;
			}
		}
		return pi;
	}

}
