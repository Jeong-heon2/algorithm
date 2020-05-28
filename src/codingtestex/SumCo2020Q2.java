package codingtestex;

import java.util.*;
public class SumCo2020Q2 {
	static long target;
	static ArrayList<Long> list = new ArrayList<>();
	public static void main(String[] args) {
		long a = 11;
		System.out.println(solution(a));

	}
	public static long solution(long n) {
        long visited = 0;
        target = n;
        
        for(long i = 1 ; i <= n ; i ++) {
			combination(visited,0,n,i,0);
		}
        
        Collections.sort(list);
        return list.get((int) (n-1));
    }
	static void combination(long visited, int start, long n, long r, int cnt) {
	    if(r == 0) {
	        print(visited,n);
	        return;
	        
	    } 
	    for(int i=start; i<n; i++) {
	    	visited = visited|1<<i;
	        combination( visited, i + 1, n, r - 1,cnt);
	        visited = visited & ~1 << i;
	    }
	    return;
	}
	// 배열 출력
    static void print(long visited, long n) {
    	long a = 0;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0)
                a += Math.pow(3, i);
        }
        list.add(a);
    }

}
