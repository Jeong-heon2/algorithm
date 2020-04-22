package programmers;

public class DFSBFSQ3 {

	public static void main(String[] args) {
		/*
		두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

		1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
		2. words에 있는 단어로만 변환할 수 있습니다.
		예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.

		두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

		제한사항
		각 단어는 알파벳 소문자로만 이루어져 있습니다.
		각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
		words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
		begin과 target은 같지 않습니다.
		변환할 수 없는 경우에는 0를 return 합니다.*/

	}
	class Solution {
	    int answer = Integer.MAX_VALUE;
	    public int solution(String begin, String target, String[] words) {
	        int size = words.length;
	        boolean[] isMarked = new boolean[size];
	        
	        for(int i = 0 ; i < size; i++){
	            int wrongCount = 0 ;
	            String str = words[i];
	            for(int j = 0 ; j < begin.length(); j++){
	                if(begin.charAt(j) != str.charAt(j)){
	                    wrongCount++;
	                    if(wrongCount > 1){
	                        break;
	                    }
	                }
	            }
	            if(wrongCount == 1){
	                DFS(words,isMarked,i,1,target);
	            }
	        }
	        if(answer == Integer.MAX_VALUE) return 0;
	        else return answer;
	    }
	    public void DFS(String[] words,boolean[] isMarked, int curIdx ,int count,String target){
	        if(isMarked[curIdx]){//이미 방문한곳이라면
	            return;
	        }
	        else if(words[curIdx].equals(target)){
	            if(answer>count) answer = count;
	        }
	        else{
	            count++;
	            isMarked[curIdx] = true;
	            //for문 cur에서 한글자만 다른 단어를 words에서 찾고 DFS 돌림
	            int idx = 0;
	            for(String str : words){
	                int wrongWordCount = 0;
	                String currStr = words[curIdx];
	                for(int i = 0 ; i < str.length(); i++){
	                    if(str.charAt(i) != currStr.charAt(i)){
	                        wrongWordCount++;
	                        if(wrongWordCount >1){
	                            break;
	                        }
	                    }
	                }
	                if(wrongWordCount == 1){
	                    DFS(words,isMarked,idx,count,target);
	                }
	                idx++;
	            }
	        }
	    }
	}

}
