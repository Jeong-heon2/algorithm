package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1976 Union find
동혁이는 친구들과 함께 여행을 가려고 한다.
한국에는 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다.

도시들의 개수와 도시들 간의 연결 여부가 주어져 있고,
동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때(중복 가능) 가능한지 여부를 판별하는 프로그램을 작성하시오.

[입력]
첫 줄에 도시의 수 N이 주어진다. N은 200이하이다. 둘째 줄에 여행 계획에 속한 도시들의 수 M이 주어진다. M은 1000이하이다. 다음 N * N 행렬을 통해 임의의 두 도시가 연결되었는지에 관한 정보가 주어진다. 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다. A와 B가 연결되었으면 B와 A도 연결되어 있다. 마지막 줄에는 여행 계획이 주어진다.

[출력]
첫 줄에 가능하면 YES 불가능하면 NO를 출력한다.
 */
public class Q1976 {
	static int[] cities ;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//도시의 수 
		int N = Integer.parseInt(br.readLine());
		//여행 계획에 속한 도시들의 수
		int M = Integer.parseInt(br.readLine());
		//union find graph
		cities = new int[N+1];
		for(int i = 0 ; i < N+1; i++) {
			cities[i] = i;
		}
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//i 도시와 연결된 도시들의 정보
			for(int j = 1 ; j <= N ; j++) {
				int city = Integer.parseInt(st.nextToken());
				if(city == 1) {
					//union i,j
					if(j > i) union(i, j);	
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int next;
		while(st.hasMoreTokens()) {
			next = Integer.parseInt(st.nextToken());
			if(!isUnion(from, next)) {
				System.out.println("NO");
				System.exit(0);
			}
			from = next;
		}
		System.out.println("YES");

	}
	public static int find(int x) {
		if(cities[x] == x) {
			return x;
		}else {
			return cities[x] = find(cities[x]);
		}
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if( x != y) {
			if(y > x) {
				cities[y] = x;
			}else {
				cities[x] = y;
			}
		}
	}
	public static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		else return false;
	}

}
