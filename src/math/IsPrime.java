package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 소수 인지 체크하는 알고리즘 
 * https://myjamong.tistory.com/139
 */
public class IsPrime {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(isPrime(n));
		
	}
	public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}
