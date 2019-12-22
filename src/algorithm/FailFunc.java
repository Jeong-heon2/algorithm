package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FailFunc {
		static String a;
		static int[] fail;
		static char[] p;
		static int count;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = br.readLine();
		fail = new int[N+1];
		p = new char[a.length()+1];
		count = 0;
		for(int i = 1; i <= a.length(); i++) {
			p[i] = a.charAt(i-1);
		}
		for(int i = 1; i < p.length-1 ; i++) {
			setfailfunc(i,fail[i]);
		}
		for(int i = 1 ; i <=N ; i++) {
			System.out.print(fail[i]+" ");
		}
		System.out.println();
		System.out.println(count);
	}
	public static void setfailfunc(int k,int fk) {
		count ++;
		if(p[fk+1]==p[k+1]) {
			fail[k+1] = fk+1;
		}
		else {
			if(fk==0) return;
			else setfailfunc(k,fail[fk]);
		}
	}
}
