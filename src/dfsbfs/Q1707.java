package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*입력은 여러 개의 테스트 케이스로 구성되어 있는데, 
첫째 줄에 테스트 케이스의 개수 K(2≤K≤5)가 주어진다.
각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V(1≤V≤20,000)와 
간선의 개수 E(1≤E≤200,000)가 빈 칸을 사이에 두고 순서대로 주어진다.
각 정점에는 1부터 V까지 차례로 번호가 붙어 있다.
이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 
각 줄에 인접한 두 정점의 번호가 빈 칸을 사이에 두고 주어진다.
K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.*/
public class Q1707 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			for(int j = 0 ; j <= V; j++) {
				arr.add(new ArrayList<Integer>());
			}
			for(int j = 1; j <= E ; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st2.nextToken());
				arr.get(v1).add(v2);
				arr.get(v2).add(v1);
			}
		}
	}
	public static void BFS(ArrayList<ArrayList<Integer>> G, int start) {
		ArrayList<Boolean> isMarked = new ArrayList<>();
		for(int i = 0 ; i < G.size()+1 ; i++) {
			isMarked.add(false);
		}
		ArrayList<Boolean> isinQueue = new ArrayList<>();
		for(int i = 0 ; i < G.size()+1 ; i++) {
			isinQueue.add(false);
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		isinQueue.set(start, true);
		while(Q.size()>0) {
			
		}
	}

}
