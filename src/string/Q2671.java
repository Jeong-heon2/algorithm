package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2671 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//^(100+1+|01)+  :    ^: 시작   ( ) : 그룹 ,   + : 한번 이상 반복  0+   ->  10시작, 0이 한번이상 반복된다: ^100+ 
		// 1+ : 1이한번이상 반복된다   ,  | : 또는    ^100+1+ 또는  01 로 시작   -> ^(100+1+|01)  
		//( )한번이상 반복된다 
		if(str.matches("^(100+1+|01)+")) {
			System.out.println("SUBMARINE");
		}else {
			System.out.println("NOISE");
		}
		
	}

}
