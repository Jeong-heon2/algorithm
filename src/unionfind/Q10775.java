package unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10775 {
	static int[] parents;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parents = new int[G+1];
		for(int i = 1 ; i <= G ; i++) {
			parents[i] = i;
		}
		int ans = 0;
		while(P--> 0) {
			int g = Integer.parseInt(br.readLine());
			int docking = find(g);// 도킹 가능한 번호중 가장 큰 번호 
			if(docking != 0) {//0번을 가리키면 도킹 할 수 없음 
				union(docking, docking -1); //docking 번 게이트는 이제 도킹했으므로 docking-1번을 가리키게 한다. 
				ans++;
			}else {
				break;
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
