package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1195 {
	static int ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String g1 = br.readLine();
		String g2 = br.readLine();
		int g1Size = g1.length();
		int g2Size = g2.length();
		ans = g1Size+g2Size;
		solve(g2, g2Size, g1, g1Size);
		if(g1Size != g2Size) {
			solve(g1, g1Size, g2, g2Size);
		}
		System.out.println(ans);
	}
	//right : ���������� �и� string
	private static void solve(String right, int rSize, String left, int lSize) {
		for(int i = 0 ; i < lSize; i++) {
			int rx = 0; // ���������� �и� string�� index 
			int lx = i;
			boolean flag = true; //Ȩ�� �̰� ������ �� �´��� 
			while(rx < rSize && lx < lSize) {
				if(right.charAt(rx) == '2' && left.charAt(lx) == '2') {
					rx++; lx++;
					flag = false;
					break;
				}
				rx++; lx++;
			}
			if(flag) {
				//���̸� ��� 
				if(lx == lSize) {
					ans = Math.min(lSize + rSize - rx , ans);
				}else {
					ans = Math.min(lSize, ans);
				}
			}
		}
	}

}
