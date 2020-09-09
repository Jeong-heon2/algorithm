package algorithm;
import java.util.HashMap;
import java.util.Map;
public class LRU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	static class Solution {
	    int ans;
	    public int solution(int cacheSize, String[] cities) {
	        if(cacheSize == 0){
	            return cities.length*5;
	        }
	        ans = 0;
	        LRUCache cache = new LRUCache(cacheSize);
	        for(int i = 0 ; i < cities.length ; i++){
	            cache.put(cities[i].toLowerCase());
	        }
	        return ans;
	    }
	    class LRUCache{
	        int cacheSize;
	        HashMap<String, Node> map;
	        Node head;
	        Node tail;
	        public LRUCache(int cacheSize){
	            this.cacheSize = cacheSize;
	            head = new Node("");
	            tail = new Node("");
	            map = new HashMap<>();
	            head.next = tail;
	            tail.prev = head;
	        }
	        private void insertToHead(Node node){
	            head.next.prev = node;
	            node.next = head.next;
	            node.prev = head;
	            head.next = node;
	            map.put(node.value, node);
	        }
	        private void remove(Node node){
	            node.next.prev = node.prev;
	            node.prev.next = node.next;
	            map.remove(node.value);
	        }
	        public void put(String key){
	            Node node = new Node(key);
	            if(map.containsKey(key)){
	                Node oldNode = map.get(key);
	                remove(oldNode);
	                ans++;
	            }else{
	                if(map.size() >= this.cacheSize){
	                    Node tailNode = tail.prev;
	                    remove(tailNode);
	                }
	                ans += 5;
	            }
	            insertToHead(node);
	        }
	    }
	    class Node{
	        Node prev;
	        Node next;
	        String value;
	        public Node(String val){
	            this.value = val;
	        }
	    }
	}

}
