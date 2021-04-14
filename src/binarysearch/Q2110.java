package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
	static int n;
	static int c;
	static int[] houses;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//집의 개수 
		c = Integer.parseInt(st.nextToken());//공유기의 개수 
		houses = new int[n];
		for(int i = 0 ; i< n ; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		solve();
		
	}
	private static void solve() {
	    int left = 1; // 가능한 최소 거리
	    int right = houses[n - 1] - houses[0]; // 가능한 최대 거리
	    //정답은 left~right 중에 있음 
	    int d = 0;
	    int ans = 0;
	 
	    while (left <= right) {
	        int mid = (left + right) / 2; // 얘가 정답인지 체크 . 기준 간격 
	        int start = houses[0];
	        int cnt = 1;//start에 하나 설치 
	 
	        
	        for (int i = 1; i < n; i++) {
	            d = houses[i] - start;
	            //기준 간격 보다 크거나 같으면 공유기 설치 가능 
	            if (mid <= d) {
	                ++cnt;
	                start = houses[i];
	            }
	        }
	 
	        if (cnt >= c) {
	            // 간격을 넓혀서 공유기를 덜 설치하게끔 해야 하네 
	        	//정답은 mid ~ right 중에 있구나 
	            ans = mid;
	            left = mid + 1;
	        } else {
	            // 기준 간격을 좁혀서 공유기를 더 설치할 수 있게끔 해야 하네 
	        	//정답은 left~mid 중에 있구나 
	            right = mid - 1;
	        }
	    }
	    System.out.println(ans);
	}

}
