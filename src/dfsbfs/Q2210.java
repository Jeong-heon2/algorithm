package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*������ ����
5��5 ũ���� �������� �ִ�. ������ ĭ���� ����(digit, 0���� 9����)�� ���� �ִ�.
�� �������� ������ ��ġ���� �����ؼ�, ������ �ִ� �� �������� �ټ� �� �̵��ϸ鼭, 
�� ĭ�� �����ִ� ���ڸ� ���ʷ� ���̸� 6�ڸ��� ���� �ȴ�. 
�̵��� �� ������ �� �� ���ƴ� ĭ�� �ٽ� ���ĵ� �Ǹ�,0���� �����ϴ� 000123�� ���� ���� ���� �� �ִ�.
�������� �־����� ��, ���� �� �ִ� ���� �ٸ� ���� �ڸ��� ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
[�Է�]
�ټ� ���� �ٿ� �ټ� ���� ������ �������� �־�����.
[���]
ù° �ٿ� ���� �� �ִ� ������ ������ ����Ѵ�.
 */
public class Q2210 {
	//6�ڸ� ���� ���� �ڷᱸ��
	static HashSet<String> set = new HashSet<>();
	static int[][] arr;
	//�������� 
	static int[] goR = {1, -1, 0, 0};
	static int[] goC = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		for(int i = 0 ; i < 5 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < 5 ; ++i) {
			for(int j = 0 ; j < 5 ; j++) {
				Bfs(new Point(i, j));
			}
		}
		System.out.println(set.size());
	}
	public static void Bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		while(q.size() > 0) {
			int qSize = q.size();
			for(int i = 0 ; i < qSize ; i++) {
				Point curr = q.poll();
				curr.line += arr[curr.x][curr.y];
				if(curr.line.length() == 6) {
					set.add(curr.line);
					continue;
				}
				
				//�������� ť�� �ֱ�
				for(int j = 0 ; j < 4 ; j ++) {
					Point next = new Point(curr.x + goR[j], curr.y + goC[j]);
					next.line = curr.line;
					if(isRanged(next.x, next.y)) {
						q.add(next);
					}
				}
			}
		}
	}
	public static boolean isRanged(int x, int y) {
		if(x < 0 || x >= 5 || y < 0 || y >= 5) return false;
		else return true;
	}
	static class Point{
		int x;
		int y;
		String line = "";
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
