package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Q1501 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();//단어, 카운트
		for(int i = 0 ; i < N ; i++) {
			String word = changeStr(br.readLine());
			if(!map.containsKey(word)) {
				map.put(word, 1);
			}else {
				map.put(word, map.get(word)+1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0) {
			//문장을  각 단어로 분리  (띄어쓰기  기준) 
			//각 단어마다 첫 문자, 끝 문자 제외하고 sort -> map에서 찾고 count를 곱해줌  ans *= cnt 
			String[] sentence = br.readLine().split(" ");
			int ans = 1;
			for(String w : sentence) {
				String word = changeStr(w);
				if(map.containsKey(word)) {
					ans *= map.get(word);
				}else {
					ans = 0;
					break;
				}
			}
			bw.write(ans+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//word 맨앞 맨뒤 글자 제외  중간만 sort 하고 리턴 
	private static String changeStr(String word) {
		int size = word.length();
		if(size >= 3) {
			char[] center = word.substring(1, size-1).toCharArray();
			Arrays.sort(center);
			return word.charAt(0) +String.valueOf(center) + word.charAt(size-1);
		}else {
			return word;
		}
		
	}

}
