package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* ��ũ ��Ʈ�ѷ�
�� �۾��� ���� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ�ð�]�� ���� 2���� �迭 jobs�� �Ű������� �־��� ��, 
�۾��� ��û���� ������� �ɸ� �ð��� ����� ���� ���̴� ������� ó���ϸ�
 ����� �󸶰� �Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���. (��, �Ҽ��� ������ ���� �����ϴ�)

[���� ����]
jobs�� ���̴� 1 �̻� 500 �����Դϴ�.
jobs�� �� ���� �ϳ��� �۾��� ���� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ�ð�] �Դϴ�.
�� �۾��� ���� �۾��� ��û�Ǵ� �ð��� 0 �̻� 1,000 �����Դϴ�.
�� �۾��� ���� �۾��� �ҿ�ð��� 1 �̻� 1,000 �����Դϴ�.
�ϵ��ũ�� �۾��� �����ϰ� ���� ���� ������ ���� ��û�� ���� �۾����� ó���մϴ�.
 */
//���ٹ� 1 : �켱���� ť , �켱���� ť��  �켱������ �۾����� �� ���� �ҿ�Ǵ� �� �켱������ ����ִ´�
//for���� ���鼭 �� ����, ���� �������� �۾��� ������ ������ ����صд�
public class HeapQ3 {

	public static void main(String[] args) {
		//[[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 2], [15, 34], [35, 43], [26, 1]]
		//74
		System.out.println(solution(new int[][] {{24, 10}, {18, 39}, {34, 20}, {37, 5},
			{47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}})
				);
	}
	public static int solution(int[][] jobs) {
		//�迭�� ����,  ��û �ð��� ���� �ɷ� ���� �����ϰ�, ��û �ð��� ���� �༮����  �۾��� ũ�Ⱑ ���� ������ ����
		//2,3���� �迭�� ���߿� ���� �����ص� �ʿ䰡 �ְڴ�.
		Arrays.sort(jobs, (o1,o2) -> {
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		//����
        int answer = 0;
        //�۾��� ����
        int size = jobs.length;
        //�ð��� �帧
        int time = 0;
        //���� �������� �۾��� ��( �ð��� ������ ���� �پ��)
        int runningTask = 0;
        int idx=1;
        //�켱���� ť : �۾��� ũ�Ⱑ ���� ���� �켱.
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				if(o1.taskTime > o2.taskTime) return 1;
				else if(o1.taskTime == o2.taskTime) return 0;
				else return -1;
			}
        });
        //���� �ʱ⿡�� �ϵ尡 �۾��� �����ϰ� ���� �����Ƿ�  ���� ������û�� �༮�� ť�� �־��ش�.
        pq.offer(new Task(jobs[0][0],jobs[0][1]));
        do {
        	//�� �ð��� ����  �۾� ��û�ð��� ���� �۾����� q�� �־��ش�.
        	if( (idx < size) && (time == jobs[idx][0]) ) {
        		//ť�� �ֱ�
        		for(int i = idx ; i < size ; i ++) {
        			if(jobs[i][0] == time) {
        				pq.offer(new Task(jobs[i][0],jobs[i][1]));
        				idx++;
        			}else break;
        		}
        	}
        	//�ϵ尡 �۾������� ������ q���� �̾Ƽ� �۾��� �����Ѵ�.
        	//������׵� : q�� ����ִ°�? q���� ���� �༮�� �۾��� �� �������� ���డ���Ѱ�?
        	if(runningTask == 0) {
        		//ť�� �ִ� �� �˻�
        		if(pq.size() == 0 && idx == size) {
        			//����  exit
        			return answer/size;
        		}else {
        			if(pq.size()!= 0) {
        				Task task = pq.peek();
        				if(time >= task.rqTime) {
        					runningTask = task.taskTime;
        					pq.poll();
        					//answer ����
        					answer += time - task.rqTime + runningTask;
        				}
        			}
        		}
        	}
        	if(runningTask != 0) {
        		runningTask--;
        	}
        	time++;
        }while(true);
    }
	static class Task{
		int rqTime;
		int taskTime;
		Task(int rt,int tt){
			this.rqTime = rt;
			this.taskTime = tt;
		}
	}
}
//������ �� ����. 
//ó���� Ʋ�ȴٰ�  �ΰ��� ���� ������ ����ϴ� �¾Ҵ�. 
//�迭�� �۾� ��û ������� ���ĵǾ����� �ʾҴ� 
//���� ���� ���� ��Ұ� �ΰ��̻� ���� �� �ִ�.
