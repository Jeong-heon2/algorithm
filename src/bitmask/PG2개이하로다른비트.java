package bitmask;

public class PG2�����Ϸδٸ���Ʈ {

	public static void main(String[] args) {
		Solution s = new Solution();
		long[] res = s.solution(new long[]{909999999999991l});
		for(int i = 0 ; i < res.length ; i++) {
			System.out.println(res[i]);
		}
	}
	static class Solution {
	    public long[] solution(long[] numbers) {
	        long[] answer = new long[numbers.length];
	        for(int i = 0 ; i < numbers.length;  i++){
	            long cur = numbers[i];
	            if(cur %2 == 0) answer[i] = cur + 1;
	            else{
	                //���� ���� �ڸ��� 0�� 1�� �ٲٰ�
	                boolean flag = true;
	                int a = 0;
	                for( ; 0 < cur >> a ; a++){
	                    if((cur & (1 << a)) == 0){
	                        cur  |= (1 << a) ;
	                        //�� ���� ������ �ڸ��� 1�� 0���� 
	                        for(int j = a-1 ; j >= 0 ; j--){
	                            if((cur & (1 << j)) > 0){
	                                cur &= ~(1<<j);
	                                break;
	                            }
	                        }
	                        flag = false;
	                        break;
	                    }
	                }
	                if(flag){
	                    //cur�� ��� 1�� �̷���� ���, �� �տ� 1�� ���̰� �� ���� ������ �� 0���� 
	                    cur |= (1 << a);
	                    cur &= ~(1<<a-1);
	                }
	                answer[i] = cur;
	            }
	        }
	        return answer;
	    }
	}
	static class Solution2 {
	    public long[] solution(long[] numbers) {
	        long[] answer = new long[numbers.length];
	        int idx = 0;
	        for(long n : numbers) {
	            int i = 0;
	            while((n & (1l << i)) != 0) i++;
	            long m = 1l << i;
	            //¦���� i = 0 
	            answer[idx++] = i == 0 ? n + 1 : (n + (m >> 1));
	        }
	        return answer;
	    }
	}

}
