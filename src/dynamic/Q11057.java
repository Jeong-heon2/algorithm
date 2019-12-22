package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int dp[][] = new int[n+1][10];
        //dp[N][L] �� N�ڸ����� L�̶�� ���ڰ� ������ , ������ �� ���ǿ� �ش��Ѵ� ����� ��
        //dp[N][L] = dp[N-1][0] + dp[N-1][1] + ... + dp[N-1][L]
        //�켱 �ʱ�ȭ����� ��
        //1�ڸ��� �ΰ�� �� ���ڰ� �� ����� �� ����
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
