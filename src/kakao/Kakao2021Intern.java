package kakao;

import java.util.Stack;

public class Kakao2021Intern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
	}
	static char[] res;
    public static String solution(int n, int k, String[] cmd) {
        res = new char[n];
        for(int i = 0 ; i <n ; i++) {
        	res[i] = 'O';
        }
        Stack<Integer> removed = new Stack<>();//<idx>
        for(int i = 0 ; i < cmd.length; i++){
            String op = cmd[i];
            if(op.charAt(0) == 'U'){
                k = up(op.charAt(2) - '0', k);
            }else if(op.charAt(0) == 'D'){
                k = down(op.charAt(2) - '0', k);
            }else if(op.charAt(0) == 'C'){
                removed.push(k);
                res[k] = 'X';
                k = find(k, n);
            }else{
                res[removed.pop()] = 'O';
            }
        }
        return new String(res);
    }
    //cur���� ���� vĭ �������� 
    private static int up(int v, int cur){
        int cnt = 0;
        int next = cur-1;
        while(cnt != v){
            //������ ���̴� �����ΰŷ� �� ħ 
            if(res[next] != 'X'){
                cnt++;
            }
            next -= 1;
        }
        return next+1;
    }
    //cur���� �Ʒ��� vĭ �������� 
    private static int down(int v, int cur){
        int cnt = 0;
        int next = cur+1;
        while(cnt != v){
            //������ ���̴� �����ΰŷ� �� ħ 
            if(res[next] != 'X'){
                cnt++;
            }
            next += 1;
        }
        return next-1;
    }
    //k�� �ڿ��� ó�� O�� ������ ��ġ. ������ �տ��� ó�� O�� ������ ��ġ 
    private static int find(int k, int n){
        for(int i = k ; i < n ; i++){
            if(res[i] == 'O') return i;
        }
        for(int i = k ; i > 0 ; i--){
            if(res[i] == 'O') return i;
        }
        return 0;
    }

}
