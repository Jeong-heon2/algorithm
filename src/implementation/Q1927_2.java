package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1927_2 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1000, new Comparator<Integer>() {  
            public int compare(Integer w1, Integer w2) {                         
                return w1.compareTo(w2);  
            }
        }); 

		while(N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0 ) {
				if(pq.size() == 0) {
					bw.write(0 + "\n");
				}
				else {
					bw.write(pq.poll() + "\n");
				}
			}else {
				pq.offer(num);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
