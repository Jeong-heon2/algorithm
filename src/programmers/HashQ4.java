package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*해시 베스트 앨범
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

[제한사항]
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
 */
// 접근법 1 : 최대힙 
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
		//노래의 고유번호
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
		//총 count
		int count = 0;
		//수록곡들의 최대 힙
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
		//고유번호
		int num ;
		//재생횟수
		int plays;
		Song(int num, int plays){
			this.num = num;
			this.plays = plays;
		}
	}

}
