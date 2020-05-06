package programmers;

import java.util.ArrayList;

/*이벤트 응모자 아이디 목록이 담긴 배열 user_id와 불량 사용자 아이디 목록이 담긴 배열 banned_id가 매개변수로 주어질 때, 당첨에서 제외되어야 할 제재 아이디 목록은 몇가지 경우의 수가 가능한 지 return 하도록 solution 함수를 완성해주세요.

[제한사항]
user_id 배열의 크기는 1 이상 8 이하입니다.
user_id 배열 각 원소들의 값은 길이가 1 이상 8 이하인 문자열입니다.
응모한 사용자 아이디들은 서로 중복되지 않습니다.
응모한 사용자 아이디는 알파벳 소문자와 숫자로만으로 구성되어 있습니다.
banned_id 배열의 크기는 1 이상 user_id 배열의 크기 이하입니다.
banned_id 배열 각 원소들의 값은 길이가 1 이상 8 이하인 문자열입니다.
불량 사용자 아이디는 알파벳 소문자와 숫자, 가리기 위한 문자 '*' 로만 이루어져 있습니다.
불량 사용자 아이디는 '*' 문자를 하나 이상 포함하고 있습니다.
불량 사용자 아이디 하나는 응모자 아이디 중 하나에 해당하고 같은 응모자 아이디가 중복해서 제재 아이디 목록에 들어가는 경우는 없습니다.
제재 아이디 목록들을 구했을 때 아이디들이 나열된 순서와 관계없이 아이디 목록의 내용이 동일하다면 같은 것으로 처리하여 하나로 세면 됩니다.
*/

//정규식 , 완전탐색
public class Kakao2019WinterQ3 {
	private static ArrayList<ArrayList<String>> list = new ArrayList<>();
	private static int answer;
	public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        for(int i = 0 ; i < banned_id.length ; i ++) {
        	banned_id[i] = banned_id[i].replace("*", ".");//정규식 사용을 위한 치환
        }
        boolean[] visited = new boolean[user_id.length];
        dfs(user_id,banned_id,0,visited);
        return answer;
    }
	//idx 는 현재 단계의 banned_id의 idx 
	//visited 는 user_id가 기록된 곳을 저장하는 용도
	public void dfs(String[] user_id, String[] banned_id, int idx, boolean[] visited) {
		if(idx == banned_id.length) {//banned_id를 모두 검사함.  list에 중복안되어있나 확인하고 검사해야한다.
			ArrayList<String> tempList = new ArrayList<>();
			for(int i = 0 ; i < visited.length ; i++) {
				if(visited[i]) {
					tempList.add(user_id[i]);
				}
			}
			// templist에  frod fradi abc123 frodoc 이런식으로 저장된다.
			// templist의 각 요소를 list 각  arraylist의 요소들과 검사해야한다. 
			int cnt = 0;
			for(int i = 0 ; i < list.size() ; i++) {
				ArrayList<String> getList = list.get(i);
				boolean flag = false;
				for(int j = 0 ; j < getList.size(); j++) {
					if(!tempList.contains(getList.get(j))){
						flag = true; //하나라도 매칭이 안되는게 있으면  getList와 tempList는 서로다른 리스트이다.
					}
				}
				if(flag) cnt ++;
				else break;// list의  요소와 같은 녀석을 발견했으므로  나머지는 검사하지 않아도 된다.
			}
			if(cnt == list.size()) {//list의 모든 요소들과 매칭이 안됨. 즉 새로운 리스트이므로 추가해야한다.
				list.add(tempList);
				answer++;
			}
			return;
		}
		
		for(int i = 0 ; i < user_id.length ; i ++) {
			if(!visited[i] && user_id[i].matches(banned_id[idx])) {
				visited[i] = true;
				dfs(user_id, banned_id, idx+1, visited);
				visited[i] = false;// 다시 false 해줘야함 주의 
			}
		}
	}
	
}
