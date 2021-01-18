package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1092 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();
		for(int i = 0 ; i <  M ; i++) {
			box.add(Integer.parseInt(st2.nextToken()));
		}
		
		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		
		int time = 0;//걸린 시간
        if(box.get(0) > crane.get(0)) {
            System.out.println("-1");
        }else{
            while(box.size() != 0){
                int idx = 0;//crane idx
                int i = 0;//box idx
                while(idx < N){
                    if(i == box.size())
                        break;
                    if(box.get(i) <= crane.get(idx)){
                    	box.remove(i);
                        idx++;
                    }else{
                       i++;
                    }
                }
                time++;
            }
            System.out.println(time);
        }
	}
}
