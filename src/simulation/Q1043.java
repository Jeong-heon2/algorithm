package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1043 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int knows = Integer.parseInt(st.nextToken());
		ArrayList<Integer> knowList = new ArrayList<>();
		while(knows-->0) {
			knowList.add(Integer.parseInt(st.nextToken()));
		}
		ArrayList<Party> partyList = new ArrayList<>();
		for(int j = 0 ; j < M ; j++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			Party party = new Party(t);
			for(int i = 0 ; i < t ; i++) {
				party.visitors_numList.add(Integer.parseInt(st.nextToken()));
			}
			partyList.add(party);
		}
		if(knowList.size() == 0) {
			System.out.println(M);
		}
		else {
			int ans = 0;
			for(int i = 0 ; i < M ; i++) {
				int knowSize = knowList.size();
				ArrayList<Integer> list = partyList.get(i).visitors_numList;
				for(int j = 0 ; j < knowSize ; j++) {
					if(list.contains(knowList.get(j))){
						break;
					}
					if(j == knowSize-1) {
						ans ++;
						for(int k = 0 ; k < list.size() ; k++ ) {
							knowList.add(list.get(k));
						}
					}
				}
			}
			System.out.println(ans);
		}
		
		
		
	}
	static class Party{
		int count_visitors;
		ArrayList<Integer> visitors_numList;
		public Party(int count_visitors) {
			this.count_visitors = count_visitors;
			this.visitors_numList = new ArrayList<>();
		}
	}

}
