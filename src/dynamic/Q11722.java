package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11722 {

	public static void main(String[] args) throws Exception  {
		// BufferedReader는 Exception 처리를 따로 해줘야 하기 때문에 throws를 해주거나
		// try~catch로 예외처리 해줘야합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// "1 3 5 6"식으로 공란 포함 String Line일시 StringTokenizer 이용
		// 공란기준으로 쪼개서 입력을 받겠다
		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< sequence.length; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
			//배열에다 토큰을 하나씩 불러서 입력
		}
		int count = 0;
		int answer = 0;
		int[] lengthArray = new int[N];
		for(int i = 0; i<sequence.length-1; i++) {//입력받은 배열 첫번째 수 부터 시작하는 감소 부분순열을 찾을것임
			//배열의 마지막 수 부터시작하는 감소부분 순열의 길이는 무조건  1 그래서 length-1
			int j = i;
			for(int k = i+1 ; k < N; k++) {
				if(sequence[j]>sequence[k]) {//10 30 20 50 1 이라면  10 30 에서 30이 더크므로 건너뛰고 
					// 다시 10 20 비교  그러다가 10 1 에서 카운트 증가 
					// 30 20 10 50 20 1 이면 30 20 에서 카운트증가  j가 k가 되어야 20과 10을 비교 
					// 10 50에서 건너 뛰고  10 20 건너뛰고 10과 1 에서 카운트증가
					// 10으로 시작하는 감소 부분순열에만 관심
					System.out.println("i = " + i + "k = " + k);
					System.out.println("seqj = " + sequence[j] + "seq k = "+sequence[k]);
					count++;
					System.out.println("count =" + count);
					j = k;
					if(count>lengthArray[i]) lengthArray[i]=count;
				}
				else if (sequence[j]<sequence[k]){
					if(lengthArray[i]<count) {
						lengthArray[i] = count;
						count = 0;
					}
					else count = 0;
					j=i;
				}
				
			}
			count = 0 ;//count 리셋
		}
		int max = 0;
		//최댓값구하기
		System.out.println(answer+1);
	}
}
