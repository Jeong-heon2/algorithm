package algorithm;

public class Kmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabdabcabcabef";
		final int sLen = s.length();
		String t = "ff";
		final int tLen = t.length();
		int j = 0;//ã�� ���� t �� index 
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
			//0~i �� substring �� �˻��� �ǵ�,  0~i-1 �� ������ j���� ��ŭ ���Ҵ�.
			//�׷��ϱ� i ��°������ i���� j���� �� �غ��� 
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				//�ٸ���,,  �Ǿ� ���� p[j-1]�� ��  �� �� ���� p[j-1]���� �������ϱ�. 
				//�ű⼭ prefix�� suffix�� ���� �ִ� �� = pi[j-1]  . i�� pi[j-1]�� �� 
				j = pi[j-1];//j-1�� �ε����ϱ� 
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
