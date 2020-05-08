package programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 �־��� �װ����� ��� �̿��Ͽ� �����θ� ¥���� �մϴ�. �׻� ICN ���׿��� ����մϴ�.

�װ��� ������ ��� 2���� �迭 tickets�� �Ű������� �־��� ��, �湮�ϴ� ���� ��θ� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
��� ������ ���ĺ� �빮�� 3���ڷ� �̷�����ϴ�.
�־��� ���� ���� 3�� �̻� 10,000�� �����Դϴ�.
tickets�� �� �� [a, b]�� a ���׿��� b �������� ���� �װ����� �ִٴ� �ǹ��Դϴ�.
�־��� �װ����� ��� ����ؾ� �մϴ�.
���� ������ ��ΰ� 2�� �̻��� ��� ���ĺ� ������ �ռ��� ��θ� return �մϴ�.
��� ���ø� �湮�� �� ���� ���� �־����� �ʽ��ϴ�.
 */
public class DFSBFSQ4_2 {
	static ArrayList<String> list = new ArrayList<String>(); //��θ� ����� �� ���� ����
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
				//���� �湮���� �ʾҰ�  target�� ��ġ�Ѵٸ�
				if((visited & (1 << i)) == 0  &&  tickets[i][0].equals(target)) {
					//�湮�ߴ� ó��
					visited = visited | 1 << i;
					String next = tickets[i][1];
					DFS(tickets,visited,next,cnt + 1,route + " " +next);
					visited = visited & ~1 << i;
				}	
			}
		}
	}

}
