package codingtestex;

import java.util.*;
public class SumCo2020Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TrieNode {
		// [ ���� ]
		// �ڽ� ��� ��
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		// ������ �������� ����
		private boolean isLastChar;
		// [ GETTER / SETTER �޼��� ]
		// �ڽ� ��� �� Getter
		Map<Character, TrieNode> getChildNodes() {
		return this.childNodes;
		}
		// ������ �������� ���� Getter
		boolean isLastChar() {
		return this.isLastChar;
		}
		// ������ �������� ���� Setter
		void setIsLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
		}
	}
	public class Trie {
		// [ ���� ]
		// ��Ʈ ���
		private TrieNode rootNode;
		// [ ������ ]
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
