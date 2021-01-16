package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1374 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		Lecture[] arr = new Lecture[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());//강의 번호
			int s = Integer.parseInt(st.nextToken());//강의 시작
			int e = Integer.parseInt(st.nextToken());//강의 끝 시간
			pq.offer(new Lecture(n-1,s,e));
		}
		/*
		Arrays.sort(arr, new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				return o1.s - o2.s;
			}
			
		});*/
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			Lecture cur = pq.poll();
			int cnt = 1;
			for(int j = i-1 ; j >= 0 ; j--) {
				Lecture pre = pq.poll();
				if(pre.e > cur.s) cnt++;
				else pq.offer(pre);
			}
			pq.offer(cur);
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	static class Lecture implements Comparable<Lecture>{
		int n;
		int s; 
		int e;
		Lecture(int n , int s, int e){
			this.n = n;
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Lecture o) {
			return this.s - o.s;
		}
	}
}
