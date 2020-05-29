package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 Q1697 숨바꼭질
수빈이는 동생과 숨바꼭질을 하고 있다. 
수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */
//dfs 재귀함수 : stackoverflow
public class Q1697_2 {
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//수빈이 위치
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		DFS(0,N,K,0);
		System.out.println(ans);

	}
	//curr: 수빈이의 현위치 , target : 동생의 위치 , count : 움직인 횟
	public static void DFS(int visited, int curr, int target, int count) {
		//범위를 벗어나거나 이미 방문한 곳이라면 return
		if(!isRanged(curr) || (visited & (1 << curr)) == 1) {
			return;
		}
		//동생의 위치에 도착했으면 ans와 count 비교후 ans 보다 작다면 ans 갱신
		if(curr == target) {
			if(ans > count) ans = count;
			return;
		}
		//현 위치 방문 표시, 다음 위치로 이동
		visited = visited | 1 << curr;
		count++;
		//가능한 움직일 수 있는 경우의 수는 3가지
		//순간이동 , 뒤로 한칸 이동, 앞으로 한 칸 이동
		DFS(visited, curr-1, target, count);
		DFS(visited, curr+1, target, count);
		DFS(visited, curr*2, target, count);
		//백트레킹
		visited = visited & ~1 << curr;
		return;
		
		
	}
	public static boolean isRanged(int curr) {
		if(0<=curr && curr<=100000) return true;
		else return false;
	}
}
