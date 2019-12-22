package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int dp[][] = new int[n+1][10];
        //dp[N][L] 은 N자리수에 L이라는 숫자가 왔을때 , 오르막 수 조건에 해당한는 경우의 수
        //dp[N][L] = dp[N-1][0] + dp[N-1][1] + ... + dp[N-1][L]
        //우선 초기화해줘야 함
        //1자리수 인경우 각 숫자가 들어갈 경우의 수 저장
        for(int i=0; i<10; i++) dp[1][i] = 1;
     
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] = dp[i][j]%10007;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<=9; i++){
            ans += dp[n][i];            
        }
        System.out.println(ans%10007);
    }
}
