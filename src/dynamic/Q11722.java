package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11722 {

	public static void main(String[] args) throws Exception  {
		// BufferedReader�� Exception ó���� ���� ����� �ϱ� ������ throws�� ���ְų�
		// try~catch�� ����ó�� ������մϴ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// "1 3 5 6"������ ���� ���� String Line�Ͻ� StringTokenizer �̿�
		// ������������ �ɰ��� �Է��� �ްڴ�
		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< sequence.length; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
			//�迭���� ��ū�� �ϳ��� �ҷ��� �Է�
		}
		int count = 0;
		int answer = 0;
		int[] lengthArray = new int[N];
		for(int i = 0; i<sequence.length-1; i++) {//�Է¹��� �迭 ù��° �� ���� �����ϴ� ���� �κм����� ã������
			//�迭�� ������ �� ���ͽ����ϴ� ���Һκ� ������ ���̴� ������  1 �׷��� length-1
			int j = i;
			for(int k = i+1 ; k < N; k++) {
				if(sequence[j]>sequence[k]) {//10 30 20 50 1 �̶��  10 30 ���� 30�� ��ũ�Ƿ� �ǳʶٰ� 
					// �ٽ� 10 20 ��  �׷��ٰ� 10 1 ���� ī��Ʈ ���� 
					// 30 20 10 50 20 1 �̸� 30 20 ���� ī��Ʈ����  j�� k�� �Ǿ�� 20�� 10�� �� 
					// 10 50���� �ǳ� �ٰ�  10 20 �ǳʶٰ� 10�� 1 ���� ī��Ʈ����
					// 10���� �����ϴ� ���� �κм������� ����
					System.out.println("i = " + i + "k = " + k);
					System.out.println("seqj = " + sequence[j] + "seq k = "+sequence[k]);
					count++;
					System.out.println("count =" + count);
					j = k;
					if(count>lengthArray[i]) lengthArray[i]=count;
				}
				else if (sequence[j]<sequence[k]){
					if(lengthArray[i]<count) {
						lengthArray[i] = count;
						count = 0;
					}
					else count = 0;
					j=i;
				}
				
			}
			count = 0 ;//count ����
		}
		int max = 0;
		//�ִ񰪱��ϱ�
		System.out.println(answer+1);
	}
}
