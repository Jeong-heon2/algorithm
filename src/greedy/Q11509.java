package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11509 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arrows = new ArrayList<>();//����� ȭ����� ���� 
		arrows.add(Integer.parseInt(st.nextToken())-1);
		for(int i = 1 ; i < N; i++) {
			int balloon = Integer.parseInt(st.nextToken());
			boolean flag = false;
			for(int j = arrows.size() - 1 ; j >= 0 ; j--) {
				int arrow = arrows.get(j);
				if(balloon == arrow) {
					//ǳ�� ���̿� ȭ�� ���̰� ���ٸ� 
					//���ο� ȭ���� �� �ʿ䰡 ����.  �� ǳ���� ������ ��Ҵ� ȭ�쿡 ���� ����
					//ȭ�� ���� 1 ���� 
					if(--arrow <= 0) {
						arrows.remove(j);
					}else {
						arrows.set(j, arrow);
					}
					flag = true;
					break;
				}
				
			}
			if(!flag) {
				//���ο� ȭ���� ��ƾ� �� 
				cnt++;
				arrows.add(balloon - 1);
			}
		}
		System.out.println(cnt);
		
	}

}
