package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 소수 경로 
public class Q1963 {
	static int num = 9999;
	static int[] arr = new int[10000];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//9999까지의 소수를 미리 생성 
		//에라토스테네스의 체 
		// 1. 배열을 생성하여 초기화한다.
	    for(int i=2; i<=num; i++) {
	        arr[i] = i;
	    }
	    // 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
	    // (지울 때 자기자신은 지우지 않고, 이미 지워진 수는 건너뛴다.)
	    for(int i=2;i <= num; i++) {
	        if(arr[i]==0) continue; // 이미 지워진 수라면 건너뛰기

	        // 이미 지워진 숫자가 아니라면, 그 배수부터 출발하여, 가능한 모든 숫자 지우기
	        for(int j=2*i; j <= num; j+=i) {
	            arr[j] = 0;
	        }
	    }
	    //입력 받기 
		//test case
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			System.out.println(String.valueOf(bfs(a,b)));
		}
	}
	public static int bfs(int start, int target) {
		boolean[] visited = new boolean[10000];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		int cnt = 0;
		while(q.size() > 0) {
			int qSize = q.size();
			while(qSize-- > 0) {
				int cur = q.poll();
				//한 자리를 바꿔서 나올수 있는 모든 경우의 수 
				//각 자리수 마다 
				for(int i = 0 ; i < 4 ; i++) {
					StringBuilder sb = new StringBuilder(String.valueOf(cur));
					//0~9로 변경할 수 있다. 
					for(int j = 0; j <= 9 ; j++) {
						sb.setCharAt(i, (char)(j+'0'));
						int next = Integer.parseInt(sb.toString());
						//방문한적 없고 소수라면 
						if(next >= 1000 && !visited[next] && arr[next] != 0) {
							//찾는 수라면 바로 리턴 
							if(next == target) return ++cnt;
							visited[next] = true;
							q.add(next);
						}
					}
				}
			}
			cnt++;
		}
		return 0;
	}
}
