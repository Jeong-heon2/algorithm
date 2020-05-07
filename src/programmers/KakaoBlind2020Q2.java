package programmers;
//괄호 변환
//국어를 잘해야하는 문제,,
//https://keepgoing0328.tistory.com/entry/2020%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B3%B5%EC%B1%84-%EA%B4%84%ED%98%B8-%EB%B3%80%ED%99%98-%EC%9E%90%EB%B0%94
//참고해서 풀었다.

//u,v로 분리하는 방법을 찾는 것이 가장 어려웠다.
public class KakaoBlind2020Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public String solution(String p) {
        
        return makeCorrect(p);
    }
    public String makeCorrect(String w){
        if(w.length() == 0){
            return "";
        }
        int dvIdx = getDevideIdx(w);
        String u = w.substring(0,dvIdx);
        String v = w.substring(dvIdx);
        if(isCorrect(u)){
            return u+makeCorrect(v);
        }else{
            String empty = "(" + makeCorrect(v) + ")";
            u = u.substring(1,u.length()-1);
            return empty + reverse(u);
        }
    }
    //u,v로 분리할 idx 반환
    public int getDevideIdx(String w){
        int open = 0;
        int close = 0;
        int i ;
        for( i = 0; i < w.length(); i++){
            if(w.charAt(i) == '(') open ++;
            else close++;
            if(open == close) return i+1;
        }
        return i;
    }
    //'옳바른 괄호 문자열'인지 아닌지
    public boolean isCorrect(String u){
        int cnt = 0;
        for(int i = 0 ; i < u.length(); i++){
            if(u.charAt(i) == '(') cnt ++;
            else cnt--;
            if(cnt<0) return false;
        }
        return (cnt == 0) ;
    }
    //괄호방향 뒤집어서 반환
    public String reverse(String w){
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < w.length() ; i++){
            if(w.charAt(i) == ')') sb.append('(');
            else sb.append(')');
        }
        return sb.toString();
    }

}
