package programmers;

import java.util.HashMap;
import java.util.Map;

//trie �ڷᱸ��
//https://mishuni.tistory.com/46
//reverse trie ����ٴ� idea 
//�ܾ� ���̺� trie�� ���� ����ٴ� idea 
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
			// ���̻�(subffix)�� Ʈ���� ����
			Trie[] tries = new Trie[10001]; 
			// ���λ�(prefix)�� Ʈ���� ����
			Trie[] rtries = new Trie[10001];
			
			for(String word : words) {
				int size = word.length();
				if(tries[size] == null) {
					tries[size] = new Trie(new TrieNode());
					tries[size].insert(word);
				}else {
					tries[size].insert(word);
				}
				// �ݴ� ���ڵ� Ʈ���� ����
				word = (new StringBuffer(word)).reverse().toString();
				if(rtries[size] == null) {
					rtries[size] = new Trie(new TrieNode());
					rtries[size].insert(word);
				}else {
					rtries[size].insert(word);
				}
			}
			
			// trie �̿��Ͽ� �ش� ������ �´� ������ ã��
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
		// �ڽ� ��� ��
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		int cnt = 0;
		// �ڽ� ��� �� Getter
		Map<Character, TrieNode> getChildNodes() {
			return this.childNodes;
		}

	}

}
