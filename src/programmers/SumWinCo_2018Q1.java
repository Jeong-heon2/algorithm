package programmers;

/*
[���� ����]
���� ��ų�̶� � ��ų�� ���� ���� ���� ����� �ϴ� ��ų�� ���մϴ�.

���� ��� ���� ��ų ������ ����ũ �� ����Ʈ�� ��Ʈ �� ����϶�, ����� ������ ���� ����Ʈ�� ��Ʈ�� ����� �ϰ�, ����Ʈ�� ��Ʈ�� ������ ���� ����ũ�� ����� �մϴ�.

�� ������ ���� �ٸ� ��ų(���� ��)�� ������ ������� ��� �� �ֽ��ϴ�. ���� ����ũ �� ���� �� ����Ʈ�� ��Ʈ �� ����� ���� ��ųƮ���� ����������, ��� �� ����ũ�� ����Ʈ�� ��Ʈ �� ����ũ �� ���� �� ����� ���� ��ųƮ���� �Ұ����մϴ�.

���� ��ų ���� skill�� �������� ���� ��ųƮ��1�� ���� �迭 skill_trees�� �Ű������� �־��� ��, ������ ��ųƮ�� ������ return �ϴ� solution �Լ��� �ۼ����ּ���.

[���� ����]
��ų�� ���ĺ� �빮�ڷ� ǥ���ϸ�, ��� ���ڿ��� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
��ų ������ ��ųƮ���� ���ڿ��� ǥ���մϴ�.
���� ���, C �� B �� D ��� CBD�� ǥ���մϴ�
���� ��ų ���� skill�� ���̴� 1 �̻� 26 �����̸�, ��ų�� �ߺ��� �־����� �ʽ��ϴ�.
skill_trees�� ���� 1 �̻� 20 ������ �迭�Դϴ�.
skill_trees�� ���Ҵ� ��ų�� ��Ÿ���� ���ڿ��Դϴ�.
skill_trees�� ���Ҵ� ���̰� 2 �̻� 26 ������ ���ڿ��̸�, ��ų�� �ߺ��� �־����� �ʽ��ϴ�.
 */
//���ٹ� : ����Ž�� 
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
	    				//�ùٸ� ��ų
	        			s = s.substring(1);
	    			}else {
	    				if(!s.contains(String.valueOf(curr.charAt(j)))){
	            			//�ùٸ� ��ų
	            		}else {
	            			//�߸���
	            			isRight = false;
	            			break;
	            		}
	    			}
        		}catch(Exception e) {
        			//s�� empty�� ���
        			//�����ִ� ��ų�� ��� �ùٸ���
        			//�ֳ��ϸ� �ߺ���ų�� �����ϱ�
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
