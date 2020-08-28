package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.

제한사항
record는 다음과 같은 문자열이 담긴 배열이며, 길이는 1 이상 100,000 이하이다.
다음은 record에 담긴 문자열에 대한 설명이다.
모든 유저는 [유저 아이디]로 구분한다.
[유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - Enter [유저 아이디] [닉네임] (ex. Enter uid1234 Muzi)
[유저 아이디] 사용자가 채팅방에서 퇴장 - Leave [유저 아이디] (ex. Leave uid1234)
[유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - Change [유저 아이디] [닉네임] (ex. Change uid1234 Muzi)
첫 단어는 Enter, Leave, Change 중 하나이다.
각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.
 */
public class KakaoBlind2019OpenChatting {
	private static HashMap<String,String> idMap = new HashMap<String,String>();
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
	public static String[] solution(String[] record) {
        ArrayList<String> ansList = new ArrayList<>();//몇개가 될지 모르니까 list.
        
        
        for(int i = 0 ; i < record.length ; i++) {
        	String[] strArr = record[i].split(" ");
        	switch(strArr[0]) {
	        	case "Enter" : {
	        		idMap.put(strArr[1], strArr[2]);
	        		ansList.add(strArr[1]+"님이 들어왔습니다.");
	        		break;
	        		
	        	}
	        	case "Leave" : {
	        		
	        		ansList.add(strArr[1]+"님이 나갔습니다.");	
	        		
	        		break;
	        	}
	        	case "Change" : {
	        		idMap.put(strArr[1], strArr[2]);
	        		break;
	        	}

        	}
        }
        String[] answer = new String[ansList.size()];
        int i = 0;
        for(String text : ansList) {
        	String[] textArr = text.split("님");
        	String id = textArr[0];
        	text = text.replace(id, idMap.get(id));
        	answer[i] = text;
        	i++;
        }
        return answer;
    }


}
