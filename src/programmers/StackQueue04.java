package programmers;
import java.util.*;
public class StackQueue04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pr = {2,1,3,2};
		int location = 2;
		solution3(pr,2);

	}
	public static int solution3(int[] priorities, int location) {
        int answer = 0;
        Queue<PrintObj> q = new LinkedList<>();
        for(int i = 0 ; i < priorities.length ; i++){
            q.add(new PrintObj(i,priorities[i]));
        }
        while(q.size()>0){
            int qsize = q.size();
            int max = 0;
            int maxLocation = 0;
            int idx = 0;
            while(qsize-- >0){
                PrintObj currObj = q.poll();
                if(max < currObj.star){
                    max = currObj.star;
                    maxLocation = idx;
                }
                q.add(currObj);
            }
            for(int i = 0 ; i < maxLocation ; i++){
                PrintObj Obj = q.poll();
                q.add(Obj);
            }
            PrintObj targetObj = q.poll();
            answer++;
            if(location == targetObj.location){
                return answer; 
            }
        }
        return answer;
    }
	static class PrintObj {
        public int location;
        public int star;
        public PrintObj(int location,int star){
            this.location = location;
            this.star = star;
        }
    }
}
