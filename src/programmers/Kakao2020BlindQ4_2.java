package programmers;

import java.util.HashMap;
import java.util.Map;

//trie 자료구조
//https://mishuni.tistory.com/46
//reverse trie 만든다는 idea 
//단어 길이별 trie를 각각 만든다는 idea 
public class Kakao2020BlindQ4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "a","b","frodo", "front", "frost", "frozen", "kakao", "frame" };
		String[] queries = { "?","fro??", "????o", "fr???", "fro???", "pro??", "??ont", "????o" };
		
		Solution sl = new Solution();
		int[] res = sl.solution(
				words, queries
		);
		for(int i = 0 ; i < res.length ; i++) {
			System.out.println(res[i]);
		}
				
	}
	static class Solution {
	    public int[] solution(String[] words, String[] queries) {
			int[] ans = new int[queries.length];
			// 접미사(subffix)용 트라이 구조
			Trie[] tries = new Trie[10001]; 
			// 접두사(prefix)용 트라이 구조
			Trie[] rtries = new Trie[10001];
			
			for(String word : words) {
				int size = word.length();
				if(tries[size] == null) {
					tries[size] = new Trie(new TrieNode());
					tries[size].insert(word);
				}else {
					tries[size].insert(word);
				}
				// 반대 문자도 트라이 생성
				word = (new StringBuffer(word)).reverse().toString();
				if(rtries[size] == null) {
					rtries[size] = new Trie(new TrieNode());
					rtries[size].insert(word);
				}else {
					rtries[size].insert(word);
				}
			}
			
			// trie 이용하여 해당 쿼리에 맞는 갯수들 찾기
			for(int i=0; i<queries.length; ++i) {
				String query = queries[i];
				if(query.indexOf('?')==0) {
					// prefix
					try {
						query = (new StringBuffer(query)).reverse().toString();
						ans[i] = rtries[query.length()].search(query);
					}
					catch(Exception e) {
						continue;
					}
				}
				
				else {
					// suffix
					try {
						ans[i] = tries[query.length()].search(query);
					}
					catch(Exception e) {
						continue;
					}
				}
			}
			
			return ans;
		}
	}
	static class Trie{
		TrieNode rootNode;
		public Trie(TrieNode root) {
			this.rootNode = root;
		}
		//insert
		void insert(String word) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				thisNode.cnt++;
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
				
			}
		}
		
		int search(String query) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < query.length(); i++) {
				char character = query.charAt(i);
				if(character == '?') return thisNode.cnt;
				TrieNode node = thisNode.getChildNodes().get(character);
				
				if (node == null) return 0;
				thisNode = node;
			}
			return thisNode.cnt;
		}

	}
	static class TrieNode{
		// 자식 노드 맵
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		int cnt = 0;
		// 자식 노드 맵 Getter
		Map<Character, TrieNode> getChildNodes() {
			return this.childNodes;
		}

	}

}
