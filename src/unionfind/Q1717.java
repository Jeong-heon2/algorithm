package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1717 집합의 표현
첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다. m은 입력으로 주어지는 연산의 개수이다.
 다음 m개의 줄에는 각각의 연산이 주어진다. 합집합은 0 a b의 형태로 입력이 주어진다. 
 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다. 
 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 
 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다. 
 a와 b는 n 이하의 자연수 또는 0이며 같을 수도 있다.

[출력]
1로 시작하는 입력에 대해서 한 줄에 하나씩 YES/NO로 결과를 출력한다. (yes/no 를 출력해도 된다)
 */
public class Q1717 {
	static int[] parents ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		for(int i = 0 ; i < N+1 ; i++) {
			parents[i] = i;
		}
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int toDo = Integer.parseInt(st.nextToken());//0 : Union , 1 : isSameParent
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			//union
			if(toDo == 0) {
				if(node1 > node2) union(node2, node1);
				else union(node1, node2);
			}else {
				//print
				if(isSameParent(node1,node2)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}else {
			return parents[x] = find(parents[x]);
		}
	}
	// y > x 여야 함.
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parents[x] = y;
	}
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) {
			return true;
		}else return false;
	}

}
