package kakao;

public class Kakao2021BilndQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution("=.=");
		String q = "- and - and - and chicken 100";
		String[] qs = q.split(" and ");
		System.out.println(qs[0]);
	}
	static class Solution {
	    public String solution(String new_id) {
	        String answer = getNewId(new_id);
	        return answer;
	    }
	    public String getNewId(String id){
	        id = id.toLowerCase();
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < id.length(); i++){
	            char ch = id.charAt(i);
	            if(checkChar(ch)){
	                sb.append(String.valueOf(ch));
	            }
	        }
	        String newId = sb.toString();
	        sb = new StringBuilder();
	        int dot_cnt = 0;
	        for(int i = 0; i < newId.length(); i++){
	            char ch = newId.charAt(i);
	            if(ch == '.'){
	                dot_cnt++;
	            }else{
	                if(dot_cnt >= 1){
	                    dot_cnt = 0;
	                    sb.append(
	                    		'.');
	                }
	                sb.append(String.valueOf(ch));
	            }
	        }
	        if(dot_cnt >= 1){
                dot_cnt = 0;
                sb.append(".");
            }
	        newId = sb.toString();
	        if(newId.charAt(0) == '.') sb.deleteCharAt(0);
	        if(sb.length() > 0){
	            if(newId.charAt(newId.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
	        }
	        if(sb.length() == 0) {
	            sb.append("a");
	        }else if(sb.length() >= 16){
	            sb.delete(15, sb.length());
	            newId = sb.toString();
	            if(newId.charAt(newId.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
	        }
	        newId = sb.toString();
	        if(newId.length() <= 2){
	            char last = newId.charAt(newId.length()-1);
	            while(sb.length() < 3){
	                sb.append(String.valueOf(last));
	            }
	        }
	        return sb.toString();
	    }
	    public boolean checkChar(char ch){
	        if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') ||
	           ch == '-' || ch == '_' || ch == '.' ){
	            return true;
	        }else{
	            return false;
	        }
	    }
	}

}
