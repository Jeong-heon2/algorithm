package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1062_2 {
	static int ans;
	static String[] words;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		ans = 0;
		boolean[] dic = new boolean[26];
		N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		words = new String[N];
		for(int i = 0 ; i < N ; i++) {
			words[i] = br.readLine();
		}
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		
		//a : 0  n : 13  t: 19 , i : 8  c : 2
		combination(dic, 0, 26, K-5);
		System.out.println(ans);
		
	}
	public static void combination(boolean[] dic, int start, int n , int r) {
		if(r == 0) {
			int res = search(dic);
			ans = Math.max(res, ans);
		}else {
			for(int i = start ; i < n ; i++) {
				if(i == 0 || i == 13 || i == 19 || i == 8 || i == 2) continue;
				dic[i] = true;
				combination(dic, i+1, n , r-1);
				dic[i] = false;
			}
		}
	}
	//읽을 수 있는 단어개수를 리턴 
	public static int search(boolean[] dic) {
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			String str = words[i];
			boolean flag = true;
			for(int j = 0 ; j < str.length() ; j++) {
				int idx = str.charAt(j) - 'a';
				if(idx == 0 || idx == 13 || idx == 19 || idx == 8 || idx == 2) continue;
				if(!dic[idx]) {
					//배우지 않은 문자라면 
					flag = false;
					break;
				}
			}
			if(flag) cnt++;
		}
		return cnt;
	}

}
