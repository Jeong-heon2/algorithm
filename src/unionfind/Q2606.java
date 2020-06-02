package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

[입력]
첫째 줄에는 컴퓨터의 수가 주어진다. 
컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
  이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

[출력]
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
 */
//문제를 보자마자 union find와 dfs bfs로 풀 수 있어보였다.
public class Q2606 {
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//컴터 개수
		int N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		for(int i = 0 ; i < N+1 ; i++) {
			parents[i] = i;
		}
		//쌍 수
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			union(com1, com2);
		}
		
		int count = 0;
		for(int i = 2 ; i <= N ; i ++) {
			if(find(i) == 1) count++;
		}
		System.out.println(count);
	}
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}else {
			return parents[x] = find(parents[x]);
		}
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(y > x) {
				parents[y] = x;
			}else {
				parents[x] = y;
			}
		}
	}

}
