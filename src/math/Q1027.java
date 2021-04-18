package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1027 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] buildings = new long[N+1];
		for(int i = 1 ; i<= N ; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		int[] res = new int[N+1];//res[i] : i�� �������� ���̴� ������ �� 
		for(int i = 1 ; i < N ; i++) {
			for(int j = i+1; j<=N ; j++) {
				//i�� j�� ���� ���̴��� Ȯ�� 
				//i�� j ������ �ǹ�����  i�� j�� ���� ���� ���� �Ʒ��� �ִ��� üũ 
				//����
				double m = (buildings[j]-buildings[i])/(double)(j-i);
				//y = m(x - x1) + y1
				//  = mx -mx1 + y1
				double tmp = -m*j + buildings[j];
				boolean flag = true;
				for(int k = i+1 ; k < j ; k++) {
					if( m*k + tmp <= buildings[k] ) {
						//���� ���� ���� ������ ������  i�� j�� ���� ������ ���� 
						flag = false;
						break;
					}
				}
				if(flag) {
					res[i]++;
					res[j]++;
				}
			}
		}
		int max = 0;
		for(int i = 1 ; i <= N ; i++) {
			max = Math.max(max, res[i]);
		}
		System.out.println(max);
		
	}

}
