package algorithm;

import java.util.Arrays;
import java.util.Comparator;

//Comparable�� Comparator ����
//Comparable�� ��ü�� ������ �� ����ϴ� �������̽�
//Comparator�� ���� ������ Ŭ����(Comparable �������̽��� ������ Ŭ���� , ex list array)���� 
//�⺻ ���� ���ذ� �ٸ��� ���� �ϰ� ���� �� ����ϴ� �������̽� 
public class SortEx {

	public static void main(String[] args) {
		String[] arr = { "bananas","apple", "cookie"};
		Arrays.sort(arr);
		for(String str : arr) {
			System.out.println(str);
		}
		// ��� : apple banana cookie
		// ������ ���� ������ ��µǵ��� �Ǿ�����
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.length() - arg1.length();
				//return ���� ����̸� �ڸ��� �ٲ۴�.
				//�� ���̰� ����� �ڷ� ������
			}
		});
		
		for(String str : arr) {
			System.out.println(str);
		}
		//��� : apple cookie bananas
		// ������ ���� �������� �������� ����
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1)*-1;
				//���� �ݴ���� ����
			}
		});
		for(String str : arr) {
			System.out.println(str);
		}
		
		CompareToEx ct = new CompareToEx(2);
		CompareToEx ct2 = new CompareToEx(1);
		CompareToEx[] ctArr = new CompareToEx[2];
		ctArr[0] = ct;
		ctArr[1] = ct2;
		Arrays.sort(ctArr);
		for(CompareToEx cte : ctArr) {
			System.out.println(cte.num);
		}
		
	}
	static class CompareToEx implements Comparable<CompareToEx>{
		int num;
		public CompareToEx(int num) {
			this.num = num;
		}
		@Override
		public int compareTo(CompareToEx arg0) {
			if(num > arg0.num) return 1;//ū ������ �������� ����
			else if(num == arg0.num) return 0;
			else return -1;
		}
		
	}

}
