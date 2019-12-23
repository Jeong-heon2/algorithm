package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//���ϻ���
//ũ�Ⱑ N��N�� �׸����� �� ĭ�� R(����), G(�ʷ�), B(�Ķ�) �� �ϳ��� ��ĥ�� �׸��� �ִ�. 
//�׸��� �� ���� �������� �������� �ִµ�, ������ ���� ������ �̷���� �ִ�. 
//��, ���� ������ �����¿�� ������ �ִ� ��쿡 �� ���ڴ� ���� ������ ���Ѵ�. 
//�׸��� �Է����� �־����� ��, ���ϻ����� ����� ���� ���� �ƴ� ����� ���� �� ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
public class Q10026 {
	static char[][] x_arr;//���ϻ���
	static char[][] arr;//�Ϲ���
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
		int x_ans=0;
		int ans=0;
		arr = new char[N+1][N+1];
		x_arr = new char[N+1][N+1];
		for(int i = 1 ; i <= N ; i ++) {
			String line = br.readLine();
			for(int j = 1 ; j<=N; j++) {
				arr[i][j] = line.charAt(j-1);
				x_arr[i][j] = line.charAt(j-1);
			}
		}
		
		for(int i = 1; i <= N ;i ++) {
			for(int j = 1; j<=N; j++) {
				if(arr[i][j] == 'R') {
					recursiveDFS(arr,i,j,'R');
					ans++;
				}
				else if(arr[i][j]=='G') {
					recursiveDFS(arr,i,j,'G');
					ans++;
				}else if(arr[i][j] == 'B'){
					recursiveDFS(arr,i,j,'B');
					ans++;
				}
			}
		}
		System.out.print(ans+" ");
		
		for(int i = 1; i <= N ;i ++) {
			for(int j = 1; j<=N; j++) {
				if(x_arr[i][j] == 'R') {
					x_recursiveDFS(x_arr,i,j,'R');
					x_ans++;
				}
				else if(x_arr[i][j]=='G') {
					x_recursiveDFS(x_arr,i,j,'G');
					x_ans++;
				}else if(x_arr[i][j] == 'B'){
					x_recursiveDFS(x_arr,i,j,'B');
					x_ans++;
				}
			}
		}
		System.out.print(x_ans);
	}
	public static void recursiveDFS(char[][] G, int startX, int startY, char color) {
		if(G[startX][startY] != color) return;
		else {
			G[startX][startY] = 'x';
			//�������� �湮
			if(startY != N) recursiveDFS(G,startX,startY+1,color);
			if(startY != 1) recursiveDFS(G,startX,startY-1,color);
			if(startX != N) recursiveDFS(G,startX+1,startY,color);
			if(startX != 1) recursiveDFS(G,startX-1,startY,color);
			return;
		}
	}
	public static void x_recursiveDFS(char[][] G, int startX, int startY, char color) {
		if(G[startX][startY] != color) {
			if((G[startX][startY] == 'x')||G[startX][startY] == 'B' || (color == 'B')) return;
		}
		
		G[startX][startY] = 'x';
		//�������� �湮
		if(startY  != N) x_recursiveDFS(G,startX,startY+1,color);
		if(startY  != 1) x_recursiveDFS(G,startX,startY-1,color);
		if(startX  != N) x_recursiveDFS(G,startX+1,startY,color);
		if(startX  != 1) x_recursiveDFS(G,startX-1,startY,color);
		return;
		
	}
}
