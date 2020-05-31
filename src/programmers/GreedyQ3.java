package programmers;
/*
프로그래머스 조이스틱
[문제 설명]
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동

만들고자 하는 이름 name이 매개변수로 주어질 때, 
이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

[제한 사항]
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
 */
//테스트케이스 11을 통과하지 못했다. 코드를 수정하다보니 점점 산으로갔다.
//다시 풀어볼 필요가 있겠다.
public class GreedyQ3 {

	public static void main(String[] args) {
		//현위치(시작위치)에서 알파벳을 찾고 
		// 위치에서 알파벳을 찾고 이동 반복.
		
		//끝났음을 어떻게 아는가?  반복문 조건 ? >> 모든 알파벳을 다 돌아본다?
		//A에서 target 문자로 바꾸고  그 다음 'A'가 아닌 문자를 찾을 때 까지 커서 이동을 count 
		
		//시작은 args[0]
		System.out.println(solution("ALA"));

	}
	public static int solution(String name) {
        int answer = 0;
        int size = name.length();
		char[] arr = name.toCharArray();
		
		int idx = 0; // args의 idx
		int tmp = 0; // 'A'를 찾을 때 까지 count
		while(size-- > 0) {
			
			//현 알파벳이  'A'이면 다음 알파벳으로
			if(name.charAt(idx) == 'A') {
				
			}else {
				//ascii A : 97   ~ N : 110   Z :122
				//N은 A에서 출발하나 Z로가서 거꾸로 가나 13번 이동으로 같음
				answer += tmp;
				tmp = 0;
				char curr = name.charAt(idx);
				if(curr <= 'N') answer += curr-'A';
				else answer += 'Z' - curr +1;
			}
			//방향을 정해줘야함.
			//오른쪽 : idx 부터 'A'가 아닌 알파벳이 나올때까지
			//왼쪽 : 뒤에서 부터 'A'가 아닌 알파벳이 나올때까지 + idx +1
			//더 작은쪽이 방향이 된다.
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
			//다음 알파벳으로 
			tmp++;
			
		}
        return answer;
    }

}
