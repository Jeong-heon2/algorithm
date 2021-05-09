package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1613 {

    static int n;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1][n+1];
        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            arr[before][after] = -1;//arr[i][k] == -1 이면 i가 선행 
            arr[after][before] = 1;//arr[i][k] == 1이면 i가 후행 
        }
        
        floyd_warshall();
        
        int S = Integer.parseInt(br.readLine());
        for(int s=0; s<S; s++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(arr[a][b] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
    
    public static void floyd_warshall() {
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(arr[i][j] == 0) {
                        if(arr[i][k] == 1 && arr[k][j] == 1) {
                        	arr[i][j] = 1;
                        }
                        else if(arr[i][k] == -1 && arr[k][j] == -1) {
                        	arr[i][j] = -1;
                        }
                    }
                }
            }
        }
    }

}
