package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다.
다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 
이 문자열은 '.', '#', 'O', 'R', 'B' 로 이루어져 있다. '.'은 빈 칸을 의미하고,
'#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치,
'B'는 파란 구슬의 위치이다.
입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 
구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.
파란 구슬을 구멍에 넣지 않으면서 빨간 구슬을 10번 이하로 움직여서 빼낼 수 있으면 1을 없으면 0을 출력한다.
*/
//dfs 과정에서  다음 위치로 보내 놓고  10회가 넘었는지, R B가 겹치는지, 구멍에 빠졌는지 체크 해주고 
//B가 빠졌거나 RB가 겹치면 리턴한다, 즉 그 경우는 아닌 경우인 것이다. 그냥 리턴해준다.
public class Q13459 {
	static int N;
	static int M;
	static int hX;
	static int hY;
	static int[] goX = { 1,-1,0,0};
	static int[] goY = { 0,0,-1,1};
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//세로
		M = Integer.parseInt(st.nextToken());//가로
		int rX = 0;
		int rY = 0;
		int bX = 0;
		int bY = 0;
		char[][] arr = new char[N][M];
		for(int i = 0; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = str.charAt(j);
				if(str.charAt(j) == 'R') {//이때도 .으로 받기
					rX = i;
					rY = j;
				}
				else if(str.charAt(j) == 'B') {
					bX = i;
					bY = j;
				}
				else if(str.charAt(j) == 'O') {
					hX = i;
					hY = j;
				}
			}
		}
		DFS(arr,rX,rY,bX,bY);
		System.out.println(ans);
	}
	public static void DFS(char[][] G, int rX,int rY,int bX,int bY) {
		int count = -1;
		recursiveDFS(G,rX,rY,bX,bY,count);
		return;
	}
	public static void recursiveDFS(char[][] G, int rX,int rY,int bX,int bY,int count) {
		if((count > 10) || ((rX == bX)&&(rY == bY)) || (bX == hX)&&(bY == hY)) return;
		else if((rX == hX)&&(rY == hY)) {
			ans = 1;
			return;
		}
		else {
			count ++;
			//동서남북
			int i = 1;
		
			if(G[rX][rY+1] == '#') {//동
				if(G[bX][bY+1] == '#') {
				}
				else {
					recursiveDFS(G,rX,rY,bX,bY+1,count);
				}
			}else {
				if(G[bX][bY+1] == '#') {
					recursiveDFS(G,rX,rY+1,bX,bY,count);
				}else {
					recursiveDFS(G,rX,rY+1,bX,bY+1,count);
				}
			}
			
			if(G[rX][rY-1] == '#') {//서
				if(G[bX][bY-1] == '#') {
				}
				else {
					recursiveDFS(G,rX,rY,bX,bY-1,count);
				}
			}
			else {
				if(G[bX][bY-1] == '#') {
					recursiveDFS(G,rX,rY-1,bX,bY,count);
				}
				else {
					recursiveDFS(G,rX,rY-1,bX,bY-1,count);
				}
			}
			if(G[rX+1][rY] == '#') {//남
				if(G[bX+1][bY] == '#') {
				}
				else {
					recursiveDFS(G,rX,rY,bX+1,bY,count);
				}
			}
			else {
				if(G[bX+1][bY] == '#') {
					recursiveDFS(G,rX+1,rY,bX,bY,count);
				}
				else {
					recursiveDFS(G,rX+1,rY,bX+1,bY,count);
				}
			}
			if(G[rX-1][rY] == '#') {//북
				if(G[bX-1][bY] == '#') {
				}
				else {
					recursiveDFS(G,rX,rY,bX-1,bY,count);
				}
			}
			else {
				if(G[bX-1][bY] == '#') {
					recursiveDFS(G,rX-1,rY,bX,bY,count);
				}
				else {
					recursiveDFS(G,rX-1,rY,bX-1,bY,count);
				}
			}
			return;
		}
	}

}
