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
		
		//key 와 value set
		Set<Map.Entry<String, String>> entries = map.entrySet();
		for(Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
	//메모이제이션에 활용
	static class Fibonacci{
		private Map<Integer, BigInteger> memoizeHashMap = new HashMap<>();
	    {
	        memoizeHashMap.put(0, BigInteger.ZERO);
	        memoizeHashMap.put(1, BigInteger.ONE);
	        memoizeHashMap.put(2, BigInteger.ONE);
	    }
	    private BigInteger fibonacci(int n) {
	        if (memoizeHashMap.containsKey(n)) {//key n이 있다면 value return
	            return memoizeHashMap.get(n);
	        } else {//key n이 없다면  n을 구하고  map에 추가
	            BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
	            memoizeHashMap.put(n, result);
	            return result;
	        }
	    }
	    //computeIfAbsent
	    //이 메소드는 두개의 입력값을 받는다. 
	    //첫번째는 key이고 두번째는 key를 사용하여 차례데로 value를 반환하는 함수형 인터페이스이다. 
	    //map에 key가 있으면 값을 반환한다는 아이디어이다.
	    //그렇지 않다면, value를 계산하고 map에 추가를 한후에 value를 돌려줄것이다. 
	    private BigInteger fibonacci2(int n) {
	    	return memoizeHashMap.computeIfAbsent(n, 
	    			(key) -> fibonacci(n - 1).add(fibonacci(n - 2)));
	    }
	    //훨씬 코드가 간결해졌다.
	    
	    //putIfAbsent
	    //computeIfAbsent와 비슷한데 차이점은, key가 존재하여도  인자로 받는 메서드가 무조건 실행된다.
	    private BigInteger fibonacci3(int n) {
	    	return memoizeHashMap.putIfAbsent(n,
	    			fibonacci(n - 1).add(fibonacci(n - 2)));
	    }
	}
	
	//computeIfPresent
	//키가 존재하면 메서드를 실행한다.
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
