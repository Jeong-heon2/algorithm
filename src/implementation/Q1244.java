package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1244 {
	static int[] swi;
	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		swi = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			swi[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0) {
			String[] tmp = br.readLine().split(" ");
			if(tmp[0].equals("1")) {
				boy(Integer.parseInt(tmp[1]));
			}else {
				girl(Integer.parseInt(tmp[1]));
			}
		}
		for(int i = 1 ; i <= N ; i++) {
			if(i % 20 == 0) {
				bw.write(swi[i] + "\n");
				bw.flush();
			}else {
				bw.write(swi[i] + " ");
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static void boy(int n) {
		for(int i = n , j = 1; i <= N ; j++, i = n*j) {
			change(i);
		}
	}
	private static void change(int n) {
		if(swi[n] == 1) swi[n] = 0;
		else swi[n] = 1;
	}
	private static void girl(int n) {
		int left = n -1;
		int right = n + 1;
		change(n);
		while(left >0 && right <= N) {
			if(swi[left] != swi[right]) {
				break;
			}else {
				change(left--);
				change(right++);
			}
		}
	}
}
