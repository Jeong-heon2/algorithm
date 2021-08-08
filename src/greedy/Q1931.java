package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*회의실 배정 백준 
입력]
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

출력]
첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 */
public class Q1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[N];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(s, e);
		}
		Arrays.sort(meetings);
		//정렬하고 앞에서 부터 읽어나간다. 
		//가장 먼저 끝나는 회의실을 배정. 
		Meeting curr = meetings[0];
		int cnt = 1;
		for(int i = 1 ; i < N ; i++) {
			if(meetings[i].s >= curr.e) {
				curr = meetings[i];
				cnt++;
			}
		}
		System.out.println(cnt);

	}
	static class Meeting implements Comparable<Meeting>{
		int s;//시작 시간 
		int e;// 끝나는 시간 
		Meeting(int s, int e){
			this.s = s;
			this.e = e;
		}
		//끝 시간 오름차순 정렬 
		//끝 나는 시간이 같으면  시작시간이 이른 순서로 정렬 
		@Override
		public int compareTo(Meeting o) {
			if(this.e - o.e >0) return 1;
			else if(this.e == o.e ) {
				return this.s - o.s;
			}
			else return -1;
		}
	}
}
