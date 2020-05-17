package programmers;

import java.util.HashMap;

/*
[���� ����]
������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��,
 �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

[���ѻ���]
������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
������ �߿��� ���������� ���� �� �ֽ��ϴ�.
 */

//���ٹ� : hashmap 
public class HashQ1 {

	public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : participant){
            if(!map.containsKey(s)){
                map.put(s,1);
            }else{
                int val = map.get(s);
                map.put(s,val+1);
            }
        }
        for(String s : completion){
            int val = map.get(s);
            map.put(s,val-1);
        }
        for(String key : map.keySet()){
            if(map.get(key) == 1) return key;
        }
        return "";
    }

}
