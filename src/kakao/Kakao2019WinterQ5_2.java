package kakao;
//��α׿��� ������ Ǯ��
//��ó : https://iron-jin.tistory.com/entry/2019-īī��-������-�ܿ�-���Ͻ�-�ڵ��׽�Ʈ-¡�˴ٸ�-�ǳʱ�feat-Java
//���� ���ٹ��� ����ߴ�
//�� �� ����� ������������
public class Kakao2019WinterQ5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class Pro64062 {

	    public int solution(int[] stones, int k) {

	        int min = Integer.MAX_VALUE;//������ max �� �߿� �ּڰ�

	        for (int i = 0; i <= stones.length-k;) {//¡�˴ٸ� ����-k��ŭ �б⹮�� �����ش�.
	            //System.out.println(i);

	            int max = stones[i];//������ ó�� ��Ҹ� max ������ �߰�

	            int idx = 0;//���� i�� ��ġ�� ������ �ε��� ����

	            for (int j = i+1; j < i+k; j++) {//k��ŭ�� ���� Ž��

	                if (stones[j] >= max) {//���� ������ ¡�˴ٸ��� ������ �ִ񰪺��� ũ�ų� ���� ��

	                    idx = j;//�ε����� ���� ¡�˴ٸ� ��ȣ�� ����
	                    max = stones[j];//������ �ִ��� ���� ¡�˴ٸ��� ����
	                }
	            }

	            if (idx == 0) i++;//������ �ִ��� ������� �ʾ��� ���� ��ĭ�� �̵�
	            else {//������ �ִ��� ����Ǿ��� ���� �ִ񰪿� �ش��ϴ� ¡�˴ٸ� ��ȣ+1�� �̵�
	                i = (idx+1);
	            }

	            min = Math.min(min,max);//������ �ִ��� �ٸ� ������ ������ ��, �� ���� ������ �ִ��� �ᰪ�� ����
	        }

	        return min;
	    }
	}

}
