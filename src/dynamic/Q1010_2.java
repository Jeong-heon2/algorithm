package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			long nFac = 1 ;
			long kFac = 1;
			for(int n = M ; n>=M-N+1; n--) {
				nFac *=n;
			}
			for(int k = N ; k>=1 ; k--) {
				kFac *=k;
			}
			System.out.println(nFac/kFac);
		}
	}

}
