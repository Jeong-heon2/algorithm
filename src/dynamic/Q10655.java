package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10655 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//        i-1까지에서 한개 건너뛴 거리의 최소 + i노드와 이전노드거리   ,   i-2까지 쭉 달려온 거리 +  i-1 건너뛰고 i-2와 i 이은 거
		//dp[i] = dp[i-1] + distance(i, 이전노드 )  , arr[i-2] + distance(i-2, i)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}

}
