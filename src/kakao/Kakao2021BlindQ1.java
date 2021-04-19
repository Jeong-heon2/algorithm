package kakao;

public class Kakao2021BlindQ1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("-_.~!@#$%^&*()=+[{]}:?,<>/"));
	}
	static class Solution {
	    public String solution(String new_id) {
	        return setId(new_id);
	    }
	    private static String setId(String id) {
	    	id = id.toLowerCase();
	    	id = id.replaceAll("[^\\da-z\\-\\_.]", "");//숫자 , 영소문자, - , _, .이 아니면 공백으로 치환 
	    	while(true) {
	    		int before = id.length();
	    		id = id.replace("..", ".");
	    		int after = id.length();
	    		if(before == after) {
	    			break;
	    		}
	    	}
	    	int size = id.length();
	    	if(size > 1) {
	    		id = removeDot(id);
	    	}else if(size == 1){
	    		if(id.charAt(0) == '.') id = "";
	    	}
	    	size = id.length();
	    	if(size == 0) {
	    		id = "a";
	    		size = 1;
	    	}
	    	if(size >= 16) {
	    		id = id.substring(0, 15);
	    		id = removeDot(id);
	    	}else if(size <= 2 ) {
	    		char ch = id.charAt(size-1);
	    		StringBuilder sb = new StringBuilder(id);
	    		while(size < 3) {
		    		sb.append(ch);
		    		size = sb.length();
	    		}
	    		id = sb.toString();
	    	}
	    	return id;
	    }
	    private static String removeDot(String id) {
	    	if(id.charAt(0) == '.') id = id.substring(1);
	    	if(id.charAt(id.length() - 1) == '.') id = id.substring(0, id.length()-1);
	    	return id;
	    }
	    
	    public String solution2(String new_id) {
	        String answer = "";
	        String temp = new_id.toLowerCase();

	        temp = temp.replaceAll("[^-_.a-z0-9]","");// - _ . 소문자  숫자 가 아닌 것
	        temp = temp.replaceAll("[.]{2,}",".");//.이 2개 이상 
	        temp = temp.replaceAll("^[.]|[.]$","");//.으로 시작 또는 .으로 끝남 
	        if(temp.equals(""))
	            temp+="a";
	        if(temp.length() >=16){
	            temp = temp.substring(0,15);
	            temp=temp.replaceAll("^[.]|[.]$","");
	        }
	        if(temp.length()<=2)
	            while(temp.length()<3)
	                temp+=temp.charAt(temp.length()-1);

	        answer=temp;
	        return answer;
	    }
	}

}
