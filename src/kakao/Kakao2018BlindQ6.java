package kakao;

public class Kakao2018BlindQ6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		Solution s = new Solution();
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		s.solution(a, arr1, arr2);
	}
	static class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        int[] arr = new int[n];
	        for(int i = 0 ; i < n; i++){
	            arr[i] = arr1[i] | arr2[i];
	        }
	        for(int i= 0 ; i < n ; i++){
	            StringBuilder sb = new StringBuilder();
	            for(int j = n-1 ; j >= 0 ; j--){
	                if((arr[i] & (1 << j)) != 0 ) {
	                    sb.append("#");
	                }else{
	                    sb.append(" ");
	                }
	            }
	            answer[i] = sb.toString();
	        }
	        return answer;
	    }
	}

}
