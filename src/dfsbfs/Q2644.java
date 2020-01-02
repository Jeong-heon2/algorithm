package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//������� 1, 2, 3, ��, n (1��n��100)�� ���ӵ� ��ȣ�� ���� ǥ�õȴ�. 
//�Է� ������ ù° �ٿ��� ��ü ����� �� n�� �־�����,
//��° �ٿ��� �̼��� ����ؾ� �ϴ� ���� �ٸ� �� ����� ��ȣ�� �־�����.
//�׸��� ��° �ٿ��� �θ� �ڽĵ� ���� ������ ���� m�� �־�����. 
//��° �ٺ��ʹ� �θ� �ڽİ��� ���踦 ��Ÿ���� �� ��ȣ x,y�� �� �ٿ� ���´�. 
//�̶� �տ� ������ ��ȣ x�� �ڿ� ������ ���� y�� �θ� ��ȣ�� ��Ÿ����.
//�� ����� �θ�� �ִ� �� �� �־�����.
//�Է¿��� �䱸�� �� ����� �̼��� ��Ÿ���� ������ ����Ѵ�. 
//� ��쿡�� �� ����� ģô ���谡 ���� ���� �̼��� ����� �� ���� ���� �ִ�. 
//�̶����� -1�� ����ؾ� �Ѵ�.
public class Q2644 {
	static ArrayList<Boolean> isMarked = new ArrayList<Boolean>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i <= 100 ; i++) {
			list.add(new ArrayList<Integer>());
			isMarked.add(true);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int targetA = Integer.parseInt(st.nextToken());
		int targetB = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M ; i ++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
			isMarked.set(a, false);
			isMarked.set(b, false);
		}
		for(int i = 0 ; i < list.size() ; i++) {
			if(!isMarked.get(i)) {
				if(i==targetA) {
					int ans = BFS(i,targetB);
					if(ans != -1) {
						System.out.println(ans);
						System.exit(0);
					}
				}
				else if(i==targetB) {
					int ans = BFS(i,targetA);
					if(ans != -1) {
						System.out.println(ans);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(-1);
	}
	private static int BFS(int start,int target) {
		ArrayList<Boolean> isinQueue = new ArrayList<>();
		for(int i = 0 ; i <= 100 ; i++) {
			isinQueue.add(false);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		isinQueue.set(start, true);
		int count = 0;
		while(q.size()>0) {
			int qsize = q.size();
			for(int j = 0 ; j<qsize; j++) {
				int curr = q.poll();
				isMarked.set(curr, true);
				if(curr == target) return count;
				for(int i : list.get(curr)) {
					if(!isinQueue.get(i) && !isMarked.get(i)) {
						q.add(i);
						isinQueue.set(i,true);
					}
				}
			}
			count++;
		}
		return -1;
	}
}
