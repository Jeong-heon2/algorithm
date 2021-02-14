package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11497 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				pq.offer(Integer.parseInt(st.nextToken()));
            }
			int res[] = new int[n];
            int left = 0;
            int right = n-1;
            
            
            for(int i=0; i<n; i++) {
                if(i%2!=0) {
                    res[left] = pq.poll();
                    left++;
                }
                else {
                    res[right] = pq.poll();
                    right--;
                }
            }
            int min = Math.abs(res[0]-res[n-1]);
            for(int i=1; i<n; i++) {
                min = Math.max(min, Math.abs(res[i]-res[i-1]));
            }
            System.out.println(min);
		}
	}

}
