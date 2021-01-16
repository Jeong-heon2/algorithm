package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q16916 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String p = br.readLine();
		int sLen = s.length();
		int pLen = p.length();
		int j = 0 ;
		int[] pi = failfunc(p);
		int ans = 0;
	    for (int i = 0 ; i < sLen ; i++) {
	    	while( j > 0 && s.charAt(i) != p.charAt(j)) {
	    		j = pi[j-1];
	    	}
	    	if( s.charAt(i) == p.charAt(j)) {
	    		if (j == pLen - 1){
	    			ans = 1;
	    			break;
	    		}else {
	    			j++;
	    		}
	    	}
	    }
	    if(ans == 1) {
	    	System.out.println(1);
	    }else {
	    	System.out.println(0);
	    }


	}
	public static int[] failfunc(String p) {
		int m = p.length();
		int[] pi = new int[m];
		//이전 단계에서  공통으로 일치된 길이 
		int j = 0 ;
		for(int i = 1 ; i < m ; i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) {
				pi[i] = j + 1;
				j++;
			}else {
				pi[i] = 0;
			}
		}
		return pi;
	}
}
