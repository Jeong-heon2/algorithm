package programmers;
//��ȣ ��ȯ
//��� ���ؾ��ϴ� ����,,
//https://keepgoing0328.tistory.com/entry/2020%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B3%B5%EC%B1%84-%EA%B4%84%ED%98%B8-%EB%B3%80%ED%99%98-%EC%9E%90%EB%B0%94
//�����ؼ� Ǯ����.

//u,v�� �и��ϴ� ����� ã�� ���� ���� �������.
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
    //u,v�� �и��� idx ��ȯ
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
    //'�ǹٸ� ��ȣ ���ڿ�'���� �ƴ���
    public boolean isCorrect(String u){
        int cnt = 0;
        for(int i = 0 ; i < u.length(); i++){
            if(u.charAt(i) == '(') cnt ++;
            else cnt--;
            if(cnt<0) return false;
        }
        return (cnt == 0) ;
    }
    //��ȣ���� ����� ��ȯ
    public String reverse(String w){
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < w.length() ; i++){
            if(w.charAt(i) == ')') sb.append('(');
            else sb.append(')');
        }
        return sb.toString();
    }

}
