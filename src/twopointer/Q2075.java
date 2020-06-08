package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
https://buddev.tistory.com/41
투포인터 
처음 접근했던 방법은 알고리즘이 틀렸다. 조금만 더 깊게 생각했어야했다.
[처음 접근법 ]
1. arr[N-1] 에서 최대값의 위치를 구한다. 그 위치를 arr[N-1][max]라 한다면 
2. arr[N-2][max] 보다 큰 값이 arr[N-1]에 있는지 찾는다 .  
3. 큰 값이 있다면 그 녀석이 두번째로 큰 녀석이고 큰 값이 없다면 arr[N-2][max]가 두번째로 큰값이다.
2~3을 반복해서 N번째로 큰 값을 찾는다.
		
 */
public class Q2075 {
	//블로그 참고한 코드 
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
