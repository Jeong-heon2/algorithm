package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[입력]
트리를 전위 순회한 결과가 주어진다. 노드에 들어있는 키의 값은 106보다 작은 양의 정수이다.
모든 값은 한 줄에 하나씩 주어지며, 노드의 수는 10,000개 이하이다. 같은 키를 가지는 노드는 없다.

[출력]
입력으로 주어진 이진 검색 트리를 후위 순회한 결과를 한 줄에 하나씩 출력한다.
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
