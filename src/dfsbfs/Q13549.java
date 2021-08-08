package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q13549 {
    private static int N; 
    private static int K; 
    private static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        answer = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
    	boolean[] isVisited = new boolean[100001];
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(N, 0));
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            isVisited[cur.x] = true; 
            
            if (cur.x == K) {
                answer = cur.cnt;
                return;//이동횟수가 적은게 우선순위 이므로 K에 먼저 도달하면 그게 정답. 
            }
            
            int nx = cur.x * 2;
            if (nx <= 100000 && !isVisited[nx]) { //순간이동 우선. 
                q.offer(new Point(nx, cur.cnt));
            }
            nx = cur.x + 1;
            if (nx <= 100000 && !isVisited[nx]) { 
                q.offer(new Point(nx, cur.cnt + 1));
            }
            nx = cur.x -1;
            if (nx >= 0 && !isVisited[nx]) { 
                q.offer(new Point(nx, cur.cnt + 1));
            }
        }
    }
    //cnt는 이동횟수.  이동횟수가 적은게 우선순위. 
    private static class Point implements Comparable<Point>{
        int x;
        int cnt;

        public Point(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }

}
