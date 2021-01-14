package stackq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1655 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		//�ִ���. mid  ���� ���� ���� 
		PriorityQueue<Integer> spq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 < o2 ? 1 : 0;
			}
		});
		//�ּ��� .  mid ���� ū ���� 
		PriorityQueue<Integer> bpq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 > o2 ? 1 : 0;
			}
		});
		int mid = Integer.parseInt(br.readLine());
		
		while(N--> 1) {
			bw.write(mid + "\n");
			
		}
		bw.write(mid + "\n");
		bw.flush();
		bw.close();
	}
}
