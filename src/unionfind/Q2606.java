package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
��� �� 1�� ��ǻ�Ͱ� �� ���̷����� �ɷȴ�. ��ǻ���� ���� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ������ �־��� ��,
 1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��� �Ǵ� ��ǻ���� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù° �ٿ��� ��ǻ���� ���� �־�����. 
��ǻ���� ���� 100 �����̰� �� ��ǻ�Ϳ��� 1�� ���� ���ʴ�� ��ȣ�� �Ű�����.
 ��° �ٿ��� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ��ǻ�� ���� ���� �־�����.
  �̾ �� ����ŭ �� �ٿ� �� �־� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ��ǻ���� ��ȣ ���� �־�����.

[���]
1�� ��ǻ�Ͱ� �� ���̷����� �ɷ��� ��, 1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��� �Ǵ� ��ǻ���� ���� ù° �ٿ� ����Ѵ�.
 */
//������ ���ڸ��� union find�� dfs bfs�� Ǯ �� �־����.
public class Q2606 {
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//���� ����
		int N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		for(int i = 0 ; i < N+1 ; i++) {
			parents[i] = i;
		}
		//�� ��
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
