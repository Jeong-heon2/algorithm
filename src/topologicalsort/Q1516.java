package topologicalsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1516 {
	static ArrayList<Integer>[] arr;
	static int[] indegree;
	static int N;
	static int[] weight;
	static int[] dp;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N= Integer.parseInt(br.readLine());
		indegree = new int[N+1];
		weight = new int[N+1];
		dp = new int[N+1];//dp[i] : i�� �ǹ��� �ִܽð� 
		arr = new ArrayList[N+1];
		
		for(int i = 1 ; i <= N ;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w =  Integer.parseInt(st.nextToken());
			dp[i] = w;
			weight[i] = w;
			while(true) {
				int node = Integer.parseInt(st.nextToken());
				if(node == -1) break;
				//node�� i�� ����Ŵ 
				arr[node].add(i);
				indegree[i]++;
			}
		}
		topologicalsort();
		for(int i = 1 ; i <= N ; i++) {
			bw.write(dp[i]+"\n");
		}
		bw.flush();
		bw.close();br.close();
	}
	private static void topologicalsort() {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> resQ = new LinkedList<>();
		for(int i = 1 ; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			resQ.offer(cur);
			for(int next : arr[cur]) {
				//next�� �ǹ� ���忡��, ���� ���������� �ǹ��� cur�� �ǹ� ���� �ٸ� ���� ���� �� �ִ�. 
				//���� �ǹ��� ��� ������ �� next�� �������� �ϹǷ�  Math.max .
				dp[next] = Math.max(dp[cur]+weight[next], dp[next]);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}

}
