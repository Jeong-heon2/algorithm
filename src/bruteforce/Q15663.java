package bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Q15663 {
	static int[] arr;
	static int N;
	static int M;
	static LinkedHashSet<String> hs;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);//먼저 정렬하고 앞에서 부터 뽑으면 사전 순대로 뽑힘 
		hs = new LinkedHashSet<>();//저장한 순서대로 link 되기 때문에 hashset을 출력할때  저장한 순서대로 출력이 됨 
	    visited = new boolean[N];
	    pickNum(0, "");
		for(String s : hs) {
			bw.write(s + "\n");
		}
		bw.flush();
		bw.close(); br.close();
	}
	public static void pickNum(int count, String str){
        if(count>=M){
            hs.add(str);
        }
        else{
            for(int i = 0 ; i < N; i++){
                if(!visited[i]){
                    visited[i] =true;
                    pickNum(count+1, str + arr[i] + " ");
                    visited[i] =false;
                }
            }
        }
    }

}
