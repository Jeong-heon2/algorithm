package programmers;
/*
[���� ����]
���ε��� ���� ������� ����Ʈ�� �̿��Ͽ� �����Ϸ��� �մϴ�. 
����Ʈ�� �۾Ƽ� �� ���� �ִ� 2�� �ۿ� Ż �� ����, ���� ���ѵ� �ֽ��ϴ�.

����Ʈ�� �ִ��� ���� ����Ͽ� ��� ����� �����Ϸ��� �մϴ�.

������� �����Ը� ���� �迭 people�� ����Ʈ�� ���� ���� limit�� 
�Ű������� �־��� ��, ��� ����� �����ϱ� ���� �ʿ��� ����Ʈ ������ �ּڰ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

[���ѻ���]
���ε��� ���� ����� 1�� �̻� 50,000�� �����Դϴ�.
�� ����� �����Դ� 40kg �̻� 240kg �����Դϴ�.
����Ʈ�� ���� ������ 40kg �̻� 240kg �����Դϴ�.
����Ʈ�� ���� ������ �׻� ������� ������ �� �ִ񰪺��� ũ�� �־����Ƿ� ������� ������ �� ���� ���� �����ϴ�.
 */
//����Ʈ�� �ִ� 2��ۿ� ��ź�ٴ� ���� ������ ���ļ� ��û ��̴�.
//���߿� �ٽ� Ǯ�� �� ��.
import java.util.Arrays;

public class GreedyQ4 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {40, 50, 40, 40, 50, 50, 60},
				240));
		
	}
	public static int solution(int[] people, int limit) {
        Arrays.sort(people);
 
        int answer = 0;
        int index = people.length - 1;
        for(int i = 0; i <= index; i++, answer++) 
            while(index > i && people[i] + people[index--] > limit) 
                answer++;
 
        return answer;
    }

}
