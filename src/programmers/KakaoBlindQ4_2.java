package programmers;

import java.util.HashMap;
import java.util.Map;

//Trie , hashmap
//참고 https://biewoom.github.io/non-linear-ds/advanced-ds/2020/04/14/Trie.html
//Trie에 대해서 더 깊이 공부해야한다.
public class KakaoBlindQ4_2 {

	public static void main(String[] args) {
		

	}
	public static int[] solution (String[] words,String[] queries) {
		Trie[] tries = new Trie[100001];
        for (String word : words) {  
            int len = word.length();
            //길이에 맞는 위치에 넣어준다
            if (tries[len] == null) tries[len] = new Trie();
            tries[len].insert(word);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();
            //길이에 맞는 위치에서 검색
            if (tries[len] == null) answer[i] = 0;
            else answer[i] = tries[len].getCount(queries[i]);
        }
        return answer;
	}
	//와일드 카드가 쿼리 문자열 앞에 > front  ,  뒤에  > back
	//문자를 거꾸로한것을 하나 더 저장해놓는다.
	static class Trie {
	    Node front;
	    Node back;

	    Trie() {
	        this.front = new Node();
	        this.back = new Node();
	    }

	    public void insert(String word) {
	        insertFront(word);
	        insertBack(word);
	    }

	    private void insertFront(String word) {
	        Node node = front;
	        for (int i = 0; i < word.length(); i++) {
	            node.count++;
	            node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
	        }
	    }

	    private void insertBack(String word) {
	        Node node = back;
	        for (int i = word.length() - 1; i >= 0; i--) {
	            node.count++;
	            node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
	        }
	    }

	    public int getCount(String query) {
	        if (query.charAt(0) == '?') return getCountFromBack(query);
	        else return getCountFromFront(query);
	    }

	    private int getCountFromFront(String query) {
	        Node node = front;
	        for (int i = 0; i < query.length(); i++) {
	            if (query.charAt(i) == '?') break;
	            if (!node.children.containsKey(query.charAt(i))) return 0;
	            node = node.children.get(query.charAt(i));
	        }
	        return node.count;
	    }

	    private int getCountFromBack(String query) {
	        Node node = back;
	        for (int i = query.length() - 1; i >= 0; i--) {
	            if (query.charAt(i) == '?') break;
	            if (!node.children.containsKey(query.charAt(i))) return 0;
	            node = node.children.get(query.charAt(i));
	        }
	        return node.count;
	    }
	}

	static class Node {
	    Map<Character, Node> children;
	    int count;

	    Node(){
	        this.children = new HashMap<>();
	        this.count = 0;
	    }
	}

}
