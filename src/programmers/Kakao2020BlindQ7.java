package programmers;

import java.util.LinkedList;
import java.util.Queue;
//회전 공식을 만드는 것이 어려웠다.
public class Kakao2020BlindQ7 {

	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};
		Solution s = new Solution();
		int time = s.solution(board);
		System.out.println(time);
	}
	static class Solution {
	    int[] goX = {1, -1, 0, 0};
	    int[] goY = {0, 0, 1, -1};
	    int N;
	    int time;
	    public int solution(int[][] board) {
	        time = 0;
	        N = board.length;
	        bfs(board);
	        return time;
	    }
	    private void bfs(int[][] board){
	        boolean[][][][] visited = new boolean[N][N][N][N];
	        visited[0][0][1][0] = true;
	        Queue<Robot> q = new LinkedList<Robot>();
	        q.offer(new Robot(0,0,1,0));
	        
	        while(q.size() > 0){
	            int qSize = q.size();
	            while(qSize-- > 0){
	                Robot cur = q.poll();
	                //todo: check finish 
	                if((cur.x1 == N-1 && cur.y1 == N-1) || (cur.x2 == N-1 && cur.y2 == N-1)){
	                    return;
	                }
	                //움직이기 4가지 
	                for(int i = 0 ; i < 4 ; i++){
	                    int nx1 = cur.x1 + goX[i];
	                    int ny1 = cur.y1 + goY[i];
	                    int nx2 = cur.x2 + goX[i];
	                    int ny2 = cur.y2 + goY[i];
	                    if(isRanged(nx1, ny1) && isRanged(nx2, ny2)&&
	                       board[ny1][nx1] != 1 && board[ny2][nx2] != 1){
	                        if(!visited[nx1][ny1][nx2][ny2]){
	                            visited[nx1][ny1][nx2][ny2] = true;
	                            visited[nx2][ny2][nx1][ny1] = true;
	                            q.offer(new Robot(nx1, ny1, nx2, ny2));
	                        }
	                    }
	                }
	                //회전 4가지
	                for(int i = 0 ; i < 4 ; i++){
	                    Robot next = rotation(cur, board, i);
	                    if(!visited[next.x1][next.y1][next.x2][next.y2]){
	                        visited[next.x1][next.y1][next.x2][next.y2] = true;
	                        visited[next.x2][next.y2][next.x1][next.y1] = true;
	                        q.offer(next);
	                    }
	                }
	            }
	            time++;
	        }
	    }
	    private Robot rotation(Robot robot, int[][] board, int rotation_num){
	        int x1 = robot.x1;
	        int x2 = robot.x2;
	        int y1 = robot.y1;
	        int y2 = robot.y2;
	        switch(rotation_num){
	            case 0 :{
	                //이동할 좌표 
	                
	                //x1, y1 중심 90도 
	                int newX = x1 - (y2 - y1);
	                int newY = y1 + (x2 - x1);
	                //대각선 좌표 
	                int diag_x = get_rect_remainder(x1, newX, x2);
	                int diag_y = get_rect_remainder(y1, newY, y2);
	                if(isRanged(diag_x, diag_y)&& board[diag_y][diag_x] != 1){
	                    if(board[newY][newX] != 1){
	                        return new Robot(x1, y1, newX, newY);
	                    }
	                }
	                break;
	            }
	            case 1 :{
	                //이동할 좌표 
	                /*
	                newX = centerX + (point2x-centerX)*Math.cos(x) - (point2y-centerY)*Math.sin(x);

	                newY = centerY + (point2x-centerX)*Math.sin(x) + (point2y-centerY)*Math.cos(x);
	                */
	                //x2,  y2 90도 
	                int newX = x2 - (y1 - y2);
	                int newY = y2 + (x1 - x2);
	                //대각선 좌표 
	                int diag_x = get_rect_remainder(x1, newX, x2);
	                int diag_y = get_rect_remainder(y1, newY, y2);
	                if(isRanged(diag_x, diag_y)&& board[diag_y][diag_x] != 1){
	                    if(board[newY][newX] != 1){
	                        return new Robot(newX, newY, x2, y2);
	                    }
	                }
	                break;
	            }
	            case 2 :{
	                //이동할 좌표 
	                
	                //x1, y1 -90도 
	                int newX = x1 + (y2 - y1);
	                int newY = y1 - (x2 - x1);
	                //대각선 좌표 
	                int diag_x = get_rect_remainder(x1, newX, x2);
	                int diag_y = get_rect_remainder(y1, newY, y2);
	                if(isRanged(diag_x, diag_y)&& board[diag_y][diag_x] != 1){
	                    if(board[newY][newX] != 1){
	                        return new Robot(x1, y1, newX, newY);
	                    }
	                }
	                break;
	            }
	            case 3:{
	                //이동할 좌표 
	                //x2, y2 -90도
	                int newX = x2 + (y1- y2);
	                int newY = y2 - (x1 - x2);
	                //대각선 좌표 
	                int diag_x = get_rect_remainder(x1, newX, x2);
	                int diag_y = get_rect_remainder(y1, newY, y2);
	                if(isRanged(diag_x, diag_y)&& board[diag_y][diag_x] != 1){
	                    if(board[newY][newX] != 1){
	                        return new Robot(newX, newY, x2, y2);
	                    }
	                }
	                break;
	            }
	        }
	        return robot;
	    }
	    //사각형의 나머지 좌표 구하기 
	    private int get_rect_remainder(int x1, int x2, int x3) {
	        if(x1 == x2) {
	            return x3;
	        }else if(x3 == x2) {
	            return x1;
	        }else {
	            return x2;
	        }
		}
	    private boolean isRanged(int x, int y){
	        if(x < 0 || x >= N || y < 0 || y >= N) return false;
	        else return true;
	    }
	    class Robot{
	        int x1;
	        int y1;
	        int x2;
	        int y2;
	        public Robot(int x1, int y1, int x2, int y2){
	            this.x1 = x1;
	            this.x2 = x2;
	            this.y1 = y1;
	            this.y2 = y2;
	        }
	    }
	}

}
