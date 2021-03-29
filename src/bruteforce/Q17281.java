package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17281 {
	static int[][] results;
	static int max;
	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//�̴�
		results = new int[N][9];
		int ans = 0;
		//0~8 �� Ÿ�� 
		int[] seq = {1,2,3,4,5,6,7,8};//0�� ������ �׻� 3�� Ÿ�� �̹Ƿ� ����. ������ 1~8�� �������� Ÿ���� ���ؾ��� 
		max = 0;
		for(int j = 0 ; j < N ;j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i< 9 ; i++) {
				results[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(seq, 0, 8);
		ans += max;
		System.out.println(ans);
	}
	private static void perm(int[] arr, int depth, int n) {
		if(depth == n) {
			Queue<Integer> q = new LinkedList<>();//���� ��ȣ 
			int idx = 0;
			for(int i = 0 ; i < 9 ; i++) {
				if(i == 3) {
					q.offer(0);//0�� ������ �׻� 3�� Ÿ�� 
					continue;
				}
				q.offer(arr[idx++]);
			}
			play(q);
			return;
		}
		for(int i = depth; i < n ; i++) {
			swap(arr, i , depth);
			perm(arr, depth+1, n);
			swap(arr, i , depth);
		}
	}
	//��ȯ�ϴ� �Լ�
	public static void swap(int[]arr , int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void play(Queue<Integer> q) {
		int out = 0;
		int score = 0;
		int[] base = new int[4];// ���̽� ��Ȳ  0 : 1�� 1 : 2��   2: 3��  3: Ȩ
		for(int t = 0 ; t < N ; t++) {
			while(out < 3) {
				int num = q.poll();//Ÿ���� ���� ���� ��ȣ 
				int cur = results[t][num]; 
				if(cur == 0) {
					out++;
				}else {
					//���̽� ���� ���� 
					for(int i = 2 ; i >= 0 ; i--) {
						//cur��ŭ ���� ��Ű�� 
						if(base[i] == 1) {
							//���̽��� ���ڰ� �ִٸ� 
							int next = i + cur;
							if(next >= 3) {
								base[3]++;
							}else {
								base[next]++;
							}
							base[i] = 0;
						}
						
					}
					//Ÿ�� ���� ���� 
					base[cur-1]++;
				}
				q.offer(num);
			}
			//Ȩ ��ŭ score ���� 
			score += base[3];
			Arrays.fill(base, 0);
			out = 0;
		}
		
		max = Math.max(max, score);
	}

}
