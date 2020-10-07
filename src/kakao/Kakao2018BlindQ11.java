package kakao;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class Kakao2018BlindQ11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
	}
	
	static class Solution {
	    public String[] solution(String[] files) {
	        Pattern h_pattern = Pattern.compile("[^0-9]{1,}");
	        Pattern n_pattern = Pattern.compile("[0-9]{1,5}");
	        
	        Arrays.sort(files, new Comparator<String>(){
	            @Override
	            public int compare(String o1, String o2){
	                //head 비교
	            	Matcher h_m_o1 = h_pattern.matcher(o1);
	                h_m_o1.find();
	                
	                Matcher h_m_o2 = h_pattern.matcher(o2);
	                h_m_o2.find();
	                /*
	                h_m_o1.group();//o1의 head 
	                h_m_o2.group();//o2의 head*/
	                
	                int h_res = h_m_o1.group().toLowerCase().compareTo(h_m_o2.group().toLowerCase());
	                
	                if(h_res > 0){
	                    return 1;
	                }else if(h_res == 0){
	                    //number 비교
	                    Matcher n_m_o1 = n_pattern.matcher(o1);
	                    n_m_o1.find(h_m_o1.end());//head 뒤 부터 find 
	                    int n1 = Integer.parseInt(n_m_o1.group());
	                    
	                    Matcher n_m_o2 = n_pattern.matcher(o2);
	                    n_m_o2.find(h_m_o2.end());//head 뒤 부터 find 
	                    int n2 = Integer.parseInt(n_m_o2.group());
	                    
	                    return n1-n2;
	                    
	                }else{
	                    return -1;
	                }
	            }
	        });
	        /*
	        String a = "foo010bar020.zip";
	        Matcher m = h_pattern.matcher(a);
	        System.out.println(m.find());
	        System.out.println(m.start());
	        System.out.println(m.group());
	        int s = m.end();
	        m = n_pattern.matcher(a);
	        System.out.println(m.find(s));
	        System.out.println(m.start());*/
	        return files;
	    }
	}

}
