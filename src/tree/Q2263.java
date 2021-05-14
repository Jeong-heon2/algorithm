package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2263 {
	static int n;
	static int in[];
	static int post[];
	static int index[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new int[n];
		post = new int[n];
		index = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <n ;i++) {
			in[i] = Integer.parseInt(st.nextToken());
			index[in[i]] = i;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <n ;i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		findTree(0, n, 0, n);
		System.out.println(sb.toString());
	}
	//input : inorder의 left, right, post order의 left, right
	private static void findTree(int il, int ir, int pl, int pr)throws IOException {
		if(il == ir) return;
		//root 찾기 
		int root = post[pr-1];
		//in order에서 root 위치 찾기 
		int rootIdx = index[root];
		//print root 
		sb.append(root + " ");
		if(rootIdx >= 0) {
			//root의 left 노드로 
			findTree(il, rootIdx, pl, pl+rootIdx-il);// il 부터 rootIdx 까지가 in order의 다음 window.  post order는 pl 부터 같은 크기만큼 
			//root의 right 노드로 
			findTree(rootIdx+1, ir, pl+rootIdx-il, pr-1);
		}
		
	}
}
