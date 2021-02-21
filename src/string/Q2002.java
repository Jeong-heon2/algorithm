package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q2002 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] cars = new String[N];
		HashMap<String,Boolean> visited = new HashMap<>();
		for(int i = 0 ;i < N ; i++) {
			String car = br.readLine();
			cars[i] = car;
			visited.put(car, false);
		}
		int ans = 0;
		int idx = 0;
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			if (!str.equals(cars[idx])) {
				ans++;
			}
			visited.put(str, true);
			while(visited.get(cars[idx])) {
				idx++;
				if (idx == N) break;
			}
		}
		System.out.println(ans);
	}
}
