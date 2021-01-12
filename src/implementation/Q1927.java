package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * �ּ� �� 
 * https://wonit.tistory.com/203
 */
public class Q1927 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//������ ����
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
			heap = new ArrayList<>(); heap.add(0); // heap �� �ε����� �˱� ���� 0���� �����Ѵٴ� Ư���� ������. 
		}
		public void insert(int data) {
			heap.add(data);
			//���� ��� 
			int pos = heap.size() - 1;
			//����� �θ��� �ε����� �׻�  pos/2 
			int parent = pos/2;
			//�θ� �� �۾ƾ��� (�ּ���) 
			while(pos > 1 && heap.get(parent) > heap.get(pos)) {
				//swap 
				int temp = heap.get(parent);
				heap.set(parent, heap.get(pos));
				heap.set(pos, temp);
				
				pos = parent;
				parent = pos/2;
			}
		}
		//��Ʈ ��带 �����ϰ�  ������ �����͸� ���� 
		public int delete() {
			//heap�� ������� ��
			if(heap.size() - 1 == 0) {
				return 0;
			}
			//���� ������ (��Ʈ ) 
			int deleteData = heap.get(1);
			//���� ��带 �θ� ���� ���� 
			heap.set(1, heap.get(heap.size() -1));
			//���� ��� ���� 
			heap.remove(heap.size() - 1);
			
			int pos = 1;
			//�� ���� �ڽ� ����� �ε����� �׻� pos*2
			while((pos*2) < heap.size()) {
				int minPos = pos*2;
				int min = heap.get(minPos);
				
				// ������ �ڽ� ���� ���� �ڽ��� �� ���� ���� ã�´� 
				int rPos = pos*2 + 1;
				if(rPos < heap.size() && min > heap.get(rPos)) {
					min = heap.get(rPos);
					minPos = rPos;
				}
				//�� ���� ���� ���� ���(��Ʈ) �� 
				if(heap.get(pos) < min) break; //�ּ��� ���� 
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
