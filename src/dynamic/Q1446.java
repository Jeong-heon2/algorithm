package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1446 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		ArrayList<Shortcut> list = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(d <= D) {
				list.add(new Shortcut(s, d, w));
			}
		}
		//dp[i] =  시작점부터  i길이 까지의 최소거리
		int[] dp = new int[D+1];
		for(int i = 1 ; i <= D  ;i++) {
			dp[i] = i;
		}
		//시작점 기준으로 오름차순 정렬 
		Collections.sort(list);
		//list가리키는 idx 
		int idx = 0 ;
		int list_size = list.size();
		for(int i = 0 ; i < D  ; i++) {
			if(idx < list_size) {
				Shortcut sc = list.get(idx);
				//i위치 에서 지름길이 있다면 
				if(sc.s == i) {
					dp[sc.d] = Math.min(dp[sc.d], dp[i]+sc.w);
					//i위치의 지름길이 여러개일 수 있으므로 i--해서 i위치를 다시 검사 
					i--;
					idx++;
					continue;
				}
			}
			dp[i+1] = Math.min(dp[i+1], dp[i]+1);
		}
		System.out.println(dp[D]);
	}
	static class Shortcut implements Comparable<Shortcut>{
		int s;
		int d;
		int w;
		Shortcut(int s , int d, int w){
			this.s = s;
			this.d = d;
			this.w = w;
		}
		@Override
		public int compareTo(Shortcut o) {
			return this.s - o.s;
		}
		
	}
}
