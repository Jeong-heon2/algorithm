package kakao;

import java.util.ArrayList;

/*
���� �ִ�ȭ
permutation, two pointers

 */
public class Kakao2020InternQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.solution("50*6-3*2"));
		
	}
	static class Solution {
		char[] prior = {'+', '-', '*'};
		ArrayList<Long> nums = new ArrayList<>();
		ArrayList<Character> ops = new ArrayList<>();
		long ans = 0;
	    public long solution(String expression) {
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0 ; i < expression.length() ; i ++) {
	        	char ch = expression.charAt(i);
	        	if(ch >= '0' && ch <= '9') {
	        		sb.append(ch);
	        	}else {
	        		nums.add(Long.parseLong(sb.toString()));
	        		sb.setLength(0);
	        		ops.add(ch);
	        	}
	        }
	        nums.add(Long.parseLong(sb.toString()));
	        perm(prior, 0, 3);
	        return ans;
	    }
	    long cal(long num1, long num2, char op) {
	    	long num = 0;
	    	switch (op) {
				case '+': {
					return num1 + num2;
				}
				case '-': {
					return num1 - num2;
				}
				case '*': {
					return num1 * num2;
				}
	    	}
	    	return num;
	    }
	    //depth�� ��ȯ Ʈ���������� ���� �� �ǹ�. n�� �迭�� ũ��
	    public void perm(char[] arr, int depth, int n) {
			if(depth == n) {
				// ���� ArrayList �� �������ش�.
	    		ArrayList<Long> cNums = new ArrayList<>(nums);
	    		ArrayList<Character> cOps = new ArrayList<Character>(ops);
	    		
	    		for(int i = 0; i < n ; i ++) {
	    			for(int j = 0 ; j < cOps.size() ; j++) {
	    				if(arr[i] == cOps.get(j)) {
	    					//���
	    					long res = cal(cNums.remove(j), cNums.remove(j), cOps.remove(j));
	    					cNums.add(j--, res);
	    				}
	    			}
	    		}
	    		ans = Math.max(ans, Math.abs(cNums.get(0)));
				return;
			}
			for(int i = depth ; i < n ; i ++) {
				swap(arr, i , depth);
				perm(arr, depth+1, n);
				swap(arr, i , depth);
			}
		}
		//��ȯ�ϴ� �Լ�
		public void swap(char[]arr , int i , int j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
