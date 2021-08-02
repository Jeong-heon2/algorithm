package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q17143 {
	static Sea[][] map;
	static int pos;//낚시왕의 위치 
	static int ans;
	static int r;
	static int c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());//상어의 수 
		map = new Sea[r+1][c+1];
		pos = 0;
		ans = 0;
		for(int i = 1;  i <= r;  i++) {
			for(int j = 1; j <= c ; j++) {
				map[i][j] = new Sea();
			}
		}
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())].pq.offer(
					new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
		}
		printSea();
		while(pos < c) {
			move();
			fishing();
			moveShark();
			eatShark();
		}
		
		System.out.println(ans);
		
	}
	//디버그용 
	private static void printSea() {
		for(int i = 1;  i <= r;  i++) {
			for(int j = 1; j <= c ; j++) {
				if(!map[i][j].pq.isEmpty()) {
					Shark shark = map[i][j].pq.peek();
					System.out.print("s");
				}else {
					System.out.print("x");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	//낚시왕이 한 칸 움직인다 
	private static void move() {
		pos++;
	}
	//낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
	private static void fishing() {
		for(int j = 1; j <=r ; j++) {
			if(!map[j][pos].pq.isEmpty()) {
				Shark shark = map[j][pos].pq.poll();
				ans += shark.z;
				printSea();
				return;
			}
		}
	}
	//상어가 이동한다 
	private static void moveShark() {
		for(int i = 1;  i <= r;  i++) {
			for(int j = 1; j <= c ; j++) {
				if(!map[i][j].pq.isEmpty()) {
					for( Shark shark : map[i][j].pq) {
						if(shark.c != pos) {
							movingSharkProcess(i,j, shark);
							map[i][j].pq.remove(shark);
							printSea();
						}
					}
				}
			}
		}
	}
	private static void movingSharkProcess(int y, int x, Shark shark) {
		int cnt = shark.s;
		while(cnt-- > 0) {
			//1북   2남   3동   4서  
			switch(shark.d) {
				case 1:{
					y--;
					if(y == 0) {
						y = 2;
						shark.d = 2;
					}
					
					break;
				}
				case 2:{
					y++;
					if(y == r+1) {
						y = r-1;
						shark.d = 1;
					}
					
					break;
				}
				case 3:{
					x++;
					if(x == c+1) {
						x = x-1;
						shark.d = 4;
					}
					
					break;
				}
				case 4:{
					x--;
					if(x == 0) {
						x = 2;
						shark.d = 3;
					}
					
					break;
				}
			}
		}
		shark.c++;
		map[y][x].pq.offer(shark);
		
	}
	//상어가 이동을 마친후 같은 위치에 상어가 여러마리 있는 지 체크하고  가장 큰 상어가 다 잡아먹기 
	private static void eatShark() {
		for(int i = 1;  i <= r;  i++) {
			for(int j = 1; j <= c ; j++) {
				if(!map[i][j].pq.isEmpty()) {
					Shark bigShark = map[i][j].pq.poll();
					map[i][j].pq.clear();
					map[i][j].pq.offer(bigShark);
					printSea();
				}
			}
		}
	}
	static class Sea{
		PriorityQueue<Shark> pq = new PriorityQueue<Shark>();
	}
	static class Shark implements Comparable<Shark>{
		int s ; //속력
		int d ; //이동 방향 
		int z ; //크기 
		int c ; //지금까지 몇번 movingSharkProcess 에 몇번 호출 되었나 . pos = 1 일때 모든 상어가 이동 완료하면 모든 상어의 이 값은 1
		Shark(int s, int d , int z, int c){
			this.s = s;
			this.d = d;
			this.z = z;
			this.c = c;
		}
		@Override
		public int compareTo(Shark o) {
			return o.z - this.z;
		}
		
	}
	class Element{
		String tagName;
		HashMap<String, HashMap<String, Element>> childs;
		Element(){
			
		}
		
		
	}

}
