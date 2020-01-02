package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*ù ��° �ٿ��� ������ ����, ���� ũ�⸦ �ǹ��ϴ� �� ���� N, M (3 �� N, M �� 10)�� �־�����.
���� N���� �ٿ� ������ ����� ��Ÿ���� ���� M�� ���ڿ��� �־�����. 
�� ���ڿ��� '.', '#', 'O', 'R', 'B' �� �̷���� �ִ�. '.'�� �� ĭ�� �ǹ��ϰ�,
'#'�� ���� �̵��� �� ���� ��ֹ� �Ǵ� ���� �ǹ��ϸ�, 'O'�� ������ ��ġ�� �ǹ��Ѵ�. 'R'�� ���� ������ ��ġ,
'B'�� �Ķ� ������ ��ġ�̴�.
�ԷµǴ� ��� ������ �����ڸ����� ��� '#'�� �ִ�. 
������ ������ �� �� �̸�, ���� ������ �Ķ� ������ �׻� 1���� �־�����.
�Ķ� ������ ���ۿ� ���� �����鼭 ���� ������ 10�� ���Ϸ� �������� ���� �� ������ 1�� ������ 0�� ����Ѵ�.
*/
//dfs ��������  ���� ��ġ�� ���� ����  10ȸ�� �Ѿ�����, R B�� ��ġ����, ���ۿ� �������� üũ ���ְ� 
//B�� �����ų� RB�� ��ġ�� �����Ѵ�, �� �� ���� �ƴ� ����� ���̴�. �׳� �������ش�.
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
		N = Integer.parseInt(st.nextToken());//����
		M = Integer.parseInt(st.nextToken());//����
		int rX = 0;
		int rY = 0;
		int bX = 0;
		int bY = 0;
		char[][] arr = new char[N][M];
		for(int i = 0; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = str.charAt(j);
				if(str.charAt(j) == 'R') {//�̶��� .���� �ޱ�
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
			//��������
			int i = 1;
		
			if(G[rX][rY+1] == '#') {//��
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
			
			if(G[rX][rY-1] == '#') {//��
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
			if(G[rX+1][rY] == '#') {//��
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
			if(G[rX-1][rY] == '#') {//��
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
