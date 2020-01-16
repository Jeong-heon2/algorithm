package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//ù° �ٿ�, N�� M�� ���´�.
//N�� 10,000���� �۰ų� ���� �ڿ���, M�� 100,000���� �۰ų� ���� �ڿ����̴�.
//��° �ٺ��� M���� �ٿ� �ŷ��ϴ� ���谡 A B�� ���� �������� ������, 
//"A�� B�� �ŷ��Ѵ�"�� �ǹ��Ѵ�. ��ǻ�ʹ� 1������ N������ ��ȣ�� �ϳ��� �Ű��� �ִ�.
//, A�� B�� �ŷ��ϴ� ��쿡�� B�� ��ŷ�ϸ�, A�� ��ŷ�� �� �ִ�
//ù° �ٿ�, �������� �� ���� ���� ���� ��ǻ�͸� ��ŷ�� �� �ִ� ��ǻ���� ��ȣ�� ������������ ����Ѵ�.
public class Q1325 {
	static ArrayList<ArrayList<Integer>> arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<ArrayList<Integer>>();
		int[] result = new int[N+1];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(0);
		for(int i = 0 ; i <= N ; i ++) {
			arr.add(new ArrayList<Integer>());
		}
		for(int i = 1 ; i <= M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			arr.get(b).add(a); // b�� ��ŷ�Ǹ� a�� ��ŷ �ȴ�
		}
		for(int i = 1; i <= N ; i++) {
			result[i] = BFS(i);
			if(result[i]>result[ans.get(0)]) {
				ans = new ArrayList<Integer>();
				ans.add(i);
			}
			else if(result[i]==result[ans.get(0)]) {
				ans.add(i);
			}
		}
		for(int i = 0 ; i < ans.size(); i ++) {
			System.out.print(ans.get(i)+ " ");
		}
	}
	public static int BFS(int start) {
		ArrayList<Boolean> isMarked = new ArrayList<>();
		for(int i = 0 ; i < arr.size()+1 ; i++) {
			isMarked.add(false);
		}
		ArrayList<Boolean> isinQueue = new ArrayList<>();
		for(int i = 0 ; i < arr.size()+1 ; i++) {
			isinQueue.add(false);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		isinQueue.set(start, true);
		int count = 0;
		while(q.size()>0) {
			int qsize = q.size();
			for(int i = 1 ; i <= qsize ; i++) {
				int curr = q.poll();
				isMarked.set(curr, true);
				for(int e : arr.get(curr)) {
					if(!isinQueue.get(e)&&!isMarked.get(e)) {
						q.add(e);
						isinQueue.set(e, true);
					}
				}
			}
			count++;
		}
		return count;
	}
}
