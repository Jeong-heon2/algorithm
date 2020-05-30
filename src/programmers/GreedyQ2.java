package programmers;
/*
[문제 설명]
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

[제한 조건]
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
 */
//접근법 combination  비효율적. number가 백만자리. log(n)에 끝내는 방법을 생각해야함
//greedy로 접근해야한다.
public class GreedyQ2 {
	static int ans = 0;
	public static void main(String[] args) {
		System.out.println(solution("11111999", 4));
	}
	
    public static String solution(String number, int k) {
        int size = number.length();
        combi(number, 0, 0, size, size-k);
        return String.valueOf(ans);
    }
    public static void combi(String number, int visited , int start, int n , int r){
        if(r == 0){
            String val = "";
            for(int i = 0 ; i < n ; i++){
                if((visited & (1 << i)) != 0 ){
                    val += String.valueOf(number.charAt(i));
                }
            }
            int cur = Integer.parseInt(val);
            if(ans < cur) ans = cur;
        }else{
            for(int i = start ; i < n ; i++){
                visited = visited | 1 << i;
                combi(number, visited, start +1 , n, r - 1);
        	    visited &= ~(1<<i);
            }
        }
    }
}
