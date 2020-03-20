package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6593 {
	static int L;
	static int R;
	static int C;
	static char[][][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());//Ãþ
		R = Integer.parseInt(st.nextToken());//Çà
	    C = Integer.parseInt(st.nextToken());//¿­
		while((L==0)&&(R==0)&&(C==0)) {
			arr = new char[L+1][R+1][C+1];
			for(int l = 1; l <=L ; l++) {
				for(int r = 1; r<=R ; r++) {
					String line = br.readLine();
					for(int c = 1 ; c<=C ; c++) {
						arr[l][r][c] = line.charAt(c-1);
					}
				}
				br.readLine();
			}
			
			
			
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());//Ãþ
			R = Integer.parseInt(st.nextToken());//Çà
		    C = Integer.parseInt(st.nextToken());//¿­
		}
	}

}
