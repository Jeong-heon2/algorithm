package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1525 {
	static HashMap<String, Integer> visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int x = 0;
		for(int i = 0 ; i <  3 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++) {
				String str = st.nextToken();
				if(str.equals("0")) {
					x = i*3 + j;
				}
				sb.append(str);
			}
		}
		visited = new HashMap<>();
		//dfs(sb.toString(), 0, x);
		bfs(sb.toString(), x);
		if(!visited.containsKey("123456780")) {
			System.out.println("-1");
		}else {
			System.out.println(visited.get("123456780"));
		}
	}
	private static void dfs(String str, int cnt, int x) {
		if(visited.containsKey(str)) {
			if(visited.get(str) <= cnt) {
				return;
			}
		}else {
			visited.put(str, cnt);
			for(int i = 0 ; i< 4 ; i++) {
				int nx = x + dx[i];
				if(nx < 0 || nx > 8) continue;
				String nstr = str.replace('0', str.charAt(nx));
				if(nx+1  > 8) {
					nstr = nstr.substring(0,nx) + '0';
				}else {
					nstr = nstr.substring(0,nx) + '0' + nstr.substring(nx+1);
				}
				dfs(nstr, cnt + 1, nx);
			}
		}
	}
	//brute force 
	private static void bfs(String str, int x) {
		Queue<String> q = new LinkedList<>();
		q.offer(str);
		visited.put(str, 0);
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-- > 0) {
				String cur = q.poll();
				x = cur.indexOf('0');
				int cx = x % 3;
				int cy = x / 3;
				for(int i = 0 ; i< 4 ; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if(nx < 0 || nx >= 3 || ny < 0 || ny >=3) continue;
					x = ny * 3 + nx;
					String nstr = cur.replace('0', cur.charAt(x));
					if(x+1  > 8) {
						nstr = nstr.substring(0,x) + '0';
					}else {
						nstr = nstr.substring(0,x) + '0' + nstr.substring(x+1);
					}
					if(!visited.containsKey(nstr)) {
						visited.put(nstr, cnt +1);
						q.offer(nstr);
					}
				}
			}
			cnt++;
		
		}
	}

}
