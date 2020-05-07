package programmers;
/*
 * ����ִ� �ڹ���� ���� �� ĭ�� ũ�Ⱑ 1 x 1�� N x N ũ���� ���簢 ���� �����̰� 
 * Ư���� ����� ����� M x M ũ���� ���簢 ���� ���·� �Ǿ� �ֽ��ϴ�.

�ڹ��迡�� Ȩ�� �Ŀ� �ְ� ���� ���� Ȩ�� ���� �κ��� �ֽ��ϴ�.
 ����� ȸ���� �̵��� �����ϸ� ������ ���� �κ��� �ڹ����� Ȩ �κп� �� �°� ä��� 
 �ڹ��谡 ������ �Ǵ� �����Դϴ�.
 �ڹ��� ������ ��� �κп� �ִ� ������ Ȩ�� ����� �ڹ��踦 ���� �� ������ ���� ������, 
 �ڹ��� ���� �������� ������ ���� �κа� �ڹ����� Ȩ �κ��� ��Ȯ�� ��ġ�ؾ� �ϸ� 
 ������ ����� �ڹ����� ���Ⱑ �������� �ȵ˴ϴ�. 
 ���� �ڹ����� ��� Ȩ�� ä�� ����ִ� ���� ����� �ڹ��踦 �� �� �ֽ��ϴ�.

���踦 ��Ÿ���� 2���� �迭 key�� �ڹ��踦 ��Ÿ���� 2���� �迭 lock�� �Ű������� �־��� ��,
 ����� �ڹ��踦 ���� ������ true��, �� �� ������ false�� return �ϵ���
  solution �Լ��� �ϼ����ּ���.
[���ѻ���]
key�� M x M(3 �� M �� 20, M�� �ڿ���)ũ�� 2���� �迭�Դϴ�.
lock�� N x N(3 �� N �� 20, N�� �ڿ���)ũ�� 2���� �迭�Դϴ�.
M�� �׻� N �����Դϴ�.
key�� lock�� ���Ҵ� 0 �Ǵ� 1�� �̷���� �ֽ��ϴ�.
0�� Ȩ �κ�, 1�� ���� �κ��� ��Ÿ���ϴ�.
 */

//���� ����� �ڹ��� ���Ⱑ �������� �ȵȴٴ� ������ ������ 05.07
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
    //90�� ȸ��   n = M
    public static int[][] rotate(int[][] key,int n){
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                clone[j][n-1-i] = key[i][j];
            }
        }
        return clone;
    }
    //map�� lock ������ ��ҵ��� ��� 1�� �Ǿ��°� Ȯ��
    public static boolean checkMatch(int[][] map ,int M, int N){
        for(int i = M-1 ; i < N+M-1 ; i ++){
            for(int j = M-1 ; j < N+M-1 ; j++ ){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
    //2���� �迭 deepCopy
    public static int[][] deepCopy(int[][] original, int n) {

        int[][] result = new int[n][n];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }

}
