package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
백준 스타트와 링크
조합 알고리즘 두번 사용 . 시간이 너무 오래걸림,
 */
public class Q14889 {
	static int[][] scores;
	static int team1;
	static int team2;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N 전체 사람 수 (짝수)
		int N = Integer.parseInt(br.readLine());
		scores = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[]visited = new boolean[N+1];
		combination(visited, 1, N + 1, N/2);
		System.out.println(ans);
		
	}
	static void combination(boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        cal(visited,n);
	        return;
	    } 
	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	// 배열 출력
    static void cal( boolean[] visited, int n) {
    	ArrayList<Integer> list_t1 = new ArrayList<>();
    	ArrayList<Integer> list_t2 = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (visited[i] == true) {
            	list_t1.add(i);
            }else {
            	list_t2.add(i);
            }
        }
        team1 = 0;
        team2 = 0;
        //team1
        getScore(list_t1, new boolean[list_t1.size()], 0, list_t1.size(), 2, true);
        //team2
        getScore(list_t2, new boolean[list_t2.size()], 0, list_t2.size(), 2, false);
        ans = Math.min(ans, Math.abs(team1 - team2));
    }
    static void getScore(ArrayList<Integer> list, boolean[] visited, int start, int n, int r, boolean flag) {
    	if(r == 0) {
    		int i = 0;
    		int j = 0;
    		for (int k = 0; k < n; k++) {
                if (visited[k] == true) {
                	if(i == 0) {
                		i = list.get(k);
                	}else {
                		j = list.get(k);
                	}
                }
            }
    		if(flag) {
    			team1 += scores[i][j];
    			team1 += scores[j][i];
    		}else {
    			team2 += scores[i][j];
    			team2 += scores[j][i];
    		}
    		return;
	    } 
	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        getScore(list, visited, i + 1, n, r - 1, flag);
	        visited[i] = false;
	    }	    
    }
}
