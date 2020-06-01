package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
���� 1717 ������ ǥ��
ù° �ٿ� n(1��n��1,000,000), m(1��m��100,000)�� �־�����. m�� �Է����� �־����� ������ �����̴�.
 ���� m���� �ٿ��� ������ ������ �־�����. �������� 0 a b�� ���·� �Է��� �־�����. 
 �̴� a�� ���ԵǾ� �ִ� ���հ�, b�� ���ԵǾ� �ִ� ������ ��ģ�ٴ� �ǹ��̴�. 
 �� ���Ұ� ���� ���տ� ���ԵǾ� �ִ����� Ȯ���ϴ� ������ 1 a b�� ���·� �Է��� �־�����. 
 �̴� a�� b�� ���� ���տ� ���ԵǾ� �ִ����� Ȯ���ϴ� �����̴�. 
 a�� b�� n ������ �ڿ��� �Ǵ� 0�̸� ���� ���� �ִ�.

[���]
1�� �����ϴ� �Է¿� ���ؼ� �� �ٿ� �ϳ��� YES/NO�� ����� ����Ѵ�. (yes/no �� ����ص� �ȴ�)
 */
public class Q1717 {
	static int[] parents ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		for(int i = 0 ; i < N+1 ; i++) {
			parents[i] = i;
		}
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int toDo = Integer.parseInt(st.nextToken());//0 : Union , 1 : isSameParent
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			//union
			if(toDo == 0) {
				if(node1 > node2) union(node2, node1);
				else union(node1, node2);
			}else {
				//print
				if(isSameParent(node1,node2)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}else {
			return parents[x] = find(parents[x]);
		}
	}
	// y > x ���� ��.
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parents[x] = y;
	}
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) {
			return true;
		}else return false;
	}

}
