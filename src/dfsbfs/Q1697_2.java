package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
���� Q1697 ���ٲ���
�����̴� ������ ���ٲ����� �ϰ� �ִ�. 
�����̴� ���� �� N(0 �� N �� 100,000)�� �ְ�, ������ �� K(0 �� K �� 100,000)�� �ִ�.
 �����̴� �Ȱų� �����̵��� �� �� �ִ�. ����, �������� ��ġ�� X�� �� �ȴ´ٸ� 1�� �Ŀ� X-1 �Ǵ� X+1�� �̵��ϰ� �ȴ�. 
 �����̵��� �ϴ� ��쿡�� 1�� �Ŀ� 2*X�� ��ġ�� �̵��ϰ� �ȴ�.
�����̿� ������ ��ġ�� �־����� ��, �����̰� ������ ã�� �� �ִ� ���� ���� �ð��� �� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
//dfs ����Լ� : stackoverflow
public class Q1697_2 {
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		//�Է¹ޱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//������ ��ġ
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		DFS(0,N,K,0);
		System.out.println(ans);

	}
	//curr: �������� ����ġ , target : ������ ��ġ , count : ������ Ƚ
	public static void DFS(int visited, int curr, int target, int count) {
		//������ ����ų� �̹� �湮�� ���̶�� return
		if(!isRanged(curr) || (visited & (1 << curr)) == 1) {
			return;
		}
		//������ ��ġ�� ���������� ans�� count ���� ans ���� �۴ٸ� ans ����
		if(curr == target) {
			if(ans > count) ans = count;
			return;
		}
		//�� ��ġ �湮 ǥ��, ���� ��ġ�� �̵�
		visited = visited | 1 << curr;
		count++;
		//������ ������ �� �ִ� ����� ���� 3����
		//�����̵� , �ڷ� ��ĭ �̵�, ������ �� ĭ �̵�
		DFS(visited, curr-1, target, count);
		DFS(visited, curr+1, target, count);
		DFS(visited, curr*2, target, count);
		//��Ʈ��ŷ
		visited = visited & ~1 << curr;
		return;
		
		
	}
	public static boolean isRanged(int curr) {
		if(0<=curr && curr<=100000) return true;
		else return false;
	}
}
