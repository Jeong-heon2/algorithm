package math;

public class SieveOfEratosthenes {
	static int num = 9999;
	static int[] arr = new int[10000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����佺�׳׽��� ü 
		// 1. �迭�� �����Ͽ� �ʱ�ȭ�Ѵ�.
	    for(int i=2; i<=num; i++) {
	        arr[i] = i;
	    }
	    // 2. 2���� �����ؼ� Ư�� ���� ����� �ش��ϴ� ���� ��� �����.
	    // (���� �� �ڱ��ڽ��� ������ �ʰ�, �̹� ������ ���� �ǳʶڴ�.)
	    for(int i=2;i <= num; i++) {
	        if(arr[i]==0) continue; // �̹� ������ ����� �ǳʶٱ�

	        // �̹� ������ ���ڰ� �ƴ϶��, �� ������� ����Ͽ�, ������ ��� ���� �����
	        for(int j=2*i; j <= num; j+=i) {
	            arr[j] = 0;
	        }
	    }
	}

}
