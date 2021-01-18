package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Q14908 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Task> pq = new PriorityQueue<>();
		for(int i = 1 ; i <= N ; i++) {
			String[] tmp = br.readLine().split(" ");
			int t = Integer.parseInt(tmp[0]);
			int s = Integer.parseInt(tmp[1]);
			pq.add(new Task(i, (s-1)*t));
		}
		for(int i = 0 ; i < N ; i++) {
			bw.write(pq.poll().n + " ");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	static class Task implements Comparable<Task>{
		int n;
		int w;
		Task(int n , int w){
			this.n = n;
			this.w = w;
		}
		@Override
		public int compareTo(Task o) {
			if(this.w - o.w < 1) {
				return this.n - o.n;
			}else {
				return -1;
			}
		}
	}
}
