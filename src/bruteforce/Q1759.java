package bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1759 {
	static char[] vowels = { 'a', 'e', 'i', 'o', 'u'};
	static ArrayList<String> res;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp = br.readLine().split(" ");
		res = new ArrayList<>();
		int L = Integer.parseInt(tmp[0]);
		int C = Integer.parseInt(tmp[1]);
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] arr = new char[C];
		for(int i = 0 ; i<C ; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		boolean[] visited = new boolean[C];
		
		combination(arr, visited, 0, C, L);
		Collections.sort(res);
		for(String str : res) {
			bw.write(str+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
		
	}
	private static void combination(char[] arr, boolean[] visited, int start, int n , int r) {
		if(r== 0) {
			ArrayList<Character> list = new ArrayList<>();
			for(int i = 0 ; i < n ; i++) {
				if(visited[i]) list.add(arr[i]);
			}
			//모음 1개, 자음 2개 들어있는지 확인 
			int vowelCnt = 0;
			int consonantCnt = 0;
			for(char ch : list) {
				boolean flag = false;
				for(char vw : vowels) {
					if(ch == vw) {
						vowelCnt++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					consonantCnt++;
				}
			}
			if(vowelCnt >= 1 && consonantCnt >=2) {
				//정렬 
				Collections.sort(list);
				StringBuilder sb = new StringBuilder();
				for(char ch : list) {
					sb.append(ch);
				}
				res.add(sb.toString());
			}
			
			
		}else {
			for(int i = start ; i < n ; i++) {
				visited[i] = true;
				combination(arr, visited, i+1, n, r-1);
				visited[i] = false;
			}
		}
	}

}
