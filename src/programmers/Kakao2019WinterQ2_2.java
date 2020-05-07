package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//정석 풀이
//문자열 메서드, 정렬 (Comparator), 차집합 
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
		//배열의 원소의 길이를 기준으로 오름차순 정렬
		Arrays.sort(arr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();//음수 또는 0이면 자리유지 ,  양수이면 자리 변경
			}
		});
		//arr :  {"3" , "2,3" , "4,2,3"  ,"2,3,4,1"}
		ArrayList<Integer> list = new ArrayList<>();//정답 리스트
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
