package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//사람들은 1, 2, 3, …, n (1≤n≤100)의 연속된 번호로 각각 표시된다. 
//입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고,
//둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
//그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 
//넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 
//이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
//각 사람의 부모는 최대 한 명만 주어진다.
//입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 
//어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 
//이때에는 -1을 출력해야 한다.
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
