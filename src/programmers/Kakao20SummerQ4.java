package programmers;

public class Kakao20SummerQ4 {
	static int ans = Integer.MAX_VALUE;
	static int[] goY = { 1,-1,0,0};
	static int[] goX = { 0,0,1,-1};
	//����
	static int N;
	//����
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
	//state : false ����  state true : �¿� ;
	public static void dfs(boolean[][] visited, int x, int y,int cost,boolean state) {
		if((x==M-1) && (y==N-1)) {
			ans = Math.min(cost, ans);
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {// i �� 0 ~ 3  ��������
			int nextX = x+goX[i];
			int nextY = y+goY[i];
			if(isRanged(nextX,nextY) && !isRock(nextX,nextY)) {
				if(!visited[nextX][nextY]) {
					//�湮����
					if(cost == 0) {
						switch (i) {
							case 1 : 
							case 0 :{//�¿����
								visited[nextX][nextY]= true;
								dfs(visited,nextX,nextY,cost + 100, true);
								visited[nextX][nextY]= false;
								break;
							}
							case 2 :
							case 3 :{//���Ϲ���
								visited[nextX][nextY]= true;
								dfs(visited,nextX,nextY,cost + 100, false);
								visited[nextX][nextY]= false;
								break;
							}
						}
					}else {
						if(state) {//�������� ������ �¿� ���
							switch (i) {
								case 1 : 
								case 0 :{//������ ���� ���  ���� ���� ���  ��, ��ȭ���� �ڳ� �ƴ�
									visited[nextX][nextY]= true;
									dfs(visited,nextX,nextY,cost + 100, state);
									visited[nextX][nextY]= false;
									break;
								}
								case 2 :
								case 3 :{//�ڳ���
									visited[nextX][nextY]= true;
									dfs(visited,nextX,nextY,cost + 500, !state);
									visited[nextX][nextY]= false;
									break;
								}
							}
						}else if(!state) {//���� ���
							switch (i) {
								case 1 : 
								case 0 :{//������ ���� ���  ���� ���� ���  ��, �ڳ���
									visited[nextX][nextY]= true;
									dfs(visited,nextX,nextY,cost + 500, !state);
									visited[nextX][nextY]= false;
									break;
								}
								case 2 :
								case 3 :{//�ڳʾƴ�
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
	//x�� y�� �������� ������ ��ġ
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
