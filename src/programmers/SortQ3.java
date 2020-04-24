package programmers;

import java.util.Arrays;

public class SortQ3 {

	public static void main(String[] args) {
		int a = solution(new int[] {0,1,1,1,2,6,6});

	}
	public static int solution(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;
        int answer = 0;
        int hIdx = 0;
        int count = 0;
        for(int i = size-1 ; i >= 0 ; i--){
            answer = citations[i];
            count++;
            if(count >= answer){
                if(count > hIdx){
                    hIdx = answer;
                }
            }
        }
        return hIdx;
    }

}
