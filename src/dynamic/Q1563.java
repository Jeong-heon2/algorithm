package dynamic;

import java.util.Scanner;

public class Q1563 {
    public static int mod = 1000000;
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][][][][] D = new int[1001][3][3][3][2];
 
        for (int now = 0; now < 3; now++) {
            for (int prev = 0; prev < 3; prev++) {
                for (int prev2 = 0; prev2 < 3; prev2++) {
 
                    // �Ἦ ����3���� ��
                    if (now == 1 && prev == 1 && prev2 == 1) {
                        continue;
                    }
 
                    // ���� 2���� �ȵ�
                    if ((now == 2 && prev == 2) || (now == 2 && prev2 == 2) || (prev == 2 && prev2 == 2)) {
                        continue;
                    }
 
                    if (now == 2 || prev == 2 || prev2 == 2) {
                        D[3][now][prev][prev2][1] = 1;
                    } else {
 
                        D[3][now][prev][prev2][0] = 1;
 
                    }
 
                }
            }
        }
 
        for (int i = 4; i <= n; i++) {
            for (int prev = 0; prev < 3; prev++) {
                for (int prev2 = 0; prev2 < 3; prev2++) {
                    for (int prev3 = 0; prev3 < 3; prev3++) {
 
                        // �⼮����
                        D[i][0][prev][prev2][0] += D[i - 1][prev][prev2][prev3][0];
                        D[i][0][prev][prev2][0] %= mod;
                        D[i][0][prev][prev2][1] += D[i - 1][prev][prev2][prev3][1];
                        D[i][0][prev][prev2][1] %= mod;
 
                        // �Ἦ
 
                        if (prev == 1 && prev2 == 1) {
 
                        } else {
 
                            D[i][1][prev][prev2][0] += D[i - 1][prev][prev2][prev3][0];
                            D[i][1][prev][prev2][0] %= mod;
                            D[i][1][prev][prev2][1] += D[i - 1][prev][prev2][prev3][1];
                            D[i][1][prev][prev2][1] %= mod;
 
                        }
 
                        D[i][2][prev][prev2][1] += D[i - 1][prev][prev2][prev3][0];
                        D[i][2][prev][prev2][1] %= mod;
 
                    }
                }
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 2; l++) {
                        ans += D[n][i][j][k][l];
                        ans%=mod;
                    }
                }
            }
        }
        
        System.out.println(ans);
 
    }
 
}
 