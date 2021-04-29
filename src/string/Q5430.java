package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5430 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String p = br.readLine();//������ �Լ� 
			int n = Integer.parseInt(br.readLine());//�迭�� ����ִ� ����
			String[] arr = new String[n];
			String input = br.readLine();
			input = input.substring(1, input.length()-1);
			arr = input.split(",");
			
			int round = p.length();
			boolean dir = true; // ���� 
			boolean isError = false;
			int first = 0;
			int last  = n-1;
			//�Լ��� ������ first ~ last ������ ��� 
			for(int i = 0 ; i <round ; i++) {
				if(p.charAt(i) == 'R') {
					dir = !dir;
				}else {
					if(first > last) {
						isError = true;
						break;
					}
					if(dir) {
						// -> ���� 
						first++;
					}else {
						// <- ���� 
						last--;
					}
				}
			}
			//��� 
			StringBuilder sb = new StringBuilder();
			if(isError) {
				sb.append("error");
			}else {
				if(dir) {
					//first~last ������ ��� 
					sb.append("[");
					for(int i = first ; i <= last ; i++) {
						sb.append(arr[i] + ",");
					}
					if(sb.charAt(sb.length()-1) == ',') sb = sb.deleteCharAt(sb.length()-1);
					sb.append("]");
				}else {
					//last~first ������ ��� 
					sb.append("[");
					for(int i = last ; i >= first ; i--) {
						sb.append(arr[i] + ",");
					}
					if(sb.charAt(sb.length()-1) == ',') sb = sb.deleteCharAt(sb.length()-1);
					sb.append("]");
				}
			}
			System.out.println(sb.toString());
		}
	}

}
