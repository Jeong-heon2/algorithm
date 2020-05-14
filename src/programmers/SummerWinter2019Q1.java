package programmers;
/*
 * 가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 
 * 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 
 * 모든 격자칸은 1cm x 1cm 크기입니다. 
 * 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 
 * 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 
 * 그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다.
 *  새로운 종이를 구할 수 없는 상태이기 때문에, 
 *  이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
 *  가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

[제한사항]
W, H : 1억 이하의 자연수
 */
//접근법 : 직선의 방정식
public class SummerWinter2019Q1 {

	public static void main(String[] args) {
		//y= -(h/w)x + h
		System.out.println(solution(100000000,99999998));
	}
	public static long solution(int w, int h) {
        long answer = 0;
        //y = -h/w*x + h
        double width = w;
        double height = h;
        double e = height/width;//기울기
        for(double x = 1; x <=w ; x++){
            //구간 검사
            double x1 = x-1;
            double x2 = x;
            double y1 = -e*x1 + height;
            double y2 = -e*x2 + height;
            //y1은 버림하고 y2는 올림하고 둘의 차이
            
            answer += Math.abs(Math.ceil(y1)-Math.floor(y2));
        }
        
        return (long)(width*height)-answer;
    }

}
//테스트 케이스 6번만 틀린다,,  캐스팅할때 무슨 문제가 있는 듯 하다. 그러나 원인을 찾지 못했다.