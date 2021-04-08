package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Q20055 {
	static int N;
	static int K;
	static int cnt;
	static Deque<Belt> upDq;
	static Deque<Belt> downDq;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		upDq = new ArrayDeque<>();
		downDq = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N ; i++) {
			upDq.offerFirst(new Belt(Integer.parseInt( st.nextToken() )));
		}
		for(int i = 0 ; i< N ; i++) {
			downDq.offerFirst(new Belt(Integer.parseInt( st.nextToken() )));
		}
		cnt = 0;
		solve();
		System.out.println(cnt);
	}
	private static void solve() {
		while(check()) {
			cnt++;
			rotateBelt();
			moveRobot();
			putRobot();
		}
	}
	private static void rotateBelt() {
		//��Ʈ ȸ�� 
		Belt n_belt = upDq.poll();
		Belt n2_belt = downDq.poll();
		//�κ� ������
		n_belt.robot = false;
		downDq.offer(n_belt);
		upDq.offer(n2_belt);
	}
	private static void moveRobot() {
		//Nĭ�� �κ��� ������ �� ����  �׳� �ٷ� poll�ϰ� �κ�������  offer 
		Belt lastBelt = upDq.poll();//N�ڸ� 
		//�κ������� 
		lastBelt.robot = false;
		upDq.offer(lastBelt);
		for(int i = 1; i < N ; i++) {
			Belt cur = upDq.poll();
			if(cur.robot) {
				Belt front = upDq.pollLast();
				if(front.life > 0 && !front.robot) {
					//������ �� ���� 
					cur.robot = false;
					front.robot = true;
					front.life --;
				}
				upDq.offer(front);
			}
			upDq.offer(cur);
		}
	}
	private static void putRobot() {
		//�κ��� offer 
		Belt firstBelt = upDq.pollLast();
		if(firstBelt.life > 0 && !firstBelt.robot) {
			firstBelt.robot = true;
			firstBelt.life--;
		}
		upDq.offer(firstBelt);
	}
	private static boolean check() {
		//������ 0��ĭ�� ������ K�� �̻��ΰ�? 
		int count = 0;
		Iterator<Belt> upItr = upDq.iterator();
		while(upItr.hasNext()) {
			if(upItr.next().life == 0) {
				count++;
			}
		}
		Iterator<Belt> downItr = downDq.iterator();
		while(downItr.hasNext()) {
			if(downItr.next().life == 0) {
				count++;
			}
		}
		if(count >= K) {
			return false;
		}
		return true;
	}
	static class Belt{
		int life;
		boolean robot;
		Belt(int life){
			this.life = life;
			this.robot = false;
		}
	}

}
