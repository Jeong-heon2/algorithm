package hashmaptest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("apple","10000");
		map.put("banana","20000");
		
		// key set
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key);
		}
		
		//key �� value set
		Set<Map.Entry<String, String>> entries = map.entrySet();
		for(Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
	//�޸������̼ǿ� Ȱ��
	static class Fibonacci{
		private Map<Integer, BigInteger> memoizeHashMap = new HashMap<>();
	    {
	        memoizeHashMap.put(0, BigInteger.ZERO);
	        memoizeHashMap.put(1, BigInteger.ONE);
	        memoizeHashMap.put(2, BigInteger.ONE);
	    }
	    private BigInteger fibonacci(int n) {
	        if (memoizeHashMap.containsKey(n)) {//key n�� �ִٸ� value return
	            return memoizeHashMap.get(n);
	        } else {//key n�� ���ٸ�  n�� ���ϰ�  map�� �߰�
	            BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
	            memoizeHashMap.put(n, result);
	            return result;
	        }
	    }
	    //computeIfAbsent
	    //�� �޼ҵ�� �ΰ��� �Է°��� �޴´�. 
	    //ù��°�� key�̰� �ι�°�� key�� ����Ͽ� ���ʵ��� value�� ��ȯ�ϴ� �Լ��� �������̽��̴�. 
	    //map�� key�� ������ ���� ��ȯ�Ѵٴ� ���̵���̴�.
	    //�׷��� �ʴٸ�, value�� ����ϰ� map�� �߰��� ���Ŀ� value�� �����ٰ��̴�. 
	    private BigInteger fibonacci2(int n) {
	    	return memoizeHashMap.computeIfAbsent(n, 
	    			(key) -> fibonacci(n - 1).add(fibonacci(n - 2)));
	    }
	    //�ξ� �ڵ尡 ����������.
	    
	    //putIfAbsent
	    //computeIfAbsent�� ����ѵ� ��������, key�� �����Ͽ���  ���ڷ� �޴� �޼��尡 ������ ����ȴ�.
	    private BigInteger fibonacci3(int n) {
	    	return memoizeHashMap.putIfAbsent(n,
	    			fibonacci(n - 1).add(fibonacci(n - 2)));
	    }
	}
	
	//computeIfPresent
	//Ű�� �����ϸ� �޼��带 �����Ѵ�.
	static class WordFrequencyFinder {
	    private Map<String, Integer> map = new HashMap<>();
	    {
	        map.put("Java", 0);
	        map.put("Jakarta", 0);
	        map.put("Eclipse", 0);
	    }
	    public void read(String text) {
	    	  for (String word : text.split(" ")) {
	    	    map.computeIfPresent(word, (String key, Integer value) -> ++value);
	    	  }
	    }
	}

}
