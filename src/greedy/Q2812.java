package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2812 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] arr = br.readLine().toCharArray();
		Deque<Character> dq = new ArrayDeque<>();
		for(int i = 0 ; i < N ; i++) {
			//	큐가 비어있으면 넣고 
			// 큐의 마지막과 arr[i] 비교해서 큐의 마지막이 더  작으면 삭제하고  arr[i]를 큐의 마지막에 추가 
			// 맨 앞자리가 가장 큰 수여야함.  그걸 찾기 위해 K>0 && 큐가 빌때까지 더 작은 숫자들을 제거 
			// 삭제는 K만큼만 
			while(K>0 && !dq.isEmpty() && dq.getLast() < arr[i]) {
				dq.removeLast();
				K--;
			}
			dq.addLast(arr[i]);
		}
		int size = dq.size() - K; //K만큼 삭제가 안 되었을 수도 있음 
		while(size-- > 0) {
			bw.write(dq.pollFirst());
		}
		bw.flush();
		bw.close();
	}

}
