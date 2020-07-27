package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
���� ��Ϲ��� 
��Ʈ����ũ , �ùķ��̼� 
 */
public class Q14891 {
	static String[] chains;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//ü���� ���� 
		int N = 4;
		//��Ϲ����� �̻� ��
		int M = 8;
		chains = new String[N];
		for(int i = 0 ; i < N ; i++) {
			chains[i] = br.readLine();
		}
		
		//ȸ�� �� 
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//1 : ������ ȸ��   -1 :���� ȸ��
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			//ȸ���ؾ��� ������ ����� ����.
			int[] turns = new int[N];//�ʱ� : 0 , 0�� ü���� ȸ�� x
			turns[num] = dir;
			
			//num�� ����ǿ��� ��ϵ�
			for(int i = num - 1 ; i > -1 ; i--) {
				if(chains[i].charAt(2) == chains[i+1].charAt(6)) {
					break;
				}else {
					turns[i] = -turns[i+1];
				}
			}
			//num�� ����� ������ ��ϵ� 
			for(int i = num + 1 ; i < N ; i++) {
				if(chains[i].charAt(6) == chains[i-1].charAt(2)) {
					break;
				}else {
					turns[i] = -turns[i-1];
				}
			}
			//ȸ���ϱ� 
			for(int i = 0 ; i < N ; i++) {
				if(turns[i] != 0) {
					turning(i, turns[i]);
				}
			}
		}
		//���� ���ϱ� 
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
		//0��° ��Ʈ �� �˾Ƴ���
		int n_0 = num & 1;
		//��Ʈ�� ���������� 1ĭ �̵�
		num = num >> 1;
		//0��° ��Ʈ�� �ǿ������� 
		n_0 = n_0 << 7;
		//�տ� 0 ä��� 
		String answer = Integer.toBinaryString(num | n_0);
		while(answer.length() != 8) {
			answer = "0" + answer;
		}
		return answer;
	}
	public static String turnLeft(String bits) {
		int num = Integer.parseInt(bits, 2);
		//7��° ��Ʈ �� �˾Ƴ���
		int n_7 = (num & (1 << 7)) != 0 ? 1 : 0;
		//��Ʈ�� �������� 1ĭ �̵�
		num = num << 1;
		//8��° ��Ʈ�� 0���� 
		num &= ~(1 << 8);
		//7��° ��Ʈ�� �� ����������
		num |= n_7;
		String answer = Integer.toBinaryString(num);
		//�տ� 0 ä���
		while(answer.length() != 8) {
			answer = "0" + answer;
		}
		return answer;
	}
}
