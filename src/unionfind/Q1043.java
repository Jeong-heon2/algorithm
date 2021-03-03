package unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1043 {
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);//사람 수 
		int M = Integer.parseInt(tmp[1]);//파티수 
		parents = new int[N+1];
		for(int i = 1 ; i <=N ;i++) {
			parents[i] = i;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());//진실을 아는 사람 수 
		for(int i = 0 ; i< K ; i++) {
			parents[Integer.parseInt(st.nextToken())] = 0;
		}
		ArrayList<Integer>[] arr = new ArrayList[M];
		for(int i = 0 ; i < M  ;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new ArrayList<>();
			int n = Integer.parseInt(st.nextToken());//파티에 오는 사람 수 
			if(n > 0) {
				int p1 = Integer.parseInt(st.nextToken());
				arr[i].add(p1);
				for(int j = 1 ; j < n; j++ ) {
					int p2 = Integer.parseInt(st.nextToken());
					arr[i].add(p2);
					union(p1, p2);
					p1 = p2;
				}
			}
		}
		int ans = M;
		for(int i = 0 ; i < M  ;i++) {
			for(int j = 0 ; j < arr[i].size(); j++) {
				if(find(arr[i].get(j)) == 0) {
					//파티에 진실을 아는 사람이 있는 경우 
					ans--;
					break;
				}
			}
		}
		System.out.println(ans);
		
		
	}
	public static int find(int x) {
		if(parents[x] == x) return x;
		else {
			return parents[x] = find(parents[x]);
		}
	}
	public static void union(int x, int y) {
		x = find(x);
        y = find(y);
        if(x != y){
        	if(y > x) {
        		parents[y] = x;
        	}else {
        		parents[x] = y;
        	}
        }
	}

}
