package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15922 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pX = Integer.parseInt(st.nextToken());
		int pY = Integer.parseInt(st.nextToken());
		int ans = pY - pX;
		while(--N> 0) {
			st = new StringTokenizer(br.readLine());
			int cX = Integer.parseInt(st.nextToken());
			int cY = Integer.parseInt(st.nextToken());
			if(pY > cX) {
				if(cY > pY) {
					ans += cY-pY;
					pX = cX;
					pY = cY;
				}else {
					pX = cX;
				}
			}else {
				ans += cY-cX;
				pX = cX;
				pY = cY;
			}
		}
		System.out.println(ans);
	}

}
