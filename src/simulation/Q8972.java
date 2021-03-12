package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q8972 {
	static int[][] map;
	static int[] dx = {0, -1, 0, 1, -1, 0, 1, -1, 0 , 1};
	static int[] dy = {0, 1, 1, 1, 0, 0 ,0 , -1, -1, -1};
	static int[] pos;
	static int R;
	static int C;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		pos = new int[2];
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0; j < C ; j++) {
				char ch = str.charAt(j);
				if(ch == 'R') {
					map[i][j] = 1;
				}else if(ch == 'I') {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		String str = br.readLine();
		br.close();
		int x = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			int move = str.charAt(i) - '0';
			x++;
			if(moveJongSu(move)) {
				if(moveCrazy()) {
					continue;
				}
			}
			System.out.println("kraj " + x);
			return;
		}
		// ������ ���¸� �Է°� ���� �������� ����Ѵ�.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(i == pos[0] && j == pos[1]) {
					bw.write("I");
				}else if(map[i][j] == 1) {
					bw.write("R");
				}else {
					bw.write(".");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}
	private static boolean moveJongSu(int move) {
		int ny = pos[0] + dy[move];
		int nx = pos[1] + dx[move];
		//��ģ �Ƶ��̳밡 �ִ� ĭ�̸� ���� ���� 
		if(map[ny][nx] != 0) return false;
		pos[0] = ny;
		pos[1] = nx;
		return true;
	}
	private static boolean moveCrazy() {
		int[][] tmp = new int[R][C];
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == 1) {
					//��ģ �Ƶ��̳�� 8���� ���� �߿��� ������ �Ƶ��̳�� ���� ����� ���� �������� �� ĭ �̵��Ѵ�.
					int idx = 0;
					int min = Integer.MAX_VALUE;
					for(int k = 1; k <= 9 ; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						int distance =  Math.abs(pos[0] - ny) + Math.abs(pos[1] - nx);
						if(min > distance) {
							min = distance;
							idx = k;
						}
					}
					//��ģ �Ƶ��̳밡 ������ �Ƶ��̳밡 �ִ� ĭ���� �̵��� ��쿡�� ������ ������ �ǰ�,
					int ny = i + dy[idx];
					int nx = j + dx[idx];
					if(pos[0] == ny && pos[1] == nx) {
						return false;
					}
					tmp[ny][nx]++;
					map[i][j]--;
				}
			}
		}
		//2�� �Ǵ� �� �̻��� ��ģ �Ƶ��̳밡 ���� ĭ�� �ִ� ��쿡�� ū ������ �Ͼ��, �� ĭ�� �ִ� �Ƶ��̳�� ��� �ı��ȴ�.
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(tmp[i][j] > 1) {
					map[i][j] = 0;
				}else if(tmp[i][j] == 1) {
					map[i][j] = 1;
				}
				
			}
		}
		return true;
	}

}
