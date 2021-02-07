package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q12904 {

	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		if(bfs(S, T)) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
	public static boolean bfs(String s, String t) {
		Queue<Word> q = new LinkedList<>();
		q.offer(new Word(s, true));
		while(q.size() >0) {
			Word cur = q.poll();
			if(cur.s.length() == t.length()) {
				if(isEqual(cur, t)) {
					return true;
				}
			}
			Word n1 = new Word("", true);
			Word n2 = new Word("", true);
			if(cur.d) {
				//문자열의 뒤에 A를 추가한다.
				n1.s = cur.s + "A";
				//문자열을 뒤집고 뒤에 B를 추가한다.
				n2.s = "B" + cur.s;
				n2.d = false;
			}else {
				
				n1.s = "A" + cur.s;
				//문자열을 뒤집고 뒤에 B를 추가한다.
				n2.s = cur.s + "B";
				n2.d = true;
			}
			if(n1.s.length() <= t.length()) {
				q.offer(n1);
			}
			if(n2.s.length() <= t.length()) {
				q.offer(n2);
			}
		}
		return false;
	}
	private static boolean isEqual(Word a, String b) {
		if(a.d) {
			if(a.s.equals(b)) return true;
		}else {
			StringBuilder sb = new StringBuilder(a.s);
			if(sb.reverse().equals(b)) {
				return true;
			}
		}
		return false;
	}
	static class Word{
		String s;
		boolean d;// true : 정방향  , false : 역 
		Word (String s, boolean d){
			this.s = s;
			this.d = d;
		}
	}

}
