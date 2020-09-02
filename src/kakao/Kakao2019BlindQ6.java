package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kakao2019BlindQ6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//page �о normal ���� ���
		
		String[] s = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		Solution sl = new Solution();
		sl.solution("Muzi", s);
	}
	static class Solution {
	    HashMap<String, Integer> urlNumMap = new HashMap<>();
	    
	    public int solution(String word, String[] pages) {
	        WebSite[] sites = new WebSite[pages.length];
	        for(int i = 0 ; i < pages.length; i++){
	            sites[i] = new WebSite(i, pages[i], word);
	        }
	        for(WebSite ws : sites){
	            for(String url : ws.outLinks){
	                if(urlNumMap.containsKey(url)){
	                    sites[urlNumMap.get(url)].link_point += ((double)ws.normal_point/(double)ws.outLinks.size()) ;
	                }
	            }
	            
	        }
	        int ansIdx = 0;
	        double ans = 0;
	        for(WebSite ws : sites){
	            double match_point = ws.link_point + (double)ws.normal_point;
	            if(ans < match_point ){
	                ans = match_point;
	                ansIdx = ws.idx;
	            }else if (ans == match_point){
	                if(ansIdx > ws.idx){
	                    ansIdx = ws.idx;
	                }
	            }
	        }
	        return ansIdx;
	    }
	    class WebSite{
	        double link_point = 0;
	        int idx;
	        int normal_point = 0;
	        String page, url;
	        ArrayList<String> outLinks;
	        
	        public WebSite(int idx, String page, String word){
	            this.idx = idx;
	            this.page = page.toLowerCase();
	            setNormalPoint(word.toLowerCase());
	            setUrl();
	            urlNumMap.put(url, idx);
	            outLinks = new ArrayList<>();
	            setOutLinks();
	        }
	        //�⺻���� ���ϱ� 
	        private void setNormalPoint(String word) {
	        	int idx = page.indexOf(word);
	        	while (idx != -1) { 
	        		char pre = page.charAt(idx - 1); 
	        		char post = page.charAt(idx + word.length());
	        		//word�� �յ� ��� ���ĺ��� �ƴϿ��� �Ѵ�.
	        		if (!Character.isAlphabetic(pre) && !Character.isAlphabetic(post)) { 
	        			normal_point++; 
	        		}
	        		//page�� idx+1 ��° ���� word�� ã�ƶ�. 
	        		idx = page.indexOf(word, idx + 1); 
	        	} 
	        	
	        } 
	        
	        //pattern�ȿ� ()�� ���� ���� matcher.group(��ȣ)�� ã�� �� �ִ�. 
	        private void setOutLinks(){
	            Pattern pattern = Pattern.compile("<a href=\"https://(.+?)\">");
	            Matcher matcher = pattern.matcher(this.page);
	            while(matcher.find()) {
	                outLinks.add(matcher.group(1));
	            }
	        }
	        private void setUrl(){
	            Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
	            Matcher matcher = pattern.matcher(this.page);
	            while(matcher.find()) {
	                url = matcher.group(1);
	                return;
	            }
	        }
	        
	    }
	}

}
