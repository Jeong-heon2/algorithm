package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
듣보잡 
입력]
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 
이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 영어 소문자로만 이루어지며, 
그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

출력]
듣보잡의 수와 그 명단을 사전순으로 출력한다.
 */
public class Q1764 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//듣도못한 사람수
		int N = Integer.parseInt(st.nextToken());
		//보도못한 사람수
		int M = Integer.parseInt(st.nextToken());
		//듣도못한 사람들 저장 
		HashMap<String, Boolean> unKnowns = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			unKnowns.put(br.readLine(), true);
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i = 0 ; i < M ; i++) {
			String name = br.readLine();
			if(unKnowns.containsKey(name)) {
				pq.offer(name);
			}
		}
		System.out.println(pq.size());
		while(pq.size() > 0) {
			System.out.println(pq.poll());
		}
	}

}
