package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Q5052 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			Trie trie = new Trie();
			int N = Integer.parseInt(br.readLine());
			boolean ans = true;
			while(N-- > 0) {
				if(!trie.insert(br.readLine())) {
					ans = false;
				}
			}
			if(ans) {
				bw.write("YES" + "\n");
				bw.flush();
			}else {
				bw.write("NO" + "\n");
				bw.flush();
			}
		}
		
		bw.close();
		br.close();

	}
	static class Trie{
		TrieNode root;
		Trie(){
			root = new TrieNode();
		}
		boolean insert(String word) {
			TrieNode thisNode = this.root;
			for(int i = 0 ; i < word.length() ; i++) {
				char ch = word.charAt(i);
				if(!thisNode.childNodes.containsKey(ch)) {
					TrieNode node = new TrieNode();
					thisNode.childNodes.put(ch, node);
					thisNode = node;
				}else {
					thisNode = thisNode.childNodes.get(ch);
					if(thisNode.isLastChar) {
						return false;
					}
				}
			}
			thisNode.isLastChar = true;
			if(thisNode.childNodes.size() == 0) {
				return true;
			}else {
				return false;
			}
			
		}
	}
	static class TrieNode{
		HashMap<Character, TrieNode> childNodes = new HashMap<>();
		boolean isLastChar = false;
	}

}
