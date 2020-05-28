package codingtestex;

import java.util.*;
public class SumCo2020Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TrieNode {
		// [ 변수 ]
		// 자식 노드 맵
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		// 마지막 글자인지 여부
		private boolean isLastChar;
		// [ GETTER / SETTER 메서드 ]
		// 자식 노드 맵 Getter
		Map<Character, TrieNode> getChildNodes() {
		return this.childNodes;
		}
		// 마지막 글자인지 여부 Getter
		boolean isLastChar() {
		return this.isLastChar;
		}
		// 마지막 글자인지 여부 Setter
		void setIsLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
		}
	}
	public class Trie {
		// [ 변수 ]
		// 루트 노드
		private TrieNode rootNode;
		// [ 생성자 ]
		Trie() {
		rootNode = new TrieNode();
		}
		
		void insert(String word) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			thisNode.setIsLastChar(true);
		}


	}
	

}
