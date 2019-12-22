package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q6603 {
	static int[] ans;
	static ArrayList<Integer> list;
	static int k;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			list = new ArrayList<Integer>();
			ans = new int[k];
			for(int i = 0 ; i <k ; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			dfs(0,0);
			
		}
	}
	public static void dfs(int start, int depth) {
	    
	    if(depth == 6) {                    //탈출조건
	        for(int i=0; i<6; i++) {
	            System.out.println(ans[i]);;    //조합하나를 출력한 뒤 탈출
	        }
	        System.out.println();
	        return;
	    }
	                                        
	    for(int i=start; i<k; i++) {    //list배열 0부터 k-1까지 탐색함     
	        ans[depth] = list.get(i);    //depth는 깊이 -> 0~5번째 깊이까지 재귀를통해 새로 탐색한 숫자를 넣음.    
	        dfs(i+1, depth+1);            //재귀 들어가는 부분 , 하나의 깊이를 탐색 후 저장했으니 다음 함수호출할때는 깊이+1을 해줘야함.
	    }
	    
	}
}
