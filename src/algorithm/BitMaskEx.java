package algorithm;
//��Ʈ ����ũ ����
//https://mygumi.tistory.com/361 ����
//
public class BitMaskEx {

	public static void main(String[] args) {
		//10���� 1 �����
		int a = (1<<10)-1;// 1<<10 �� 1�� �������� 10 ��Ʈ��ŭ shift
		//��Ȯ�ϰԴ� ������ 1�� 2������ �ٲٰ� 0 10���� �����ʿ� ���� ��  �ٽ� �������� ��ȯ
		System.out.println(a);
		
		//shift right
		int b = (10>>3); // ���������� 3��Ʈ ��ŭ �δ�. 
		//1010 �� 0001�� �ȴ�.
		System.out.println(b);
		
		// A << B  = >  A*2^B
		// A >> B  = >  A/2^B
		// (A+B)/2  = >  (A+B) >> 1
		
		//Ȧ�� �Ǻ� ��
		//2��������  2�� 0�� �ڸ��� 1�̸� Ȧ���̰� 0 �̸� ¦���̱� ����.
		int c = 11;
		if((c&1) == 1) {
			System.out.println("Ȧ��");
		}
		
		//0��° ��Ʈ ���� 1�� �����ϱ�
		c = 10;//1010
		System.out.println(c|1<<0);//1011, 11
		System.out.println(1010|0001);//1011 , 11
		
		//0���� ��Ʈ ���� 0���� �����ϱ�
		c = 3;//1111
	    c &= ~(1<<1);
		System.out.println(c); //1110, 14
		System.out.println(1111 & 1110);// 1110, 14
		//����!!!!
		System.out.println(c & 1110);//��� 6���� ����,, 
		//int & ��Ʈ �� �߸��� ����� ������ ���� �ֳ�����.
		System.out.println(31 & 11110);//�굵 6..
		
		//0��° ��Ʈ �� �˾Ƴ���
		c = 3;
		System.out.println(c & (1 << 1));// 0
		//1��° ��Ʈ �� �˾Ƴ���
		System.out.println(c & (1 << 1));// 10  > 2�� 1��  ,
		//�� 1��° ��Ʈ���� �����ִ�.
		
		System.out.println(bitCount(15));// 1111 �� 4��
		
		int k = 0 ;
		k = k | (1 << 3);
		System.out.println(k);
		
	}
	//1�� ���� ����
	public static int bitCount(int n ) {
		if(n==0) return 0;
		return n%2 + bitCount(n/2);
	}

}
