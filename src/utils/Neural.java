package utils;

public class Neural {

	public static void main(String[] args) {
		int[][] ans = new int[][] {{1,0,0}, {0,1,0}, {0,0,1}};
		int[][] input = new int[][] {{2,-4}, {0,3}, {-6,2}};
		while(true) {
			int t1 = (int) ((Math.random() * (10 + 10)) - 10);
			int t2 = (int) ((Math.random() * (10 + 10)) - 10);
			int t3 = (int) ((Math.random() * (10 + 10)) - 10);
			int t4 = (int) ((Math.random() * (10 + 10)) - 10);
			int t5 = (int) ((Math.random() * (10 + 10)) - 10);
			
			int w1 = (int) ((Math.random() * (10 + 10)) - 10);
			int w2 = (int) ((Math.random() * (10 + 10)) - 10);
			int w3 = (int) ((Math.random() * (10 + 10)) - 10);
			int w4 = (int) ((Math.random() * (10 + 10)) - 10);
			int w5 = (int) ((Math.random() * (10 + 10)) - 10);
			int w6 = (int) ((Math.random() * (10 + 10)) - 10);
			boolean flag = true;
			for(int i = 0; i < 3 ;i++) {
				int r1 = 0;
				int r2 = 0;
				int r3 = 0;
				int r4 = 0;
				int r5 = 0;
				int r6 = 0;
				if(input[i][0] > t1) {
					r1 = input[i][0] * w1;
					r2 = input[i][0] * w2;
					r3 = input[i][0] * w3;
				}
				if(input[i][1] > t2) {
					r4 = input[i][1] * w4;
					r5 = input[i][1] * w5;
					r6 = input[i][1] * w6;
				}
				
				int s1 = r1+r4;
				int s2 = r2 + r5;
				int s3 = r3 + r6;
				
				int out1 = 0;
				int out2 = 0;
				int out3 = 0;
				if(s1 > t3) {
					out1 = 1;
				}
				if(s2>t4) {
					out2 = 1;
				}
				if(s3>t5) {
					out3 = 1;
				}
				if(out1 == ans[i][0] && out2 == ans[i][1] && out3 == ans[i][2]) {
					continue;
				}else {
					flag = false;
					break;
				}
				
			}
			if(flag) {
				System.out.println("t1 : " + t1);
				System.out.println("t2 : " + t2);
				System.out.println("t3 : " + t3);
				System.out.println("t4 : " + t4);
				System.out.println("t5 : " + t5);
				
				System.out.println("w1 : " + w1);
				System.out.println("w2 : " + w2);
				System.out.println("w3 : " + w3);
				System.out.println("w4 : " + w4);
				System.out.println("w5 : " + w5);
				System.out.println("w6 : " + w6);
				break;
			}
		}

	}

}
