package kakao;

/*
 와일드카드 문자인 '?'는 글자 하나를 의미하며, 어떤 문자에도 매치된다고 가정합니다.
  예를 들어 "fro??"는 "frodo", "front", "frost" 등에 매치되지만 "frame", "frozen"에는 매치되지 않습니다.
입력 : 가사에 사용된 모든 단어들이 담긴 배열 words와 찾고자 하는 키워드가 담긴 배열 queries 

[가사 단어 제한사항]
words의 길이(가사 단어의 개수)는 2 이상 100,000 이하입니다.
각 가사 단어의 길이는 1 이상 10,000 이하로 빈 문자열인 경우는 없습니다.
전체 가사 단어 길이의 합은 2 이상 1,000,000 이하입니다.
가사에 동일 단어가 여러 번 나올 경우 중복을 제거하고 words에는 하나로만 제공됩니다.
각 가사 단어는 오직 알파벳 소문자로만 구성되어 있으며, 특수문자나 숫자는 포함하지 않는 것으로 가정합니다.

[검색 키워드 제한사항]
queries의 길이(검색 키워드 개수)는 2 이상 100,000 이하입니다.
각 검색 키워드의 길이는 1 이상 10,000 이하로 빈 문자열인 경우는 없습니다.
전체 검색 키워드 길이의 합은 2 이상 1,000,000 이하입니다.
검색 키워드는 중복될 수도 있습니다.
각 검색 키워드는 오직 알파벳 소문자와 와일드카드 문자인 '?' 로만 구성되어 있으며, 특수문자나 숫자는 포함하지 않는 것으로 가정합니다.
검색 키워드는 와일드카드 문자인 '?'가 하나 이상 포함돼 있으며, '?'는 각 검색 키워드의 접두사 아니면 접미사 중 하나로만 주어집니다.
예를 들어 "??odo", "fro??", "?????"는 가능한 키워드입니다.
반면에 "frodo"('?'가 없음), "fr?do"('?'가 중간에 있음), "?ro??"('?'가 양쪽에 있음)는 불가능한 키워드입니다.
 */

//효율성은 도저히 해결 못하겠어서 정확성만 맞추었다..
public class Kako2020BlindQ4 {

	public static void main(String[] args) {
		String[] words = new String[] {"frodo","front","frost",
				"frozen","frame","kakao"};
		String[] queries = new String[] {
				"fro??","????o","fr???","fro???","pro?"
		};
		int[] results = solution(words,queries);
		for(int i = 0; i < results.length ; i++) {
			System.out.println(results[i]);
		}
	}
	public static int[] solution(String[] words, String[] queries) {
		int[] ans = new int[queries.length];
		for(int i = 0 ; i < queries.length; i ++) {
			//쿼리에서 하나씩 꺼내서   ? 를 . 으로 replace
			String regex = queries[i].replace("?", ".");
			//words에서 쿼리에 맞는 녀석들 찾고  카운트
			//카운트결과 정답에 추가
			for(int j = 0 ; j < words.length ; j++) {
				if(words[j].matches(regex)) {
					ans[i]++;
				}
			}
		}
		return ans;
	}
}
//효율성 문제이다.  효율성을 고려하지 않으면 10분만에 해결 가능한 문제.

