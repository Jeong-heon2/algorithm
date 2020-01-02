package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//첫째 줄에 유저의 수 N (2 ≤ N ≤ 100)과 친구 관계의 수 M (1 ≤ M ≤ 5,000)이 주어진다. 
//둘째 줄부터 M개의 줄에는 친구 관계가 주어진다. 
//친구 관계는 A와 B로 이루어져 있으며, A와 B가 친구라는 뜻이다.
//A와 B가 친구이면, B와 A도 친구이며, A와 B가 같은 경우는 없다. 
//친구 관계는 중복되어 들어올 수도 있으며, 친구가 한 명도 없는 사람은 없다.
//또, 모든 사람은 친구 관계로 연결되어져 있다.
//첫째 줄에 BOJ의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 출력한다. 
//그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력한다.
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
				BFS(i,userArr);//모든 유저 BFS 돌림
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
				userArr[start].ans = userArr[start].ans + count;//start유저의 친구를 방문할때마다 count 누적 시킴
				//즉, 큐에서 뽑는 순간 = 친구를 탐색한 것 . count = 친구까지의 거리
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
