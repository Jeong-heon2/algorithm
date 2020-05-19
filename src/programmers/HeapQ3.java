package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* 디스크 컨트롤러
각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 
작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면
 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)

[제한 사항]
jobs의 길이는 1 이상 500 이하입니다.
jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
 */
//접근법 1 : 우선순위 큐 , 우선순위 큐에  우선순위를 작업량이 더 적게 소요되는 걸 우선순위로 집어넣는다
//for문을 돌면서 현 시점, 현재 진행중인 작업이 끝나는 시점을 기록해둔다
public class HeapQ3 {

	public static void main(String[] args) {
		//[[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 2], [15, 34], [35, 43], [26, 1]]
		//74
		System.out.println(solution(new int[][] {{24, 10}, {18, 39}, {34, 20}, {37, 5},
			{47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}})
				);
	}
	public static int solution(int[][] jobs) {
		//배열을 정렬,  요청 시간이 작은 걸로 먼저 정렬하고, 요청 시간이 같은 녀석들은  작업의 크기가 작은 순서로 정렬
		//2,3차원 배열은 나중에 따로 정리해둘 필요가 있겠다.
		Arrays.sort(jobs, (o1,o2) -> {
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		//정답
        int answer = 0;
        //작업의 개수
        int size = jobs.length;
        //시간의 흐름
        int time = 0;
        //현재 진행중인 작업의 양( 시간이 지남에 따라 줄어듬)
        int runningTask = 0;
        int idx=1;
        //우선순위 큐 : 작업의 크기가 작은 것이 우선.
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				if(o1.taskTime > o2.taskTime) return 1;
				else if(o1.taskTime == o2.taskTime) return 0;
				else return -1;
			}
        });
        //가장 초기에는 하드가 작업을 수행하고 있지 않으므로  가장 먼저요청한 녀석을 큐에 넣어준다.
        pq.offer(new Task(jobs[0][0],jobs[0][1]));
        do {
        	//현 시간과 같은  작업 요청시간을 가진 작업들을 q에 넣어준다.
        	if( (idx < size) && (time == jobs[idx][0]) ) {
        		//큐에 넣기
        		for(int i = idx ; i < size ; i ++) {
        			if(jobs[i][0] == time) {
        				pq.offer(new Task(jobs[i][0],jobs[i][1]));
        				idx++;
        			}else break;
        		}
        	}
        	//하드가 작업중이지 않으면 q에서 뽑아서 작업을 실행한다.
        	//고려사항들 : q가 비어있는가? q에서 뽑은 녀석의 작업을 현 시점에서 진행가능한가?
        	if(runningTask == 0) {
        		//큐에 있는 거 검사
        		if(pq.size() == 0 && idx == size) {
        			//끝남  exit
        			return answer/size;
        		}else {
        			if(pq.size()!= 0) {
        				Task task = pq.peek();
        				if(time >= task.rqTime) {
        					runningTask = task.taskTime;
        					pq.poll();
        					//answer 갱신
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
//문제를 잘 읽자. 
//처음엔 틀렸다가  두가지 예외 사항을 고려하니 맞았다. 
//배열은 작업 요청 순서대로 정렬되어잇지 않았다 
//같은 값을 가진 요소가 두개이상 들어올 수 있다.
