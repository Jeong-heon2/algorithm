package programmers;

public class Kakao20SummerQ4 {
	static int ans = Integer.MAX_VALUE;
	static int[] goY = { 1,-1,0,0};
	static int[] goX = { 0,0,1,-1};
	//가로
	static int N;
	//세로
	static int M;
	static int[][] boards;
	public static void main(String[] args) {
		int[][] boar = {{0,0,0},{0,0,0},{0,0,0}};
		solution(boar);
		System.out.println(ans);
	}
	public static int solution(int[][] board) {
        int answer = 0;
        M = board.length;
        N = board[0].length;
        boards = board;
        boolean[][] visited = new boolean[M][N];
        visited[0][0]=true;
        dfs(visited,0,0,0,true);
        return answer;
    }
	//state : false 상하  state true : 좌우 ;
	public static void dfs(boolean[][] visited, int x, int y,int cost,boolean state) {
		if((x==M-1) && (y==N-1)) {
			ans = Math.min(cost, ans);
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {// i 가 0 ~ 3  동서남북
			int nextX = x+goX[i];
			int nextY = y+goY[i];
			if(isRanged(nextX,nextY) && !isRock(nextX,nextY)) {
				if(!visited[nextX][nextY]) {
					//방문가능
					if(cost == 0) {
						switch (i) {
							case 1 : 
							case 0 :{//좌우방향
								visited[nextX][nextY]= true;
								dfs(visited,nextX,nextY,cost + 100, true);
								visited[nextX][nextY]= false;
								break;
							}
							case 2 :
							case 3 :{//상하방향
								visited[nextX][nextY]= true;
								dfs(visited,nextX,nextY,cost + 100, false);
								visited[nextX][nextY]= false;
								break;
							}
						}
					}else {
						if(state) {//현재진행 방향이 좌우 라면
							switch (i) {
								case 1 : 
								case 0 :{//동으로 가는 경우  서로 가는 경우  즉, 변화없음 코너 아님
									visited[nextX][nextY]= true;
									dfs(visited,nextX,nextY,cost + 100, state);
									visited[nextX][nextY]= false;
									break;
								}
								case 2 :
								case 3 :{//코너임
									visited[nextX][nextY]= true;
									dfs(visited,nextX,nextY,cost + 500, !state);
									visited[nextX][nextY]= false;
									break;
								}
							}
						}else if(!state) {//상하 라면
							switch (i) {
								case 1 : 
								case 0 :{//동으로 가는 경우  서로 가는 경우  즉, 코너임
									visited[nextX][nextY]= true;
									dfs(visited,nextX,nextY,cost + 500, !state);
									visited[nextX][nextY]= false;
									break;
								}
								case 2 :
								case 3 :{//코너아님
									visited[nextX][nextY]= true;
									dfs(visited,nextX,nextY,cost + 100, state);
									visited[nextX][nextY]= false;
									break;
								}
							}
						}
					}
				}
			}
		}
		return;
		
	}
	//x와 y는 다음으로 가야할 위치
	public static boolean isRock(int x, int y) {
		if(boards[x][y] == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isRanged(int x , int y) {
		if((x>=0 && x<M) && (y>=0 && y<N)){
			return true;
		}else return false;
	}

}
