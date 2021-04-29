package algorithm;

public class Kmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabdabcabcabef";
		final int sLen = s.length();
		String t = "ff";
		final int tLen = t.length();
		int j = 0;//찾을 패턴 t 의 index 
		int[] pi = failFunc(t);
		int ans = -1;
		for(int i = 0 ; i < sLen; i++, j++) {
			if(s.charAt(i) != t.charAt(j)) {
				if(j != 0) {
					j = pi[j-1] - 1;
					i--;
				}else {
					j = -1;
				}
			}
			if(j == tLen - 1) {
				ans = i - tLen + 1;
				break;
			}
		}
		
		System.out.println(ans);
	}
	public static int[] failFunc(String s) {
		int m = s.length();
		int[] pi = new int[m];
		pi[0] = 0;
		int j = 0;
		for(int i = 1 ; i < m ; i++) {
			//0~i 번 substring 을 검사할 건데,  0~i-1 번 까지는 j길이 만큼 같았다.
			//그러니까 i 번째에서는 i번과 j번을 비교 해봐라 
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				//다르면,,  맨앞 부터 p[j-1]개 와  맨 뒤 부터 p[j-1]개가 같았으니까. 
				//거기서 prefix와 suffix가 같은 최대 값 = pi[j-1]  . i와 pi[j-1]을 비교 
				j = pi[j-1];//j-1이 인덱스니까 
			}
			if(s.charAt(i) == s.charAt(j)) {
				pi[i] = j++ + 1;
			}else {
				pi[i] = 0;
			}
		}
		return pi;
	}

}
