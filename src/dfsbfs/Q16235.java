package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q16235 {
	static int N;
	static int M;
	static int K;
	static Ground[][] ground;
	static int[] goX = { 1,1,0,-1,-1,-1,0,1 };
	static int[] goY = { 0,-1,-1,-1,0,1,1,1};
	static ArrayList<Tree> deadTrees = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		K = Integer.parseInt(tmp[2]);
		
		ground = new Ground[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N ; j++) {
				ground[i][j] = new Ground(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i = 1 ; i <= M ; i++) {
			tmp = br.readLine().split(" ");
			int r = Integer.parseInt(tmp[0]);
			int c = Integer.parseInt(tmp[1]);
			ground[r][c].trees.add(new Tree(r,c,Integer.parseInt(tmp[2])));
		}
		while(K-- > 0) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(getTreeCnt());
	}
	static int getTreeCnt() {
		int cnt = 0;
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1 ; j <= N ; j++) {
				cnt += ground[i][j].trees.size();
			}
		}
		return cnt;
	}
	static void spring() {
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1 ; j <= N ; j++) {
				int size = ground[i][j].trees.size();
				for(int k = size-1 ; k >=0 ; k--) {
					Tree tree = ground[i][j].trees.get(k);
					if(tree.age <= ground[i][j].curFood) {
						ground[i][j].curFood -= tree.age;
						tree.age++;
					}else {
						for(int t = k ; t >= 0; t--) {
							deadTrees.add(ground[i][j].trees.get(t));
							ground[i][j].trees.remove(t);
						}
						break;
					}
					
				}
			}
		}
	}
	static void summer() {
		for(Tree tree : deadTrees) {
			ground[tree.r][tree.c].curFood += tree.age/2;
		}
		deadTrees.clear();
	}
	static void fall() {
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1 ; j <= N ; j++) {
				int size = ground[i][j].trees.size();
				for(int k = size-1 ; k >=0 ; k--) {
					Tree tree = ground[i][j].trees.get(k);
					if(tree.age %5 == 0) {
						for(int t = 0 ; t < 8 ; t++) {
							int ny = i + goY[t];
							int nx = j + goX[t];
							if(ny < 1 || ny > N || nx < 1 || nx > N) continue;
							ground[ny][nx].trees.add(new Tree(ny,nx,1));
						}
					}
					
				}
			}
		}
	}
	static void winter() {
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1 ; j <= N ; j++) {
				ground[i][j].curFood += ground[i][j].addFood;
			}
		}
	}
	static class Ground{
		int curFood;//current 양분 
		int addFood;//추가될 양분 
		ArrayList<Tree> trees;
		Ground(int addFood){
			this.curFood = 5;
			this.addFood = addFood;
			this.trees = new ArrayList<>();
		}
	}
	static class Tree{
		int r;
		int c;
		int age;
		Tree(int r, int c, int age){
			this.r = r;
			this.c = c;
			this.age = age;
		}
	}
}
