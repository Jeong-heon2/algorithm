package kakao;
import java.util.*;
public class Kakao2021BlindQ32 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(s.solution(info, query));

	}
	static class Solution {
	    public static int[] solution(String[] info, String[] query) {
	        int[] answer = {};
	        Trie trie = new Trie();
	        for(String line : info){
	            String[] arr = line.split(" ");
	            trie.insert(arr);
	        }
	        
	        for(int i = 0 ; i < query.length; i++){
	            StringTokenizer st = new StringTokenizer(query[i]);
	            String[] arr = new String[5];
	            int idx = 0;
	            for(int j = 0 ; j < 7; j++){
	                String str = st.nextToken();
	                if(j%2 == 0) arr[idx++] = str;
	            }
	            arr[idx] = st.nextToken();
	            answer[i] = trie.search(arr, 0, trie.root);
	        }
	        return answer;
	    }
	    static class Trie{
	        static TrieNode root;
	        public Trie(){
	            this.root = new TrieNode();
	        }
	        // 자식 노드 추가 
	        static void insert(String[] infos) { 
	            TrieNode thisNode = root; 
	            for (int i = 0; i < infos.length; i++) {
	                if(thisNode.childNodes.containsKey(infos[i])){
	                    thisNode = thisNode.childNodes.get(infos[i]);
	                    thisNode.cnt++;
	                }else{
	                    TrieNode nextNode = new TrieNode();
	                    thisNode.childNodes.put(infos[i], nextNode);
	                    thisNode = nextNode;
	                }
	            } 
	            thisNode.isLastChar = true; 
	        }
	        static int search(String[] query, int idx, TrieNode curNode){
	            int res = 0;
	            if(idx == query.length - 1){
	                for(String key : curNode.childNodes.keySet()){
	                    TrieNode nextNode = curNode.childNodes.get(key);
	                    if(Integer.parseInt(query[idx]) <= Integer.parseInt(key)){
	                        res += nextNode.cnt;
	                    }
	                }
	                return res;
	            }else{
	                if(query[idx].equals("-")){
	                    for(String key : curNode.childNodes.keySet()){
	                        TrieNode nextNode = curNode.childNodes.get(key);
	                        res += search(query, idx+1, nextNode);
	                    }
	                }else{
	                    if(curNode.childNodes.containsKey(query[idx])){
	                        TrieNode nextNode = curNode.childNodes.get(query[idx]);
	                        res += search(query, idx+1, nextNode);
	                    }else{
	                        return 0;
	                    }
	                }
	                return res;
	            }
	        }

	    }
	    static class TrieNode{
	        Map<String, TrieNode> childNodes = new HashMap<>();
	        boolean isLastChar = false;
	        int cnt = 1;
	    }
	}

}
