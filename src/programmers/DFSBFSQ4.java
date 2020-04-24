package programmers;

import java.util.ArrayList;

public class DFSBFSQ4 {
	static ArrayList<ArrayList<String>> list = new ArrayList<>();
	public static void main(String[] args) {
		String[] answer = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
	}
    public static String[] solution(String[][] tickets) {
        int size = tickets.length;
        ArrayList<String> answer ;
        for(int i = 0 ; i < size ; i++){
            if(tickets[i][0].equals("ICN")){
            	ArrayList<String> route = new ArrayList<>();
            	boolean[] isMarked = new boolean[size];
                route.add("ICN");
                isMarked[i] = true;
                DFS(tickets,isMarked,i,route);
            }
        }
        answer = list.get(0);
        for(int i = 1 ; i < list.size(); i++){
            ArrayList<String> list2 = list.get(i);
            for(int j = 0 ; j < size+1 ; j++){
                int result =  answer.get(j).compareTo(list2.get(j));
                if(result == 0){
                    continue;
                }else if(result == 1){//list2가 사전적으로 더 앞에있다
                    answer = list2;
                    break;
                }else{
                    break;
                }
            }
            
        }
        String[] ans = new String[size+1];
        answer.toArray(ans);
        return ans;
    }
    public static void DFS(String[][] tickets, boolean[] isMarked, int idx, ArrayList<String> route ){
        if(route.size() > tickets.length+1 ){
            return;
        }
        else{
            isMarked[idx] = true;
            String next = tickets[idx][1];
            route.add(next);
            for(int i = 0 ; i < tickets.length; i++){
                if(next.equals(tickets[i][0]) && !isMarked[i]){//다음 목적지와 같고 방문하지 않은 행
                    DFS(tickets, isMarked,i,route);
                }
            }
        }
        if(route.size() == tickets.length+1 ){
            list.add(route);
            return;
        }
    }
	

}
