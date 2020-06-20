package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
����Ʈ�� ����
�Է�]
�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. 
�� ���̽��� n�� �����ϸ�, �� �ٷ� �̷���� �ִ�. (n �� 123456)
�Է��� ���������� 0�� �־�����.
���]
�� �׽�Ʈ ���̽��� ���ؼ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ����Ѵ�.
 */
public class Q4948 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 123456*2;
		int[] arr = new int[max+1];
		for(int i = 2 ; i <= max ; i++) {
			arr[i] = i;
		}
		/*
		�Ҽ��� n�� ����� �ƴϾ�� �Ѵ�.
		�Է¹��� ���� �Է¹��� ������ ���� �� ��� ����� �������� �Ҽ��� �ƴϴ�.
		�׷��� ��� ����� �ʿ����, ��Ʈ n ������ ����� �������� �Ҽ��� �ƴϴ�.
		 */
		for (int i = 2; i <= Math.sqrt(max); i++) { 
			if (arr[i] == 0) // �̹� üũ�� ���� ����� Ȯ������ �ʴ´�
				continue;
	        for (int j = i + i; j <= max; j += i) { // i�� ������ i�� ������� 0���� üũ
	        	arr[j] = 0;
	        }
		}
		do {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			int ans = 0;
			for(int i = n+1 ; i <= 2*n ; i++) {
				if(arr[i] != 0) ans++;
			}
			System.out.println(ans);
		}while(true);
		
	}
}
