package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//첫째 줄에, N과 M이 들어온다.
//N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다.
//둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, 
//"A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.
//, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다
//첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.
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
			arr.get(b).add(a); // b가 해킹되면 a도 해킹 된다
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
