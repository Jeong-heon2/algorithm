package programmers;

import java.util.Arrays;
/*
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

[제한 사항]
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
 */
//접근법 1 : 해쉬를 이용하여 풀 방법이 떠오르질 않았다. 그래서 sort와 정규식을 이용했다.
//119, 97674223, 1195524421  입력이 이렇게 있으면 
//sort 하면 119, 1195524421, 97674223  이렇게 된다.
//앞에서부터  연속된 두개씩만 조사하면 된다.  119, 1195524421 조사하고 그다음은 1195524421, 97674223
// 119와 97674223은 조사할필요가 없다.
//왜냐하면  정렬을 했기때문에 119가  1195524421의  접두어가 아니라면  그 뒤에있는 것들의 접두어도 아니기때문이다.
public class HashQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        String a;
        String b = phone_book[0];
        for(int i = 1 ; i < phone_book.length ; i++){
            a = b;
            b = phone_book[i];
            if(isRight(a,b)) return false;
        }
        return true;
    }
    private static boolean isRight(String a , String b){
        if(b.matches("^"+a+".*")) return true;
        return false;
    }

}
