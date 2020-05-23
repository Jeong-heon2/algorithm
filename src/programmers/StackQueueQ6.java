package programmers;

public class StackQueueQ6 {

	public static void main(String[] args) {
		int[] result = solution(new int[] {1,2,6,23,4,3,0,2,12});
		for(int i = 0 ; i < result.length ; i ++) {
			System.out.println(result[i]);
		}

	}
	public static int[] solution(int[] prices) {
        int[] answer = {};
        int size = prices.length;
        answer = new int[size];
        
        for(int i = 0 ; i < size-1 ; i++){
            int n = prices[i];
            for(int j = i+1 ; j<size ; j++){
                if(n<=prices[j]) answer[i] += 1;
            }
        }
        return answer;
    }

}
