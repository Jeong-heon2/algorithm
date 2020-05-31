package programmers;
/*
[문제 설명]
무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 
구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.

구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.

사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 
매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

[제한사항]
무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
 */
//구명보트에 최대 2명밖에 못탄다는 제한 사항을 놓쳐서 엄청 헤맸다.
//나중에 다시 풀어 볼 것.
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
