package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q5373 {
	static char[][][] cube;
	static char[] colors = {'w','y','r','o','g','b'};//윗 아 앞 뒤 왼 오 
	//앞 -> 왼 -> 뒤 -> 오 -> 앞    operation direction (시계방향) 
	//opDir[0] : 0(윗) 시계방향 회전 할때   앞(2) -> 왼(4) ->... 
	static int[][] opDir = { {2,4,3,5},
							 {2,5,3,4},
							 {2,4,3,5},
							 {2,4,3,5},
							 {2,4,3,5},
							 {2,4,3,5},
						   };
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		cube = new char[6][3][3];
		for(int i = 0 ; i < 6; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				for(int k = 0 ; k  < 3 ; k++) {
					cube[i][j][k] = colors[i];
				}
			}
		}
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int  n = Integer.parseInt(br.readLine());//큐브를 돌릴 횟 수 
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(n-- >0) {
				String token = st.nextToken();
				char plane = token.charAt(0);
				char dir = token.charAt(1);
				
			}
		}
	}
	private static int getPlane(char plane) {
		if(plane == 'U') {
			return 0;
		}else if(plane == 'D') {
			return 1;
		}else if(plane == 'F') {
			return 2;
		}else if(plane == 'B') {
			return 3;
		}else if(plane == 'L') {
			return 4;
		}else {
			return 5;
		}
	}
	private static void rotateClock(char plane, int[][] pos) {
		char[] tmp = new char[3];
		switch(plane) {
			case 'U':{
				
				break;
			}
		}
			
			
		
	}

}
