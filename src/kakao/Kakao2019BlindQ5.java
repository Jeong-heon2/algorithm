package kakao;

import java.util.Arrays;

import utils.ArrayInputConvert;

public class Kakao2019BlindQ5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = ArrayInputConvert.convertInput("[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]");
		System.out.println(str);
		int[][] arr = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		Solution s = new Solution();
		
		int[][] res = s.solution(arr);
	}
	static class Solution {
	    int[] pre;
	    int[] post;
	    int idx;
	    public int[][] solution(int[][] nodeinfo) {
	        int[][] answer = new int[2][nodeinfo.length];
	        pre = new int[nodeinfo.length];
	        post = new int[nodeinfo.length];
	        
	        Node[] arr = new Node[nodeinfo.length];
	        //트리의 root를 찾고
	        for(int i = 0 ; i < nodeinfo.length ; i++){
	            arr[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
	        }
	        Arrays.sort(arr);
	        //트리에 노드들을 집어넣고
	        Tree tree = new Tree(arr[0]);
	        for(int i = 1; i < arr.length; i++){
	            tree.insert(arr[i]);
	        }
	        //전위 후위 순회를 돌린다. 
	        idx = 0;
	        tree.preorder(tree.root);
	        idx = 0;
	        tree.postorder(tree.root);
	        answer[0] = pre;
	        answer[1] = post;
	        return answer;
	    }
	    //이진트리를 구현 
	    //각각의 노드들은 번호가 부여된다. 
	    class Tree{
	        Node root;
	        public Tree(Node root){
	            this.root = root;
	        }
	        public void insert(Node node){
	            Node thisNode = root;
	            while(true){
	                if(thisNode.x < node.x){
	                    //오른쪽으로
	                    if(thisNode.right == null){
	                        thisNode.right = node;
	                        break;
	                    }else{
	                        thisNode = thisNode.right;
	                    }
	                }else{
	                    //왼쪽으로 
	                    if(thisNode.left == null){
	                        thisNode.left = node;
	                        break;
	                    }else{
	                        thisNode = thisNode.left;
	                    }
	                }
	            }
	        }
	        public void preorder(Node root){
	            if(root == null){
	                return;
	            }else{
	                pre[idx++] = root.n;
	                preorder(root.left);
	                preorder(root.right);
	            }
	        }
	        public void postorder(Node root){
	            if(root == null){
	                return;
	            }else{
	                postorder(root.left);
	                postorder(root.right);
	                post[idx++] = root.n;
	            }
	        }
	        
	    }
	    class Node implements Comparable<Node>{
	        int x;
	        int y;
	        int n;
	        Node left;
	        Node right;
	        public Node(int x, int y, int n){
	            this.x = x;
	            this.y = y;
	            this.n = n;
	        }
	        @Override
			public int compareTo(Node o) {
				if(y < o.y) return 1;
				else if(y == o.y) {
	                if(x > o.x) return 1;
	                else return -1;
	            }
				else{
	                return -1;
	            }
			}
	    }
	    
	}

}
