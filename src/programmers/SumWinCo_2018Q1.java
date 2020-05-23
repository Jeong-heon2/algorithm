package programmers;

/*
[문제 설명]
선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

[제한 조건]
스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
스킬 순서와 스킬트리는 문자열로 표기합니다.
예를 들어, C → B → D 라면 CBD로 표기합니다
선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
skill_trees는 길이 1 이상 20 이하인 배열입니다.
skill_trees의 원소는 스킬을 나타내는 문자열입니다.
skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 */
//접근법 : 완전탐색 
public class SumWinCo_2018Q1 {

	public static void main(String[] args) {
		
		System.out.println(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
	}
	public static int solution(String skill, String[] skill_trees) {
		int size = skill_trees.length;
        int answer = size;
        for(int i = 0 ; i < size ; i++ ) {
        	String s = skill;
        	String curr = skill_trees[i];
        	boolean isRight = true;
        	for(int j = 0 ; j < curr.length() ; j++) {
        		try {
	        		if(s.charAt(0) == curr.charAt(j)) {
	    				//올바른 스킬
	        			s = s.substring(1);
	    			}else {
	    				if(!s.contains(String.valueOf(curr.charAt(j)))){
	            			//올바른 스킬
	            		}else {
	            			//잘못됨
	            			isRight = false;
	            			break;
	            		}
	    			}
        		}catch(Exception e) {
        			//s가 empty일 경우
        			//남아있는 스킬은 모두 올바르다
        			//왜냐하면 중복스킬이 없으니까
        			break;
        		}
        	}
        	if(!isRight) {
    			answer--;
    		}
        }
        return answer;
    }

}
