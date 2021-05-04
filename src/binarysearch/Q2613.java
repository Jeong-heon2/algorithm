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
			if(isPossible(mid)) {//mid 값보다 큰 원소들이 있으면 안 됨 
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
		//2 2 2 2 1 0 와 같이 0개 그룹이 포함되어있으면  ans list에는 2 2 2 2 1 5개만 저장.
		//2개 이상인 그룹에서 나눠서  0을 없애주기 
		
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
	private static ArrayList<Integer> processing(int mid){//arr 각 원소는 mid보다 작거나 같은 
		int sum = 0;//현재 그룹의 합산 
		int len = 0;//현재 그룹에 속한 숫자 개수 
		int cntGroup = 1;//나눈 그룹 개수 
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
