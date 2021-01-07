package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q13335 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int w = Integer.parseInt(tmp[1]);
		int L = Integer.parseInt(tmp[2]);
		StringTokenizer st = new StringTokenizer(br.readLine());
		Truck[] arr = new Truck[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = new Truck(Integer.parseInt(st.nextToken()));
		}
		int time = 0;
		ArrayList<Truck> list = new ArrayList<>();//�ٸ� ���� �ִ� Ʈ���� 
		Bridge bridge = new Bridge(w, L);
		int idx = 0;
		while(true) {
			time++;
			for(int i = 0 ; i < list.size() ; i++) {//�ٸ� �� Ʈ���� ó�� 
				list.get(i).time++;
				if(list.get(i).time > bridge.w) {
					bridge.curL -= list.get(i).weight;
					bridge.curW--;
					list.remove(i--);
				}
			}
			if(idx < n) {// ��� ���� Ʈ���� ó�� 
				if(bridge.L >= bridge.curL + arr[idx].weight && list.size() + 1 <= bridge.w ) {
					list.add(arr[idx]);
					bridge.curL += arr[idx++].weight;
					bridge.curW++;
				}
			}
			if(list.size() == 0) break;
		}
		System.out.println(time);
		
	}
	static class Truck{
		int weight;// Ʈ�� ���� 
		int time; // �ٸ����� �־��� �ð� 
		public Truck(int weight) {
			this.weight = weight;
			this.time = 1;
		}
	}
	static class Bridge{
		int w;// �ٸ� ���� 
		int L;// �ٸ� ���� 
		int curW; //���� �ٸ� �� Ʈ�� ����
		int curL; //���� �ٸ� ����
		public Bridge(int w, int L) {
			this.w = w;
			this.L = L;
			this.curW = 0;
			this.curL = 0;
		}
	}
}
