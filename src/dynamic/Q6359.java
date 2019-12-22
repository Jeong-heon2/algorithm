package dynamic;

import java.util.ArrayList;
import java.util.Scanner;

public class Q6359 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] room_num = new int[N];
		int[] answer = new int[N];
		for(int i=0;i<N;i++) {
			room_num[i] = sc.nextInt();
		}
		ArrayList<Boolean> doorStatelist = new ArrayList<>();
		for(int i = 0; i<N ; i ++) {
			for(int k = 0; k<room_num[i]; k++) {
				doorStatelist.add(true);
			}
			for(int j = 2 ; j<=room_num[i]; j++) {
				for(int k= 1; k*j<=room_num[i]; k++) {
					if(doorStatelist.get(k*j-1)==true) {
						doorStatelist.set(k*j-1, false);
					}
					else {
						doorStatelist.set(k*j-1, true);
					}
					
				}
			}
			for(int k =0; k<doorStatelist.size();k++) {
				if(doorStatelist.get(k)==true) {
					answer[i]++;
				}
			}
			doorStatelist.clear();
		}
		for(int i = 0; i<N ; i ++) {
			System.out.println(answer[i]);
		}
	}
}
//n%k == 0 (배수찾기)
// boolean a
// boolean b
// a = !b  >> 요방법
// room_num 배열은 만들필요 없을듯?
// BufferedReader br = new BufferedReader(new InputStreamReader(Syste.in));
//br.readline();