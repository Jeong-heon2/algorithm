package programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 */
public class DFSBFSQ4_2 {
	static ArrayList<String> list = new ArrayList<String>(); //경로를 여기다 다 담을 것임
	public static void main(String[] args) {
		String[][] tickets = {{"ICN","SFO"},{"SFO","ICN"},{"ICN","SFO"},
				{"SFO","QRE"}
		};
		String[] result = solution(tickets);
		for(String str : result) {
			System.out.println(str);
		}
	}
	public static String[] solution(String[][] tickets) {
	    String[] answer = {};
	    DFS(tickets,0,"ICN",0,"ICN");
	    int size = list.size();
	    Collections.sort(list);
	    String ans = list.get(0);
	    answer = ans.split(" ");
	    return answer;
	}
	public static void DFS(String[][] tickets,int visited,String target,int cnt,String route) {
		if(cnt == tickets.length) {
			list.add(route);
			return;
		}
		else {
			for(int i = 0 ; i < tickets.length; i++) {
				//아직 방문하지 않았고  target과 일치한다면
				if((visited & (1 << i)) == 0  &&  tickets[i][0].equals(target)) {
					//방문했다 처리
					visited = visited | 1 << i;
					String next = tickets[i][1];
					DFS(tickets,visited,next,cnt + 1,route + " " +next);
					visited = visited & ~1 << i;
				}	
			}
		}
	}

}
