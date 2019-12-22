package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//   Ʈ�� ��������� > 1���� �迭�� ����
		//           1     >> arr[1]
		//          2 3    >> arr[2] arr[3]
		//         4 5 6
		//        7 8 9 10
		int[] arr = new int[N*(N+1)/2+1]; //���� ���� �迭 
		int[] dp = new int[N*(N+1)/2+1]; //dp[n]�� arr[n] ��ġ���� ������� ���µ� �ִ� ��� ���� 
		for(int i =1; i<=N; i++) {//���� �ް�
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1+i*(i-1)/2; j<=i*(i+1)/2 ; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
		}
		//�������� 1�����λ����ϰ� 1�� ����  �������鼭  dp�� ���Ұ���
		for(int i = 1 ; i <= N; i++) {// i�� ���� ����
			int x = 1 + i*(i-1)/2;//x�� i���� ù��° ������ arr�迭���� idx��
			for(int j = 0; j<i; j++) {//i������ i���� ���Ұ� �����Ƿ�  ������ ������ŭ �ݺ�
				if(j != 0 && j != i-1) {//������ ù��° ���ҿ� ���������Ҵ� ����� ���̽�
					dp[x+j] = Math.max(dp[x+j-i], dp[x+j-i+1]) + arr[x+j]; // ������� 3���� �ι���������(idx5��)
				}// �̳𿡼� �� �� �ִ°�δ� idx 2�� 3   ���� idx(5)-���� ����(3) or ���� idx - ���� ���� +1
				else if (j == 0) {//������ ù��° ���Ҵ�   ���� idx - ���� ���� + 1 �θ� ��������
					dp[x+j] = dp[x+j-i+1] + arr[x+j];
				}
				else dp[x+j] = dp[x+j-i] + arr[x+j];// ��� ���� idx - �������� �θ� �� �� ���� 
			}
		}
		int max = 0;
		for(int i = 1+N*(N-1)/2; i<= N*(N+1)/2 ; i++) { // �� �Ʒ��� �� dp�� �ִ밪�� ������
			if (max < dp[i]) max = dp[i];
		}
		System.out.println(max);
	}

}
