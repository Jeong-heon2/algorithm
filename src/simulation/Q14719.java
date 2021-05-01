package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14719 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] arr = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for(int i = h ; i >= 1 ; i--) {
			boolean flag = false;
			int cnt = 0;
			for(int j = 0 ; j < w; j++) {
				if(i == arr[j]) {
					if(!flag) {
						flag = true;
						cnt = 0;
					}else {
						ans += cnt;
						cnt = 0;
					}
					arr[j]--;
				}else {
					cnt++;
				}
			}
		}
		System.out.println(ans);
	}

}
