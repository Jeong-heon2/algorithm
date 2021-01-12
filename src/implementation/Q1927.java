package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 최소 힙 
 * https://wonit.tistory.com/203
 */
public class Q1927 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//연산의 개수
		int N = Integer.parseInt(br.readLine());
		MinHeap hp = new MinHeap();
		while(N-- > 0) {
			int num =  Integer.parseInt(br.readLine());
			if(num == 0) {
				System.out.println(hp.delete());
			}else {
				hp.insert(num);
			}
		}	
	}
	static class MinHeap { 
		private ArrayList<Integer> heap;
		/*heap init*/ 
		public MinHeap(){ 
			heap = new ArrayList<>(); heap.add(0); // heap 의 인덱스는 알기 쉽게 0부터 시작한다는 특성을 따른다. 
		}
		public void insert(int data) {
			heap.add(data);
			//말단 노드 
			int pos = heap.size() - 1;
			//노드의 부모의 인덱스는 항상  pos/2 
			int parent = pos/2;
			//부모가 더 작아야함 (최소힙) 
			while(pos > 1 && heap.get(parent) > heap.get(pos)) {
				//swap 
				int temp = heap.get(parent);
				heap.set(parent, heap.get(pos));
				heap.set(pos, temp);
				
				pos = parent;
				parent = pos/2;
			}
		}
		//루트 노드를 삭제하고  삭제한 데이터를 리턴 
		public int delete() {
			//heap이 비어있을 때
			if(heap.size() - 1 == 0) {
				return 0;
			}
			//지울 데이터 (루트 ) 
			int deleteData = heap.get(1);
			//말단 노드를 부모 노드로 세팅 
			heap.set(1, heap.get(heap.size() -1));
			//말단 노드 삭제 
			heap.remove(heap.size() - 1);
			
			int pos = 1;
			//내 왼쪽 자식 노드의 인덱스는 항상 pos*2
			while((pos*2) < heap.size()) {
				int minPos = pos*2;
				int min = heap.get(minPos);
				
				// 오른쪽 자식 노드와 왼쪽 자식중 더 작은 값을 찾는다 
				int rPos = pos*2 + 1;
				if(rPos < heap.size() && min > heap.get(rPos)) {
					min = heap.get(rPos);
					minPos = rPos;
				}
				//더 작은 값과 현재 노드(루트) 비교 
				if(heap.get(pos) < min) break; //최소힙 만족 
				//swap
				int tmp = heap.get(pos);
				heap.set(pos, heap.get(minPos));
				heap.set(minPos, tmp);
				pos = minPos;
			}		
			return deleteData;
		}
	}
}
