package algorithm;

public class StringMethodEx {

	public static void main(String[] args) {
		//compareTo
		String s1 = "abc";
		String s2 = "bcd";
		System.out.println(s1.compareTo(s2));
		//s1�� ���������� �տ� ���� ������ -1 ��ȯ 
		//comparteToIgnoreCase �Լ��� ���ڿ� ���Ҷ� ��ҹ��� ���� x
		
		//concat
		System.out.println(s1.concat(s2));
		//�ι��ڿ� �̾� ����
		
		//endsWith
		String s3 = "ab cde";
		String s4 = "cde";
		System.out.println(s3.endsWith(s4));
		//s4�� s3�� ���̻��̸� true
		
		//startsWith
		//��� ���λ�
		
		//indexOf(string s)
		s1 = "hello world";
		s2 = "wo";
		System.out.println(s1.indexOf(s2));
		//s2�� �����ϴ� index 6�� ��ȯ (int��)
		//ã�� ���ϸ� -1
		
		//indexOf(String s, int from)
		//from ���Ŀ� s�� ó�� ��Ÿ���� �ε��� �� ��ȯ
		
		//s1.toLowerCase() ���ڿ��� ��� �빮�ڸ� �ҹ��ڷ� ��ȯ
		//s1.toUpperCase() ���ڿ��� ��� �ҹ��ڸ� �빮�ڷ� ��ȯ
		
		//s1.trim()  �Ǿ�, �ǵ��� ������ ����
		
		//substring(int start, int end)
		//���ڿ��� start �ε��� ���� end-1 �ε��� ������ �κй��ڿ� ��ȯ
		s1 = "ABCDEFG";
		System.out.println(s1.substring(0,3));
		//ABC 
		System.out.println(s1.substring(1,1));
		System.out.println(s1.substring(1));
		
		//split()
		//������ ���ڷ� ���ڿ��� ���� �� �ִ�. ��� ���� �迭�� ��ȯ
		s1 = "abc def ghi";
		String[] sp = s1.split(" ");
		for(int i = 0 ; i < sp.length; i++) {
			System.out.println(sp[i]);
		}
		//abc def ghi
		
		//contains
		//�ΰ��� string�� ���ؼ� �񱳴�� string�� �����ϰ������� true
		s1 = "abcde";
		s2 = "cd";
		System.out.println(s1.contains(s2));
		
	}

}
