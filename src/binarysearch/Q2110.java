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
		n = Integer.parseInt(st.nextToken());//���� ���� 
		c = Integer.parseInt(st.nextToken());//�������� ���� 
		houses = new int[n];
		for(int i = 0 ; i< n ; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		solve();
		
	}
	private static void solve() {
	    int left = 1; // ������ �ּ� �Ÿ�
	    int right = houses[n - 1] - houses[0]; // ������ �ִ� �Ÿ�
	    //������ left~right �߿� ���� 
	    int d = 0;
	    int ans = 0;
	 
	    while (left <= right) {
	        int mid = (left + right) / 2; // �갡 �������� üũ . ���� ���� 
	        int start = houses[0];
	        int cnt = 1;//start�� �ϳ� ��ġ 
	 
	        
	        for (int i = 1; i < n; i++) {
	            d = houses[i] - start;
	            //���� ���� ���� ũ�ų� ������ ������ ��ġ ���� 
	            if (mid <= d) {
	                ++cnt;
	                start = houses[i];
	            }
	        }
	 
	        if (cnt >= c) {
	            // ������ ������ �����⸦ �� ��ġ�ϰԲ� �ؾ� �ϳ� 
	        	//������ mid ~ right �߿� �ֱ��� 
	            ans = mid;
	            left = mid + 1;
	        } else {
	            // ���� ������ ������ �����⸦ �� ��ġ�� �� �ְԲ� �ؾ� �ϳ� 
	        	//������ left~mid �߿� �ֱ��� 
	            right = mid - 1;
	        }
	    }
	    System.out.println(ans);
	}

}
