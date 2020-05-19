package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*�ؽ� ����Ʈ �ٹ�
��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�.
 �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.

���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
�帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
�帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
�뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��,
 ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

[���ѻ���]
genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
�帣 ������ 100�� �̸��Դϴ�.
�帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
 */
// ���ٹ� 1 : �ִ��� 
public class HashQ4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]
		int[] result = solution(new String[] {"classic", "pop", "classic","classic","pop"},
				new int[] {500, 600, 150, 800, 2500});
		for(int i = 0 ; i < result.length ; i ++) {
			System.out.println(result[i]);
		}

	}
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String,Genre> map = new HashMap<>();
        
		int size = genres.length;
		//�뷡�� ������ȣ
        int idx = 0;
        while(size-- > 0) {
        	String name = genres[idx];
        	int play = plays[idx];
        	if(map.containsKey(name)) {
        		Genre genre = map.get(name);
        		int count = genre.count + play;
        		genre.count = count;
        		genre.sPq.offer(new Song(idx,play));
        		map.put(name, genre);
        	}else {
        		Genre genre = new Genre(play);
        		genre.sPq.offer(new Song(idx,play));
        		map.put(name, genre);
        	}
        	idx++;
        }
        PriorityQueue<Genre> gPq = new PriorityQueue<>(new Comparator<Genre>() {

			@Override
			public int compare(Genre o1, Genre o2) {
				if(o1.count > o2.count) return -1;
				else if (o1.count == o2.count) return 0;
				else return 1;
			}
        });
        for(Map.Entry<String, Genre> entry : map.entrySet()) {
        	gPq.offer(entry.getValue());
        }
        int gpqSize = gPq.size();
        ArrayList<Integer> list = new ArrayList<>();
        while(gpqSize -- >0) {
        	try {
        		Genre genre = gPq.poll();
        		list.add(genre.sPq.poll().num);
        		list.add(genre.sPq.poll().num);
        	}catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i ++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	static class Genre{
		//�� count
		int count = 0;
		//���ϰ���� �ִ� ��
		PriorityQueue<Song> sPq = new PriorityQueue<>(new Comparator<Song>() {

			@Override
			public int compare(Song o1, Song o2) {
				if(o1.plays > o2.plays) return -1;
				else if(o1.plays == o2.plays) return 0;
				else return 1;
			}
		});
		Genre(int count){
			this.count = count;
		}
	}
	static class Song{
		//������ȣ
		int num ;
		//���Ƚ��
		int plays;
		Song(int num, int plays){
			this.num = num;
			this.plays = plays;
		}
	}

}
