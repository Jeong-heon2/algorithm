package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
입력]
첫째 줄에 트리의 노드의 개수 N이 주어진다. 
N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 0번 노드부터 N-1번 노드까지, 각 노드의 부모가 주어진다. 
만약 부모가 없다면 (루트) -1이 주어진다. 셋째 줄에는 지울 노드의 번호가 주어진다.

출력]
첫째 줄에 입력으로 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력한다.
 */
//접근법 : bfs 
public class Q1068 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer>[] arr = (ArrayList<Integer>[])new ArrayList[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = new ArrayList<>();
		}
		//root node 
		int rootN = 0;
		for(int i = 0 ; i < N ; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(cur != -1) {
				arr[cur].add(i);
			}else {
				rootN = i;
			}
		}
		//bfs
		int ans = 0;
		arr[Integer.parseInt(br.readLine())] = null;
		Queue<Integer> q = new LinkedList<>();
		q.add(rootN);
		while(q.size() > 0) {
			int curr = q.poll();
			boolean check = true;
			//root가 지워졌을 수도있음.
			if(arr[curr] != null) {
				for(int next : arr[curr]) {
					if(arr[next] != null) {
						q.add(next);
						check = false;
					}
				}
				//자식 노드를 큐에 추가하지못했다 > 리프 노드다. 
				if(check) ans++;
			}
		}
		System.out.println(ans);

	}
}
