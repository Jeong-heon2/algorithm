package algorithm;

public class Floyd_Warshall {

	public static void main(String[] args) {
		int INF = 10000;
	
		int[][] D = { {0,0,0,0,0},{0,0,INF,-2,INF},{0,4,0,3,INF},{0,INF,INF,0,2}
		,{0,INF,-1,INF,0}
		};
		for(int k = 1 ; k <=4 ; k++) {
			for(int i = 1; i <= 4 ; i++) {
				for(int j = 1; j<=4 ; j++) {
					if(D[i][j]>(D[i][k]+D[k][j])) {
						D[i][j] = D[i][k]+D[k][j];
						System.out.println("D["+i+"]["+j+"] = D["+i+"]["+k+"]" +"plus"
								+"D["+k+"]["+j+"]");
					}
				}
			}
		}
		for(int i = 1 ; i<=4 ; i ++) {
			for(int j = 1; j <= 4 ; j++) {
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
	}
}
