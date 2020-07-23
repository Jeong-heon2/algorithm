package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 경사로 
구현?
 */
public class Q14890 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int L  = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i = 0 ; i < N ; i ++) {
			int v1 = arr[i][0];
			int v1_cnt = 1;
			boolean flag = true;
			for (int j = 1 ; j < N ; j++) {
				int v2 = arr[i][j];
				if(Math.abs(v1 - v2) > 1) {
					flag = false;
					break;
				}
				if(v2 > v1) {
					if(v1_cnt < L) {
						flag = false;
						break;
					}
					else {
						v1 = v2;
						v1_cnt = 1;
					}	
				}else if(v2 == v1) {
					v1_cnt++;
					v1 = v2;
				}else {
					//뒤에 길이 L만큼 같은 숫자가 나오는지 체크 
					if(j + L - 1< N) {
						int cnt = 1;
						for(int k = j+1 ; k < j + L ; k++) {
							if(v2 == arr[i][k]) cnt++;
							else break;
						}
						if(cnt == L) {
							v1 = v2;
							//이미 경사로에 투자됨.
							v1_cnt = 0;
							j += L-1;
						}else {
							flag = false;
							break;
						}
					}else {
						if(L == 1) {
							v1 = v2;
							v1_cnt = 0;
						}else {
							flag = false;
							break;
						}
					}
				}
			}
			if(flag) ans++;
		}
		for(int i = 0 ; i < N ; i ++) {
			int v1 = arr[0][i];
			int v1_cnt = 1;
			boolean flag = true;
			for (int j = 1 ; j < N ; j++) {
				int v2 = arr[j][i];
				if(Math.abs(v1 - v2) > 1) {
					flag = false;
					break;
				}
				if(v2 > v1) {
					if(v1_cnt < L) {
						flag = false;
						break;
					}
					else {
						v1 = v2;
						v1_cnt = 1;
					}
				}else if(v2 == v1) {
					v1_cnt++;
					v1 = v2;
				}else {
						//뒤에 길이 L만큼 같은 숫자가 나오는지 체크 
						if(j + L - 1 < N) {
							int cnt = 1;
							for(int k = j+1 ; k < j + L ; k++) {
								if(v2 == arr[k][i]) cnt++;
								else break;
							}
							if(cnt == L) {
								v1 = v2;
								//이미 경사로에 투자됨.
								v1_cnt = 0;
								j += L-1;
							}else {
								flag = false;
								break;
							}
						}else {
							if(L == 1) {
								v1 = v2;
								v1_cnt = 0;
							}else {
								flag = false;
								break;
							}
						}					
				}
			}
			if(flag) ans++;
		}
		System.out.println(ans);
	}

}
