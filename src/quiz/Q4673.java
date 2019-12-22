package quiz;

import java.util.ArrayList;

public class Q4673 {

	public static void main(String[] args) {
		ArrayList<String> num100_list = new ArrayList<String>();
		for(int i = 1; i<=10000 ; i++) {
			num100_list.add(String.valueOf(i));
		}
		for(int i = 1; i<=10000 ; i++) {
			if(i<10) {
				int nonselfnum = i + i;
				num100_list.remove(String.valueOf(nonselfnum));
			}
			else if (i>=10 && i<100) {
				int nonselfnum = i + i/10 + i%10;
				if(nonselfnum <= 10000) {
					num100_list.remove(String.valueOf(nonselfnum));
				}
			}
			else if (i>=100 && i<1000) {
				int nonselfnum = i + i/100 + (i/10)%10 + i%10;
				if(nonselfnum <= 10000) {
					num100_list.remove(String.valueOf(nonselfnum));
				}
			}
			else if (i>=1000 && i<10000) {
				int nonselfnum = i + i/1000 + (i/100)%10 + (i/10)%10+ i%10; // 규칙이 보이기 시작
				if(nonselfnum <= 10000) {
					num100_list.remove(String.valueOf(nonselfnum));
				}
			}
		}
		for(int i = 0; i<num100_list.size(); i++) {
			System.out.println(num100_list.get(i));
		}
	}
}
