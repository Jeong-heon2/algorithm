package stackq;

import java.util.Comparator;
import java.util.PriorityQueue;

//java�� PriorityQueue ����
//���� https://cjh5414.github.io/priorityqueue/
public class PriorityQ {

	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>();
		pq.offer(new Student("��ö��", 20));
		pq.offer(new Student("�迵��", 100));
		pq.offer(new Student("������", 66));
		pq.offer(new Student("�̳���", 7));
		pq.offer(new Student("����", 43));
		pq.offer(new Student("�ȿ���", 100));
		
		
		//���� ���� ����  pq�� ��������� ����
		PriorityQueue<Student> reversedPriorityQueue = new PriorityQueue<>(pq.size(), new Comparator<Student>() {
		    @Override
		    public int compare(Student p1, Student p2) {
		       return p1.age >= p2.age ? 1 : -1;
		    }
		});
		
		//���ٽ�
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
	        return "�̸� : " + name + ", ���� : " + age;
	    }
	    //���� ���� ������ ����
		@Override
		public int compareTo(Student target) {
			return this.age <= target.age ? 1 : - 1;
		}
	}

}
