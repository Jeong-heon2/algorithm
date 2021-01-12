package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//���� �Ҽ� ��� 
public class Q1963 {
	static int num = 9999;
	static int[] arr = new int[10000];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//9999������ �Ҽ��� �̸� ���� 
		//�����佺�׳׽��� ü 
		// 1. �迭�� �����Ͽ� �ʱ�ȭ�Ѵ�.
	    for(int i=2; i<=num; i++) {
	        arr[i] = i;
	    }
	    // 2. 2���� �����ؼ� Ư�� ���� ����� �ش��ϴ� ���� ��� �����.
	    // (���� �� �ڱ��ڽ��� ������ �ʰ�, �̹� ������ ���� �ǳʶڴ�.)
	    for(int i=2;i <= num; i++) {
	        if(arr[i]==0) continue; // �̹� ������ ����� �ǳʶٱ�

	        // �̹� ������ ���ڰ� �ƴ϶��, �� ������� ����Ͽ�, ������ ��� ���� �����
	        for(int j=2*i; j <= num; j+=i) {
	            arr[j] = 0;
	        }
	    }
	    //�Է� �ޱ� 
		//test case
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			System.out.println(String.valueOf(bfs(a,b)));
		}
	}
	public static int bfs(int start, int target) {
		boolean[] visited = new boolean[10000];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		int cnt = 0;
		while(q.size() > 0) {
			int qSize = q.size();
			while(qSize-- > 0) {
				int cur = q.poll();
				//�� �ڸ��� �ٲ㼭 ���ü� �ִ� ��� ����� �� 
				//�� �ڸ��� ���� 
				for(int i = 0 ; i < 4 ; i++) {
					StringBuilder sb = new StringBuilder(String.valueOf(cur));
					//0~9�� ������ �� �ִ�. 
					for(int j = 0; j <= 9 ; j++) {
						sb.setCharAt(i, (char)(j+'0'));
						int next = Integer.parseInt(sb.toString());
						//�湮���� ���� �Ҽ���� 
						if(next >= 1000 && !visited[next] && arr[next] != 0) {
							//ã�� ����� �ٷ� ���� 
							if(next == target) return ++cnt;
							visited[next] = true;
							q.add(next);
						}
					}
				}
			}
			cnt++;
		}
		return 0;
	}
}
