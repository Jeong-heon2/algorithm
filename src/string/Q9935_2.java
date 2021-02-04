package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9935_2 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		char[] res = new char[str.length()];
		int idx = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			res[idx++] = str.charAt(i);
	        int j = bomb.length();
	        if(str.charAt(i) == bomb.charAt(--j)) //c4중 4부터 비교를 시작한다.
	        {
	            boolean check = false;
	            int size = idx - bomb.length();
	            if(size >= 0) {
	            	for(int k = idx-1; k>=size; k--)
		            {
		                if(res[k] == bomb.charAt(j--))
		                {
		                    check = true;
		                }
		                else
		                {
		                    check = false;
		                    break;
		                }
		            }
		            
		            if(check) idx -= bomb.length();
	            }
	            
	        }

		}
		if(idx == 0 ) {
			System.out.println("FRULA");
		}else {
			System.out.println(String.valueOf(res, 0 , idx));
		}
	}

}
