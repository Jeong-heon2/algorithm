package programmers;
/*
[���� ����]
� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.

���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. �� �� ���� ū ���ڴ� 94 �Դϴ�.

���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

[���� ����]
number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.
 */
//���ٹ� combination  ��ȿ����. number�� �鸸�ڸ�. log(n)�� ������ ����� �����ؾ���
//greedy�� �����ؾ��Ѵ�.
public class GreedyQ2 {
	static int ans = 0;
	public static void main(String[] args) {
		System.out.println(solution("11111999", 4));
	}
	
    public static String solution(String number, int k) {
        int size = number.length();
        combi(number, 0, 0, size, size-k);
        return String.valueOf(ans);
    }
    public static void combi(String number, int visited , int start, int n , int r){
        if(r == 0){
            String val = "";
            for(int i = 0 ; i < n ; i++){
                if((visited & (1 << i)) != 0 ){
                    val += String.valueOf(number.charAt(i));
                }
            }
            int cur = Integer.parseInt(val);
            if(ans < cur) ans = cur;
        }else{
            for(int i = start ; i < n ; i++){
                visited = visited | 1 << i;
                combi(number, visited, start +1 , n, r - 1);
        	    visited &= ~(1<<i);
            }
        }
    }
}
