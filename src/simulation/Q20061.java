package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20061 {
	static boolean[][] map = new boolean[10][10];
	static int score;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		score = 0;
		while(N -- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			setBlock(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			play();
			check();
		}
		//�Ķ��� ����� �ʷϻ� �������� �ִ� ��� ���� ���� 
		int cnt = 0;
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 6 ;  j < 10 ; j++) {
				if(map[i][j]) cnt++;
			}
		}
		for(int i = 6 ; i < 10 ; i++) {
			for(int j = 0 ;  j < 4 ; j++) {
				if(map[i][j]) cnt++;
			}
		}
		
		System.out.println(score);
		System.out.println(cnt);
	}
	//��� ���� 
	private static void setBlock(int t, int x, int y) {
		//�ʷϻ� ���忡 ����
		if(t == 1) {
			boolean flag = true;
			for(int i = x ; i < 10 ; i++) {
				if(map[i][y]) {
					map[i-1][y] = true;
					flag = false;
					break;
				}
			}
			if(flag) {
				map[9][y] = true;
			}
		}else if(t == 2) {
			boolean flag = true;
			for(int i = x ; i < 10 ; i++) {
				if(map[i][y] || map[i][y+1]) {
					map[i-1][y] = true;
					map[i-1][y+1] = true;
					flag = false;
					break;
				}
			}
			if(flag) {
				map[9][y] = true;
				map[9][y+1] = true;
			}
		}else {
			boolean flag = true;
			for(int i = x ; i < 10 ; i++) {
				if(map[i][y]) {
					map[i-1][y] = true;
					map[i-2][y] = true;
					flag = false;
					break;
				}
			}
			if(flag) {
				map[9][y] = true;
				map[8][y] = true;
			}
		}
		//�Ķ��� ���忡 ���� 
		if(t == 1) {
			boolean flag = true;
			for(int i = y ; i < 10 ; i++) {
				if(map[x][i]) {
					map[x][i-1] = true;
					flag = false;
					break;
				}
			}
			if(flag) {
				map[x][9] = true;
			}
		}else if(t == 2) {
			boolean flag = true;
			for(int i = y ; i < 10 ; i++) {
				if(map[x][i]) {
					map[x][i-1] = true;
					map[x][i-2] = true;
					flag = false;
					break;
				}
			}
			if(flag) {
				map[x][9] = true;
				map[x][8] = true;
			}
		}else {
			boolean flag = true;
			for(int i = y ; i < 10 ; i++) {
				if(map[x][i] || map[x+1][i]) {
					map[x][i-1] = true;
					map[x+1][i-1] = true;
					flag = false;
					break;
				}
			}
			if(flag) {
				map[x][9] = true;
				map[x+1][9] = true;
			}
		}
	}
	//���� ȹ�� ���� 
	private static void play() {
		//�ʷϻ� ����  ȹ�� 
		for(int i = 6 ; i < 10 ; i++) {
			boolean flag = true;
			for(int j = 0 ;  j < 4 ; j++) {
				if(!map[i][j]) {
					//�࿡ �ϳ��� ����� ä������ �ʾҴٸ�
					flag = false;
					break;
				}
			}
			if(flag) {
				score++;
				//���྿ �Ʒ��� �̵� 
				rowDown(i);
			}
		}
		//�Ķ��� ���� ȹ�� 
		for(int i = 6 ; i < 10 ; i++) {
			boolean flag = true;
			for(int j = 0 ;  j < 4 ; j++) {
				if(!map[j][i]) {
					//���� �ϳ��� ����� ä������ �ʾҴٸ�
					flag = false;
					break;
				}
			}
			if(flag) {
				score++;
				//�ѿ��� ������ �̵� 
				colRight(i);
			}
		}
	}
	//����ĭ ��� üũ 
	private static void check() {
		//���� �ʷ� ĭ 
		int cnt = 0;
		for(int i = 4 ; i < 6 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				if(map[i][j]) {
					cnt++; break;
				}
			}
		}
		while(cnt -- > 0) {
			rowDown(9);
		}
		cnt = 0;
		for(int i = 4 ; i < 6 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				if(map[j][i]) {
					cnt++; break;
				}
			}
		}
		while(cnt -- > 0) {
			colRight(9);
		}
	}
	//r������ 1�྿ �Ʒ��� 
	private static void rowDown(int r) {
		for(int j = r ; j > 4 ; j--) {
			for(int k = 0 ; k < 4 ; k++) {
				map[j][k] = map[j-1][k];
			}
		}
		for(int j = 0 ; j < 4 ; j++) {
			//���� �ʷ� ���� �� �� ���� 
			map[4][j] = false;
		}
	}
	//c���� 1����  ���������� 
	private static void colRight(int c) {
		for(int j = c ; j > 4 ; j--) {
			for(int k = 0 ; k < 4 ; k++) {
				map[k][j] = map[k][j-1];
			}
		}
		for(int j = 0 ; j < 4 ; j++) {
			//�����Ķ� ���� ���� �� ���� 
			map[j][4] = false;
		}
	}

}
