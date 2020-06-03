package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
[�Է�]
ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� ù° �ٿ��� ģ�� ������ �� F�� �־�����, 
�� ���� 100,000�� ���� �ʴ´�. ���� F���� �ٿ��� ģ�� ���谡 ���� ������� �־�����. 
ģ�� ����� �� ������� ���̵�� �̷���� ������, 
���ĺ� �빮�� �Ǵ� �ҹ��ڷθ� �̷���� ���� 20 ������ ���ڿ��̴�.

[���]
ģ�� ���谡 ���� ������, �� ����� ģ�� ��Ʈ��ũ�� �� ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
public class Q4195 {
	static int[] parents;//�θ� ��
	static int[] cnt;//�ڽ��� �������(���� ����)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//test case 
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			//<�̸�, ������ȣ>
			HashMap<String, Integer> map = new HashMap<>();
			//ģ�� ���� ��
			int N = Integer.parseInt(br.readLine());
			//�Է¿� �̸����ΰ� ���� �ٸ� �� �����Ƿ� N*2
			parents = new int[N*2];
			cnt = new int[N*2];
			//�ʱ�ȭ 
			for(int i = 0; i < N*2 ; i++) {
				parents[i] = i;
				cnt[i] = 1;
			}
			//�̸��� ������ȣ 
			int idx = 0;
			while(N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//ģ��1 
				String f1 = st.nextToken();
				int f1_idx ;
				if(!map.containsKey(f1)) {
					f1_idx = idx;
					map.put(f1, idx++);
				}else f1_idx = map.get(f1);
				//ģ��2 
				String f2 = st.nextToken();
				int f2_idx;
				if(!map.containsKey(f2)) {
					f2_idx = idx;
					map.put(f2, idx++);
				}else f2_idx = map.get(f2);
				
				System.out.println(union(f1_idx, f2_idx));
				
			}
			
		}
	}
	private static int find(int x) {
		if(parents[x] == x) {
			return x;
		}else {
			return parents[x] = find(parents[x]);
		}

	}
	private static int union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(y > x) {
				parents[y] = x;
				cnt[x] += cnt[y]; // y�� x �ڽ����� �պ� 
				cnt[y] = 1; //�ܸ���尡 �Ǿ����Ƿ� 1�� �ʱ�ȭ
				return cnt[x];
			}
			else {
				parents[x] = y;
				cnt[y] += cnt[x];
				cnt[x] = 1;
				return cnt[y];
			}
		}
		return cnt[x];
	}

}