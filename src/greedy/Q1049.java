package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
�Է�]
ù° �ٿ� N�� M�� �־�����. N�� 100���� �۰ų� ���� �ڿ����̰�, 
M�� 50���� �۰ų� ���� �ڿ����̴�. ��° �ٺ��� M���� �ٿ��� �� �귣���� ��Ű�� ���ݰ� ������ ������ �������� �����Ͽ� �־�����. 
������ 0���� ũ�ų� ����, 1,000���� �۰ų� ���� �����̴�.

���]
ù° �ٿ� ��Ÿ���� ��� N�� ��� ���� �ʿ��� ���� �ּڰ��� ����Ѵ�.
 */
public class Q1049 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//broken lines
		int N = Integer.parseInt(st.nextToken());
		//num of brands
		int M = Integer.parseInt(st.nextToken());
		int[] packages = new int[M];
		int[] singles = new int[M];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			packages[i] = Integer.parseInt(st.nextToken());
			singles[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(packages);
		Arrays.sort(singles);
		
		int quotient = N/6;
		int remainder = N%6;
		int ans = 0;
		if(packages[0] < singles[0] * 6) {
			ans += quotient * packages[0];
			if(packages[0] < remainder * singles[0]) {
				ans += packages[0];
			}else {
				ans += remainder * singles[0];
			}
			System.out.println(ans);
		}else {
			System.out.println(N * singles[0]);
		}
	}

}
