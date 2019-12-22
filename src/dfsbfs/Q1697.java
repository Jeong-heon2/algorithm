package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] count = new int[100001];
		BFS(count,N,M);
		System.out.println(count[M]);
	}
	public static void BFS(int[] count, int start, int target) {
		if(start == target) return;
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		int j = 1;// 현재 라운드
		while(count[target] == 0) {//target위치에 뭔 가 값이 써지게 되면 그것이 정답
			int qsize = Q.size();
			for(int i = 0 ; i < qsize ; i++) {//큐에서 하나씩 뽑아서 방문할 곳 체크
				int current = Q.poll();
				if((current-1)>=0) {
					if((count[current-1] > j) || (count[current-1]==0 && (current-1 !=start)) ) {//j번만에 올수있는데 더 큰값이 있으므로
						count[current-1] = j;//여기까지는 j번만에 올수있다.
						if(current-1 == target) break;
						Q.add(current-1);//다음 방문할 곳
					}
				}
				if((current+1) <= 100000) {
					if((count[current+1] > j) || (count[current+1]==0)&& (current+1 !=start)) {
						count[current+1] = j;
						if(current+1 == target) break;
						Q.add(current+1);
					}
				}
				if((current*2) <= 100000) {
					if((count[current*2] > j) || (count[current*2]==0)&& (current*2 !=start)) {
						count[current*2] = j;
						if(current*2 == target) break;
						Q.add(current*2);
					}	
				}
			}
			j++;
		}
		return;
	}
}
