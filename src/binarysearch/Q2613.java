package binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2613 {
	static int[] arr;
	static int N;
	static int M;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int[N];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			int v = Integer.parseInt(st.nextToken());
			sum += v;
			arr[i] = v;
		}
		int l = 0;
		int r = sum;
		ans = new ArrayList<>();
		while(l <= r) {
			int mid = (l+r)/2;
			if(isPossible(mid)) {//mid ������ ū ���ҵ��� ������ �� �� 
				ArrayList<Integer> res = processing(mid);
				if(res.get(0) <= M) {
					res.set(0, mid);
					ans = res;
					r = mid - 1;
				}else {
					l = mid + 1;
				}
			}else {
				l = mid + 1;
			}
			
		}
		//9 6
		//1 1 1 1 1 1 1 1
		//2 2 2 2 1 0 �� ���� 0�� �׷��� ���ԵǾ�������  ans list���� 2 2 2 2 1 5���� ����.
		//2�� �̻��� �׷쿡�� ������  0�� �����ֱ� 
		
		int size = ans.size();
		while(check(ans)) {
			for(int i = size -1 ; i >= 1 ; i--) {
				if(ans.get(i) >= 2) {
					ans.set(i, ans.get(i)-1);
					ans.add(1);
					break;
				}
			}
		}
		bw.write(ans.get(0) + "\n");
		for(int i = 1 ; i <= M ; i++) {
			bw.write(ans.get(i) + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static boolean check(ArrayList<Integer> ans) {
		if(ans.size()-1 < M) {
			return true;
		}
		return false;
	}
	private static boolean isPossible(int mid) {
		for(int i = 0 ; i< N ; i++) {
			if(arr[i] > mid) return false;
		}
		return true;
	}
	private static ArrayList<Integer> processing(int mid){//arr �� ���Ҵ� mid���� �۰ų� ���� 
		int sum = 0;//���� �׷��� �ջ� 
		int len = 0;//���� �׷쿡 ���� ���� ���� 
		int cntGroup = 1;//���� �׷� ���� 
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			if(sum + arr[i] > mid) {
				res.add(len);
				len = 1;
				sum = arr[i];
				cntGroup++;
			}else {
				
				len++;
				sum += arr[i];
			}
		}
		res.add(len);
		res.add(0, cntGroup);
		return res;
	}

}
