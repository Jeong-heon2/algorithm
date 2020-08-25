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
		        		//삭제 
		        		delete(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
		        		break;
		        	}
		        	case 1:{
		        		//설치 
		        		add(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
		        		break;
		        	}
	        	}
	        }
	        /*
	         return 하는 배열은 x좌표 기준으로 오름차순 정렬하며, x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬해주세요.
				x, y좌표가 모두 같은 경우 기둥이 보보다 앞에 오면 됩니다.
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
	    	//일단삭제 하고 삭제된 상태에서
	    	arr[y][x].remove(Integer.valueOf(type));
	    	switch(type) {
		    	case 0 : {
		    		//기둥 삭제의 경우 
			    	//내 위치 위의 보, 내위치 위의 왼쪽의 보 , 내위치 위의 기둥의 상태가 괜찮은지 확인 
		    		//만약 상태가 false면  기둥을 다시 더하고 return 
		    		//내 위치 위의 보 상태 체크 
		    		if(y + 1 < N) {
		    			if(arr[y+1][x].contains(1)) {
		    				if(!checkBo(x, y+1)) {
		    					arr[y][x].add(0);
		    					return;
		    				}
		    			}
		    		}
		    		//내 위의 왼쪽의 보 
		    		if(y + 1 < N && x - 1 >= 0) {
		    			if(arr[y+1][x-1].contains(1)) {
		    				if(!checkBo(x-1, y+1)) {
		    					arr[y][x].add(0);
		    					return;
		    				}
		    			}
		    		}
			    	//내위치 위의 기둥 
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
		    		//내 위치 기둥, 내 오른쪽 기둥 , 내 왼쪽보 내 오른 쪽 보 확인 
		    		int rx = x + 1;
		    		int lx = x - 1;
		    		boolean r_check = isRanged(rx, y);
		    		boolean l_check = isRanged(lx, y);
		    		if(r_check) {
		    			//내 오른쪽 기둥 체크 
		    			if(arr[y][rx].contains(0)) {
		    				if(!checkPillar(rx, y)) {
		    					arr[y][x].add(1);
		    					return;
		    				}
		    			}
		    			//내 오른쪽 보 체크
		    			if(arr[y][rx].contains(1)) {
		    				if(!checkBo(rx, y)) {
		    					arr[y][x].add(1);
		    					return;
		    				}
		    			}
		    		}
		    		if(l_check) {
		    			//내 왼쪽 보 체크 
		    			if(arr[y][lx].contains(1)) {
		    				if(!checkBo(lx, y)) {
		    					arr[y][x].add(1);
		    					return;
		    				}
		    			}
		    		}
		    		//내 위치의 기둥 체크 
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
	    		case 0 : {//기둥 
	    			//기둥을 더하는 경우
	    	        //내 위치 밑에 기둥이 있거나 내 위치가 맨아래면 가능 
	    	        //또는 내위치에 보가 있다면 가능 
	    			if(checkPillar(x, y)) {
	    				arr[y][x].add(0);
	    				cnt++;
	    				return;
	    			}
	    			break;
	    		}
	    		case 1 : {// 보 
	    			//보를 더하는 경우 
	    	        //내 위치 양옆에 모두 보가 있거나 ( 내 위치 아래 또는 오른쪽)에 기둥이 있다면  가능 
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
	    	//오른쪽 끝에 기둥이 있는가?
	    	if(r_check && d_check) {
	    		if(arr[dy][rx].contains(0)) {
	    			return true;
	    		}
	    	}
	    	//내 밑에 기둥이 있는가?
	    	if(d_check) {
	    		if(arr[dy][x].contains(0)) {
	    			return true;
	    		}
	    	}
	    	//한쪽 끝과 다른 한 쪽 끝이 모두 보와 연결되어있느가?
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
	    	
	    	//바닥 위에 있는가?
	    	if(y == 0) {
	    		return true;
	    	}
	    	//보 위에 있는가?
	    	//내 위치에 보가 있는가?
	    	if(arr[y][x].contains(1)) {
	    		return true;
	    	}
	    	//내 왼쪽에 보가 있는가?
	    	if(l_check) {
	    		if(arr[y][lx].contains(1)) {
	    			return true;
	    		}
	    	}
	    	//다른 기둥위에 있는가?
	    	if(d_check) {
	    		if(arr[dy][x].contains(0)) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	}

}
