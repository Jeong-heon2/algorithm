package kakao;

import utils.ArrayInputConvert;

public class Kakao2018BlindQ4 {

	public static void main(String[] args) {
		System.out.println(ArrayInputConvert.convertInput("[TTTANT, RRFACC, RRRFCC, TRRRAA, TTMMMF, TMMTTJ]"));
		String[] arr = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		Solution sl = new Solution();
		sl.solution(6, 6, arr);

	}
	static class Solution {
	    int M;
	    int N;
	    char[][] arr;
	    int ans;
	    public int solution(int m, int n, String[] board) {
	        ans = 0;
	        M = m;
	        N = n;
	        arr = new char[M][N];
	        for(int i = 0 ; i < M ; i++){
	            for(int j = 0 ; j < N ; j++){
	                arr[i][j] = board[i].charAt(j);
	            }
	        }
	        boolean flag = true;
	        boolean[][] checked;
	        while(flag){
	            flag = false;
	            checked = new boolean[M][N];
	            for(int i = 0 ; i < M-1 ; i++){
	                for(int j = 0 ; j < N-1; j++){
	                    if(check(i, j)){
	                        flag = true;
	                        checked[i][j] = true;
	                        checked[i][j+1] = true;
	                        checked[i+1][j] = true;
	                        checked[i+1][j+1] = true;
	                    }
	                }
	            }
	            if(flag) {
	                delete(checked);
	                move();
	            }
	        }
	        return ans;
	    }
	    //board 2*2 check 
	    public boolean check(int y, int x){
	        char target = arr[y][x];
	        if(target == ' ') return false;
	        for(int i = y; i < y+2 ; i++){
	            for(int j = x; j < x+2; j++){
	                if(target != arr[i][j]){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    public void delete(boolean[][] checked){
	        //지울 때마다 ans ++
	        for(int i = 0 ; i < M ; i++){
	            for(int j = 0 ; j < N  ; j++){
	                if(checked[i][j]){
	                    arr[i][j] = ' ';
	                    ans++;
	                }
	            }
	        }
	    }
	    public void move(){
	        boolean flag = true;
	        while(flag){
	            flag = false;
	            for(int i = 0 ; i < M ; i++){
	                for(int j = 0 ; j < N ; j++){
	                    if(arr[i][j] == ' ' && i > 0 && arr[i-1][j] != ' '){
	                        swap(i,j, i-1, j);
	                        flag = true;
	                    }
	                }
	            }
	        }
	    }
	    public void swap(int y, int x, int y2, int x2){
	        char tmp = arr[y][x];
	        arr[y][x] = arr[y2][x2];
	        arr[y2][x2] = tmp;
	    }
	}

}
