package algorithm;

//여러 노드에서 두개의 노드가 서로 같은 집합에 속하는지 판별
//find : 노드가 어떤 집합에 속해있는지
//Union : 두 노드가 포함된 집합을 서로 합침

//https://brenden.tistory.com/33   << 이해가 안 되면 여기로.
public class UnionFind {
	//인덱스는 자기자신의 번호
	//value는 자기자신의 부모의 번호
	static int[] parents = new int[100001];
	
	public static void main(String[] args) {
		//unionfind 초기상태는 자기자신이 부모
		for(int i = 0 ; i < 8 ; i++) {
			parents[i] = i;
		}
		union(1,2);
		union(2,3);
		System.out.println("3의 부모는? : " + find(3));//1
		System.out.println("1과 3은 연결되어 있나요? : " + isSameParent(1,3));//true
		System.out.println("2와 3은? : " + isSameParent(2, 3));
		
	}
	
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}else {
			//재귀. 메모이제이션
			return parents[x] = find(parents[x]); 
		}
	}
	//y가 더 크다고 가정 (번호가 더 작은 노드가 부모가 되게 하는 것이 일반적이라고 한다.)
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
