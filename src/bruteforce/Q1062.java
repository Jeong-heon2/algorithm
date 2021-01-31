package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
//실패 
public class Q1062 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		Alphabet[] dic = new Alphabet[26];
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		for(int i = 0 ; i < 26 ; i++) {
			dic[i] = new Alphabet(i, 0);
		}
		Word[] arr = new Word[N];
		for(int i = 0 ; i < N ;i++) {
			String str = br.readLine();
			arr[i] = new Word(str, 0);
			boolean[] visited= new boolean[26];
			for(int j = 0 ; j < str.length() ; j++) {
				int idx = str.charAt(j) - 'a';
				if(!visited[idx]) {
					dic[idx].cnt++;
					visited[idx] = true;
					arr[i].cnt++;
				}
				
			}
		}
		Arrays.sort(dic, new Comparator<Alphabet>() {
			@Override
			public int compare(Alphabet o1, Alphabet o2) {
				return o2.cnt - o1.cnt;
			}
		});
		boolean[] knows = new boolean[26];
		for(int i = 0 ; i < K-1 ; i++) {
			knows[dic[i].ch] = true;
		}
		int ans = N;
		for(int i = 0 ; i < N ;i++) {
			Word word = arr[i];
			for(int j = 0 ; j < word.w.length() ; j++) {
				//모르는 글자라면 
				if(!knows[word.w.charAt(j) - 'a']) {
					ans--;
					break;
				}
			}
		}
		System.out.println(ans);
		
	}
	static class Word{
		String w;
		int cnt;//단어 w가 배워야할 문자 종류 수 
		Word(String w , int cnt){
			this.w = w;
			this.cnt = cnt;
		}
	}
	static class Alphabet{
		int ch;
		int cnt;// 알파벳 ch가 단어에 포함된 횟수 
		Alphabet(int ch , int cnt){
			this.ch = ch;
			this.cnt = cnt;
		}
	}

}
