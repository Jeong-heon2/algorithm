package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1107 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Character> brokenBtns = new ArrayList<>();
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(M-- > 0 ) {
				brokenBtns.add(st.nextToken().charAt(0));
			}
		}
		int max = Math.abs(N - 100);//+,- 버튼으로만 움직이는 경우 
		int cnt = getCnt(brokenBtns, N, max);
		if(cnt == -1) {
			System.out.println(max);
		}else {
			System.out.println(Math.min(max, cnt));
		}
	}
	//리모콘 채널 입력  +  +,-버튼 으로 움직이는 경우  
	public static int getCnt(ArrayList<Character> brokenBtns, int target, int max) {
		int ans_up = Integer.MAX_VALUE;
		//max까지만.  max보다 크면  +,- 버튼으로만 움직이는 게 더 낫다 
		for(int i = 0 ; i <= max ; i++) {
			String up = String.valueOf(target + i);
			boolean flag = true;
			for(int j = 0 ; j < up.length() ; j++) {
				if(brokenBtns.contains(up.charAt(j))) {
					flag = false;
					break;
				}
			}
			if(flag) {
				ans_up = target + i;
				break;
			}
		}
		int ans_down = Integer.MAX_VALUE;
		for(int i = 0 ; i <= max ; i++) {
			int tmp = target - i;
			if(tmp == -1) break;
			String up = String.valueOf(tmp);
			boolean flag = true;
			for(int j = 0 ; j < up.length() ; j++) {
				if(brokenBtns.contains(up.charAt(j))) {
					flag = false;
					break;
				}
			}
			if(flag) {
				ans_down = tmp;
				break;
			}
		}
		if(ans_up == Integer.MAX_VALUE && ans_down == Integer.MAX_VALUE) {
			return -1;
		}else {
			if(ans_up == Integer.MAX_VALUE) {
				return String.valueOf(ans_down).length() + Math.abs(target - ans_down);
			}
			else if(ans_down == Integer.MAX_VALUE) {
				return String.valueOf(ans_up).length() + Math.abs(target - ans_up);
			}
			ans_up = String.valueOf(ans_up).length() + Math.abs(target - ans_up);
			ans_down = String.valueOf(ans_down).length() + Math.abs(target - ans_down);
			return Math.min(ans_up, ans_down);
		}
	}

}
