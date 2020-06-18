package greedy;

import java.util.Arrays;
import java.util.Scanner;

/*
�Է�]
N�� �Է¹޴´�. N�� �ִ� 105���� ���ڷ� �����Ǿ� ������, 0���� �������� �ʴ´�.

���]
�̸��ڰ� ����� �;��ϴ� ���� �����Ѵٸ� �� ���� ����϶�. �� ���� �������� �ʴ´ٸ�, -1�� ����϶�.
 */
//���ٹ� : �� �ڸ����� ��� ������ �� 3�� ����̸� �� ���� 3�� ����̴�. 
//3�� ����̸鼭 0�� �ϳ��̻� �����ϸ� �ȴ�. ������ sort�ϸ� 0�� �ǳ����� ���ϱ�. 
//0�� ������ ������ ���ڵ��� 3�� ����� �Ǵϱ�. 30�� ����� �ȴ�.
//3�� ������� Ȯ���ϰ� 0�� �����ϴ��� Ȯ���ϰ� ������������ sort 
public class Q10610 {
	static char[] chars;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		chars = new char[N.length()];
		sc.close();
		if(isMultipleOfThree(N)) {
			Arrays.sort(chars);
			for(int i = N.length()-1 ; i >= 0 ; i--){
				System.out.print(chars[i]);
			}
		}else {
			System.out.println(-1);
		}
		
		
	}
	private static boolean isMultipleOfThree(String n) {
		int sum = 0;
		boolean isZero = false;
		for(int i = 0 ; i < n.length() ; i ++){
			char ch = n.charAt(i);
			sum += ch - '0';
			chars[i] = ch;
			if(ch == '0') isZero = true;
			
		}
		if(sum % 3 == 0 && isZero) return true;
		else return false;
	}

}
