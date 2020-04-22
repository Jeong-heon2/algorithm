package programmers;

public class DFSBFSQ3 {

	public static void main(String[] args) {
		/*
		�� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �ֽ��ϴ�. �Ʒ��� ���� ��Ģ�� �̿��Ͽ� begin���� target���� ��ȯ�ϴ� ���� ª�� ��ȯ ������ ã������ �մϴ�.

		1. �� ���� �� ���� ���ĺ��� �ٲ� �� �ֽ��ϴ�.
		2. words�� �ִ� �ܾ�θ� ��ȯ�� �� �ֽ��ϴ�.
		���� ��� begin�� hit, target�� cog, words�� [hot,dot,dog,lot,log,cog]��� hit -> hot -> dot -> dog -> cog�� ���� 4�ܰ踦 ���� ��ȯ�� �� �ֽ��ϴ�.

		�� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �Ű������� �־��� ��, �ּ� �� �ܰ��� ������ ���� begin�� target���� ��ȯ�� �� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

		���ѻ���
		�� �ܾ�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
		�� �ܾ��� ���̴� 3 �̻� 10 �����̸� ��� �ܾ��� ���̴� �����ϴ�.
		words���� 3�� �̻� 50�� ������ �ܾ ������ �ߺ��Ǵ� �ܾ�� �����ϴ�.
		begin�� target�� ���� �ʽ��ϴ�.
		��ȯ�� �� ���� ��쿡�� 0�� return �մϴ�.*/

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
	        if(isMarked[curIdx]){//�̹� �湮�Ѱ��̶��
	            return;
	        }
	        else if(words[curIdx].equals(target)){
	            if(answer>count) answer = count;
	        }
	        else{
	            count++;
	            isMarked[curIdx] = true;
	            //for�� cur���� �ѱ��ڸ� �ٸ� �ܾ words���� ã�� DFS ����
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
