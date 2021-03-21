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
		HashMap<String, Integer> map = new HashMap<>();//�ܾ�, ī��Ʈ
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
			//������  �� �ܾ�� �и�  (����  ����) 
			//�� �ܾ�� ù ����, �� ���� �����ϰ� sort -> map���� ã�� count�� ������  ans *= cnt 
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
	//word �Ǿ� �ǵ� ���� ����  �߰��� sort �ϰ� ���� 
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
