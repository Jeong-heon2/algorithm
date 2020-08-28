package kakao;
/*
 �ٸ� ����, abcabcdede�� ���� ���, ���ڸ� 2�� ������ �߶� �����ϸ� abcabc2de�� ������,
3�� ������ �ڸ��ٸ� 2abcdede�� �Ǿ� 3�� ������ ���� ª�� ���� ����� �˴ϴ�. �̶� 3�� ������ �ڸ��� �������� ���� ���ڿ��� �״�� �ٿ��ָ� �˴ϴ�.

������ ���ڿ� s�� �Ű������� �־��� ��, ���� ������ ������� 1�� �̻� ������
 ���ڿ��� �߶� �����Ͽ� ǥ���� ���ڿ� �� ���� ª�� ���� ���̸� return 
 �ϵ��� solution �Լ��� �ϼ����ּ���.
 */

//������ ����� ����
//���ڿ� ���� �պ��� ������ ���̴�� �߶�� �Ѵٴ� ���� �ݿ����� ���ߴ�.
public class Kakao2020BlindQ1 {

	public static void main(String[] args) {
		int ans = solution("aabbaccc");
		System.out.println(ans);

	}
	public static int solution(String s) {
		int length = s.length();
		int answer = length;
		for(int i = length/2 ; i >=1 ; i-- ) {
			String str = s;
			//i�� ã�����ϴ� substring ����
			for(int j = 0 ; j+i*2 <= str.length() ; j++) {
				String sub = str.substring(j,j+i);
				String sub2 = str.substring(j+i,j+i*2);
				if(sub.equals(sub2)) {
					try {
						int num = Integer.parseInt(str.substring(j-1,j));
						num++;
						str = str.substring(0,j-1) + num + sub + str.substring(j+i*2);
					}catch (Exception e) {
						str = str.substring(0,j) + "2" + sub + str.substring(j+i*2);
					}
				}
			}
			answer = Math.min(answer, str.length());
		}
        return answer;
    }

}
