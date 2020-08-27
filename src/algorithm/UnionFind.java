package algorithm;

//���� ��忡�� �ΰ��� ��尡 ���� ���� ���տ� ���ϴ��� �Ǻ�
//find : ��尡 � ���տ� �����ִ���
//Union : �� ��尡 ���Ե� ������ ���� ��ħ

//https://brenden.tistory.com/33   << ���ذ� �� �Ǹ� �����.
public class UnionFind {
	//�ε����� �ڱ��ڽ��� ��ȣ
	//value�� �ڱ��ڽ��� �θ��� ��ȣ
	static int[] parents = new int[100001];
	
	public static void main(String[] args) {
		//unionfind �ʱ���´� �ڱ��ڽ��� �θ�
		for(int i = 0 ; i < 8 ; i++) {
			parents[i] = i;
		}
		union(1,2);
		union(2,3);
		System.out.println("3�� �θ��? : " + find(3));//1
		System.out.println("1�� 3�� ����Ǿ� �ֳ���? : " + isSameParent(1,3));//true
		System.out.println("2�� 3��? : " + isSameParent(2, 3));
		
	}
	
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}else {
			//���. �޸������̼�
			return parents[x] = find(parents[x]); 
		}
	}
	//y�� �� ũ�ٰ� ���� (��ȣ�� �� ���� ��尡 �θ� �ǰ� �ϴ� ���� �Ϲ����̶�� �Ѵ�.)
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if( x != y ) {
			parents[y] = x;
		}
	}
	
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		else return false;
	}

}
