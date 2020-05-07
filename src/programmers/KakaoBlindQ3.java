package programmers;
/*
 * 잠겨있는 자물쇠는 격자 한 칸의 크기가 1 x 1인 N x N 크기의 정사각 격자 형태이고 
 * 특이한 모양의 열쇠는 M x M 크기인 정사각 격자 형태로 되어 있습니다.

자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있습니다.
 열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 
 자물쇠가 열리게 되는 구조입니다.
 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만, 
 자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 
 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다. 
 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.

열쇠를 나타내는 2차원 배열 key와 자물쇠를 나타내는 2차원 배열 lock이 매개변수로 주어질 때,
 열쇠로 자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return 하도록
  solution 함수를 완성해주세요.
[제한사항]
key는 M x M(3 ≤ M ≤ 20, M은 자연수)크기 2차원 배열입니다.
lock은 N x N(3 ≤ N ≤ 20, N은 자연수)크기 2차원 배열입니다.
M은 항상 N 이하입니다.
key와 lock의 원소는 0 또는 1로 이루어져 있습니다.
0은 홈 부분, 1은 돌기 부분을 나타냅니다.
 */

//열쇠 돌기와 자물쇠 돌기가 만나서는 안된다는 조건을 빼먹음 05.07
public class KakaoBlindQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = new int[][] {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(solution(key,lock));
	}
	public static boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int mapSize = N+M*2-2;
        int[][] map = new int[mapSize][mapSize];
        //map의 중심에 lock을 복사
        int idx = 0;
        for(int i = M-1 ; i < N+M-1 ; i ++){
            System.arraycopy(lock[idx],0,map[i],M-1,N);
            idx++;
        }
        for(int i = 0 ; i<N+M-1 ; i++ ){
            for(int j = 0 ; j < N+M-1 ; j++){
                //90도 회전 4번하고 lock 과 매칭하는지 체크
                for(int t = 0 ; t <4 ; t++){
                    //90도 회전
                    key = rotate(key,M);
                    //rotatedKey를 map에 입힌다
                    int[][] copyMap = deepCopy(map,mapSize);
                    idx=0;
                    int idx2 = 0;
                    for(int s = i ; s < i+M ; s++){
                    	for(int v = j ; v < j+M; v++) {
                    		if(key[idx][idx2] == 1) {
                    			copyMap[s][v] = 1;
                    		}
                    	}

                    }
                    if(checkMatch(copyMap,M,N)) return true;
                }
            }
        }
        return false;
    }
    //90도 회전   n = M
    public static int[][] rotate(int[][] key,int n){
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                clone[j][n-1-i] = key[i][j];
            }
        }
        return clone;
    }
    //map의 lock 범위의 요소들이 모두 1이 되었는가 확인
    public static boolean checkMatch(int[][] map ,int M, int N){
        for(int i = M-1 ; i < N+M-1 ; i ++){
            for(int j = M-1 ; j < N+M-1 ; j++ ){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
    //2차원 배열 deepCopy
    public static int[][] deepCopy(int[][] original, int n) {

        int[][] result = new int[n][n];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }

}
