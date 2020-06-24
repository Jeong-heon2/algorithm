package graph;

import java.util.Arrays;
import java.util.HashMap;
/*
 ����
 ������ �� n, ��� ����� ���� 2���� �迭 results�� �Ű������� �־��� �� ��Ȯ�ϰ� ������ �ű� �� �ִ� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���]
������ ���� 1�� �̻� 100�� �����Դϴ�.
��� ����� 1�� �̻� 4,500�� �����Դϴ�.
results �迭 �� �� [A, B]�� A ������ B ������ �̰�ٴ� �ǹ��Դϴ�.
��� ��� ������� ����� �����ϴ�.
 */
//���ٹ� : �̱� �� �ְų� �� �� �ִ� �������� n-1�� �� �� ������ �� ������ ���� �� �ִ�.
//�ؽø��� �̿��� dfs
//�ٸ� ������� �÷��̵� �ͼ��� ���� Ǯ����. �÷��̵� �ͼ��ε� Ǯ� ��.
public class PGgraph02 {
	static Node[] nodes;
	static boolean[] visited;
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
	}
	public static int solution(int n, int[][] results) {
        nodes = new Node[n+1];
        visited = new boolean[n+1];
        for(int i = 1 ; i<=n ; i++){
            nodes[i] = new Node(i);
        }
        for(int i = 0 ; i < results.length; i ++){
            int strong = results[i][0];
            int weak = results[i][1];
            nodes[strong].weak.put(weak, nodes[weak]);
            nodes[weak].strong.put(strong, nodes[strong]);
        }
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
        	Arrays.fill(visited, false);
            int strongCnt = nodes[i].getStrongCnt(nodes[i].strong);
            Arrays.fill(visited, false);
            int weakCnt = nodes[i].getWeakCnt(nodes[i].weak);
            if(strongCnt + weakCnt >= n-1 ) {
            	ans++;
            }
        }
        return ans;
    }
    static class Node{
        HashMap<Integer, Node> strong = new HashMap<>();
        HashMap<Integer, Node> weak = new HashMap<>();
        int num;
        Node(int num){
            this.num = num;
        }
        int getStrongCnt(HashMap<Integer, Node> map){
            if(map.size() == 0){
                return 0;
            }else{
                int res = 0;
                for(int i : map.keySet()){
                	if(!visited[i]) {
                		visited[i] = true;
                		res++;
                		res += getStrongCnt(nodes[i].strong);
                	}
                    
                }
                return res;
            }
        }
        int getWeakCnt(HashMap<Integer, Node> map) {
        	if(map.size() == 0){
                return 0;
            }else{
                int res = 0;
                for(int i : map.keySet()){
                	if(!visited[i]) {
                		visited[i] = true;
                		res++;
                		res += getWeakCnt(nodes[i].weak);
                	}
                }
                return res;
            }
        }
    }

}
