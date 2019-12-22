package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q6603 {
	static int[] ans;
	static ArrayList<Integer> list;
	static int k;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			list = new ArrayList<Integer>();
			ans = new int[k];
			for(int i = 0 ; i <k ; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			dfs(0,0);
			
		}
	}
	public static void dfs(int start, int depth) {
	    
	    if(depth == 6) {                    //Ż������
	        for(int i=0; i<6; i++) {
	            System.out.println(ans[i]);;    //�����ϳ��� ����� �� Ż��
	        }
	        System.out.println();
	        return;
	    }
	                                        
	    for(int i=start; i<k; i++) {    //list�迭 0���� k-1���� Ž����     
	        ans[depth] = list.get(i);    //depth�� ���� -> 0~5��° ���̱��� ��͸����� ���� Ž���� ���ڸ� ����.    
	        dfs(i+1, depth+1);            //��� ���� �κ� , �ϳ��� ���̸� Ž�� �� ���������� ���� �Լ�ȣ���Ҷ��� ����+1�� �������.
	    }
	    
	}
}
