package kakao;
/*
 다른 예로, abcabcdede와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 abcabc2de가 되지만,
3개 단위로 자른다면 2abcdede가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로
 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 
 하도록 solution 함수를 완성해주세요.
 */

//문제를 제대로 읽자
//문자열 제일 앞부터 정해진 길이대로 잘라야 한다는 것을 반영하지 못했다.
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
			//i가 찾고자하는 substring 길이
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
