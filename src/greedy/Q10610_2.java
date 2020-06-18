package greedy;

/*
 ��¥ �ȶ��� Ǯ��..
 ��Ǯ�̺��� 5������ ������ 
 */
import java.io.*;

public class Q10610_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solution(br.readLine()));
    }

    private static String solution(String number) {
        long[] countOfNumbers = new long[10];

        boolean includeZero = false;
        long checkOfSum = 0;

        for (int i=0; i<number.length(); ++i) {
            int num = number.charAt(i) - '0';

            checkOfSum += num;
            if (num == 0) {
                includeZero = true;
            }

            ++countOfNumbers[num];
        }

        if (!includeZero || checkOfSum%3 != 0) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        for (int i=9; i>=0; --i) {
            while (countOfNumbers[i] > 0) {
                sb.append(i);
                --countOfNumbers[i];
            }
        }

        return sb.toString();
    }
}
