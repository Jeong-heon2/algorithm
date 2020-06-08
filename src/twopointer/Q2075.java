package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
https://buddev.tistory.com/41
�������� 
ó�� �����ߴ� ����� �˰����� Ʋ�ȴ�. ���ݸ� �� ��� �����߾���ߴ�.
[ó�� ���ٹ� ]
1. arr[N-1] ���� �ִ밪�� ��ġ�� ���Ѵ�. �� ��ġ�� arr[N-1][max]�� �Ѵٸ� 
2. arr[N-2][max] ���� ū ���� arr[N-1]�� �ִ��� ã�´� .  
3. ū ���� �ִٸ� �� �༮�� �ι�°�� ū �༮�̰� ū ���� ���ٸ� arr[N-2][max]�� �ι�°�� ū���̴�.
2~3�� �ݺ��ؼ� N��°�� ū ���� ã�´�.
		
 */
public class Q2075 {
	//��α� ������ �ڵ� 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int[] h = new int[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.fill(h, N-1);
		
		int max = 0 , idx;
		for(int i = 0 ; i < N ; i++) {
			max = arr[h[0]][0];
			idx = 0;
			for(int j = 0 ; j < N ; j++) {
				if(max < arr[h[j]][j]) {
					max = arr[h[j]][j];
					idx = j;
				}
			}
			h[idx]--;
		}
		System.out.println(max);
	}

}
