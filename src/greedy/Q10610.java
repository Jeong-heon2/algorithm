package greedy;

import java.util.Arrays;
import java.util.Scanner;

/*
입력]
N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

출력]
미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.
 */
//접근법 : 각 자리수를 모두 합했을 때 3의 배수이면 그 수는 3의 배수이다. 
//3의 배수이면서 0을 하나이상 포함하면 된다. 어차피 sort하면 0은 맨끝으로 가니까. 
//0을 제외한 나머지 숫자들은 3의 배수가 되니까. 30의 배수가 된다.
//3의 배수인지 확인하고 0을 포함하는지 확인하고 내림차순으로 sort 
public class Q10610 {
	static char[] chars;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		chars = new char[N.length()];
		sc.close();
		if(isMultipleOfThree(N)) {
			Arrays.sort(chars);
			for(int i = N.length()-1 ; i >= 0 ; i--){
				System.out.print(chars[i]);
			}
		}else {
			System.out.println(-1);
		}
		
		
	}
	private static boolean isMultipleOfThree(String n) {
		int sum = 0;
		boolean isZero = false;
		for(int i = 0 ; i < n.length() ; i ++){
			char ch = n.charAt(i);
			sum += ch - '0';
			chars[i] = ch;
			if(ch == '0') isZero = true;
			
		}
		if(sum % 3 == 0 && isZero) return true;
		else return false;
	}

}
