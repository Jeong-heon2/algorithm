package programmers;

import java.util.ArrayList;

/*�̺�Ʈ ������ ���̵� ����� ��� �迭 user_id�� �ҷ� ����� ���̵� ����� ��� �迭 banned_id�� �Ű������� �־��� ��, ��÷���� ���ܵǾ�� �� ���� ���̵� ����� ��� ����� ���� ������ �� return �ϵ��� solution �Լ��� �ϼ����ּ���.

[���ѻ���]
user_id �迭�� ũ��� 1 �̻� 8 �����Դϴ�.
user_id �迭 �� ���ҵ��� ���� ���̰� 1 �̻� 8 ������ ���ڿ��Դϴ�.
������ ����� ���̵���� ���� �ߺ����� �ʽ��ϴ�.
������ ����� ���̵�� ���ĺ� �ҹ��ڿ� ���ڷθ����� �����Ǿ� �ֽ��ϴ�.
banned_id �迭�� ũ��� 1 �̻� user_id �迭�� ũ�� �����Դϴ�.
banned_id �迭 �� ���ҵ��� ���� ���̰� 1 �̻� 8 ������ ���ڿ��Դϴ�.
�ҷ� ����� ���̵�� ���ĺ� �ҹ��ڿ� ����, ������ ���� ���� '*' �θ� �̷���� �ֽ��ϴ�.
�ҷ� ����� ���̵�� '*' ���ڸ� �ϳ� �̻� �����ϰ� �ֽ��ϴ�.
�ҷ� ����� ���̵� �ϳ��� ������ ���̵� �� �ϳ��� �ش��ϰ� ���� ������ ���̵� �ߺ��ؼ� ���� ���̵� ��Ͽ� ���� ���� �����ϴ�.
���� ���̵� ��ϵ��� ������ �� ���̵���� ������ ������ ������� ���̵� ����� ������ �����ϴٸ� ���� ������ ó���Ͽ� �ϳ��� ���� �˴ϴ�.
*/

//���Խ� , ����Ž��
public class Kakao2019WinterQ3 {
	private static ArrayList<ArrayList<String>> list = new ArrayList<>();
	private static int answer;
	public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        for(int i = 0 ; i < banned_id.length ; i ++) {
        	banned_id[i] = banned_id[i].replace("*", ".");//���Խ� ����� ���� ġȯ
        }
        boolean[] visited = new boolean[user_id.length];
        dfs(user_id,banned_id,0,visited);
        return answer;
    }
	//idx �� ���� �ܰ��� banned_id�� idx 
	//visited �� user_id�� ��ϵ� ���� �����ϴ� �뵵
	public void dfs(String[] user_id, String[] banned_id, int idx, boolean[] visited) {
		if(idx == banned_id.length) {//banned_id�� ��� �˻���.  list�� �ߺ��ȵǾ��ֳ� Ȯ���ϰ� �˻��ؾ��Ѵ�.
			ArrayList<String> tempList = new ArrayList<>();
			for(int i = 0 ; i < visited.length ; i++) {
				if(visited[i]) {
					tempList.add(user_id[i]);
				}
			}
			// templist��  frod fradi abc123 frodoc �̷������� ����ȴ�.
			// templist�� �� ��Ҹ� list ��  arraylist�� ��ҵ�� �˻��ؾ��Ѵ�. 
			int cnt = 0;
			for(int i = 0 ; i < list.size() ; i++) {
				ArrayList<String> getList = list.get(i);
				boolean flag = false;
				for(int j = 0 ; j < getList.size(); j++) {
					if(!tempList.contains(getList.get(j))){
						flag = true; //�ϳ��� ��Ī�� �ȵǴ°� ������  getList�� tempList�� ���δٸ� ����Ʈ�̴�.
					}
				}
				if(flag) cnt ++;
				else break;// list��  ��ҿ� ���� �༮�� �߰������Ƿ�  �������� �˻����� �ʾƵ� �ȴ�.
			}
			if(cnt == list.size()) {//list�� ��� ��ҵ�� ��Ī�� �ȵ�. �� ���ο� ����Ʈ�̹Ƿ� �߰��ؾ��Ѵ�.
				list.add(tempList);
				answer++;
			}
			return;
		}
		
		for(int i = 0 ; i < user_id.length ; i ++) {
			if(!visited[i] && user_id[i].matches(banned_id[idx])) {
				visited[i] = true;
				dfs(user_id, banned_id, idx+1, visited);
				visited[i] = false;// �ٽ� false ������� ���� 
			}
		}
	}
	
}
