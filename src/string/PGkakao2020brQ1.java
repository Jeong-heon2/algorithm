package string;
/*
īī�� 2020 recruitment ���ڿ� ����
���ڿ� , �迭 �ε��� �򰥸��� ���� 
 */
public class PGkakao2020brQ1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("a"));
	}
	static class Solution {
	    public int solution(String s) {
	        int answer = 1000;
	        //1 ~ s.length/2 ����
	        if(s.length() == 1) return 1;
	        for(int i = 1 ; i <= s.length()/2 ; i++) {
	        	//i : �߶���� ���� 
	        	//�� ���ڿ� 1 
	        	String str = s.substring(0, i);
	        	String str2;
	        	//�� ���ڿ� 2�� ���� �ε���
	        	int idx = i;
	        	int cnt = 1;
	        	int tmp = 0;
	        	StringBuilder sb = new StringBuilder();
	        	while(idx + i <= s.length()) {
	        		str2 = s.substring(idx, idx + i);
	        		if(str.equals(str2)) {
	        			cnt++;
	        		}else {
	        			if(cnt > 1) {
	        				sb.append(cnt + str);
	        			}else {
	        				sb.append(str);
	        			}
	        			tmp = idx;
	        			cnt = 1;
	        		}
	        		idx = idx + i;
	        		str = str2;
	        	}
	        	if(cnt > 1) {
	        		sb.append(cnt + s.substring(tmp, tmp + i));
	        		tmp = tmp + i*cnt;
	        		sb.append(s.substring(tmp, s.length()));
	        	}else {
	        		sb.append(s.substring(tmp, s.length()));
	        		
	        	}
	        	if(sb.length() < answer) answer = sb.length();
	        }
	        return answer;
	        
	    }
	}

}
