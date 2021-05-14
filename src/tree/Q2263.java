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
	//input : inorder�� left, right, post order�� left, right
	private static void findTree(int il, int ir, int pl, int pr)throws IOException {
		if(il == ir) return;
		//root ã�� 
		int root = post[pr-1];
		//in order���� root ��ġ ã�� 
		int rootIdx = index[root];
		//print root 
		sb.append(root + " ");
		if(rootIdx >= 0) {
			//root�� left ���� 
			findTree(il, rootIdx, pl, pl+rootIdx-il);// il ���� rootIdx ������ in order�� ���� window.  post order�� pl ���� ���� ũ�⸸ŭ 
			//root�� right ���� 
			findTree(rootIdx+1, ir, pl+rootIdx-il, pr-1);
		}
		
	}
}
