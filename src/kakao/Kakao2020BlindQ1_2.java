package kakao;

public class Kakao2020BlindQ1_2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("aabbaccc"));

	}
	static class Solution {
	    public int solution(String s) {
	        int answer = s.length();
	        //1�� ���� ���� > �׳� s�� ����
	        //2�� ���� ���� > s�� ù���� ���� 2���� ��� �����ֵ� �������
	        //���� �� ���� ���� ī���� 
	        //��ü ���̱��ϱ�
	        //3�� ���� ���� > ���� ���� 
	        //...
	        //s/2������ ���� ���� �ݺ� 
	        for(int i = 1; i <= s.length() ; i++) {
	        	String str = compress(s, i);
	        	answer = Math.min(answer, str.length());
	        }
	        return answer;
	    }
	    private String compress(String s, int n) {
	    	//s�� ������ ���� n���� Ȯ�� 
	    	StringBuilder sb = new StringBuilder();
	    	int cnt = 1;
	    	int start = 0;
	    	int end = start + n;
	    	String prev = s.substring(start, n);
	    	for(start += n, end += n ; start < s.length() && end <= s.length() ; start += n, end += n) {
	    		String cur = s.substring(start, end);
	    		if(prev.equals(cur)) {
	    			cnt++;
	    		}else {
	    			if(cnt > 1) {
	    				sb.append(cnt);
	    			}
	    			cnt = 1;
	    			sb.append(prev);
	    		}
	    		prev = cur;
	    	}
	    	String last = "";
	    	if(start < s.length()) {
	    		last = s.substring(start);
	    	}
	    	if(cnt > 1) {
	    		sb.append(cnt);
	    	}
	    	sb.append(prev);
	    	sb.append(last);
	    	
	    	return sb.toString();
	    }
	}

}
