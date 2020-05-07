package algorithm;

public class StringMethodEx {

	public static void main(String[] args) {
		//compareTo
		String s1 = "abc";
		String s2 = "bcd";
		System.out.println(s1.compareTo(s2));
		//s1이 사전순으로 앞에 오기 때문에 -1 반환 
		//comparteToIgnoreCase 함수는 문자열 비교할때 대소문자 구분 x
		
		//concat
		System.out.println(s1.concat(s2));
		//두문자열 이어 붙임
		
		//endsWith
		String s3 = "ab cde";
		String s4 = "cde";
		System.out.println(s3.endsWith(s4));
		//s4가 s3의 접미사이면 true
		
		//startsWith
		//얘는 접두사
		
		//indexOf(string s)
		s1 = "hello world";
		s2 = "wo";
		System.out.println(s1.indexOf(s2));
		//s2가 시작하는 index 6을 반환 (int형)
		//찾지 못하면 -1
		
		//indexOf(String s, int from)
		//from 이후에 s가 처음 나타나는 인덱스 를 반환
		
		//s1.toLowerCase() 문자열의 모든 대문자를 소문자로 변환
		//s1.toUpperCase() 문자열의 모든 소문자를 대문자로 변환
		
		//s1.trim()  맨앞, 맨뒤의 공백을 날림
		
		//substring(int start, int end)
		//문자열의 start 인덱스 부터 end-1 인덱스 까지의 부분문자열 반환
		s1 = "ABCDEFG";
		System.out.println(s1.substring(0,3));
		//ABC 
		System.out.println(s1.substring(1,1));
		System.out.println(s1.substring(1));
		
		//split()
		//지정한 문자로 문자열을 나눌 수 있다. 결과 값은 배열로 반환
		s1 = "abc def ghi";
		String[] sp = s1.split(" ");
		for(int i = 0 ; i < sp.length; i++) {
			System.out.println(sp[i]);
		}
		//abc def ghi
		
		//contains
		//두개의 string을 비교해서 비교대상 string을 포함하고잇으면 true
		s1 = "abcde";
		s2 = "cd";
		System.out.println(s1.contains(s2));
		
	}

}
