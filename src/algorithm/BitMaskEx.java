package algorithm;
//비트 마스크 연습
//https://mygumi.tistory.com/361 참고
//
public class BitMaskEx {

	public static void main(String[] args) {
		//10개의 1 만들기
		int a = (1<<10)-1;// 1<<10 은 1을 왼쪽으로 10 비트만큼 shift
		//정확하게는 십진수 1을 2진수로 바꾸고 0 10개를 오른쪽에 붙인 후  다시 십진수로 변환
		System.out.println(a);
		
		//shift right
		int b = (10>>3); // 오른쪽으로 3비트 만큼 민다. 
		//1010 이 0001이 된다.
		System.out.println(b);
		
		// A << B  = >  A*2^B
		// A >> B  = >  A/2^B
		// (A+B)/2  = >  (A+B) >> 1
		
		//홀수 판별 식
		//2진수에서  2의 0승 자리가 1이면 홀수이고 0 이면 짝수이기 때문.
		int c = 11;
		if((c&1) == 1) {
			System.out.println("홀수");
		}
		
		//0번째 비트 값을 1로 변경하기
		c = 10;//1010
		System.out.println(c|1<<0);//1011, 11
		System.out.println(1010|0001);//1011 , 11
		
		//0번쨰 비트 값을 0으로 변경하기
		c = 3;//1111
	    c &= ~(1<<1);
		System.out.println(c); //1110, 14
		System.out.println(1111 & 1110);// 1110, 14
		//주의!!!!
		System.out.println(c & 1110);//얘는 6으로 나옴,, 
		//int & 비트 는 잘못된 결과를 가져올 수도 있나보다.
		System.out.println(31 & 11110);//얘도 6..
		
		//0번째 비트 값 알아내기
		c = 3;
		System.out.println(c & (1 << 1));// 0
		//1번째 비트 값 알아내기
		System.out.println(c & (1 << 1));// 10  > 2의 1승  ,
		//즉 1번째 비트값이 켜져있다.
		
		System.out.println(bitCount(15));// 1111 총 4개
		
		int k = 0 ;
		k = k | (1 << 3);
		System.out.println(k);
		
	}
	//1의 갯수 세기
	public static int bitCount(int n ) {
		if(n==0) return 0;
		return n%2 + bitCount(n/2);
	}

}
