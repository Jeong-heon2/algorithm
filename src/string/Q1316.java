package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q1316 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<Character> set = new HashSet<>();
		int ans = n;
		while(n-- > 0) {
			String s = br.readLine();
			char pre = s.charAt(0);
			set.add(pre);
			for(int i = 1 ; i < s.length() ; i++) {
				char cur = s.charAt(i);
				//set에는 있는데 pre와 다르다면 그룹 단어가 아니다. 
				if(set.contains(cur) && pre != cur) {
					ans--;
					break;
				}else {
					set.add(cur);
				}
				pre = cur;
			}
			set.clear();
		}
		System.out.println(ans);
	}
}
