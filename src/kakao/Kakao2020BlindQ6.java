package kakao;

import java.util.ArrayList;
//�ذ����� ã�� �͵� ������� ������ �������.
//�ð�/�ݽð� ������ ���� �迭�� ���� �ع��� ã�� ���� �ٽ�.

public class Kakao2020BlindQ6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] weak = {0, 3 , 11, 21};
		int[] dist = {10, 4};
		s.solution(30, weak, dist);
		System.out.println(s.res);
	}
	static class Solution {
		int[] weak;
		int weakSize;
		int n ;
		int res;
	    public int solution(int n, int[] weak, int[] dist) {
	        this.weak = weak;
	        weakSize = weak.length;
	        res = Integer.MAX_VALUE;
	        this.n = n;
	        boolean[] visited = new boolean[dist.length];
	        for(int i = dist.length ; i >= 1 ; i--) {
	        	combination(dist, visited, 0, dist.length, i, n);
	        }
	        return res;
	    }
	    //���� �˰��� 
	    private void combination(int[] arr, boolean[] visited, int start, int n, int r, int len) {
	    	if(r == 0) {
	    		ArrayList<Integer> list = new ArrayList<>();
	    		for (int i = 0; i < n; i++) {
	                if (visited[i] == true) {
	                	list.add(arr[i]);
	                }
	            }
	    		perm(list, 0, list.size());
	    		return;
	    	}
	    	for(int i = start; i < n; i++) {
		        visited[i] = true;
		        combination(arr, visited, i + 1, n, r - 1, len);
		        visited[i] = false;
		    }
	    	
	    }
	    //Ž�� 
	    private void search(ArrayList<Integer> list) {
	    	for(int i = 0 ; i < weakSize ; i++) {
	    		//i�� weak �迭 ���� ��ġ  weak�� ��� ������ �ѹ��� ���� ��ġ�� �Ǿ���Ѵ�.
		    	int cnt = 0; //���� ��� ��������� Ŀ���Ǿ�����
		    	int w_idx = i;
		    	int friend_cnt = 0;
		    	boolean flag_1 = false;
	    		for(int dist : list) {
	    			friend_cnt++;
		    		cnt++;
	    			int w2 = w_idx + 1;
	    			boolean flag = false;
	    			do {
	    				if(w2 == weakSize) {
	    					w2 = 0;
	    					flag = true;
	    				}
	    				int front = weak[w2];
	    				int back = weak[w_idx];
	    				if(flag) {
	    					front += n;
	    				}
	    				if(flag_1) {
	    					back += n;
	    				}
	    				if(front - back > dist) {
	    					w_idx = w2 - 1;
	    					break;
	    				}
	    				else {
	    					cnt ++;
	    					w2++;
	    				}
	    			}while(cnt != weakSize);
		    		if(cnt == weakSize) break;
		    		w_idx ++;
		    		if(w_idx == weakSize) { 
		    			w_idx = 0;
		    			flag_1 = true;
		    		}
		    		
		    	}
	    		if(cnt == weakSize) res = Math.min(res, friend_cnt);
	    	}
	    }
	    public void perm(ArrayList<Integer> arr, int depth, int n) {
			if(depth == n) {
				search(arr);
				return;
			}
			for(int i = depth ; i < n ; i ++) {
				swap(arr, i , depth);
				perm(arr, depth+1, n);
				swap(arr, i , depth);
			}
		}
		//��ȯ�ϴ� �Լ�
		public void swap(ArrayList<Integer> arr , int i , int j) {
			int temp = arr.get(i);
			arr.set(i, arr.get(j));
			arr.set(j, temp);
		}
	}
}
