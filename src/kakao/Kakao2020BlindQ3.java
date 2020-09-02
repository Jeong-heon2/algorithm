package kakao;

public class Kakao2020BlindQ3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		Solution s = new Solution();
		if(s.solution(key, lock)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	static class Solution {
	    public boolean solution(int[][] key, int[][] lock) {
	        int M = key.length;
	        int N = lock.length;
	        int mapSize = N+M*2-2;
	        int[][] map = new int[mapSize][mapSize];
	        //map�� �߽ɿ� lock�� ����
	        int idx = 0;
	        for(int i = M-1 ; i < N+M-1 ; i ++){
	            System.arraycopy(lock[idx],0,map[i],M-1,N);
	            idx++;
	        }
	        for(int i = 0 ; i<N+M-1 ; i++ ){
	            for(int j = 0 ; j < N+M-1 ; j++){
	                //90�� ȸ�� 4���ϰ� lock �� ��Ī�ϴ��� üũ
	                for(int t = 0 ; t <4 ; t++){
	                    //90�� ȸ��
	                    key = rotate(key,M);
	                    //rotatedKey�� map�� ������
	                    int[][] copyMap = deepCopy(map,mapSize);
	                    idx=0;
	                    for(int s = i ; s < i+M ; s++){
	                        int idx2 = 0;
	                        for(int v = j ; v < j+M; v++) {
	                            if(key[idx][idx2] == 1) {
	                                //���赹��� �ڹ��赹��� ������ �ȵǹǷ�
	                                if(copyMap[s][v] == 1) {
	                                    copyMap[s][v] = 0;
	                                }else {
	                                    copyMap[s][v] = 1;
	                                }

	                            }
	                            idx2++;
	                        }
	                        idx++;
	                    }
	                    if(checkMatch(copyMap,M,N)) return true;
	                }
	            }
	        }
	        return false;
	    }
	    //90�� ȸ��   n = M
	    public int[][] rotate(int[][] key,int n){
	        int[][] clone = new int[n][n];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                clone[j][n-1-i] = key[i][j];
	            }
	        }
	        return clone;
	    }
	    //map�� lock ������ ��ҵ��� ��� 1�� �Ǿ��°� Ȯ��
	    public boolean checkMatch(int[][] map ,int M, int N){
	        for(int i = M-1 ; i < N+M-1 ; i ++){
	            for(int j = M-1 ; j < N+M-1 ; j++ ){
	                if(map[i][j] == 0) return false;
	            }
	        }
	        return true;
	    }
	    //2���� �迭 deepCopy
	    public int[][] deepCopy(int[][] original, int n) {

	        int[][] result = new int[n][n];
	        for (int i = 0; i < original.length; i++) {
	            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
	        }
	        return result;
	    }
	}

}
