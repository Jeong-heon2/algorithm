package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1194 {
	 
    static int N, M, min = Integer.MAX_VALUE;
    static char[][] map = new char[51][51];
    static boolean[][][] visited = new boolean[51][51][1<<6];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Position> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
 
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0') {
                    Position start = new Position(i, j, 0);
                    q.add(start);
                    visited[start.x][start.y][start.key] = true;
                }
            }
        }
        bfs();
        System.out.println(min);
    }
 
    static void bfs() {
        int cnt = 0;
        while(!q.isEmpty()) {
 
            int size= q.size();
 
            for (int i = 0; i < size; i++) {
 
                Position now = q.poll();
                int x = now.x;
                int y = now.y;
                int key = now.key;
 
 
                if (map[x][y] == '1') {
                    min = Math.min(min,cnt);
 
                    break;
                }
 
                for (int j = 0; j < 4; j++) {
 
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int cur_key = key;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][cur_key] || map[nx][ny] == '#') continue;
                    if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
                        //키 
                        cur_key |= (1<< (map[nx][ny] - 'a'));
                    }
 
                    if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
                        if ((cur_key & (1 << map[nx][ny] - 'A')) == 0) {
                            continue; //키가 없음 
                        }
                    }
                    visited[nx][ny][cur_key] = true;
                    q.add(new Position(nx, ny, cur_key));
                }
            }
            cnt++;    
        }
 
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
 
    }
    static class Position {
        int x,y;
        int key;
        public Position(int x, int y, int key) {
            super();
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }
}

