package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//6603 백준  로또
//dfs , 백트래킹 
public class Q6603_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			String line = br.readLine();
			if(line.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(line);
			int num = Integer.parseInt(st.nextToken());
			int[] arr = new int[num];
			boolean[] visited = new boolean[num];
			for(int i = 0 ; i < num ; i ++) {
				int curr = Integer.parseInt(st.nextToken());
				arr[i] = curr;
			}
			combination(arr,visited,0,num,6);
			System.out.println();
		}while(true);
	}
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        print(arr,visited,n);
	        return;
	    } 
	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	// 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
