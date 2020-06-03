package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
[입력]
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 
이 값은 100,000을 넘지 않는다. 다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 
친구 관계는 두 사용자의 아이디로 이루어져 있으며, 
알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.

[출력]
친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
 */
public class Q4195 {
	static int[] parents;//부모 노
	static int[] cnt;//자식이 몇명인지(나를 포함)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//test case 
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			//<이름, 고유번호>
			HashMap<String, Integer> map = new HashMap<>();
			//친구 관계 수
			int N = Integer.parseInt(br.readLine());
			//입력에 이름전부가 서로 다를 수 있으므로 N*2
			parents = new int[N*2];
			cnt = new int[N*2];
			//초기화 
			for(int i = 0; i < N*2 ; i++) {
				parents[i] = i;
				cnt[i] = 1;
			}
			//이름의 고유번호 
			int idx = 0;
			while(N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//친구1 
				String f1 = st.nextToken();
				int f1_idx ;
				if(!map.containsKey(f1)) {
					f1_idx = idx;
					map.put(f1, idx++);
				}else f1_idx = map.get(f1);
				//친구2 
				String f2 = st.nextToken();
				int f2_idx;
				if(!map.containsKey(f2)) {
					f2_idx = idx;
					map.put(f2, idx++);
				}else f2_idx = map.get(f2);
				
				System.out.println(union(f1_idx, f2_idx));
				
			}
			
		}
	}
	private static int find(int x) {
		if(parents[x] == x) {
			return x;
		}else {
			return parents[x] = find(parents[x]);
		}

	}
	private static int union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(y > x) {
				parents[y] = x;
				cnt[x] += cnt[y]; // y가 x 자식으로 합병 
				cnt[y] = 1; //단말노드가 되었으므로 1로 초기화
				return cnt[x];
			}
			else {
				parents[x] = y;
				cnt[y] += cnt[x];
				cnt[x] = 1;
				return cnt[y];
			}
		}
		return cnt[x];
	}

}