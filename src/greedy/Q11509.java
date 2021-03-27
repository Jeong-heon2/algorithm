package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11509 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arrows = new ArrayList<>();//쏘아진 화살들의 높이 
		arrows.add(Integer.parseInt(st.nextToken())-1);
		for(int i = 1 ; i < N; i++) {
			int balloon = Integer.parseInt(st.nextToken());
			boolean flag = false;
			for(int j = arrows.size() - 1 ; j >= 0 ; j--) {
				int arrow = arrows.get(j);
				if(balloon == arrow) {
					//풍선 높이와 화살 높이가 같다면 
					//새로운 화살을 쏠 필요가 없다.  이 풍선은 이전에 쏘았던 화살에 의해 터짐
					//화살 높이 1 감소 
					if(--arrow <= 0) {
						arrows.remove(j);
					}else {
						arrows.set(j, arrow);
					}
					flag = true;
					break;
				}
				
			}
			if(!flag) {
				//새로운 화살을 쏘아야 함 
				cnt++;
				arrows.add(balloon - 1);
			}
		}
		System.out.println(cnt);
		
	}

}
