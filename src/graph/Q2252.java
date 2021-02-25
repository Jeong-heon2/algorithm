package graph;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
 
public class Q2252 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
        	tmp = br.readLine().split(" ");
        	int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            list[x].add(y);
            indegree[y]++;
        }
        
        //위상정렬 
        Queue<Integer> q = new LinkedList<Integer>();
        //indegree 0 이면 큐에 넣는다 
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(q.size() > 0){
            int current = q.poll();
            bw.write(current+ " ");
            //다음 노드들을 방문하여  indegree -1 해주고 만약 0이면 큐에 넣는다. 
            for(int next : list[current]){
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
 
}

