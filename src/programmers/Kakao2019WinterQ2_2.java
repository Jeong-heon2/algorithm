package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//���� Ǯ��
//���ڿ� �޼���, ���� (Comparator), ������ 
public class Kakao2019WinterQ2_2 {

	public static void main(String[] args) {
		int[] tupleArr = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
		for(int val : tupleArr) {
			System.out.println(val);
		}
	}
	
	public static int[] solution(String s) {
		s = s.substring(2,s.length()-2).replace("},{", "-");
		String[] arr = s.split("-");//"4,2,3"   "3"   "2,3,4,1"
		//�迭�� ������ ���̸� �������� �������� ����
		Arrays.sort(arr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();//���� �Ǵ� 0�̸� �ڸ����� ,  ����̸� �ڸ� ����
			}
		});
		//arr :  {"3" , "2,3" , "4,2,3"  ,"2,3,4,1"}
		ArrayList<Integer> list = new ArrayList<>();//���� ����Ʈ
		for(String tmp : arr) {
			String[] val = tmp.split(",");
			
			for(int i = 0 ; i<val.length ; i++) {
				int num = Integer.parseInt(val[i]);
				if(!list.contains(num)) {
					list.add(num);
				}
			}
		}
		
		int[] answer = new int[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}

}
