package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2141 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<House> list = new ArrayList<>();
		StringTokenizer st;
		long sum = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			sum += a;
			list.add(new House(x,a));
		}
		Collections.sort(list);
		long cnt = 0;
		for(House h : list) {
			cnt += h.a;
			if(cnt >= (sum+1)/2) {
				bw.write(h.x + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		
	}
	static class House implements Comparable<House>{
		long x;
		long a;
		House(long x, long a){
			this.x = x;
			this.a = a;
		}
		@Override
		public int compareTo(House o) {
			if(this.x < o.x) {
				return -1;
			}else {
				return 1;
			}
		}
	}

}
