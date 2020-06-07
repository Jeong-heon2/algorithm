package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
������ ��2
N���� ���� �� ���� A[1], A[2], ��, A[N] �� �ִ�. 
�� ������ i��° ������ j��° �������� �� A[i]+A[i+1]+��+A[j-1]+A[j]�� M�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù° �ٿ� N(1��N��10,000), M(1��M��300,000,000)�� �־�����. 
���� �ٿ��� A[1], A[2], ��, A[N]�� �������� �и��Ǿ� �־�����. 
������ A[x]�� 30,000�� ���� �ʴ� �ڿ����̴�.

[���]
ù° �ٿ� ����� ���� ����Ѵ�.
 */
public class Q2003 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int end = 0;
		int res = 0;
		for(int start = 0 ; start < N ; start++) {
			while(end < N && sum < M) {
				sum += arr[end++];
			}
			if(sum == M) res++;
			sum -= arr[start];
		}
		System.out.println(res);
	}
}
