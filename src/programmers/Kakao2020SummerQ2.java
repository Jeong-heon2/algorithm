package programmers;

import java.util.ArrayList;

public class Kakao2020SummerQ2 {
	//���⿡ ������ �켱���� ����Ǽ��� �ٴ�´�.
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) {
		solution("100-200*300-500+20");

	}
	public static long solution(String expression) {
        long answer = 0;
        char[] arr = {'*','+','-'};
		perm(arr,0,3);
		//list�� �켱���� ������ ���.
		String tmp = expression;
		for(String s : list) {
			String[] order = s.split(" ");
			expression = tmp;
			for(int i = 0 ; i < order.length ; i++) {
				//���� ������ (�켱���� ��� ����)
				String e = order[i];
				
				for(int j = 0 ; j < expression.length() ; j ++) {
					Character ch = expression.charAt(j);
					if(ch.toString().equals(e)) {
						if(j == 0) break;
						//j�� ������ ��ġ
						//j�� ���� ������ ��ġ
						int fIdx = 0;
						//j�� ���� ������ ��ġ
						int eIdx = expression.length();
						for(int k = j-1 ; k >=0 ; k--) {
							//�ٸ� �����ڸ� ã�´�
							if(isRight(expression.charAt(k))){
								if(e.equals("-")) {
									if(expression.charAt(k) == '-') {
										fIdx = k;
										break;
									}
								}
								fIdx = k+1;
								break;
							}
						}
						for(int t = j+1 ; t < expression.length() ; t++) {
							//�ٸ� �����ڸ� ã�´�.
							if(isRight(expression.charAt(t))){
								eIdx = t;
								break;
							}
						}
						//fIdx ���� eIdx-1������  ����ؾ��� ����
						String sub = expression.substring(fIdx,eIdx);
						int result = cal(sub,e);
						expression= expression.substring(0,fIdx) + result + expression.substring(eIdx,expression.length());
						j = fIdx;
					}
				}
			}
			int res = Integer.parseInt(expression);
			res = Math.abs(res);
			answer = Math.max(res, answer);
		}
        return answer;
    }
	//ǥ���İ� �����ڸ� �޾Ƽ� ����� ����
	public static int cal(String ex, String e) {
		if(ex.charAt(0)== '-') {
			ex = ex.substring(1,ex.length());
			ex = ex.replace('-', ' ');
			String[] arr = ex.split(" ");
			return -(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
		}
		String[] arr = ex.split("\\"+e);
		
		if(arr[0].equals("")) {
			return -Integer.parseInt(arr[1]);
		}
		switch(e) {
			case "+" : {
				return Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
			}
			case "-" : {
				return Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
			}
			case "*" : {
				return Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
			}
		}
		return 0;
	}
	//�������ΰ�?
	public static boolean isRight(char ch) {
		if(ch == '*' || ch == '+' || ch == '-') {
			return true;
		}else {
			return false;
		}
	}
	public static void perm(char[] arr, int depth, int n) {
		if(depth == n) {
			String str = "";
			for(int i = 0 ; i < n ; i ++) {
				str = str + arr[i] + " ";
			}
			str.trim();
			list.add(str);
			return;
		}
		for(int i = depth ; i < n ; i ++) {
			swap(arr, i , depth);
			perm(arr, depth+1, n);
			swap(arr, i , depth);
		}
	}
	//��ȯ�ϴ� �Լ�
	public static void swap(char[]arr , int i , int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

}
