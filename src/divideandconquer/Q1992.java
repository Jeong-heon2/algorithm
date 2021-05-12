package divideandconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1992 {
	static char[][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i = 0 ; i <n ; i++) {
			char[] arr = br.readLine().toCharArray();
			map[i] = arr;
		}
		int res = check(0,0,n,n);
		if(res == -1) {
			System.out.println(quadtree(0,0,n,n));
		}else {
			System.out.println(res);
		}
		
	}
	
	private static String quadtree(int y, int x, int w, int h) {
		StringBuilder sb = new StringBuilder();
		int leftUp = check(x, y, x+w/2, y+h/2);
		int rightUp = check(x+w/2, y, x+w, y+h/2);
		int leftDown = check(x, y+h/2, x+w/2, y+h);
		int rightDown = check(x+w/2, y+h/2, x+w, y+h);
		if(leftUp != -1 && leftDown == leftUp && rightDown == leftUp && rightUp == leftUp) {
			sb.append("(");
			sb.append(leftUp);
			sb.append(")");
			return sb.toString();
		}
		sb.append("(");
		if(leftUp == -1) {
			sb.append(quadtree(y,x, w/2, h/2));
		}else {
			sb.append(leftUp);
		}
		if(rightUp == -1) {
			sb.append(quadtree(y,x+w/2, w/2, h/2));
		}else {
			sb.append(rightUp);
		}
		if(leftDown == -1) {
			sb.append(quadtree(y+h/2,x, w/2, h/2));
		}else {
			sb.append(leftDown);
		}
		if(rightDown == -1) {
			sb.append(quadtree(y+h/2,x+w/2, w/2, h/2));
		}else {
			sb.append(rightDown);
		}
		
		sb.append(")");
		return sb.toString();
	}
	private static int check(int fx, int fy, int tx, int ty) {
		char pre = map[fy][fx];
		for(int y = fy ; y < ty ; y++) {
			for(int x = fx ; x < tx ; x ++) {
				if(map[y][x] != pre) return -1;
				pre = map[y][x];
			}
		}
		return pre-'0';
	}
}
