package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 톱니바퀴 
비트마스크 , 시뮬레이션 
 */
public class Q14891 {
	static String[] chains;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//체인의 개수 
		int N = 4;
		//톱니바퀴의 이빨 수
		int M = 8;
		chains = new String[N];
		for(int i = 0 ; i < N ; i++) {
			chains[i] = br.readLine();
		}
		
		//회전 수 
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//1 : 오른쪽 회전   -1 :왼쪽 회전
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			//회전해야할 방향을 기록할 것임.
			int[] turns = new int[N];//초기 : 0 , 0번 체인은 회전 x
			turns[num] = dir;
			
			//num번 톱니의왼쪽 톱니들
			for(int i = num - 1 ; i > -1 ; i--) {
				if(chains[i].charAt(2) == chains[i+1].charAt(6)) {
					break;
				}else {
					turns[i] = -turns[i+1];
				}
			}
			//num번 톱니의 오른쪽 톱니들 
			for(int i = num + 1 ; i < N ; i++) {
				if(chains[i].charAt(6) == chains[i-1].charAt(2)) {
					break;
				}else {
					turns[i] = -turns[i-1];
				}
			}
			//회전하기 
			for(int i = 0 ; i < N ; i++) {
				if(turns[i] != 0) {
					turning(i, turns[i]);
				}
			}
		}
		//점수 구하기 
		int score = 0;
		for(int i = 0 ; i < N ; i++) {
			if(chains[i].charAt(0) == '1') {
				score += Math.pow(2, i);
			}
		}
		System.out.println(score);

	}
	public static void turning(int num, int dir) {
		if(dir == 1) {
			chains[num] = turnRight(chains[num]);
		}else {
			chains[num] = turnLeft(chains[num]);
		}
	}
	
	public static String turnRight(String bits) {
		int num = Integer.parseInt(bits, 2);
		//0번째 비트 값 알아내기
		int n_0 = num & 1;
		//비트를 오른쪽으로 1칸 이동
		num = num >> 1;
		//0번째 비트를 맨왼쪽으로 
		n_0 = n_0 << 7;
		//앞에 0 채우기 
		String answer = Integer.toBinaryString(num | n_0);
		while(answer.length() != 8) {
			answer = "0" + answer;
		}
		return answer;
	}
	public static String turnLeft(String bits) {
		int num = Integer.parseInt(bits, 2);
		//7번째 비트 값 알아내기
		int n_7 = (num & (1 << 7)) != 0 ? 1 : 0;
		//비트를 왼쪽으로 1칸 이동
		num = num << 1;
		//8번째 비트를 0으로 
		num &= ~(1 << 8);
		//7번째 비트를 맨 오른쪽으로
		num |= n_7;
		String answer = Integer.toBinaryString(num);
		//앞에 0 채우기
		while(answer.length() != 8) {
			answer = "0" + answer;
		}
		return answer;
	}
}
