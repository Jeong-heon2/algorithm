package graph;

import java.util.Arrays;
import java.util.HashMap;
/*
 순위
 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항]
선수의 수는 1명 이상 100명 이하입니다.
경기 결과는 1개 이상 4,500개 이하입니다.
results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
모든 경기 결과에는 모순이 없습니다.
 */
//접근법 : 이길 수 있거나 질 수 있는 선수들을 n-1개 알 고 있으면 내 순위를 정할 수 있다.
//해시맵을 이용한 dfs
//다른 사람들은 플로이드 와샬로 많이 풀었다. 플로이드 와샬로도 풀어볼 것.
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
