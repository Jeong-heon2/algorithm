package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
���� 1976 Union find
�����̴� ģ����� �Բ� ������ ������ �Ѵ�.
�ѱ����� ���ð� N�� �ְ� ������ �� ���� ���̿� ���� ���� ����, ���� ���� �ִ�.

���õ��� ������ ���õ� ���� ���� ���ΰ� �־��� �ְ�,
�������� ���� ��ȹ�� ���� ���õ��� ������� �־����� ��(�ߺ� ����) �������� ���θ� �Ǻ��ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù �ٿ� ������ �� N�� �־�����. N�� 200�����̴�. ��° �ٿ� ���� ��ȹ�� ���� ���õ��� �� M�� �־�����. M�� 1000�����̴�. ���� N * N ����� ���� ������ �� ���ð� ����Ǿ������� ���� ������ �־�����. 1�̸� ����� ���̰� 0�̸� ������ ���� ���� ���̴�. A�� B�� ����Ǿ����� B�� A�� ����Ǿ� �ִ�. ������ �ٿ��� ���� ��ȹ�� �־�����.

[���]
ù �ٿ� �����ϸ� YES �Ұ����ϸ� NO�� ����Ѵ�.
 */
public class Q1976 {
	static int[] cities ;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//������ �� 
		int N = Integer.parseInt(br.readLine());
		//���� ��ȹ�� ���� ���õ��� ��
		int M = Integer.parseInt(br.readLine());
		//union find graph
		cities = new int[N+1];
		for(int i = 0 ; i < N+1; i++) {
			cities[i] = i;
		}
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//i ���ÿ� ����� ���õ��� ����
			for(int j = 1 ; j <= N ; j++) {
				int city = Integer.parseInt(st.nextToken());
				if(city == 1) {
					//union i,j
					if(j > i) union(i, j);	
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int next;
		while(st.hasMoreTokens()) {
			next = Integer.parseInt(st.nextToken());
			if(!isUnion(from, next)) {
				System.out.println("NO");
				System.exit(0);
			}
			from = next;
		}
		System.out.println("YES");

	}
	public static int find(int x) {
		if(cities[x] == x) {
			return x;
		}else {
			return cities[x] = find(cities[x]);
		}
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if( x != y) {
			if(y > x) {
				cities[y] = x;
			}else {
				cities[x] = y;
			}
		}
	}
	public static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		else return false;
	}

}
