package algorithm;

import java.util.Arrays;
import java.util.Comparator;

//Comparable과 Comparator 연습
//Comparable은 객체를 정렬할 때 사용하는 인터페이스
//Comparator는 정렬 가능한 클래스(Comparable 인터페이스를 구현한 클래스 , ex list array)들의 
//기본 정렬 기준과 다르게 정렬 하고 싶을 때 사용하는 인터페이스 
public class SortEx {

	public static void main(String[] args) {
		String[] arr = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		Arrays.sort(arr);
		for(String str : arr) {
			System.out.println(str);
		}
		String a = "a-10 a";
		String b = "a-10 b";
		System.out.println("음수면 a 가 사전순으로 더 앞." + a.compareTo(b));
		// 출력 : apple banana cookie
		// 원래는 사전 순서로 출력되도록 되어잇음
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.length() - arg1.length();
				//return 값이 양수이면 자리를 바꾼다.
				//즉 길이가 긴놈을 뒤로 보낸다
			}
		});
		
		for(String str : arr) {
			System.out.println(str);
		}
		//출력 : apple cookie bananas
		// 원소의 길이 기준으로 오름차순 정렬
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1)*-1;
				//사전 반대순서 정렬
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
		//출력  1 2 
		
	}
	static class CompareToEx implements Comparable<CompareToEx>{
		int num;
		public CompareToEx(int num) {
			this.num = num;
		}
		//Arrays.sort  ,  Cellections.sort 할대 이 메서드가 사용된다
		@Override
		public int compareTo(CompareToEx arg0) {
			if(num > arg0.num) return 1;//큰 순으로 오름차순 정렬
			else if(num == arg0.num) return 0;
			else return -1;
		}
	}
}
