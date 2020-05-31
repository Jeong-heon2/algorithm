package programmers;
/*
���α׷��ӽ� ���̽�ƽ
[���� ����]
���̽�ƽ���� ���ĺ� �̸��� �ϼ��ϼ���. �� ó���� A�θ� �̷���� �ֽ��ϴ�.
ex) �ϼ��ؾ� �ϴ� �̸��� �� ���ڸ� AAA, �� ���ڸ� AAAA
���̽�ƽ�� �� �������� �����̸� �Ʒ��� �����ϴ�.

�� - ���� ���ĺ�
�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
�� - Ŀ���� ���������� �̵�

������� �ϴ� �̸� name�� �Ű������� �־��� ��, 
�̸��� ���� ���̽�ƽ ���� Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� ���弼��.

[���� ����]
name�� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
name�� ���̴� 1 �̻� 20 �����Դϴ�.
 */
//�׽�Ʈ���̽� 11�� ������� ���ߴ�. �ڵ带 �����ϴٺ��� ���� �����ΰ���.
//�ٽ� Ǯ� �ʿ䰡 �ְڴ�.
public class GreedyQ3 {

	public static void main(String[] args) {
		//����ġ(������ġ)���� ���ĺ��� ã�� 
		// ��ġ���� ���ĺ��� ã�� �̵� �ݺ�.
		
		//�������� ��� �ƴ°�?  �ݺ��� ���� ? >> ��� ���ĺ��� �� ���ƺ���?
		//A���� target ���ڷ� �ٲٰ�  �� ���� 'A'�� �ƴ� ���ڸ� ã�� �� ���� Ŀ�� �̵��� count 
		
		//������ args[0]
		System.out.println(solution("ALA"));

	}
	public static int solution(String name) {
        int answer = 0;
        int size = name.length();
		char[] arr = name.toCharArray();
		
		int idx = 0; // args�� idx
		int tmp = 0; // 'A'�� ã�� �� ���� count
		while(size-- > 0) {
			
			//�� ���ĺ���  'A'�̸� ���� ���ĺ�����
			if(name.charAt(idx) == 'A') {
				
			}else {
				//ascii A : 97   ~ N : 110   Z :122
				//N�� A���� ����ϳ� Z�ΰ��� �Ųٷ� ���� 13�� �̵����� ����
				answer += tmp;
				tmp = 0;
				char curr = name.charAt(idx);
				if(curr <= 'N') answer += curr-'A';
				else answer += 'Z' - curr +1;
			}
			//������ ���������.
			//������ : idx ���� 'A'�� �ƴ� ���ĺ��� ���ö�����
			//���� : �ڿ��� ���� 'A'�� �ƴ� ���ĺ��� ���ö����� + idx +1
			//�� �������� ������ �ȴ�.
			int right = 1;
			int left = 1;
			for(int i = 1 ; i < name.length() ; i++) {
				if(name.charAt(idx+i) == 'A') right++;
				else break;
			}
			for(int i = 1 ; i < name.length() ; i++) {
				if((idx-i)<0) idx = name.length()-1;
				if(name.charAt(idx-i) == 'A') left++;
				else break;
			}
			left += idx+1;
			if(left > right) idx = name.length()-left-1;
			else idx += right;
			//���� ���ĺ����� 
			tmp++;
			
		}
        return answer;
    }

}
