package stackq;

import java.util.Comparator;
import java.util.PriorityQueue;

//java의 PriorityQueue 연습
//참고 https://cjh5414.github.io/priorityqueue/
public class PriorityQ {

	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>();
		pq.offer(new Student("김철수", 20));
		pq.offer(new Student("김영희", 100));
		pq.offer(new Student("한택희", 66));
		pq.offer(new Student("이나영", 7));
		pq.offer(new Student("이혁", 43));
		pq.offer(new Student("안영희", 100));
		
		
		//나이 적은 순서  pq가 비어있으면 에러
		PriorityQueue<Student> reversedPriorityQueue = new PriorityQueue<>(pq.size(), new Comparator<Student>() {
		    @Override
		    public int compare(Student p1, Student p2) {
		       return p1.age >= p2.age ? 1 : -1;
		    }
		});
		
		//람다식
		PriorityQueue<Student> reversedPriorityQueue2 = new PriorityQueue<>(pq.size(),
		        (Student p1, Student p2) -> p1.age >= p2.age ? 1 : -1);
	}
	static class Student implements Comparable<Student>{
	    String name;
	    int age;

	    public Student(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    @Override
	    public String toString() {
	        return "이름 : " + name + ", 점수 : " + age;
	    }
	    //나이 많은 순서로 정렬
		@Override
		public int compareTo(Student target) {
			return this.age <= target.age ? 1 : - 1;
		}
	}

}
