package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//3���� �丶��
//ù �ٿ��� ������ ũ�⸦ ��Ÿ���� �� ���� M,N�� �׾ƿ÷����� ������ ���� ��Ÿ���� H�� �־�����.
//M�� ������ ���� ĭ�� ��, N�� ������ ���� ĭ�� ���� ��Ÿ����. 
//��, 2 �� M �� 100, 2 �� N �� 100, 1 �� H �� 100 �̴�. 
//��° �ٺ��ʹ� ���� ���� ���ں��� ���� ���� ���ڱ����� ����� �丶����� ������ �־�����. 
//��, ��° �ٺ��� N���� �ٿ��� �ϳ��� ���ڿ� ��� �丶���� ������ �־�����.
//�� �ٿ��� ���� �����ٿ� ����ִ� �丶����� ���°� M���� ������ �־�����. 
//���� 1�� ���� �丶��, ���� 0 �� ���� ���� �丶��, ���� -1�� �丶�䰡 ������� ���� ĭ�� ��Ÿ����. 
//�̷��� N���� ���� H�� �ݺ��Ͽ� �־�����.

public class Q7569 {
	static Queue<Points> Q = new LinkedList<Points>();
	static int M;
	static int N;
	static int H;
	static int[][][] arr;
	static int ans=0;
	static boolean[][][] isinQueue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H+1][M+1][N+1]; // �� �� ��
		isinQueue = new boolean[H+1][M+1][N+1];
		int count_0 = 0;
		for(int i = 1 ; i<= H ; i++) {
			for(int j = 1; j<= M ; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int k = 1; k<=N ; k++) {
					int a = Integer.parseInt(st2.nextToken());
					arr[i][j][k] = a;
					if(a==0) count_0 ++;
				}
			}
		}
		for(int i = 1 ; i<= H ; i++) {
			for(int j = 1; j<= M ; j++) {
				for(int k = 1; k<=N ; k++) {
					if(arr[i][j][k]==1) {
						Q.add(new Points(i,j,k));
						isinQueue[i][j][k] = true;
					}
					
				}
			}
		}
		BFS();
		if(count_0 == 0) System.out.println(0);
		else {
			for(int i = 1 ; i<= H ; i++) {
				for(int j = 1; j<= M ; j++) {
					for(int k = 1; k<=N ; k++) {
						if(arr[i][j][k]==0) {
							System.out.println(-1);
							System.exit(0);
						}
					}
				}
			}
			System.out.println(ans-1);
		}
	}
	public static void BFS() {
		while (Q.size()>0) {
			int s = Q.size();
			ans++;
			for(int i = 0 ; i < s ; i++) {
				Points current = Q.poll();
				arr[current.x][current.y][current.z] = 1;
				//�����������Ʒ��� ť�� �ִµ� 
				//���� : Q�� ���� arr[point]�� 0�̰� N,M,H �����ȿ�
				if(((current.z) != N)&&(!isinQueue[current.x][current.y][current.z+1])){
					if(arr[current.x][current.y][current.z+1] == 0) {
						Q.add(new Points(current.x,current.y,current.z+1));
						isinQueue[current.x][current.y][current.z+1] = true;
					}
				}
				if(((current.z-1) != 0)&&(!isinQueue[current.x][current.y][current.z-1])) {
					if(arr[current.x][current.y][current.z-1] == 0) {
						Q.add(new Points(current.x,current.y,current.z-1));
						isinQueue[current.x][current.y][current.z-1] = true;
					}
				}
				if(((current.y) != M)&&(!isinQueue[current.x][current.y+1][current.z])) {
					if(arr[current.x][current.y+1][current.z] == 0) {
						Q.add(new Points(current.x,current.y+1,current.z));
						isinQueue[current.x][current.y+1][current.z] = true;
					}
				}
				if(((current.y-1) != 0)&&(!isinQueue[current.x][current.y-1][current.z])) {
					if(arr[current.x][current.y-1][current.z] == 0) {
						Q.add(new Points(current.x,current.y-1,current.z));
						isinQueue[current.x][current.y-1][current.z] = true;
					}
				}
				if(((current.x) != H)&&(!isinQueue[current.x+1][current.y][current.z])) {
					if(arr[current.x+1][current.y][current.z] == 0) {
						Q.add(new Points(current.x+1,current.y,current.z));
						isinQueue[current.x+1][current.y][current.z] = true;
					}
				}
				if(((current.x-1) != 0)&&(!isinQueue[current.x-1][current.y][current.z])) {
					if(arr[current.x-1][current.y][current.z] == 0) {
						Q.add(new Points(current.x-1,current.y,current.z));
						isinQueue[current.x-1][current.y][current.z]= true;
					}
				}
			}
		}
		return;
	}

}
class Points{
	int x;
	int y;
	int z;
	public Points(int x, int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}