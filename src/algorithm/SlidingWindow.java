package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//boj 11003
/*
N���� �� A1, A2, ..., AN�� L�� �־�����.
D[i] = A[i-L+1] ~ A[i] ���� �ּڰ��̶�� �� ��, D�� ����� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
�̶�, i �� 0 �� Ai�� �����ϰ� D�� ���ؾ� �Ѵ�.

ù° �ٿ� N�� L�� �־�����. (1 �� L �� N �� 5,000,000)
��° �ٿ��� N���� �� Ai�� �־�����. (-109 �� Ai �� 109)

ù° �ٿ� Di�� �������� �����Ͽ� ������� ����Ѵ�.
*/
public class SlidingWindow {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] ans = new int[N];
		st = new StringTokenizer(br.readLine());
		br.close();
		Deque<int[]> d = new ArrayDeque<>();
		for(int i = 0 ; i < N ; i++) {
			int cur = Integer.parseInt(st.nextToken());
			//���� �� �� �ε����� ���� �ε��� �˻� 
			if(!d.isEmpty() && d.peekFirst()[0] <= i-L) {
				d.poll();
			}
			//���� �� �� 
			while(!d.isEmpty() && d.peekLast()[1] > cur) {
				d.pollLast();
			}
			d.offer(new int[] {i,cur});
			ans[i] = d.peekFirst()[1];
		}
		for(int i = 0 ; i < N ; i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	

}
