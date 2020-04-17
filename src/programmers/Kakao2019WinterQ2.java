package programmers;

import java.util.ArrayList;

public class Kakao2019WinterQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
	}
	public static int[] solution(String s) {
        int size = s.length();
        int idx= 0;
        int max = 0;
        boolean state = false;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(500);
        for(int i = 0 ; i< 500 ; i ++){
            arr.add(new ArrayList<Integer>());
        }
        String str = "";
        while(size-- >0){
            char ch = s.charAt(idx);
            if(ch  == '{'){
                state = true;
            }else if(ch == ','){
                if(state){
                    list.add(Integer.parseInt(str));
                    str= "";
                }
            }else if(ch == '}'){
                if(state){
                    list.add(Integer.parseInt(str));
                    str= "";
                    int listSize = list.size();
                    if(listSize > max) max = listSize;
                    arr.get(listSize-1).addAll(list);
                    list.clear();
                    state = false;
                }
            }else{
                if(state){
                    str = str+ch;
                    
                }
            }
            idx++;
        }
        //차집합 구하기
        int[] ans = new int[max];
        ans[0] = arr.get(0).get(0);
        if(max > 1){
            for(int i = 1 ; i < max ; i++){
                ArrayList<Integer> lst2 = arr.get(i);
                ArrayList<Integer> lst = arr.get(i-1);
                //lst2에서 lst에는 없는 원소 찾아야함.
                for(int j = 0; j < lst2.size() ; j++){
                    if(!lst.contains(lst2.get(j))){
                        ans[i] = lst2.get(j);
                    }
                }
            }
        }
        return ans;
    }
}
