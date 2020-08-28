package kakao;
//호텔 방배정
//방이 총 k개  1~ k번
//초기에 모든 방은 비어잇다.
/*
[조건]
한 번에 한 명씩 신청한 순서대로 방을 배정합니다.
고객은 투숙하기 원하는 방 번호를 제출합니다.
고객이 원하는 방이 비어 있다면 즉시 배정합니다.
고객이 원하는 방이 이미 배정되어 있으면 원하는 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방을 배정합니다.
전체 방 개수 k와 고객들이 원하는 방 번호가 순서대로 들어있는 배열 room_number가 매개변수로 
주어질 때, 각 고객에게 배정되는 방 번호를 순서대로 배열에 담아 return 하도록
 solution 함수를 완성해주세요.
[제한 사항]
k는 1 이상 10의 12승 이하인 자연수입니다.
room_number 배열의 크기는 1 이상 200,000 이하입니다.
room_number 배열 각 원소들의 값은 1 이상 k 이하인 자연수입니다.
room_number 배열은 모든 고객이 방을 배정받을 수 있는 경우만 입력으로 주어집니다.
예를 들어, k = 5, room_number = [5, 5] 와 같은 경우는 
방을 배정받지 못하는 고객이 발생하므로 이런 경우는 입력으로 주어지지 않습니다.
*/
//처음 접근 법 :  bitmask를 이용하여  visited 체크 
public class Kakao2019WinterQ4 {
	public long[] solution(long k, long[] room_number) {
		int roomLength = room_number.length;
        long[] answer = new long[roomLength];
        long visited = 0;
        for(int i = 0 ; i < roomLength ; i++ ) {
        	long num = room_number[i];//num은 고객이 원하는 방 번호
        	if((visited & (1 << num)) == 0) { // num 번째 비트가 0인가 ? 즉  num번 방이 비었는가?
        		//비었다면 즉시 배정
        		visited = visited | (1 << num);
        		//배정 되었으므로 배열에 추가
        		answer[i] = num;
        	}
        	else {
        		//방이 비어있지 않음  새로운 방을 조건에 맞게 찾아야함.
        		while((visited & (1 << num++)) != 0) //방을 배정받지 못하는 경우는 입력으로 주어지지 않는다
        		visited = visited | (1 << num);
        		//배정 되었으므로 배열에 추가
        		answer[i] = num;
        	}
        }
        return answer;
    }
	//시간 초과
}
