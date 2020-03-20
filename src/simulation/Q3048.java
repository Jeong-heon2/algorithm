package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q3048 {
	static class Node{
		boolean team;
		char ch;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Node[] team1 = new Node[a+1];
		Node[] team2 = new Node[b+1];
		String str = br.readLine();
		for(int i = 1; i <=a ; i++) {
			team1[i] = new Node();
			team1[i].ch = str.charAt(i-1);
			team1[i].team = true;
		}
		String str2 = br.readLine();
		for(int i = 1; i <=b ; i++) {
			team2[i] = new Node();
			team2[i].ch = str2.charAt(i-1);
			team2[i].team = false;
		}
		int T = Integer.parseInt(br.readLine());		
		ArrayList<Node> teams = new ArrayList<Node>();
		for(int i = a ; i >= 1 ; i--) {
			teams.add(team1[i]);
		}
		for(int i = 1 ; i <= b ;i ++) {
			teams.add(team2[i]);
		}
		
		for(int i = 1; i<=T ; i++) {
			for(int j = a ; j>=1 ; j--) {
				for(int k = 0 ; k <=teams.size()-2 ; k++) {
					if(teams.get(k).ch == team1[j].ch) {
						if(teams.get(k+1).team != teams.get(k).team) {
							//자리 바꾸기
							Node temp = teams.get(k);
							teams.set(k, teams.get(k+1));
							teams.set(k+1, temp);
							break;
						}
						else {
							break;
						}
					}
				}
			}
		}
		String ans = "";
		for(int i = 0 ; i <= teams.size()-1 ; i++ ) {
			ans = ans + teams.get(i).ch;
		}
		System.out.println(ans);
		
	}

}
