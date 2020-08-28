package kakao;

import java.util.EmptyStackException;
import java.util.Stack;

public class Kakao2019WinterQ1 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2}
		,{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board,moves));
	}
	public static int solution(int[][] board, int[] moves) {
		final int boardSize = board.length;
		final int movesSize = moves.length;
		int answer = 0;
		Stack<Integer>[] craneArr = new Stack[boardSize];
		Stack<Integer> baguni = new Stack();
		
		for(int i = 0 ; i < boardSize ; i++) craneArr[i] = new Stack();
		for(int i = boardSize-1 ; i > -1 ; i--) {
			for(int j = 0 ; j < board[i].length ; j++) {
				craneArr[j].push(board[i][j]);
			}
		}
		for(int i = 0 ; i < movesSize ; i++) {
			try {
				int popedDoll = craneArr[moves[i]-1].pop();
				if(popedDoll != 0) {
					int baguniSize = baguni.size();
					int count = 0;
					while(baguniSize-- >0) {
						int baguniPoped = baguni.pop();
						if(popedDoll != baguniPoped) {
							baguni.push(baguniPoped);
							break;
						}else {
							count++;
						}
					}
					if(count == 0) {
						baguni.push(popedDoll);
					}else {
						answer = answer + count + 1;
					}
				}else {
					i--;//기계에서 뽑았는데 0이면 다시 그 위치에서 뽑기
				}
			}catch(EmptyStackException e) {
				//기계의 스택에 남아있는게 없는데 또 뽑으려고하면 아무일도 일어나지 않는다
				//다음 뽑아야할 거 뽑기
				continue;
				
			}
		}
		
		
		return answer;
	}

}
