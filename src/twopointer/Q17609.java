package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17609 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String str = br.readLine();
			int left = 0;
			int size = str.length();
			int right = size - 1;
			boolean check = true;//�׳� ȸ������ �ƴ��� 
			while(left < right) {
				if (str.charAt(left) != str.charAt(right)) {//�ٸ��� ���Դٸ� 
					check = false; //�׳� ȸ���� �ϴ� �ƴ� 
					int tmpR = right - 1;
					int tmpL = left;
					boolean flag = true;
					while(tmpL < tmpR) {//�����ʰŸ� ���� 
						if (str.charAt(tmpL) != str.charAt(tmpR)) {
							//�ٸ��� �� �������� 
							flag = false;
							break;
						}
						tmpL++;tmpR--;
					}
					if(flag) {//����ȸ�� 
						System.out.println("1");
						break;
					}else {//�̹��� ���ʰŸ� ���� 
						tmpR = right;
						tmpL = left + 1;
						flag = true;
						while(tmpL < tmpR) {
							if (str.charAt(tmpL) != str.charAt(tmpR)) {
								//�ٸ��� �� �������� 
								flag = false;
								break;
							}
							tmpL++;tmpR--;
						}
						if(flag) {
							System.out.println("1");
							break;
						}else {
							System.out.println("2");
							break;
						}
					}
				}
				
				left++;
				right--;
			}
			if (check) {
				System.out.println("0");
			}
		}
	}

}
