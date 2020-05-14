package programmers;


public class Kakao2020SummerQ1 {

	public static void main(String[] args) {
		
	}
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        Position[][] phone = new Position[][] {
        	{new Position(0,0,'1'),new Position(0,1,'2'), new Position(0,2,'3')},
        	{new Position(1,0,'4'),new Position(1,1,'5'), new Position(1,2,'6')},
        	{new Position(2,0,'7'),new Position(2,1,'8'), new Position(2,2,'9')},
        	{new Position(3,0,'*'),new Position(3,1,'0'), new Position(3,2,'#')},
        };
        //왼손의 현 위치
        Position l_pos = new Position(3,0,'*');
        //오른손의 현 위치
        Position r_pos = new Position(3,2,'#');
        for(int i = 0 ; i < numbers.length ; i ++) {
        	//눌러야할 번호
        	int num = numbers[i];
        	
        	switch(num) {
        		case 1 : {
        			l_pos.setPos(0, 0, '1');
        			answer = answer+"L";
        			break;
        		}
        		case 2 : {
        			Position next = new Position(0,1,'2');
        			int left_distance = getDistance(next,l_pos);
        			int right_distance = getDistance(next,r_pos);
        			if(left_distance > right_distance) {
        				answer = answer+"R";
        				r_pos.setPos(0, 1, '2');
        			}else if(left_distance < right_distance) {
        				answer = answer+"L";
        				l_pos.setPos(0, 1, '2');
        			}else {
        				if(hand.equals("right")) {
        					answer = answer+"R";
            				r_pos.setPos(0, 1, '2');
        				}else {
        					answer = answer+"L";
        					l_pos.setPos(0, 1, '2');
        				}
        			}
        			break;
        		}
        		case 3 : {
        			r_pos.setPos(0, 2, '3');
        			answer = answer+"R";
        			break;
        		}
        		case 4 : {
        			l_pos.setPos(1, 0, '4');
        			answer = answer+"L";
        			break;
        		}
        		case 5 : {
        			Position next = new Position(1,1,'5');
        			int left_distance = getDistance(next,l_pos);
        			int right_distance = getDistance(next,r_pos);
        			if(left_distance > right_distance) {
        				answer = answer+"R";
            			r_pos.setPos(1, 1, '5');
        			}else if(left_distance < right_distance) {
        				answer = answer+"L";
        				l_pos.setPos(1, 1, '5');
        			}else {
        				if(hand.equals("right")) {
        					answer = answer+"R";
        					r_pos.setPos(1, 1, '5');
        				}else {
        					answer = answer+"L";
        					l_pos.setPos(1, 1, '5');
        				}
        			}
        			break;
        		}
        		case 6 : {
        			r_pos.setPos(1, 2, '6');
        			answer = answer+"R";
        			break;
        		}
        		case 7 : {
        			l_pos.setPos(2, 0, '7');
        			answer = answer+"L";
        			break;
        		}
        		case 8 : {
        			Position next = new Position(2,1,'8');
        			int left_distance = getDistance(next,l_pos);
        			int right_distance = getDistance(next,r_pos);
        			if(left_distance > right_distance) {
        				answer = answer+"R";
        				r_pos.setPos(2, 1, '8');
        			}else if(left_distance < right_distance) {
        				answer = answer+"L";
        				l_pos.setPos(2, 1, '8');
        			}else {
        				if(hand.equals("right")) {
        					answer = answer+"R";
        					r_pos.setPos(2, 1, '8');
        				}else {
        					answer = answer+"L";
        					l_pos.setPos(2, 1, '8');
        				}
        			}
        			break;
        		}
        		case 9 : {
        			r_pos.setPos(2, 2, '9');
        			answer = answer+"R";
        			break;
        		}
        		case 0 : {
        			Position next = new Position(3,1,'0');
        			int left_distance = getDistance(next,l_pos);
        			int right_distance = getDistance(next,r_pos);
        			if(left_distance > right_distance) {
        				answer = answer+"R";
        				r_pos.setPos(3, 1, '0');
        			}else if(left_distance < right_distance) {
        				answer = answer+"L";
        				l_pos.setPos(3, 1, '0');
        			}else {
        				if(hand.equals("right")) {
        					answer = answer+"R";
        					r_pos.setPos(3, 1, '0');
        				}else {
        					answer = answer+"L";
        					l_pos.setPos(3, 1, '0');
        				}
        			}
        			break;
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }
	public static int getDistance(Position from , Position to) {
		int xd = Math.abs(from.x - to.x);
		int yd = Math.abs(from.y - to.y);
		return xd+yd;
	}
	static class Position {
		int x;
		int y;
		char ch;
		public Position(int x, int y, char ch) {
			this.x = x;
			this.y = y;
			this.ch = ch;
		}
		public void setPos(int x, int y, char ch) {
			this.x = x;
			this.y = y;
			this.ch = ch;
		}
	}

}

