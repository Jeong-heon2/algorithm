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
			//	ť�� ��������� �ְ� 
			// ť�� �������� arr[i] ���ؼ� ť�� �������� ��  ������ �����ϰ�  arr[i]�� ť�� �������� �߰� 
			// �� ���ڸ��� ���� ū ��������.  �װ� ã�� ���� K>0 && ť�� �������� �� ���� ���ڵ��� ���� 
			// ������ K��ŭ�� 
			while(K>0 && !dq.isEmpty() && dq.getLast() < arr[i]) {
				dq.removeLast();
				K--;
			}
			dq.addLast(arr[i]);
		}
		int size = dq.size() - K; //K��ŭ ������ �� �Ǿ��� ���� ���� 
		while(size-- > 0) {
			bw.write(dq.pollFirst());
		}
		bw.flush();
		bw.close();
	}

}
