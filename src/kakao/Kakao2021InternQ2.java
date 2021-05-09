package kakao;

public class Kakao2021InternQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] a = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		solution(a);
	}
	static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0 ; i < 5 ; i++){
            char[][] map = new char[5][5];
            for(int j = 0 ; j < 5 ; j++){
                map[j] = places[i][j].toCharArray();
            }
            boolean flag = true;
            for(int y = 0 ; y < 5 ; y++){
                for(int x = 0 ; x < 5 ; x++){
                    if(map[y][x] == 'P'){
                    	boolean[][] visited = new boolean[5][5];
                    	visited[y][x] = true;
                        if(!search(map, visited,new int[]{y,x}, 0, false)){
                            flag = false; 
                            break;
                        }
                    }
                }
                if(!flag) break;
            }
            if(flag) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
    public static boolean search(char[][] map, boolean[][] visited,int[] p, int depth, boolean flag){
        if(depth == 2){
            return true;
        }else{
            for(int i = 0 ; i< 4 ; i++){
                int nx = p[1] + dx[i];
                int ny = p[0] + dy[i];
                if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
                if(!visited[ny][nx]) {
                	visited[ny][nx] = true;
                	if(map[ny][nx] == 'P'){
                        if(!flag) return false;//파티션 안 만났는데 P를 또 만나면 
                        else return true;
                    }else if(map[ny][nx] == 'X'){
                        if(!search(map, visited, new int[]{ny,nx}, depth +1, true)) return false;
                    }else{
                        if(!search(map, visited, new int[]{ny,nx}, depth +1, false)) return false;
                    }
                }
                
            }
            return true;
        }
    }

}
