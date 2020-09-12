package kakao;

import java.util.ArrayList;

import utils.ArrayInputConvert;

public class Kakao2021BlindQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] q = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		s.solution(info, q);


		System.out.println(ArrayInputConvert.convertInput("[\"java and backend and junior and pizza 100\",\"python and frontend and senior and chicken 200\",\"cpp and - and senior and pizza 250\",\"- and backend and senior and - 150\",\"- and - and - and chicken 100\",\"- and - and - and - 150\"]"));
	}
	static class Solution {
	    public int[] solution(String[] info, String[] query) {
	        int n = info.length;
	        Person[] people = new Person[n];
	        for(int i = 0 ; i < n; i++){
	            String[] infos = info[i].split(" ");
	            people[i] = new Person(infos[0], infos[1], infos[2],infos[3],Integer.parseInt(infos[4]));
	        }
	        int m = query.length;
	        int[] answer = new int[m];
	        for(int i = 0 ; i < m; i++){
	            ArrayList<Person> list = new ArrayList<>();
	            for(int p = 0 ; p < n ; p++){
	                list.add(people[p]);
	            }
	            String[] q = query[i].split(" ");
	            for(int j = 0 ; j < q.length; j++){
	                String str = q[i];
	                if(str.equals("and") || str.equals("-")) continue;
	                for(int t = 0 ; t < list.size(); t++){
	                	Person person = list.get(t);
	                    if(person.lang.equals(str) || person.job.equals(str) 
	                       || person.career.equals(str) || person.food.equals(str)){
	                        continue;
	                    }else{
	                        if(j == q.length - 1){
	                            if(person.point >= Integer.parseInt(str)){
	                                continue;
	                            }
	                        }
	                    }
	                    list.remove(person);
	                    t--;
	                }
	            }
	            answer[i] = list.size();
	        }
	        
	        return answer;
	    }
	    class Person{
	        String lang;
	        String job;
	        String career;
	        String food;
	        int point;
	        public Person(String l, String j, String c, String f, int p){
	            this.lang = l;
	            this.job = j;
	            this.career = c;
	            this.food = f;
	            this.point = p;
	        }
	    }
	}

}
