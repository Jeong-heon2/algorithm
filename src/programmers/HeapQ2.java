package programmers;
/*
[���� ����]
��� ���忡���� �Ϸ翡 �а��縦 1�澿 ����մϴ�. ���� �а��縦 ���޹޴� ������ �������� 
������ k�� ���Ŀ��� �а��縦 ���޹��� �� �ֱ� ������ �ؿ� ���忡�� �а��縦 �����ؾ� �մϴ�.
�ؿ� ���忡���� ���� �а��縦 ������ �� �ִ� ��¥�� ������ �˷��־���,
 ��� ���忡���� ��ۺ� ���̱� ���� �ּ����� Ƚ���� �а��縦 ���޹ް� �ͽ��ϴ�.

���� ���忡 �����ִ� �а��� ���� stock, �а��� ���� ����(dates)�� �ش� ������ ���� ������ �а��� ����(supplies), 
���� �������κ��� ���޹��� �� �ִ� ���� k�� �־��� ��, �а��簡 �������� �ʰ� ������ ��ϱ� ���ؼ�
 �ּ��� �� �� �ؿ� �������κ��� �а��縦 ���޹޾ƾ� �ϴ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
dates[i]���� i��° ���� �������� ���������, 
supplies[i]���� dates[i] ��¥�� ���� ������ �а��� ������ ��� �ֽ��ϴ�.

[���ѻ���]
stock�� �ִ� �а���� ����(0�� ����)���� ���˴ϴ�.
stock�� k�� 2 �̻� 100,000 �����Դϴ�.
dates�� �� ���Ҵ� 1 �̻� k �����Դϴ�.
supplies�� �� ���Ҵ� 1 �̻� 1,000 �����Դϴ�.
dates�� supplies�� ���̴� 1 �̻� 20,000 �����Դϴ�.
k�� °���� �а��簡 ����� ���޵Ǳ� ������ k-1�Ͽ� ����� ���������� Ȯ���ϸ� �˴ϴ�.
dates�� ����ִ� ��¥�� �������� ���ĵǾ� �ֽ��ϴ�.
dates�� ����ִ� ��¥�� ���޵Ǵ� �а���� �۾� ���� �� ������ ���޵Ǵ� ���� �������� �մϴ�. ���� ��� 9��°�� �а��簡 �ٴڳ�����, 10��°�� ���޹����� 10��°���� ������ ��� �� �ֽ��ϴ�.
�а��簡 �ٴڳ��� ���� �־����� �ʽ��ϴ�.
 */

//���ٹ� 1 : ���� �̿� .  ������ Ǫ�� ����� �������� �ʾҴ�.
//�����غ��� �̹����  �ð��� �ʹ� ���� �ɸ���.
public class HeapQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        //dates�� ���� �˰��� ������
        //4 , 10 , 15 ,  4 10,  4 15, 10 15,  4 10 15
        //�� ����� ���� simulation ������
        //
        return answer;
    }
	//dates�� ���� �˰��� ������
	private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        print(arr,visited,n);
	        return;
	    } 
	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	// �迭 ���
    private static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
