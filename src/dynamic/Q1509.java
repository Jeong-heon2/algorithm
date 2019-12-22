package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1509 {//팰린드롬 분할 , dp,문자열 처리

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		//Q10942 문제에서 응용
		//12321 이 주어졌을때
		//12321을 다 검사할 필요없고
		//시작점과 끝점이 같고    시작점과 끝점을 제외한 232 가 팰린드롬이면 
		//12321은 팰린드롬이다.
		//dp[s][e] = s부터 e까지 팰린드롬인지 아닌지 
		//dp[s][e] = array[s] == array[e] && dp[s + 1][e - 1]
	}
}
