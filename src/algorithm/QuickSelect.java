package algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuickSelect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st2 = new StringTokenizer(sc.nextLine());
		for(int i = 0 ; i < N ;i ++) {
			arr.add(Integer.parseInt(st2.nextToken()));
		}
		System.out.println(quick_selection(arr,K));
		
		
	}
	public static int quick_selection(ArrayList<Integer> arr, int K) {
		int pivot = arr.get(arr.size()/2);
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		int mid = 0;//모두 다른 정수이므로 
		for (int i = 0 ; i < arr.size() ; i ++) {
			if(arr.get(i) < pivot) {
				left.add(arr.get(i));
			}
			else if(arr.get(i) > pivot) {
				right.add(arr.get(i));
			}
			else {
				mid = arr.get(i);
			}
		}
		if(K<=left.size()) {
			return quick_selection(left,K);
		}
		else if(K == left.size()+1) {
			return mid;
		}
		else {
			return quick_selection(right,K-left.size()-1);
		}
	}
}
