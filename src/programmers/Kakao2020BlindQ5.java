package programmers;

import java.util.ArrayList;



public class Kakao2020BlindQ5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] res = s.solution(5, build_frame);
		int a = s.cnt;
	}
	static class Solution {
		ArrayList<Integer>[][] arr ;
		int N;
		int cnt;
	    public int[][] solution(int n, int[][] build_frame) {
	    	N = n+1;
	        arr = (ArrayList<Integer>[][]) new ArrayList[N][N];
	        for(int i = 0 ; i < N ; i ++) {
	        	for(int j = 0 ; j < N ; j++) {
	        		arr[i][j] = new ArrayList<>();
	        	}
	        }
	        cnt = 0;
	        for(int i = 0 ; i < build_frame.length ; i++) {
	        	switch(build_frame[i][3]) {
		        	case 0:{
		        		//���� 
		        		delete(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
		        		break;
		        	}
		        	case 1:{
		        		//��ġ 
		        		add(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
		        		break;
		        	}
	        	}
	        }
	        /*
	         return �ϴ� �迭�� x��ǥ �������� �������� �����ϸ�, x��ǥ�� ���� ��� y��ǥ �������� �������� �������ּ���.
				x, y��ǥ�� ��� ���� ��� ����� ������ �տ� ���� �˴ϴ�.
	         */
	        int[][] res = new int[cnt][3];
	        int idx = 0;
	        for(int x = 0 ; x < N ; x ++) {
	        	for(int y = 0 ; y < N ; y++) {
	        		if(arr[y][x].contains(0)) {
	        			res[idx][0] = x;
	        			res[idx][1] = y;
	        			res[idx++][2] = 0;
	        		}
	        		if(arr[y][x].contains(1)) {
	        			res[idx][0] = x;
	        			res[idx][1] = y;
	        			res[idx++][2] = 1;
	        		}
	        	}
	        }
	        return res;
	    }
	    public void delete(int x, int y, int type){
	    	//�ϴܻ��� �ϰ� ������ ���¿���
	    	arr[y][x].remove(Integer.valueOf(type));
	    	switch(type) {
		    	case 0 : {
		    		//��� ������ ��� 
			    	//�� ��ġ ���� ��, ����ġ ���� ������ �� , ����ġ ���� ����� ���°� �������� Ȯ�� 
		    		//���� ���°� false��  ����� �ٽ� ���ϰ� return 
		    		//�� ��ġ ���� �� ���� üũ 
		    		if(y + 1 < N) {
		    			if(arr[y+1][x].contains(1)) {
		    				if(!checkBo(x, y+1)) {
		    					arr[y][x].add(0);
		    					return;
		    				}
		    			}
		    		}
		    		//�� ���� ������ �� 
		    		if(y + 1 < N && x - 1 >= 0) {
		    			if(arr[y+1][x-1].contains(1)) {
		    				if(!checkBo(x-1, y+1)) {
		    					arr[y][x].add(0);
		    					return;
		    				}
		    			}
		    		}
			    	//����ġ ���� ��� 
		    		if(y + 1 < N) {
		    			if(arr[y+1][x].contains(0)) {
		    				if(!checkPillar(x, y+1)) {
		    					arr[y][x].add(0);
		    					return;
		    				}
		    			}
		    		}
		    		cnt--;
		    		break;
		    	}
		    	case 1 : {
		    		//�� ��ġ ���, �� ������ ��� , �� ���ʺ� �� ���� �� �� Ȯ�� 
		    		int rx = x + 1;
		    		int lx = x - 1;
		    		boolean r_check = isRanged(rx, y);
		    		boolean l_check = isRanged(lx, y);
		    		if(r_check) {
		    			//�� ������ ��� üũ 
		    			if(arr[y][rx].contains(0)) {
		    				if(!checkPillar(rx, y)) {
		    					arr[y][x].add(1);
		    					return;
		    				}
		    			}
		    			//�� ������ �� üũ
		    			if(arr[y][rx].contains(1)) {
		    				if(!checkBo(rx, y)) {
		    					arr[y][x].add(1);
		    					return;
		    				}
		    			}
		    		}
		    		if(l_check) {
		    			//�� ���� �� üũ 
		    			if(arr[y][lx].contains(1)) {
		    				if(!checkBo(lx, y)) {
		    					arr[y][x].add(1);
		    					return;
		    				}
		    			}
		    		}
		    		//�� ��ġ�� ��� üũ 
		    		if(arr[y][x].contains(0)) {
		    			if(!checkPillar(x, y)) {
		    				arr[y][x].add(1);
	    					return;
		    			}
		    		}
		    		cnt--;
		    		break;
		    	}
	    	}
	    }
	    public void add(int x, int y, int type){
	    	switch(type) {
	    		case 0 : {//��� 
	    			//����� ���ϴ� ���
	    	        //�� ��ġ �ؿ� ����� �ְų� �� ��ġ�� �ǾƷ��� ���� 
	    	        //�Ǵ� ����ġ�� ���� �ִٸ� ���� 
	    			if(checkPillar(x, y)) {
	    				arr[y][x].add(0);
	    				cnt++;
	    				return;
	    			}
	    			break;
	    		}
	    		case 1 : {// �� 
	    			//���� ���ϴ� ��� 
	    	        //�� ��ġ �翷�� ��� ���� �ְų� ( �� ��ġ �Ʒ� �Ǵ� ������)�� ����� �ִٸ�  ���� 
	    			if(checkBo(x, y)) {
	    				arr[y][x].add(1);
	    				cnt++;
	    				return;
	    			}
	    			break;
	    		}
	    	}
	    }
	    public boolean isRanged(int x, int y) {
	    	if(x < 0 || x >= N || y < 0 || y >= N) return false;
	    	else return true;
	    }
	    public boolean checkBo(int x, int y) {
	    	
	    	int lx = x - 1;
	    	int rx = x + 1;
	    	int dy = y - 1;
	    	boolean l_check = isRanged(lx, y);
	    	boolean r_check = isRanged(rx, y);
	    	boolean d_check = isRanged(x, dy);
	    	//������ ���� ����� �ִ°�?
	    	if(r_check && d_check) {
	    		if(arr[dy][rx].contains(0)) {
	    			return true;
	    		}
	    	}
	    	//�� �ؿ� ����� �ִ°�?
	    	if(d_check) {
	    		if(arr[dy][x].contains(0)) {
	    			return true;
	    		}
	    	}
	    	//���� ���� �ٸ� �� �� ���� ��� ���� ����Ǿ��ִ���?
	    	if(r_check && l_check) {
	    		if(arr[y][lx].contains(1) && arr[y][rx].contains(1)) {
	    			return true;
	    		}
	    	}
	    	return false;
	    	
	    	
	    }
	    public boolean checkPillar(int x, int y) {
	    	int lx = x - 1;
	    	int rx = x + 1;
	    	int dy = y - 1;
	    	boolean l_check = isRanged(lx, y);
	    	boolean d_check = isRanged(x, dy);
	    	
	    	//�ٴ� ���� �ִ°�?
	    	if(y == 0) {
	    		return true;
	    	}
	    	//�� ���� �ִ°�?
	    	//�� ��ġ�� ���� �ִ°�?
	    	if(arr[y][x].contains(1)) {
	    		return true;
	    	}
	    	//�� ���ʿ� ���� �ִ°�?
	    	if(l_check) {
	    		if(arr[y][lx].contains(1)) {
	    			return true;
	    		}
	    	}
	    	//�ٸ� ������� �ִ°�?
	    	if(d_check) {
	    		if(arr[dy][x].contains(0)) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	}

}
