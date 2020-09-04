package kakao;

import utils.ArrayInputConvert;

public class Kakao2018BlindQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ArrayInputConvert.convertInput("[[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,4,0,0,0],[0,0,0,0,0,4,4,0,0,0],[0,0,0,0,3,0,4,0,0,0],[0,0,0,2,3,0,0,0,5,5],[1,2,2,2,3,3,0,0,0,5],[1,1,1,0,0,0,0,0,0,5]]"));
		int[][] board = {{0,0,0,0,0,0,0,0,0,7},{0,0,0,0,0,0,0,7,7,7},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};
		Solution sl = new Solution();
		System.out.println(sl.solution(board));

	}
	static class Solution {
	    int height;
	    int N;
	    int ans;
	    public int solution(int[][] board) {
	        ans = 0;
	        //1.가장 높은 블록의 y 위치 부터 검은 블록을 다 체운다. 
	        //2. 가장 높은 블록의 y, 0 부터 2*3  3*2 직사각형을 탐색해서
	        //3. 검은 블록 2개 색깔블록 4개가 직사각형에 있으면 삭제 하고 개수 카운팅후 1번 부터 반복
	        N = board.length;
	        height = 0;
	        boolean find = false;
	        for(int i = 0 ; i < N ; i++){
	            for(int j = 0 ; j < N ; j++){
	            	if(board[i][j] != 0){
	                    height = i;
	                    find = true;
	                    break;
	                }
	            }
	            if(find) break;
	        }
	        setBlack(board);
	        for(int i = height; i < N ; i++){
	            for(int j = 0 ; j < N ; j++){
	                if(i+2 < N && j+1 < N){
	                    if(detactAndDelete(board, 3+i, 2+j, i, j)){
	                        setBlack(board);
	                        i = height - 1;
	                        break;
	                    }
	                }
	                if(i+1 < N && j + 2 < N){
	                    if(detactAndDelete(board, 2+i, 3+j, i, j)){
	                        setBlack(board);
	                        i = height - 1;
	                        break;
	                    }
	                }
	            }
	        }
	        
	        
	        return ans;
	    }
	    public void setBlack(int[][] arr){
	        //height ~ N-1 까지 검은색 블록을 체운다 (조건에 맞게)
	        boolean[] visited = new boolean[N];
	        for(int i = height ; i < N ; i++){
	            for(int j = 0 ; j < N ; j++){
	                if(arr[i][j] != 0 && arr[i][j] != -1){
	                    visited[j] = true;
	                    continue;
	                }
	                if(!visited[j]){
	                    arr[i][j] = -1;
	                }
	            }
	        }
	    }
	    public boolean detactAndDelete (int[][] arr, int len_y, int len_x, int y, int x){
	        int black_cnt = 0;
	        int color = -1;
	        int color_cnt = 0;
	        for(int i = y ; i < len_y ; i++){
	            for(int j = x ; j < len_x ; j++){
	                if(arr[i][j] == 0) break;
	                else if(arr[i][j] == -1) black_cnt++;
	                else{
	                    if(color == -1){
	                        color = arr[i][j];
	                        color_cnt++;
	                    }else{
	                        if(color != arr[i][j]) break;
	                        else color_cnt++;
	                    }
	                }
	            }
	        }
	        if(black_cnt == 2 && color_cnt == 4) {
	            delete(arr, len_y, len_x, y, x);
	            ans++;
	            return true;
	        }else{
	            return false;
	        }
	    }
	    public void delete(int[][] arr, int len_y, int len_x, int y, int x){
	        for(int i = y ; i < len_y ; i++){
	            for(int j = x; j < len_x; j++){
	                arr[i][j] = 0;
	            }
	        }
	    }
	}

}
