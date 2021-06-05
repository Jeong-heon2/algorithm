package quiz;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Line2021인턴Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int n = 2;
		String[] data = {"a1 1 6 6", "a2 1 2 9", "b1 2 3 3", "b2 2 4 1"};
		String limit = "0 0";
		s.solution(n, data, limit);
	}
	static class Solution {
	    int N;
	    Data[] datas;
	    int[] limits;
	    int min;
	    ArrayList<Data> ansList;
	    public String[] solution(int n, String[] data, String limit) {
	        ansList = new ArrayList<>();
	        N = n;
	        min = Integer.MAX_VALUE;
	        limits = new int[2];
	        StringTokenizer st = new StringTokenizer(limit);
	        limits[0] = Integer.parseInt(st.nextToken());
	        limits[1] = Integer.parseInt(st.nextToken());
	        if(limits[0] == 0) limits[0] = Integer.MAX_VALUE;
	        if(limits[1] == 0) limits[1] = Integer.MAX_VALUE;
	        datas = new Data[data.length];
	        for(int i = 0 ; i < data.length ; i++){
	            st = new StringTokenizer(data[i]);
	            String name = st.nextToken();
	            int num = Integer.parseInt(st.nextToken());
	            int time = Integer.parseInt(st.nextToken());
	            int space = Integer.parseInt(st.nextToken());
	            datas[i] = new Data(name, num, time, space);
	        }
	        combi(new boolean[data.length], 0, data.length, n);
	        int size = ansList.size();
	        
	        String[] answer = new String[size];
	        
	        for(int i = 0 ; i < size ; i++){
	            answer[i] = ansList.get(i).alName;
	        }
	        return answer;
	    }
	    private void combi( boolean[] visited, int start, int len, int r){
	        if(r==0){
	            int time = 0;
	            int space = 0;
	            boolean[] check = new boolean[N+1];//각 문제가 다 포함 되었는지 
	            ArrayList<Data> list = new ArrayList<>();
	            for(int i = 0 ; i <  len; i++){
	                if(visited[i]){
	                    time += datas[i].time;
	                    space += datas[i].space;
	                    check[datas[i].n] = true;
	                    list.add(datas[i]);
	                }
	            }
	            for(int i = 1 ; i <=  N; i++){
	                if(!check[i]){
	                    return;
	                }
	            }
	            
	            if(limits[0] >= time && limits[1] >= space){
	                if(min > time + space){
	                    min = time + space;
	                    ansList = list;
	                }
	            }
	        }else{
	            for(int i = start ; i < len ; i++){
	                visited[i] = true;
	                combi(visited, i+1, len, r-1);
	                visited[i] = false;
	            }
	        }
	    }
	    class Data{
	        String alName;
	        int n;
	        int time;
	        int space;
	        public Data(String name, int n, int t, int s){
	            this.alName = name;
	            this.n = n;
	            this.time = t;
	            this.space = s;
	        }
	    }
	}

}
