package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 연산자 끼워넣기
brute force , permutation
 */
public class Q14888 {
	static int max;
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//숫자의 개수
		int N = Integer.parseInt(br.readLine());
		int[] tmps = new int[4];
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i ++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < 4 ; i++ ) {
			tmps[i] = Integer.parseInt(st.nextToken());
		}
		
		char[] operators = new char[N-1];
		int idx = 0;
		for(int i = 0 ; i < 4 ; i ++) {
			while(tmps[i]-- != 0) {
				if(i == 0) {
					operators[idx++] = '+';
				}else if(i == 1) {
					operators[idx++] = '-';
				}else if(i == 2) {
					operators[idx++] = '*';
				}else if(i == 3) {
					operators[idx++] = '%';
				}
			}
		}
		max = -Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;
		perm(nums, operators, 0, N-1);
		System.out.println(max);
		System.out.println(min);
		
	}
	public static int calculation(int[] nums, char[] opers) {
		//피연산자1 
		int p1 = nums[0];
		int p2 = 0;
		//nums idx
		int idx = 0;
		while(++idx != nums.length) {
			p2 = nums[idx];
			char oper = opers[idx-1];
			int res = 0;
			if(oper == '+') {
				res = p1 + p2;
			}else if(oper == '-') {
				res = p1 - p2;
			}else if(oper == '*') {
				res = p1 * p2;
			}else {
				res = p1 / p2;
			}
			
			p1 = res;
		}
		return p1;
	}
	public static void perm(int[] nums, char[] arr, int depth, int n) {
		if(depth == n) {
			int res = calculation(nums, arr);
			if(res > max) max = res;
			if(res < min) min = res;
			return;
		}
		for(int i = depth ; i < n ; i ++) {
			swap(arr, i , depth);
			perm(nums, arr, depth+1, n);
			swap(arr, i , depth);
		}
	}
	public static void swap(char[]arr , int i , int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
