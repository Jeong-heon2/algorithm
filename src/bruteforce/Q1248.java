package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1248 {
	static int N;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String ch = br.readLine();
		int idx = 0;
		map = new char[N][N];
		for (int i = 0; i < N; i++) { 
			for (int j = i; j < N; j++) { 
				map[i][j] = ch.charAt(idx++); 
			}
		}

		rePermutation(new int[N], 0, N);
	}
	
	private static boolean rePermutation(int[] rePerm,int n, int r) {
        if(n==r) {
            for(int j:rePerm) {
                System.out.print(j+" ");
            }
            System.out.println();
            System.exit(0);
            return true;
        }
        for(int i=1;i<22;i++) {
            rePerm[n]=i - 11;
            if (check(rePerm, n)) {
            	rePermutation(rePerm,n+1, r);
            }
            
        }
        return false;
    }
	private static boolean check(int[] rePerm, int idx) { 
		for (int i = 0; i <= idx; i++) { 
			int sum = 0; 
			for (int j = i; j <= idx; j++) {
				sum += rePerm[j]; //map의 부호가 맞는지 검사한다. 
				if (map[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) { 
					return false; 
				}
			} 
		} 
		return true; 	
	}

}
