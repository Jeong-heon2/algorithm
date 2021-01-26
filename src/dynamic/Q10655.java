package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10655 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//dp[i] = min( dp[i-1] + distance(i, i-1) , arr[i-2] + distance(i, i-2) ) 
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		int[] arr = new int[N];
		Node[] nodes = new Node[N];
		for(int i = 0 ; i < N ; i++) {
			String[] tmp = br.readLine().split(" ");
			nodes[i] = new Node(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}
		arr[0] = 0;
		arr[1] = getDistance(nodes[0], nodes[1]);
		dp[0] = 0;
		dp[1] = getDistance(nodes[0], nodes[1]);
		int pre = 0;
		for(int i = 2 ; i < N ; i++) {
			int tmp = getDistance(nodes[i], nodes[i-1]);
			arr[i] = arr[i-1] + tmp;
			dp[i] = Math.min(dp[i-1] + tmp , arr[i-2] + getDistance(nodes[i], nodes[i-2]));
		}
		System.out.println(dp[N-1]);
	}
	public static int getDistance(Node i, Node j) {
		return Math.abs(i.x - j.x) + Math.abs(i.y - j.y);
	}
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
