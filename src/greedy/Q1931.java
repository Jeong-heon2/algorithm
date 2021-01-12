package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*ȸ�ǽ� ���� ���� 
�Է�]
ù° �ٿ� ȸ���� �� N(1 �� N �� 100,000)�� �־�����. 
��° �ٺ��� N+1 �ٱ��� �� ȸ���� ������ �־����µ� �̰��� ������ ���̿� �ΰ� ȸ���� ���۽ð��� ������ �ð��� �־�����. ���� �ð��� ������ �ð��� 231-1���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.

���]
ù° �ٿ� �ִ� ����� �� �ִ� ȸ���� �ִ� ������ ����Ѵ�.
 */
public class Q1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[N];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(s, e);
		}
		Arrays.sort(meetings);
		//�����ϰ� �տ��� ���� �о����. 
		//�� ���� ��� 
		//1. ���� ������ ������ �ð���  ���� ���� ���� �� -> ���� ������ �����ϴ� ���� �� ���� 
		//2. ���� ���� ���۽ð���  ���� ���� ������ �ð� ���� -> ȸ�ǽ� ��� ���� 
		//3. ���� ���� ���۽ð��� ���� ���� ������ �ð� ���� ->ȸ�ǽ� ��� �Ұ� 
		Meeting curr = meetings[0];
		int cnt = 1;
		for(int i = 1 ; i < N ; i++) {
			if(meetings[i].e < curr.e) {
				curr = meetings[i];
			}else if (meetings[i].s >= curr.e) {
				curr = meetings[i];
				cnt++;
			}
		}
		System.out.println(cnt);

	}
	static class Meeting implements Comparable<Meeting>{
		int s;//���� �ð� 
		int e;// ������ �ð� 
		Meeting(int s, int e){
			this.s = s;
			this.e = e;
		}
		//���� �ð� �������� ���� 
		@Override
		public int compareTo(Meeting o) {
			return this.s - o.s;
		}
	}
}
