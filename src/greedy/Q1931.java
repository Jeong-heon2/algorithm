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
		//세 가지 경우 
		//1. 다음 미팅의 끝나는 시간이  현재 미팅 보다 앞 -> 다음 미팅을 선택하는 것이 더 좋음 
		//2. 다음 미팅 시작시간이  현재 미팅 끝나는 시간 이후 -> 회의실 사용 가능 
		//3. 다음 미팅 시작시간이 현재 미팅 끝나는 시간 이전 ->회의실 사용 불가 
		Meeting curr = meetings[0];
		int cnt = 1;
		for(int i = 1 ; i < N ; i++) {
			if(meetings[i].e < curr.e) {
				curr = meetings[i];
			}else if (meetings[i].s >= curr.e) {
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
		//시작 시간 오름차순 정렬 
		@Override
		public int compareTo(Meeting o) {
			return this.s - o.s;
		}
	}
}
