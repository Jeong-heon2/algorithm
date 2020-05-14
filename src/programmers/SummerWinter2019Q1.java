package programmers;
/*
 * ���� ���̰� Wcm, ���� ���̰� Hcm�� ���簢�� ���̰� �ֽ��ϴ�. 
 * ���̿��� ����, ���� ����� �����ϰ� ���� ���·� ���� �׾��� ������, 
 * ��� ����ĭ�� 1cm x 1cm ũ���Դϴ�. 
 * �� ���̸� ���� ���� ���� 1cm �� 1cm�� ���簢������ �߶� ����� �����̾��µ�, 
 * �������� �� ���̸� �밢�� ������ 2���� �մ� �������� �߶� ���ҽ��ϴ�. 
 * �׷��Ƿ� ���� ���簢�� ���̴� ũ�Ⱑ ���� �����ﰢ�� 2���� �������� �����Դϴ�.
 *  ���ο� ���̸� ���� �� ���� �����̱� ������, 
 *  �� ���̿��� ���� ������ ����, ���� ����� �����ϰ� 1cm �� 1cm�� �߶� ����� �� �ִ� ��ŭ�� ����ϱ�� �Ͽ����ϴ�.
 *  ������ ���� W�� ������ ���� H�� �־��� ��, ����� �� �ִ� ���簢���� ������ ���ϴ� solution �Լ��� �ϼ��� �ּ���.

[���ѻ���]
W, H : 1�� ������ �ڿ���
 */
//���ٹ� : ������ ������
public class SummerWinter2019Q1 {

	public static void main(String[] args) {
		//y= -(h/w)x + h
		System.out.println(solution(100000000,99999998));
	}
	public static long solution(int w, int h) {
        long answer = 0;
        //y = -h/w*x + h
        double width = w;
        double height = h;
        double e = height/width;//����
        for(double x = 1; x <=w ; x++){
            //���� �˻�
            double x1 = x-1;
            double x2 = x;
            double y1 = -e*x1 + height;
            double y2 = -e*x2 + height;
            //y1�� �����ϰ� y2�� �ø��ϰ� ���� ����
            
            answer += Math.abs(Math.ceil(y1)-Math.floor(y2));
        }
        
        return (long)(width*height)-answer;
    }

}
//�׽�Ʈ ���̽� 6���� Ʋ����,,  ĳ�����Ҷ� ���� ������ �ִ� �� �ϴ�. �׷��� ������ ã�� ���ߴ�.