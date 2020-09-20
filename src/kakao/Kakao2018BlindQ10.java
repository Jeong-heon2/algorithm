package kakao;
import java.util.*;
public class Kakao2018BlindQ10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(new String[]{"go","gone","guild"});
		
	}
	
	static class Solution {
	    public int solution(String[] words) {
	        int answer = 0;
	        Trie trie = new Trie();
	        for(int i = 0 ; i < words.length; i++){
	            trie.insert(words[i]);
	        }
	        for(int i = 0 ; i < words.length; i++){
	            answer += trie.search(words[i]);
	        }
	        return answer;
	    }
	    class Trie{
	        TrieNode rootNode;
	        public Trie(){
	            this.rootNode = new TrieNode();
	        }
	        //insert
	        public void insert(String word){
	            TrieNode thisNode = this.rootNode;
	            for (int i = 0; i < word.length(); i++) {
	                char ch = word.charAt(i);
	                if(thisNode.childNodes.containsKey(ch)){
	                    thisNode = thisNode.childNodes.get(ch);
	                    thisNode.cnt++;
	                }else{
	                    TrieNode newNode = new TrieNode();
	                    thisNode.childNodes.put(ch, newNode);
	                    thisNode = newNode;
	                }
	            }
	            thisNode.isLastChar = true;       
	        }
	        //search
	        public int search(String word){
	            TrieNode thisNode = this.rootNode;
	            for(int i = 0 ; i < word.length(); i++){
	                char ch = word.charAt(i);
	                TrieNode node = thisNode.childNodes.get(ch);
	                if(node.cnt == 1){
	                    return i+1;
	                }
	                thisNode = node;
	            }
	            return word.length();
	        }
	        
	    }
	    class TrieNode{
	        HashMap<Character, TrieNode> childNodes = new HashMap<>(); 
	        boolean isLastChar;
	        int cnt = 1;
	    }
	}

}
