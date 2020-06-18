package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
�Է�]
ù° �ٿ��� �׽�Ʈ ���̽��� ���� T(1 �� T �� 20)�� �־�����.
�� �׽�Ʈ ���̽��� ù° �ٿ� �������� ���� N(1 �� N �� 100,000)�� �־�����. 
��° �ٺ��� N�� �ٿ��� ������ �������� �����ɻ� ����, ���� ������ ������ ������ ���̿� �ΰ� �� �ٿ� �־�����. 
�� ���� ������ ��� 1������ N������ ������ ���� �����ȴٰ� �����Ѵ�.

���]
�� �׽�Ʈ ���̽��� ���ؼ� ���� �ֽ�ȸ�簡 ������ �� �ִ� ���Ի���� �ִ� �ο����� �� �ٿ� �ϳ��� ����Ѵ�.
 */
public class Q1946 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//test case
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			//number of applicants
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int i = 0 ; i < N ; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//	���� 
				int a = Integer.parseInt(st.nextToken());
				//  ���� 
				int b = Integer.parseInt(st.nextToken());
				arr[a-1] = b-1;
			}
			int ans = 1;
			int val = arr[0];//����1���� ���� ��� 
			for(int i = 1 ; i < N ; i++) {
				int a = arr[i];
				if(a < val) {
					ans++;
					val = a;
				}
			}
			System.out.println(ans);
		}

	}

}
