package kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//�Է��� �����鼭 �ּ� ����ġ ������ ����  ���� ���� �����Ϸ� �ߴ�.
//������ �� ����� �˰��� ��ü�� Ʋ�ȴ�..
public class Q2887_2 {
	static int N;//��� ���� 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		int ans = 0;
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
					, Integer.parseInt(st.nextToken()));
			int res = Integer.MAX_VALUE;
			if(list.size() != 0) {
				for(int j = 0 ; j < list.size() ; j++) {
					Node node2 = list.get(j);
					int val = Math.min(Math.abs(node2.z - node.z), 
								Math.min(Math.abs(node2.x - node.x), 
										Math.abs(node2.y - node.y)));
					if(val < res ) res = val;
				}
				ans += res;
			}
			list.add(node);
		}
		System.out.println(ans);
	}
	static class Node {
		int x;
		int y;
		int z;
		Node(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	
}