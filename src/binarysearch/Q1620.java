package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int q_leng = Integer.parseInt(st.nextToken());
		//포켓몬 입력 받기
		Map<String,String> pokets = new HashMap<>();
		for(int i = 1 ; i <= size ; i ++) {
			String poketMon = br.readLine();
			pokets.put(String.valueOf(i), poketMon);
			pokets.put(poketMon, String.valueOf(i));
		}
		//질문 개수만큼
		while(q_leng-- >0) {
			String line = br.readLine();
			System.out.println(pokets.get(line));
		}
	}
}
