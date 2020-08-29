package kakao;
//pseudo-code�� ���� ���ǿ� �°� ��Ȯ�ϰ� ������ �� �ִ°�?

public class Kakao2020BlindQ2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("()))((()"));

	}
	
	static class Solution {
	    public String solution(String p) {
	        String answer = makeCorrect(p);
	        return answer;
	    }
	    public String makeCorrect(String w) {
	    	if(w.length() == 0) return w;
	    	int divideIdx = getDivideIdx(w) + 1;
	    	String u = w.substring(0, divideIdx);
	    	String v = w.substring(divideIdx);
	    	if(isRightString(u)) {
	    		return u + makeCorrect(v);
	    	}else {
	    		String empty = "(" + makeCorrect(v) + ")";
	            u = u.substring(1,u.length()-1);
	            return empty + reverse(u);
	    	}
	    	
	    }
	    //u-v�� �и��ϴ� idx�� ��ȯ�ϴ�  �޼��� 
	    public int getDivideIdx(String s) {
	    	//���� : ��, u�� "�������� ��ȣ ���ڿ�"�� �� �̻� �и��� �� ����� ��
	    	//���� : v�� �� ���ڿ��� �� �� �ֽ��ϴ�.
	    	//s�� �տ��� ���� �о� ���鼭 ���� ��ȣ���� ���� ��ȣ���� üũ�ϰ�
	    	//������ ī���� 
	    	//open �� close�� �������� ���� ���� 
	    	int open = 0;
	    	int close = 0;
	    	for(int i = 0 ; i < s.length() ; i ++) {
	    		if(s.charAt(i) == '(') open ++;
	    		else close ++;
	    		if(open == close) return i;
	    	}
	    	return 0;
	    }
	    //�ùٸ� ���ڿ����� üũ�ϴ� �޼���
	    public boolean isRightString(String s) {
	    	int cnt = 0;
	        for(int i = 0 ; i < s.length(); i++){
	            if(s.charAt(i) == '(') cnt ++;
	            else cnt--;
	            if(cnt<0) return false;
	        }
	        return (cnt == 0) ;
	    }
	    //���ڿ� ��ȣ������ ������ �޼��� 
	    public String reverse(String s) {
	    	StringBuffer sb = new StringBuffer();
	        for(int i = 0 ; i < s.length() ; i++){
	            if(s.charAt(i) == ')') sb.append('(');
	            else sb.append(')');
	        }
	        return sb.toString();
	    }
	}
	
}
