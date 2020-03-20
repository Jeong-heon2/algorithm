package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2980 {
	static class Sinho{
		int d;
		int r;
		int g;
		int curr = 0;
		public Sinho(int d, int r, int g) {
			this.d = d;
			this.r = r;
			this.g = g;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		ArrayList<Sinho> Sinhos = new ArrayList<Sinho>();
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st2.nextToken());
			int r = Integer.parseInt(st2.nextToken());
			int g = Integer.parseInt(st2.nextToken());
			Sinhos.add(new Sinho(d,r,g));
		}
		int curTime = 0;
		for(int i = 1 ; i<=L ; i++) {
			curTime++;
			for(int j = 0 ; j< Sinhos.size() ; j++) {
				Sinho nowSinho = Sinhos.get(j);
				nowSinho.curr++;
				if(nowSinho.curr == (nowSinho.r + nowSinho.g)) {
					nowSinho.curr = 0;
				}
				if(i == nowSinho.d) {
					if(nowSinho.r > nowSinho.curr) {//정지
						int plusTime = nowSinho.r - nowSinho.curr;
						curTime = curTime + plusTime;
						for(int t = 0 ; t < plusTime-1 ; t++) {
							for(int k = 0 ; k< Sinhos.size() ; k++) {
								Sinho nowSinho2 = Sinhos.get(k);
								nowSinho2.curr++;
								if(nowSinho2.curr == (nowSinho.r + nowSinho.g)) {
									nowSinho2.curr = 0;
								}
							}
						}
					}
					else if((nowSinho.r+nowSinho.g)>nowSinho.curr) {//녹색신호
						
					}
				}
			}
		}
		System.out.println(curTime);
	}
}
