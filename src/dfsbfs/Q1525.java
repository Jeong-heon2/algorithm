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
		//2차원 말고 1차원으로 저장.  1234567890 
		for(int i = 0 ; i <  3 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++) {
				String str = st.nextToken();
				sb.append(str);
			}
		}
		//각 상태에서 몇번 이동했는지 저장. ex (123456780, 3) : 초기상태에서 3번 이동해서 123456780이 됨 
		visited = new HashMap<>();
		//dfs(sb.toString(), 0, x);
		bfs(sb.toString());
		if(!visited.containsKey("123456780")) {
			System.out.println("-1");
		}else {
			System.out.println(visited.get("123456780"));
		}
	}
	/*
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
	}*/
	//brute force 
	private static void bfs(String str) {
		Queue<String> q = new LinkedList<>();
		q.offer(str);
		//초기상태 저장 . 
		visited.put(str, 0);
		//이동횟수 
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-- > 0) {
				String cur = q.poll();
				//빈칸의 위치 
				int x = cur.indexOf('0');
				//빈칸의 2차원 좌표 
				int cx = x % 3;
				int cy = x / 3;
				//빈칸을 동서남북 인접한 위치에 이동시키기 
				for(int i = 0 ; i< 4 ; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					//범위 체크 
					if(nx < 0 || nx >= 3 || ny < 0 || ny >=3) continue;
					//인접한 위치의 1차원 좌표 값 
					x = ny * 3 + nx;
					//빈칸과 교환 
					String nstr = cur.replace('0', cur.charAt(x));
					if(x+1  > 8) {
						nstr = nstr.substring(0,x) + '0';
					}else {
						nstr = nstr.substring(0,x) + '0' + nstr.substring(x+1);
					}
					//처음 방문한 상태만 저장  
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
