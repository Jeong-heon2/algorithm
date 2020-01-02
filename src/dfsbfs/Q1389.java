package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//ù° �ٿ� ������ �� N (2 �� N �� 100)�� ģ�� ������ �� M (1 �� M �� 5,000)�� �־�����. 
//��° �ٺ��� M���� �ٿ��� ģ�� ���谡 �־�����. 
//ģ�� ����� A�� B�� �̷���� ������, A�� B�� ģ����� ���̴�.
//A�� B�� ģ���̸�, B�� A�� ģ���̸�, A�� B�� ���� ���� ����. 
//ģ�� ����� �ߺ��Ǿ� ���� ���� ������, ģ���� �� �� ���� ����� ����.
//��, ��� ����� ģ�� ����� ����Ǿ��� �ִ�.
//ù° �ٿ� BOJ�� ���� �߿��� �ɺ� �������� ���� ���� ���� ����� ����Ѵ�. 
//�׷� ����� ���� ���� ��쿡�� ��ȣ�� ���� ���� ����� ����Ѵ�.
public class Q1389 {
	static int MAX = 100;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		User[] userArr = new User[MAX+1];
		int ans = 0;
		for(int i = 1 ; i <= M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			if(userArr[a] == null) {
				userArr[a] = new User();
				userArr[a].freind.add(b);
			}
			else {
				userArr[a].freind.add(b);
			}
			
			if(userArr[b] == null) {
				userArr[b] = new User();
				userArr[b].freind.add(a);
			}
			else {
				userArr[b].freind.add(a);
			}
		}
		for(int i = 1 ; i <= MAX; i++) {
			if(userArr[i] != null) {
				BFS(i,userArr);//��� ���� BFS ����
			}
		}
		for(int i = 1 ; i <= MAX; i++) {
			if(userArr[i] != null) {
				if(ans == 0) {
					ans = i;
				}
				else {
					if(userArr[ans].ans > userArr[i].ans) ans = i;
				}
			}
		}
		System.out.println(ans);
		
	}
	private static void BFS(int start,User[] userArr) {
		ArrayList<Boolean> isinQueue = new ArrayList<>();
		for(int i = 0 ; i <= 100 ; i++) {
			isinQueue.add(false);
		}
		ArrayList<Boolean> isMarked = new ArrayList<>();
		for(int i = 0 ; i <= 100 ; i++) {
			isMarked.add(false);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		isinQueue.set(start, true);
		int count = 0;
		while(q.size()>0) {
			int qsize = q.size();
			for(int j = 0 ; j<qsize; j++) {
				int curr = q.poll();
				userArr[start].ans = userArr[start].ans + count;//start������ ģ���� �湮�Ҷ����� count ���� ��Ŵ
				//��, ť���� �̴� ���� = ģ���� Ž���� �� . count = ģ�������� �Ÿ�
				isMarked.set(curr, true);
				for(int e : userArr[curr].freind) {
					if(!isMarked.get(e) && !isinQueue.get(e)) {
						q.add(e);
						isinQueue.set(e, true);
					}
				}
			}
			count++;
		}
		return;
	}
	
}
class User{
	ArrayList<Integer> freind = new ArrayList<Integer>();
	int ans;
}
