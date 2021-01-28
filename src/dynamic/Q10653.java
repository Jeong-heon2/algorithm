package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10653 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		Node[] nodes = new Node[N+1];
		for(int i = 1 ; i <= N ; i++) {
			tmp = br.readLine().split(" ");
			nodes[i] = new Node(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}
		//i�������� j�� �ǳʶ� �ּҰŸ� = min (i-1�� �ǳʶپ j�� �ǳʶٰ� �Ǵ� ���,  i-1������ j�� �ǳʶٰ� i-1���� �ǳʶ��� �ʴ� ��� ) 
		//dp[i][j] =  MIN ( dp[i-2][j-1] + distance( i-2, i)  ,  dp[i-1][j] + distance(i-1, i )  ) 
		int[][] dp = new int[N+1][K+1];
		int temp = getDistance(nodes[2], nodes[1]);
		
		for(int i = 0 ; i <= K; i++) {
			dp[2][i] = temp;
		}
		
		for(int i = 3 ; i <= N ; i++) {
			temp = getDistance(nodes[i-1], nodes[i]);
			dp[i][0] = dp[i-1][0] + temp;
			for(int j = 1 ; j <= K ; j++) {
				if(j > i - 2) break;
				dp[i][j] = Math.min(dp[i-2][j-1] + getDistance(nodes[i-2], nodes[i]), dp[i-1][j] + temp);
			}
		}
		System.out.println(dp[N][K]);
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
