package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * ä�ù濡 ������ �����ų�, �г����� ������ ����� ��� ���ڿ� �迭 record�� �Ű������� �־��� ��, ��� ����� ó���� ��, ���������� ���� ������ ����� ���� �Ǵ� �޽����� ���ڿ� �迭 ���·� return �ϵ��� solution �Լ��� �ϼ��϶�.

���ѻ���
record�� ������ ���� ���ڿ��� ��� �迭�̸�, ���̴� 1 �̻� 100,000 �����̴�.
������ record�� ��� ���ڿ��� ���� �����̴�.
��� ������ [���� ���̵�]�� �����Ѵ�.
[���� ���̵�] ����ڰ� [�г���]���� ä�ù濡 ���� - Enter [���� ���̵�] [�г���] (ex. Enter uid1234 Muzi)
[���� ���̵�] ����ڰ� ä�ù濡�� ���� - Leave [���� ���̵�] (ex. Leave uid1234)
[���� ���̵�] ����ڰ� �г����� [�г���]���� ���� - Change [���� ���̵�] [�г���] (ex. Change uid1234 Muzi)
ù �ܾ�� Enter, Leave, Change �� �ϳ��̴�.
�� �ܾ�� �������� ���еǾ� ������, ���ĺ� �빮��, �ҹ���, ���ڷθ� �̷�����ִ�.
���� ���̵�� �г����� ���ĺ� �빮��, �ҹ��ڸ� �����Ѵ�.
���� ���̵�� �г����� ���̴� 1 �̻� 10 �����̴�.
ä�ù濡�� ���� ������ �г����� �����ϴ� �� �߸� �� �Է��� �־����� �ʴ´�.
 */
public class KakaoBlind2019OpenChatting {
	private static HashMap<String,String> idMap = new HashMap<String,String>();
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
	public static String[] solution(String[] record) {
        ArrayList<String> ansList = new ArrayList<>();//��� ���� �𸣴ϱ� list.
        
        
        for(int i = 0 ; i < record.length ; i++) {
        	String[] strArr = record[i].split(" ");
        	switch(strArr[0]) {
	        	case "Enter" : {
	        		idMap.put(strArr[1], strArr[2]);
	        		ansList.add(strArr[1]+"���� ���Խ��ϴ�.");
	        		break;
	        		
	        	}
	        	case "Leave" : {
	        		
	        		ansList.add(strArr[1]+"���� �������ϴ�.");	
	        		
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
        	String[] textArr = text.split("��");
        	String id = textArr[0];
        	text = text.replace(id, idMap.get(id));
        	answer[i] = text;
        	i++;
        }
        return answer;
    }


}
