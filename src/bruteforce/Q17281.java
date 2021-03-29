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
		N = Integer.parseInt(br.readLine());//이닝
		results = new int[N][9];
		int ans = 0;
		//0~8 번 타자 
		int[] seq = {1,2,3,4,5,6,7,8};//0번 선수는 항상 3번 타자 이므로 제외. 나머지 1~8번 선수들의 타순을 정해야함 
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
			Queue<Integer> q = new LinkedList<>();//선수 번호 
			int idx = 0;
			for(int i = 0 ; i < 9 ; i++) {
				if(i == 3) {
					q.offer(0);//0번 선수는 항상 3번 타자 
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
	//교환하는 함수
	public static void swap(int[]arr , int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void play(Queue<Integer> q) {
		int out = 0;
		int score = 0;
		int[] base = new int[4];// 베이스 상황  0 : 1루 1 : 2루   2: 3루  3: 홈
		for(int t = 0 ; t < N ; t++) {
			while(out < 3) {
				int num = q.poll();//타석에 나설 선수 번호 
				int cur = results[t][num]; 
				if(cur == 0) {
					out++;
				}else {
					//베이스 주자 진루 
					for(int i = 2 ; i >= 0 ; i--) {
						//cur만큼 진루 시키고 
						if(base[i] == 1) {
							//베이스에 주자가 있다면 
							int next = i + cur;
							if(next >= 3) {
								base[3]++;
							}else {
								base[next]++;
							}
							base[i] = 0;
						}
						
					}
					//타자 주자 진루 
					base[cur-1]++;
				}
				q.offer(num);
			}
			//홈 만큼 score 증가 
			score += base[3];
			Arrays.fill(base, 0);
			out = 0;
		}
		
		max = Math.max(max, score);
	}

}
