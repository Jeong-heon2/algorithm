package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[�Է�]
Ʈ���� ���� ��ȸ�� ����� �־�����. ��忡 ����ִ� Ű�� ���� 106���� ���� ���� �����̴�.
��� ���� �� �ٿ� �ϳ��� �־�����, ����� ���� 10,000�� �����̴�. ���� Ű�� ������ ���� ����.

[���]
�Է����� �־��� ���� �˻� Ʈ���� ���� ��ȸ�� ����� �� �ٿ� �ϳ��� ����Ѵ�.
 */
public class Q5639 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String v = br.readLine();
		Tree tree = new Tree(new Node(Integer.parseInt(v)));
		while((v = br.readLine()) != null && v.length() != 0) {
			tree.insert(Integer.parseInt(v));
		}
		tree.postorder(tree.root);
		
	}
	static class Tree{
		Node root;
		public Tree(Node root) {
			this.root = root;
		}
		public void insert(int val) {
			Node thisNode = root;
			do {
				if(thisNode.val > val) {
					if(thisNode.left == null) {
						thisNode.left = new Node(val);
						return;
					}else {
						thisNode = thisNode.left;
					}
				}else {
					if(thisNode.right == null) {
						thisNode.right = new Node(val);
						return;
					}else {
						thisNode = thisNode.right;
					}
				}
			}while(true);
		}
		public void postorder(Node root) {
			if(root != null){ 
				postorder(root.left);
				postorder(root.right);
				System.out.println(root.val);
			}

		}
	}
	static class Node{
		int val;
		Node left;
		Node right;
		Node(int val){
			this.val = val;
		}
	}
}
