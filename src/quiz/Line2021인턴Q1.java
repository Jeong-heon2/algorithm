package quiz;

public class Line2021¿Œ≈œQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Solution {
	    public int solution(String inputString) {
	        int len = inputString.length();
	        int idx = 1; // 1~999
	        int idx2 = 0; // idx¿« idx 
	        String str = String.valueOf(idx);
	        for(int i = 0 ; i < len ; i++){
	            char ch = inputString.charAt(i);
	            while(idx < 1000 && !check(str, ch, idx2)){
	                idx2++;
	                if(str.length() <= idx2){
	                    idx2 = 0;
	                    idx++;
	                    str = String.valueOf(idx);
	                }
	            }
	            idx2++;
	            if(str.length() <= idx2){
	                idx2 = 0;
	                idx++;
	                str = String.valueOf(idx);
	            }
	        }
	        if(idx2 == 0) return idx-1;
	        else return idx;
	    }
	    private boolean check(String a, char b, int idx2){
	        if(a.charAt(idx2) == b) return true;
	        return false;
	    }
	}

}
