package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17609 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String str = br.readLine();
			int left = 0;
			int size = str.length();
			int right = size - 1;
			boolean check = true;//그냥 회문인지 아닌지 
			while(left < right) {
				if (str.charAt(left) != str.charAt(right)) {//다른게 나왔다면 
					check = false; //그냥 회문은 일단 아님 
					int tmpR = right - 1;
					int tmpL = left;
					boolean flag = true;
					while(tmpL < tmpR) {//오른쪽거를 삭제 
						if (str.charAt(tmpL) != str.charAt(tmpR)) {
							//다른게 또 나왔으면 
							flag = false;
							break;
						}
						tmpL++;tmpR--;
					}
					if(flag) {//유사회문 
						System.out.println("1");
						break;
					}else {//이번엔 왼쪽거를 삭제 
						tmpR = right;
						tmpL = left + 1;
						flag = true;
						while(tmpL < tmpR) {
							if (str.charAt(tmpL) != str.charAt(tmpR)) {
								//다른게 또 나왔으면 
								flag = false;
								break;
							}
							tmpL++;tmpR--;
						}
						if(flag) {
							System.out.println("1");
							break;
						}else {
							System.out.println("2");
							break;
						}
					}
				}
				
				left++;
				right--;
			}
			if (check) {
				System.out.println("0");
			}
		}
	}

}
