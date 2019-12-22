package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] count = new int[100001];
		BFS(count,N,M);
		System.out.println(count[M]);
	}
	public static void BFS(int[] count, int start, int target) {
		if(start == target) return;
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		int j = 1;// ���� ����
		while(count[target] == 0) {//target��ġ�� �� �� ���� ������ �Ǹ� �װ��� ����
			int qsize = Q.size();
			for(int i = 0 ; i < qsize ; i++) {//ť���� �ϳ��� �̾Ƽ� �湮�� �� üũ
				int current = Q.poll();
				if((current-1)>=0) {
					if((count[current-1] > j) || (count[current-1]==0 && (current-1 !=start)) ) {//j������ �ü��ִµ� �� ū���� �����Ƿ�
						count[current-1] = j;//��������� j������ �ü��ִ�.
						if(current-1 == target) break;
						Q.add(current-1);//���� �湮�� ��
					}
				}
				if((current+1) <= 100000) {
					if((count[current+1] > j) || (count[current+1]==0)&& (current+1 !=start)) {
						count[current+1] = j;
						if(current+1 == target) break;
						Q.add(current+1);
					}
				}
				if((current*2) <= 100000) {
					if((count[current*2] > j) || (count[current*2]==0)&& (current*2 !=start)) {
						count[current*2] = j;
						if(current*2 == target) break;
						Q.add(current*2);
					}	
				}
			}
			j++;
		}
		return;
	}
}
